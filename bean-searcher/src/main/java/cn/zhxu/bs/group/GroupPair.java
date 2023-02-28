package cn.zhxu.bs.group;

import cn.zhxu.bs.BeanMeta;
import cn.zhxu.bs.implement.DefaultSqlResolver;
import cn.zhxu.bs.param.FieldParam;

import java.util.Collections;
import java.util.List;

/**
 * Group 对
 * 从 {@link DefaultSqlResolver } 中分离而来
 * @author Troy.Zhou @ 2023-02-28
 * @since v4.1.0
 */
public class GroupPair {

    public static final Group<List<FieldParam>> EMPTY_GROUP = new Group<>(Collections.emptyList());

    /**
     * 解析器
     */
    public interface Resolver {

        GroupPair resolve(BeanMeta<?> beanMeta, Group<List<FieldParam>> paramsGroup);

    }


    /**
     * 用于 where 的条件组
     */
    final Group<List<FieldParam>> whereGroup;

    /**
     * 用于 having 的条件组
     */
    final Group<List<FieldParam>> havingGroup;

    public GroupPair(Group<List<FieldParam>> whereGroup, Group<List<FieldParam>> havingGroup) {
        this.whereGroup = whereGroup;
        this.havingGroup = havingGroup;
    }

    public Group<List<FieldParam>> getWhereGroup() {
        return whereGroup;
    }

    public Group<List<FieldParam>> getHavingGroup() {
        return havingGroup;
    }

}
