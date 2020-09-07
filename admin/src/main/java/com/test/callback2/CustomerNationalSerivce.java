package com.test.callback2;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: spark
 * @Date: 2020/4/24 13:36
 **/
@Slf4j
public class CustomerNationalSerivce extends AbstractSynDataService<CustomerNational> {

    @Override
    public String getKey() {
        return "customer_number";
    }

    private long saveSynCustomer(final long synId) {
        return saveList(new SynData<CustomerNational>() {
            @Override
            public int saveAs(List<Map<?, ?>> source) {
                return saveCustomer(source);
            }

            @Override
            public List<Map<?, ?>> getSource(long id) {
                List<Map<?, ?>> list = Lists.newLinkedList();
                Map<String, String> map = Maps.newHashMap();
                map.put("11", "11");
                map.put("22", "22");
                map.put("33", "33");
                map.put("44", "44");
                list.add(map);
                return list;
            }
        }, synId);
    }

    /**
     * 保存数据
     *
     * @param list
     * @return
     */
    private int saveCustomer(List<Map<?, ?>> list) {
        int total = 0;
        CustomerNational customer = null;
        for (Map<?, ?> map : list) {
            System.out.println(map);
        }
        return total;
    }

    public static void main(String... args) {
        CustomerNationalSerivce customerNationalSerivce=new CustomerNationalSerivce();
        customerNationalSerivce.saveSynCustomer(0l);
    }

}
