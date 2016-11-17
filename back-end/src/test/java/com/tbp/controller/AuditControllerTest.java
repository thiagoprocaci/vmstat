package com.tbp.controller;


import com.tbp.domain.Audit;
import com.tbp.domain.AuditFactory;
import com.tbp.repository.AuditRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AuditControllerTest {

    AuditFactory auditFactory;
    AuditRepository auditRepository;
    AuditController auditController;

    @Before
    public void before() {
        auditFactory = mock(AuditFactory.class);
        auditRepository = mock(AuditRepository.class);

        auditController = new AuditController();
        auditController.auditRepository = auditRepository;
        auditController.auditFactory = auditFactory;
    }

    @Test
    public void testAnnotation() throws NoSuchMethodException {
        assertTrue(AuditController.class.isAnnotationPresent(RestController.class));
        assertTrue(AuditController.class.isAnnotationPresent(RequestMapping.class));
        assertEquals("audit", AuditController.class.getAnnotation(RequestMapping.class).value()[0]);

        Method startsAuditing = AuditController.class.getDeclaredMethod("startsAuditing", String.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class);
        assertFalse(startsAuditing.isAnnotationPresent(CrossOrigin.class));
        assertTrue(startsAuditing.isAnnotationPresent(RequestMapping.class));
        assertEquals(RequestMethod.PUT, startsAuditing.getAnnotation(RequestMapping.class).method()[0]);
        assertEquals("/", startsAuditing.getAnnotation(RequestMapping.class).value()[0]);


        Method list = AuditController.class.getDeclaredMethod("list");
        assertTrue(list.isAnnotationPresent(CrossOrigin.class));
        assertTrue(list.isAnnotationPresent(RequestMapping.class));
        assertEquals(RequestMethod.GET, list.getAnnotation(RequestMapping.class).method()[0]);
        assertEquals("/", list.getAnnotation(RequestMapping.class).value()[0]);


        Field[] fields = AuditController.class.getDeclaredFields();
        assertFalse(fields.length == 0);
        for(Field f: fields) {
            assertTrue(f.isAnnotationPresent(Autowired.class));
        }
    }

    @Test
    public void testList() throws NoSuchFieldException, IllegalAccessException {
        Audit a = new Audit();
        Field f = a.getClass().getDeclaredField("id");
        f.setAccessible(true);
        f.set(a, 1L);

        List<Audit> auditList = new ArrayList<>();
        auditList.add(a);
        when(auditRepository.findAll()).thenReturn(auditList);

        assertEquals(auditList, auditController.list());
    }

    @Test
    public void startsAuditingTest() throws NoSuchFieldException, IllegalAccessException {
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

        Audit a = new Audit();
        Field f = a.getClass().getDeclaredField("id");
        f.setAccessible(true);
        f.set(a, 1L);


        when(auditFactory.create(ip,  totalMemory,  usedMemory,  activeMemory,  inactiveMemory,  freeMemory,  bufferMemory,
                swapCache,  totalSwap,  usedSwap,  freeSwap,  nonNiceUserCpuTicks,  niceUserCpuTicks,  systemCpuTicks,  idleCpuTicks,  ioWaitCpuTicks,  irqCpuTicks,  softirqCpuTicks,
                stolenCpuTicks,  pagesPagedIn,  pagesPagedOut,  pagesSwappedIn,  pagesSwappedOut,  interrupts,  cpuContextSwitches,  bootTime,  forks)).thenReturn(a);
        when(auditRepository.save(a)).thenReturn(a);

        Audit a2 = auditController.startsAuditing(ip,  totalMemory,  usedMemory,  activeMemory,  inactiveMemory,  freeMemory,  bufferMemory,  swapCache,  totalSwap,  usedSwap,  freeSwap,  nonNiceUserCpuTicks,  niceUserCpuTicks,  systemCpuTicks,  idleCpuTicks,  ioWaitCpuTicks,  irqCpuTicks,  softirqCpuTicks,  stolenCpuTicks,  pagesPagedIn,  pagesPagedOut,  pagesSwappedIn,  pagesSwappedOut,  interrupts,  cpuContextSwitches,  bootTime,  forks);
        verify(auditRepository).save(a);
        assertEquals(a, a2);
    }


}
