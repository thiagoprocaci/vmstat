package com.tbp.controller.dto;


import com.tbp.AuditBuilder;
import com.tbp.domain.Audit;
import org.junit.Test;


import java.text.SimpleDateFormat;

import static com.tbp.controller.dto.MemoryStatus.*;
import static org.junit.Assert.*;

public class MemoryStatusTest {

    @Test
    public void testMemoryStatus() {
        Audit audit = AuditBuilder.build();
        MemoryStatus memoryStatus = new MemoryStatus(audit);
        assertEquals((round(audit.getTotalMemory() * CONVERTER, PLACES)), memoryStatus.getTotalMemory().doubleValue(), 0.001);
        assertEquals((round(audit.getUsedMemory() * CONVERTER, PLACES)), memoryStatus.getUsedMemory().doubleValue(), 0.001);
        assertEquals((round(audit.getActiveMemory() * CONVERTER, PLACES)), memoryStatus.getActiveMemory().doubleValue(), 0.001);
        assertEquals((round(audit.getInactiveMemory() * CONVERTER, PLACES)), memoryStatus.getInactiveMemory().doubleValue(), 0.001);
        assertEquals((round(audit.getFreeMemory() * CONVERTER, PLACES)), memoryStatus.getFreeMemory().doubleValue(), 0.001);
        assertEquals((round(audit.getBufferMemory() * CONVERTER, PLACES)), memoryStatus.getBufferMemory().doubleValue(), 0.001);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        assertEquals(simpleDateFormat.format(audit.getDate()), memoryStatus.getDate());
        assertEquals(audit.getIpRunnerMachine(), memoryStatus.getIpRunnerMachine());

        assertEquals(UNIT_MEASUREMENT, memoryStatus.getUnitMeasurement());
    }

    @Test
    public void testRound() {
        assertEquals(2.55, round(2.5455555, PLACES), 0.001);
        assertEquals(2.54, round(2.5445555, PLACES), 0.001);
    }



}
