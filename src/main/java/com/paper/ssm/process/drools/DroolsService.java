package com.paper.ssm.process.drools;

import org.kie.api.KieBase;
import org.springframework.stereotype.Service;


/**
 * @author ZengYuan
 */
@Service
public class DroolsService {
    /**
     * 创建KieSession
     * @return
     */
    public KieBase newKieBase() {
        KieBase kieBase = NewKieBase.ruleKieBase("");
        return kieBase;
    }
}