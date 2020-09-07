package com.test.callback2;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: spark
 * @Date: 2020/4/24 11:45
 **/

public interface SynData<T> {
    /**
     * 查询要同步的数据源
     *
     * @param synId 同步的主键
     * @return
     */
    List<Map<?, ?>> getSource(long synId);

    /**
     * 保存数据源
     *
     * @param source
     * @return
     */
    int saveAs(List<Map<?, ?>> source);

}
