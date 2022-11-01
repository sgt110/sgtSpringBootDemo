package com.sgt.service.junit.impl

import com.sgt.bo.TestBO
import com.sgt.bo.TestBO2
import com.sgt.dal.nhsa.NhsaReportStatisticsMapper
import com.sgt.dal.nhsa.po.NhsaEnterGroupRecordPO
import com.sgt.dal.patientsignrecordsnapshot.StatisticPatientSignRecordSnapshotMapper
import com.sgt.dal.patientsignrecordsnapshot.po.StatisticPatientSignRecordSnapshotPO
import com.sgt.service.junit.helper.JunitTestHelper
import org.junit.runner.RunWith
import org.mockito.Mockito
import spock.lang.Specification
import spock.lang.Title
import spock.lang.Unroll

/*
 * Project: sgtSpringBootDemo
 * 
 * File Created at 2022-10-09
 
 * Copyright 2014 ANTEAM-INC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Anteam_INC Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with ANTEAM-INC.
 */
@Title("测试Spock单测")
class SpockTestServiceImplTest extends Specification {
    StatisticPatientSignRecordSnapshotMapper snapshotMapper = Mock(StatisticPatientSignRecordSnapshotMapper)
    NhsaReportStatisticsMapper nhsaReportStatisticsMapper = Mock(NhsaReportStatisticsMapper)
    JunitTestHelper junitTestHelper = Mockito.spy(JunitTestHelper)
    def junitTestService = new JunitTestServiceImpl(mapper: snapshotMapper, nhsaReportStatisticsMapper: nhsaReportStatisticsMapper,junitTestHelper: junitTestHelper)

    @Unroll
    def "testGetByBo#title"() {
        given: "准备"
        snapshotMapper.list() >> poList
        nhsaReportStatisticsMapper.list() >> list

        when: "执行方法"
        def res = junitTestService.getByBo(testBO2)

        then: "校验结果"
        res == resList

        where: "设置数据"
        title | testBO2           | poList      | list      || resList
        "成功1" | new TestBO2(0, 0) | getPOList() | getList() || new TestBO(0, 1, new TestBO2(0, 0))
        "成功2" | new TestBO2(1, 0) | getPOList() | getList() || new TestBO(1, 1, new TestBO2(1, 0))
        "成功3" | new TestBO2(0, 1) | getPOList() | getList() || new TestBO(0, 0, new TestBO2(0, 1))
        "成功4" | new TestBO2(1, 1) | getPOList() | getList() || new TestBO(0, 0, new TestBO2(1, 1))
        "成功5" | null              | getPOList() | getList() || new TestBO(0, 0, null)
        "情况1" | new TestBO2(0, 0) | []          | getList() || new TestBO(0, 0, new TestBO2(0, 0))
        "情况3" | new TestBO2(1, 0) | getPOList() | []        || new TestBO(1, 0, new TestBO2(1, 0))
    }

    private List<StatisticPatientSignRecordSnapshotPO> getPOList (){
        return [new StatisticPatientSignRecordSnapshotPO(hospitalCode: "hospitalCode")]
    }

    private List<NhsaEnterGroupRecordPO> getList() {
        return [new NhsaEnterGroupRecordPO(signRecordCode: "signRecordCode")]
    }

    @Unroll
    def "testGetByBo2#title"() {
        given: "准备"
//        Mockito.when(junitTestHelper.testVoid()).thenCallRealMethod()
//        Mockito.doCallRealMethod().when(junitTestHelper).testVoid()

        when: "执行方法"
        def res = junitTestService.getByBo2(testBO2)

        then: "校验结果"
        res == resList

        where: "设置数据"
        title | testBO2           || resList
        "成功1" | new TestBO2(0, 0) || new TestBO(0, 1, new TestBO2(0, 0))
        "成功2" | new TestBO2(1, 0) || new TestBO(1, 1, new TestBO2(1, 0))
    }
}
