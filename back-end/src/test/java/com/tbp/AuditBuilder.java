package com.tbp;


import com.tbp.domain.Audit;

import java.lang.reflect.Field;

public class AuditBuilder {

    public static Audit build() {
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

        Audit a = new Audit(ip,  totalMemory,  usedMemory,  activeMemory,  inactiveMemory,  freeMemory,  bufferMemory,  swapCache,  totalSwap,  usedSwap,  freeSwap,  nonNiceUserCpuTicks,  niceUserCpuTicks,  systemCpuTicks,  idleCpuTicks,  ioWaitCpuTicks,  irqCpuTicks,  softirqCpuTicks,  stolenCpuTicks,  pagesPagedIn,  pagesPagedOut,  pagesSwappedIn,  pagesSwappedOut,  interrupts,  cpuContextSwitches,  bootTime,  forks);
        Field f;
        try {
            f = a.getClass().getDeclaredField("id");
            f.setAccessible(true);
            f.set(a, 1L);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return a;
    }

}
