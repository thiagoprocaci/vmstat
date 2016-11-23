package com.tbp.controller.factory;


import com.tbp.controller.dto.MemoryStatus;
import com.tbp.domain.Audit;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MemoryStatusListFactoryTest {

    MemoryStatusListFactory memoryStatusListFactory;

    @Before
    public void before() {
        memoryStatusListFactory = new MemoryStatusListFactory();
    }

    @Test
    public void testCreate() throws IllegalAccessException, NoSuchFieldException {

        Long totalMemory = 8048596L;
        Long usedMemory = 5137340L;
        Long activeMemory = 4971944L;
        Long inactiveMemory = 1863576L;
        Long freeMemory = 507384L;
        Long bufferMemory = 388644L;
        Long swapCache =  2014988L;
        Long totalSwap =  8259580L;
        Long usedSwap =  45896L;
        Long freeSwap =  8213684L;
        Long nonNiceUserCpuTicks =  547648L;
        Long niceUserCpuTicks =  10601L;
        Long systemCpuTicks =  185046L;
        Long idleCpuTicks =  26288525L;
        Long ioWaitCpuTicks =  95903L;
        Long irqCpuTicks =  0L;
        Long softirqCpuTicks =  1597L;
        Long stolenCpuTicks =  0L;
        Long pagesPagedIn =  3680855L;
        Long pagesPagedOut =  8097236L;
        Long pagesSwappedIn =  240L;
        Long pagesSwappedOut =  11574L;
        Long interrupts =  32210185L;
        Long cpuContextSwitches =  88732486L;
        Long bootTime =  1479320066L;
        Long forks =  37260L;


        assertNotNull(memoryStatusListFactory.create(null));
        assertTrue(memoryStatusListFactory.create(null).isEmpty());
        List<Audit> auditList = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            String ip = i + "";
            Audit audit = new Audit(ip,  totalMemory,  usedMemory,  activeMemory,  inactiveMemory,  freeMemory,  bufferMemory,  swapCache,  totalSwap,  usedSwap,  freeSwap,  nonNiceUserCpuTicks,  niceUserCpuTicks,  systemCpuTicks,  idleCpuTicks,  ioWaitCpuTicks,  irqCpuTicks,  softirqCpuTicks,  stolenCpuTicks,  pagesPagedIn,  pagesPagedOut,  pagesSwappedIn,  pagesSwappedOut,  interrupts,  cpuContextSwitches,  bootTime,  forks);
            auditList.add(audit);
        }
        List<MemoryStatus> memoryStatusList = memoryStatusListFactory.create(auditList);
        assertNotNull(memoryStatusList);
        assertFalse(memoryStatusList.isEmpty());
        assertEquals(2, memoryStatusList.size());
        assertEquals("0", memoryStatusList.get(0).getIpRunnerMachine());
        assertEquals("1", memoryStatusList.get(1).getIpRunnerMachine());
    }
}
