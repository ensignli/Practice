package com.test.vo;

import lombok.Data;

/**
 * @Description: TODO
 * @Author: spark
 * @Date: 2020/4/26 9:06
 **/
@Data
public class ActiveUserVo {
    /**
     * 交易账号
     */
    private Long customerNo;
    /**
     * 交易账号（模拟）
     */
    private Long customerNoDemo;
    /**
     * 活动编码
     */
    private String activeNo;
}
