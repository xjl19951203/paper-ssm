package com.paper.ssm.core.model.normalize;

import com.paper.ssm.core.model.Model;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @className: Information
 * @author: ZengYuan
 * @description:
 * @date 2020/4/12 23:47
 * @version: 1.0
 */
@Setter
@Getter
public class Information extends Model {

    private Integer id;
    private String title;
    private List<InfoRef> infoRefList;
    private List<AttrRef> attrRefList;
}
