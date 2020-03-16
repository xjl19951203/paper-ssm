package com.paper.ssm.model.normalize;

import com.paper.ssm.model.Model;
import com.paper.ssm.model.normalize.rules.Initial;
import com.paper.ssm.model.normalize.rules.Range;
import com.paper.ssm.model.normalize.rules.Type;
import com.paper.ssm.model.normalize.rules.Unit;
import lombok.Getter;
import lombok.Setter;

/**
 * Rule与 Node 之间 M:N的关系，即某个结点Node的规则链，是与相关的Rule集合的Chain的并集
 * 并且该每一种类型的Chain只能存在一个，这里涉及要优先级的问题
 * @author ZengYuan
 */
@Setter
@Getter
public class Rule extends Model {

    public static final int INITIAL_STYLE = 1;
    public static final int RANGE_STYLE= 2;
    public static final int TYPE_STYLE = 3;
    public static final int UNIT_STYLE = 4;

    /** 子类型标识符 */
    protected Integer style;
    private Integer initialId;
    private Integer rangeId;
    private Integer typeId;
    private Integer unitId;
    private Initial initial;
    private Range range;
    private Type type;
    private Unit unit;

    @Override
    public String toString() {
        return "Rule{" +
                "style=" + style +
                ", initialId=" + initialId +
                ", rangeId=" + rangeId +
                ", typeId=" + typeId +
                ", unitId=" + unitId +
                ", initial=" + initial +
                ", range=" + range +
                ", type=" + type +
                ", unit=" + unit +
                '}';
    }
}
