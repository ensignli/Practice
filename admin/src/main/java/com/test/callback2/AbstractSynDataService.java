package com.test.callback2;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: spark
 * @Date: 2020/4/24 11:43
 **/
public abstract class AbstractSynDataService<T> {

    public abstract String getKey();

    public long saveList(SynData<T> synData, long synId) {
        //查询记录
        List<Map<?, ?>> sourceList = synData.getSource(synId);
        if (sourceList == null || sourceList.size() <= 0) {
            return -1;
        }
        return saveList(sourceList, synData);
    }

    private long saveList(List<Map<?, ?>> tradeList, SynData<T> synData) {
        //下次同步的最大maxId
        System.out.println(tradeList.size());
        return tradeList.size() > 0 ? synData.saveAs(tradeList) : 0;
    }
}