package com.paper.ssm.model.normalize;

import com.paper.ssm.model.Model;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 规则链，与规则库构建关联关系
 * @author ZengYuan
 */
@Getter
@Setter
public class Chain extends Model implements Cloneable{

    private List<Link> linkList;
    /** 不关注次序 */
    private List<Attribute> attributeList;

    public Chain append(Chain chain) {
        if (chain == null) {
            return null;
        }
        Chain newChain = new Chain();
        newChain.setAttributeList(new ArrayList<>());
        for (Attribute attribute : this.getAttributeList()) {
            newChain.getAttributeList().add(attribute);
        }
        for (Attribute attribute : chain.getAttributeList()) {
            newChain.getAttributeList().add(attribute);
        }
        return newChain;
    }

}
