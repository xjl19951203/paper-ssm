package com.paper.ssm.task.drools;

import com.paper.ssm.task.drools.NewKieBase;
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