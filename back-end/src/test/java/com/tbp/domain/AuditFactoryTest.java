package com.tbp.domain;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AuditFactoryTest {

    private AuditFactory auditFactory;

    @Before
    public void before() {
        auditFactory = new AuditFactory();
    }

    @Test
    public void testCreate() {
        String ip = "10.0.5.134";
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

        Audit audit = auditFactory.create(ip,  totalMemory,  usedMemory,  activeMemory,  inactiveMemory,  freeMemory,  bufferMemory,  swapCache,  totalSwap,  usedSwap,  freeSwap,  nonNiceUserCpuTicks,  niceUserCpuTicks,  systemCpuTicks,  idleCpuTicks,  ioWaitCpuTicks,  irqCpuTicks,  softirqCpuTicks,  stolenCpuTicks,  pagesPagedIn,  pagesPagedOut,  pagesSwappedIn,  pagesSwappedOut,  interrupts,  cpuContextSwitches,  bootTime,  forks);
        assertEquals(ip, audit.getIpRunnerMachine());
        assertEquals(totalMemory, audit.getTotalMemory());
        assertEquals(usedMemory, audit.getUsedMemory());
        assertEquals(activeMemory, audit.getActiveMemory());
        assertEquals(inactiveMemory, audit.getInactiveMemory());
        assertEquals(freeMemory, audit.getFreeMemory());
        assertEquals(bufferMemory, audit.getBufferMemory());
        assertEquals(swapCache, audit.getSwapCache());
        assertEquals(totalSwap, audit.getTotalSwap());
        assertEquals(usedSwap, audit.getUsedSwap());
        assertEquals(freeSwap, audit.getFreeSwap());
        assertEquals(nonNiceUserCpuTicks, audit.getNonNiceUserCpuTicks());
        assertEquals(niceUserCpuTicks, audit.getNiceUserCpuTicks());
        assertEquals(systemCpuTicks, audit.getSystemCpuTicks());
        assertEquals(idleCpuTicks, audit.getIdleCpuTicks());
        assertEquals(ioWaitCpuTicks, audit.getIoWaitCpuTicks());
        assertEquals(irqCpuTicks, audit.getIrqCpuTicks());
        assertEquals(softirqCpuTicks, audit.getSoftirqCpuTicks());
        assertEquals(stolenCpuTicks, audit.getStolenCpuTicks());
        assertEquals(pagesPagedIn, audit.getPagesPagedIn());
        assertEquals(pagesPagedOut, audit.getPagesPagedOut());
        assertEquals(pagesSwappedIn, audit.getPagesSwappedIn());
        assertEquals(pagesSwappedOut, audit.getPagesSwappedOut());
        assertEquals(interrupts, audit.getInterrupts());
        assertEquals(cpuContextSwitches, audit.getCpuContextSwitches());
        assertEquals(bootTime, audit.getBootTime());
        assertEquals(forks, audit.getForks());
    }


}
