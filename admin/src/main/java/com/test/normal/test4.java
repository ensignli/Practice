package com.test.normal;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class test4 {

    public static void main(String[] args) {
        String str = "lizhan,dd";
        System.out.println(Arrays.asList(str.split(",")));


        int bidTmp = 0;

        for (int i = 0; i < 3; i++) {
            bidTmp = i;
            System.out.println(bidTmp + 1);


            System.out.println(bidTmp);

        }


        String paycode = "";
        System.out.println(paycode.indexOf("4"));
        //System.out.println(paycode.substring(paycode.indexOf("")+1, paycode.length()));


        String str2 = "ab=1";
        Map<String, String> collect = Arrays.stream(str2.split("&"))
                .map(s -> s.split("="))
                .collect(Collectors.toMap(x -> x[0], x -> x[1],
                        (u, v) -> {
                            throw new IllegalStateException(String.format("Duplicate key %s", u));
                        }, LinkedHashMap::new));


        System.out.println(collect);
        System.out.println(new BigDecimal("100.000").setScale(2, RoundingMode.HALF_UP).toString());

        System.out.println("https://admindemo.cfdealer88.com/".indexOf("1demo"));

        System.out.println("81000332".substring(0, 3));

        System.out.println(StringUtils.deleteWhitespace("  81 0 0 033 2 "));

        int type = 6, aType = 3;

        if ((8 == type && 2 == aType) || ((5 == type || 6 == type) && (2 == aType || 3 == aType))) {
            System.out.println("命中");
        }

        Integer limit = Integer.MAX_VALUE;
        System.out.println(limit);

        String ids="1,2,3,4,5,6,7,8,9,10,11,12";
        List<String> list = Arrays.asList(ids.split(","));
        List<List<String>> parts = Lists.partition(list, 100);
        parts.parallelStream().forEach(e-> {
            System.out.println(e);
        });

    }

}
