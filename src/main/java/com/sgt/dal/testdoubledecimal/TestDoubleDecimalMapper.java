/*
 * Project: hcare-supervise-local-web
 *
 * File Created at 2022-07-14
 *
 * Copyright 2012-2015 Greenline.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Greenline Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Greenline.com.
 */
package com.sgt.dal.testdoubledecimal;

import com.sgt.dal.nhsa.po.NhsaEnterGroupRecordPO;
import com.sgt.dal.testdoubledecimal.po.TestDoubleDecimalPO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 上报数据统计
 *
 * @author sungt
 * @version V1.0
 * @since 2022-07-14 15:50
 */
@Mapper
public interface TestDoubleDecimalMapper {


    /**
     * 添加数据
     *
     * @param po 添加的对象
     * @return 影响行数
     */
    int insert(@Param("poList") List<TestDoubleDecimalPO> poList);

    List<TestDoubleDecimalPO> list();
}
