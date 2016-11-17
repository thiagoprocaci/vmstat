package com.tbp.domain;


import org.springframework.stereotype.Component;

@Component
public class AuditFactory {

    public Audit create(String ipRunnerMachine, Long totalMemory, Long usedMemory, Long activeMemory, Long inactiveMemory, Long freeMemory, Long bufferMemory, Long swapCache, Long totalSwap, Long usedSwap, Long freeSwap, Long nonNiceUserCpuTicks, Long niceUserCpuTicks, Long systemCpuTicks, Long idleCpuTicks, Long ioWaitCpuTicks, Long irqCpuTicks, Long softirqCpuTicks, Long stolenCpuTicks, Long pagesPagedIn, Long pagesPagedOut, Long pagesSwappedIn, Long pagesSwappedOut, Long interrupts, Long cpuContextSwitches, Long bootTime, Long forks) {
        return new Audit(ipRunnerMachine,  totalMemory,  usedMemory,  activeMemory,  inactiveMemory,  freeMemory,  bufferMemory,  swapCache,  totalSwap,  usedSwap,  freeSwap,  nonNiceUserCpuTicks,  niceUserCpuTicks,  systemCpuTicks,  idleCpuTicks,  ioWaitCpuTicks,  irqCpuTicks,  softirqCpuTicks,  stolenCpuTicks,  pagesPagedIn,  pagesPagedOut,  pagesSwappedIn,  pagesSwappedOut,  interrupts,  cpuContextSwitches,  bootTime,  forks);
    }

}
