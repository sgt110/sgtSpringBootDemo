package com.sgt.service.junit.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.sgt.bo.TestBO;
import com.sgt.bo.TestBO2;
import com.sgt.dal.nhsa.NhsaReportStatisticsMapper;
import com.sgt.dal.nhsa.po.NhsaEnterGroupRecordPO;
import com.sgt.dal.patientsignrecordsnapshot.StatisticPatientSignRecordSnapshotMapper;
import com.sgt.dal.patientsignrecordsnapshot.po.StatisticPatientSignRecordSnapshotPO;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JunitTestServiceImplTest {

    @Mock
    private StatisticPatientSignRecordSnapshotMapper mockMapper;
    @Mock
    private NhsaReportStatisticsMapper mockNhsaReportStatisticsMapper;

    @InjectMocks
    private JunitTestServiceImpl junitTestServiceImplUnderTest;

    @Test
    void testGetByBo() {
        // Setup
        final TestBO2 testBO2 = new TestBO2();
        testBO2.setA(0);
        testBO2.setB(0);

        final TestBO2 testBO21 = new TestBO2();
        testBO21.setA(0);
        testBO21.setB(0);
        final TestBO expectedResult = new TestBO(0, 1, testBO21);

        // Configure StatisticPatientSignRecordSnapshotMapper.list(...).
        final List<StatisticPatientSignRecordSnapshotPO> poList = Collections
            .singletonList(new StatisticPatientSignRecordSnapshotPO("cardNo"));
        when(mockMapper.list()).thenReturn(poList);

        // Run the test
        final TestBO result = junitTestServiceImplUnderTest.getByBo(testBO2);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetByBo2() {
        // Setup
        final TestBO2 testBO2 = new TestBO2();
        testBO2.setA(1);
        testBO2.setB(0);

        final TestBO2 testBO21 = new TestBO2();
        testBO21.setA(1);
        testBO21.setB(0);
        final TestBO expectedResult = new TestBO(1, 1, testBO21);

        // Configure NhsaReportStatisticsMapper.list(...).
        final NhsaEnterGroupRecordPO nhsaEnterGroupRecordPO = new NhsaEnterGroupRecordPO();
        nhsaEnterGroupRecordPO.setPkId(0L);
        nhsaEnterGroupRecordPO.setId("id");
        nhsaEnterGroupRecordPO.setCardNo("cardNo");
        nhsaEnterGroupRecordPO.setSignRecordCode("signRecordCode");
        nhsaEnterGroupRecordPO.setGroupManagementCode("groupManagementCode");
        nhsaEnterGroupRecordPO.setStatusCode(0);
        nhsaEnterGroupRecordPO.setStatusDesc("statusDesc");
        nhsaEnterGroupRecordPO.setContent("content");
        nhsaEnterGroupRecordPO.setCreator("creator");
        nhsaEnterGroupRecordPO.setOperator("operator");
        nhsaEnterGroupRecordPO.setApiRecordId("apiRecordId");
        nhsaEnterGroupRecordPO.setEnterGroupId("enterGroupId");
        nhsaEnterGroupRecordPO.setSignRecordSnapshotId("signRecordSnapshotId");
        nhsaEnterGroupRecordPO.setGmtCreated(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        nhsaEnterGroupRecordPO.setGmtModified(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<NhsaEnterGroupRecordPO> list = Collections.singletonList(nhsaEnterGroupRecordPO);
        when(mockNhsaReportStatisticsMapper.list()).thenReturn(list);

        // Run the test
        final TestBO result = junitTestServiceImplUnderTest.getByBo(testBO2);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetByBo_StatisticPatientSignRecordSnapshotMapperReturnsNoItems() {
        // Setup
        final TestBO2 testBO2 = new TestBO2();
        testBO2.setA(0);
        testBO2.setB(0);

        final TestBO2 testBO21 = new TestBO2();
        testBO21.setA(0);
        testBO21.setB(0);
        final TestBO expectedResult = new TestBO(0, 0, testBO21);
        when(mockMapper.list()).thenReturn(Collections.emptyList());

        // Run the test
        final TestBO result = junitTestServiceImplUnderTest.getByBo(testBO2);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetByBo_NhsaReportStatisticsMapperReturnsNoItems() {
        // Setup
        final TestBO2 testBO2 = new TestBO2();
        testBO2.setA(0);
        testBO2.setB(0);

        final TestBO2 testBO21 = new TestBO2();
        testBO21.setA(0);
        testBO21.setB(0);
        final TestBO expectedResult = new TestBO(0, 1, testBO21);

        // Configure StatisticPatientSignRecordSnapshotMapper.list(...).
        final List<StatisticPatientSignRecordSnapshotPO> poList = Collections
            .singletonList(new StatisticPatientSignRecordSnapshotPO("cardNo"));
        when(mockMapper.list()).thenReturn(poList);

        when(mockNhsaReportStatisticsMapper.list()).thenReturn(Collections.emptyList());

        // Run the test
        final TestBO result = junitTestServiceImplUnderTest.getByBo(testBO2);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
