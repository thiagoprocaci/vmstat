package com.tbp.controller.dto;


import com.tbp.AuditBuilder;
import com.tbp.domain.Audit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CpuStatusTest {

    @Test
    public void testCpuStatus() {

        Audit audit = AuditBuilder.build();
        CpuStatus cpuStatus = new CpuStatus(audit);

        assertEquals(audit.getNonNiceUserCpuTicks(), cpuStatus.getNonNiceUserCpuTicks());
        assertEquals(audit.getNiceUserCpuTicks(), cpuStatus.getNiceUserCpuTicks());
        assertEquals(audit.getSystemCpuTicks(), cpuStatus.getSystemCpuTicks());
        assertEquals(audit.getIdleCpuTicks(), cpuStatus.getIdleCpuTicks());
        assertEquals(audit.getIoWaitCpuTicks(), cpuStatus.getIoWaitCpuTicks());
        assertEquals(audit.getIrqCpuTicks(), cpuStatus.getIrqCpuTicks());
        assertEquals(audit.getSoftirqCpuTicks(), cpuStatus.getSoftirqCpuTicks());
        assertEquals(audit.getStolenCpuTicks(), cpuStatus.getStolenCpuTicks());
        assertEquals(audit.getIpRunnerMachine(), cpuStatus.getIpRunnerMachine());
    }

}
