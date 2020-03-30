package com.paper.ssm.process.drools;

import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.internal.utils.KieHelper;

/**
 * @author ZengYuan
 */
public class NewKieBase {

    /**
     * 将业务规则写到规则库中
     * @param rule 是我们动态传入的规则内容
     * @return KieBase
     */
    public static KieBase ruleKieBase(String rule) {
        KieHelper helper = new KieHelper();
        KieBase kieBase = null;
        try {
            helper.addContent(rule, ResourceType.DRL);
        //为了省事，小编直接将rule写成activityRule()
            kieBase = helper.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kieBase;
    }
}