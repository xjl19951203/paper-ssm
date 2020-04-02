package com.paper.ssm.run.drools;

import com.paper.ssm.core.model.normalize.Attribute;
import com.paper.ssm.core.model.normalize.Chain;
import com.paper.ssm.run.data.Data;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

/**
 * @className: DroolsImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/4/2 8:34
 * @version: 1.0
 */
@Service("droolsService")
public class DroolsImpl implements DroolsService{

    private KieSession statefulKieSession;

    public DroolsImpl() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer container = kieServices.getKieClasspathContainer();
        statefulKieSession = container.newKieSession("all-rules");
    }

    @Override
    public void run(Data data, Chain chain) {
        for (Attribute attribute : chain.getAttributeList()) {
            /** field作为内循环，因为只需要处理chain中有的filed属性，chain没有的，直接忽视 */
            for (Attribute field : data.getFieldList()) {
                if (field.getRuleId().equals(attribute.getRuleId())) {
                    attribute.setField(field);
                }
            }
            /** drools驱动处理规则实例 */
            statefulKieSession.insert(attribute);
        }
        /** 设置全局变量：data */
        statefulKieSession.setGlobal("data", data);

        statefulKieSession.fireAllRules();
        statefulKieSession.dispose();

        System.out.println(data);
        /** 经规则链融合后的新data */
        data.setFieldList(chain.getAttributeList());
    }
}
