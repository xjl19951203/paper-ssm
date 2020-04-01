package com.paper.ssm.test;

import com.paper.ssm.SsmApplication;
import com.paper.ssm.model.normalize.Attribute;
import com.paper.ssm.model.normalize.Chain;
import com.paper.ssm.model.normalize.RuleMacro;
import com.paper.ssm.mvc.dao.normalize.AttributeDao;
import com.paper.ssm.process.data.Compare;
import com.paper.ssm.process.data.Data;
import com.paper.ssm.process.data.Field;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @className: DroolsTest
 * @author: ZengYuan
 * @description:
 * @date 2020/3/31 19:13
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SsmApplication.class)
public class DroolsTest {

    private static KieContainer container = null;
    private KieSession statefulKieSession = null;
    private Chain chain;
    private Data data;

    @Resource
    AttributeDao attributeDao;

    @Before
    public void start () {
        KieServices kieServices = KieServices.Factory.get();
        container = kieServices.getKieClasspathContainer();
        statefulKieSession = container.newKieSession("all-rules");

        chain = new Chain();
        chain.setAttributeList(this.attributeDao.selectListByQuery(null));
        data = new Data();
        data.setValue("1");
        data.setFieldList(new ArrayList<>());
        Field f1 = new Field();
        f1.setRuleId(1);
        f1.setValue("111");
        Field f2 = new Field();
        f2.setRuleId(RuleMacro.UNIT);
        f2.setValue("g");
        data.getFieldList().add(f1);
        data.getFieldList().add(f2);
    }

    /** 静态规则测试 */
    @Test
    public void test() {

        for (Attribute attribute : chain.getAttributeList()) {
            Compare compare = new Compare();
            compare.setData(data);
            compare.setAttribute(attribute);
            /** 规则实例在data的fieldList中不存在，则直接添加 */
            compare.setField(null);
            compare.setRuleId(attribute.getRuleId());
            for (Field field : data.getFieldList()) {
                /** 规则实例在data的fieldList中存在，则需要讨论如何处理冲突*/
                if (field.getRuleId().equals(attribute.getRuleId())) {
                    compare.setField(field);
                }
            }
            statefulKieSession.insert(compare);
        }

        System.out.println(data);

        statefulKieSession.fireAllRules();
        statefulKieSession.dispose();

        System.out.println("===========================");

        System.out.println(data);
    }

    /** 动态规则测试 */
    @Test
    public void ruleStringTest() throws Exception {

        String myRule = "import com.asiainfo.bean.Person\n" +
                "\n" +
                "dialect  \"mvel\"\n" +
                "\n" +
                "rule \"age\"\n" +
                "    when\n" +
                "        $person : Person(age<16 || age>50)\n" +
                "    then\n" +
                "        System.out.println(\"这个人的年龄不符合要求！（基于动态加载）\");\n" +
                "end\n";

        KieHelper helper = new KieHelper();

        helper.addContent(myRule, ResourceType.DRL);

        KieSession ksession = helper.build().newKieSession();

        Data data = new Data();


        ksession.insert(data);

        ksession.fireAllRules();

        ksession.dispose();
    }
}
