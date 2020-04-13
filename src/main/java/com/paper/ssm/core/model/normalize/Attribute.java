package com.paper.ssm.core.model.normalize;

import com.paper.ssm.core.model.Model;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @className: Attribute
 * @author: ZengYuan
 * @description: 规则实例库
 * @date 2020/3/20 13:41
 * @version: 1.0
 */
@Getter
@Setter
public class Attribute extends Model implements Cloneable{

    private Integer id;
    private String title;
    private List<Chain> chainList;

}
