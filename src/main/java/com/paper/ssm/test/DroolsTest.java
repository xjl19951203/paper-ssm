package com.paper.ssm.test;

import com.paper.ssm.SsmApplication;
import com.paper.ssm.core.model.normalize.Attribute;
import com.paper.ssm.core.model.normalize.Chain;
import com.paper.ssm.core.model.normalize.RuleMacro;
import com.paper.ssm.core.dao.normalize.AttributeDao;
import com.paper.ssm.core.model.data.Data;
import com.paper.ssm.core.service.data.DataService;
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
    private DataService dataService;
    @Resource
    AttributeDao attributeDao;

    @Before
    public void start () {
        KieServices kieServices = KieServices.Factory.get();
        container = kieServices.getKieClasspathContainer();
        statefulKieSession = container.newKieSession("all-rules");

        chain = new Chain();
//        chain.setAttributeList(this.attributeDao.selectListByQuery(null));
        data = new Data();
        data.setPointId(1);
        data.setProcessId(1);
        data.setValue("1");
        Attribute f1 = new Attribute();
//        f1.setRuleId(1);
//        f1.setValue("111");
        Attribute f2 = new Attribute();
//        f2.setRuleId(RuleMacro.UNIT);
//        f2.setValue("g");
    }

    /** 静态规则测试 */
    @Test
    public void test() {

//        for (Attribute attribute : chain.getAttributeList()) {
//            /** field作为内循环，因为只需要处理chain中有的filed属性，chain没有的，直接忽视 */
//            for (Attribute field : data.getFieldList()) {
//                if (field.getRuleId().equals(attribute.getRuleId())) {
//                    attribute.setField(field);
//                }
//            }
//            /** drools驱动处理规则实例 */
//            statefulKieSession.insert(attribute);
//        }
        /** 设置全局变量：data */
        statefulKieSession.setGlobal("data", data);

        statefulKieSession.fireAllRules();
        statefulKieSession.dispose();

        System.out.println(data);
        /** 经规则链融合后的新data */
//        data.setFieldList(chain.getAttributeList());
        this.dataService.insert(data);
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
