package com.paper.ssm.model.normalize.chains;

/**
 * 缺省值规范
 */
public class Default extends Chain {

    private String value;

    @Override
    public void execute() {

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
