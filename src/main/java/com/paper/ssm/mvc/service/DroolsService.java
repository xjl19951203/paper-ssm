package com.paper.ssm.mvc.service;

import com.paper.ssm.model.normalize.rules.NewKieBase;
import org.kie.api.KieBase;
import org.springframework.stereotype.Service;


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