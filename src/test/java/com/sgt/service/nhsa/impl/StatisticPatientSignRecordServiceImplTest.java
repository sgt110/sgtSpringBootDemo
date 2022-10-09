package com.sgt.service.nhsa.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
class StatisticPatientSignRecordServiceImplTest {

    @Mock
    private StatisticPatientSignRecordSnapshotMapper mockMapper;
    @Mock
    private NhsaReportStatisticsMapper mockNhsaReportStatisticsMapper;

    @InjectMocks
    private StatisticPatientSignRecordServiceImpl statisticPatientSignRecordServiceImplUnderTest;

    @Test
    void testInitStatisticPatientSignRecordData() {
        // Setup
        // Configure StatisticPatientSignRecordSnapshotMapper.list(...).
        final List<StatisticPatientSignRecordSnapshotPO> poList = Collections
            .singletonList(new StatisticPatientSignRecordSnapshotPO("cardNo"));
        when(mockMapper.list()).thenReturn(poList);

        // Run the test
        statisticPatientSignRecordServiceImplUnderTest.initStatisticPatientSignRecordData();

        // Verify the results
        verify(mockMapper).batchInsert(Collections.singletonList(new StatisticPatientSignRecordSnapshotPO("cardNo")));
    }

    @Test
    void testInitStatisticPatientSignRecordData_StatisticPatientSignRecordSnapshotMapperListReturnsNoItems() {
        // Setup
        when(mockMapper.list()).thenReturn(Collections.emptyList());

        // Run the test
        statisticPatientSignRecordServiceImplUnderTest.initStatisticPatientSignRecordData();

        // Verify the results
        verify(mockMapper).batchInsert(Arrays.asList(new StatisticPatientSignRecordSnapshotPO("cardNo")));
    }

    @Test
    void testInitNhsaEnterGroupRecordData() {
        // Setup
        // Configure StatisticPatientSignRecordSnapshotMapper.list(...).
        final List<StatisticPatientSignRecordSnapshotPO> poList = Arrays
            .asList(new StatisticPatientSignRecordSnapshotPO("cardNo"));
        when(mockMapper.list()).thenReturn(poList);

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
        nhsaEnterGroupRecordPO.setSignRecordSnapshotId("id");
        nhsaEnterGroupRecordPO.setGmtCreated(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        nhsaEnterGroupRecordPO.setGmtModified(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<NhsaEnterGroupRecordPO> list = Arrays.asList(nhsaEnterGroupRecordPO);
        when(mockNhsaReportStatisticsMapper.list()).thenReturn(list);

        when(mockNhsaReportStatisticsMapper.insert(Arrays.asList(new NhsaEnterGroupRecordPO()))).thenReturn(0);

        // Run the test
        statisticPatientSignRecordServiceImplUnderTest.initNhsaEnterGroupRecordData();

        // Verify the results
        verify(mockNhsaReportStatisticsMapper).insert(Arrays.asList(new NhsaEnterGroupRecordPO()));
    }

    @Test
    void testInitNhsaEnterGroupRecordData_StatisticPatientSignRecordSnapshotMapperReturnsNoItems() {
        // Setup
        when(mockMapper.list()).thenReturn(Collections.emptyList());

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
        nhsaEnterGroupRecordPO.setSignRecordSnapshotId("id");
        nhsaEnterGroupRecordPO.setGmtCreated(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        nhsaEnterGroupRecordPO.setGmtModified(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<NhsaEnterGroupRecordPO> list = Arrays.asList(nhsaEnterGroupRecordPO);
        when(mockNhsaReportStatisticsMapper.list()).thenReturn(list);

        when(mockNhsaReportStatisticsMapper.insert(Arrays.asList(new NhsaEnterGroupRecordPO()))).thenReturn(0);

        // Run the test
        statisticPatientSignRecordServiceImplUnderTest.initNhsaEnterGroupRecordData();

        // Verify the results
        verify(mockNhsaReportStatisticsMapper).insert(Arrays.asList(new NhsaEnterGroupRecordPO()));
    }

    @Test
    void testInitNhsaEnterGroupRecordData_NhsaReportStatisticsMapperListReturnsNoItems() {
        // Setup
        // Configure StatisticPatientSignRecordSnapshotMapper.list(...).
        final List<StatisticPatientSignRecordSnapshotPO> poList = Arrays
            .asList(new StatisticPatientSignRecordSnapshotPO("cardNo"));
        when(mockMapper.list()).thenReturn(poList);

        when(mockNhsaReportStatisticsMapper.list()).thenReturn(Collections.emptyList());
        when(mockNhsaReportStatisticsMapper.insert(Arrays.asList(new NhsaEnterGroupRecordPO()))).thenReturn(0);

        // Run the test
        statisticPatientSignRecordServiceImplUnderTest.initNhsaEnterGroupRecordData();

        // Verify the results
        verify(mockNhsaReportStatisticsMapper).insert(Arrays.asList(new NhsaEnterGroupRecordPO()));
    }
}
