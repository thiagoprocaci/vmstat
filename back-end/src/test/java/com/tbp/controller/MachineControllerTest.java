package com.tbp.controller;


import com.tbp.controller.dto.Machine;
import com.tbp.controller.factory.MachineListFactory;
import com.tbp.repository.AuditRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class MachineControllerTest {

    AuditRepository auditRepository;
    MachineListFactory machineListFactory;
    MachineController machineController;


    @Before
    public void before() {
        auditRepository = mock(AuditRepository.class);
        machineListFactory = mock(MachineListFactory.class);
        machineController = new MachineController();
        machineController.auditRepository = auditRepository;
        machineController.machineListFactory = machineListFactory;
    }

    @Test
    public void testAnnotation() throws NoSuchMethodException {
        assertTrue(MachineController.class.isAnnotationPresent(RestController.class));
        assertTrue(MachineController.class.isAnnotationPresent(RequestMapping.class));
        assertEquals("machine", MachineController.class.getAnnotation(RequestMapping.class).value()[0]);

        Method find = MachineController.class.getDeclaredMethod("find");
        assertTrue(find.isAnnotationPresent(CrossOrigin.class));
        assertTrue(find.isAnnotationPresent(RequestMapping.class));
        assertEquals(RequestMethod.GET, find.getAnnotation(RequestMapping.class).method()[0]);
        assertEquals("/", find.getAnnotation(RequestMapping.class).value()[0]);


        Field[] fields = MachineController.class.getDeclaredFields();
        assertFalse(fields.length == 0);
        for(Field f: fields) {
            assertTrue(f.isAnnotationPresent(Autowired.class));
        }
    }

    @Test
    public void testFind() {
        Collection<String> stringList = new ArrayList<>();
        stringList.add("a");

        Machine machine = new Machine("localhost");
        List<Machine> machineList = new ArrayList<>();
        machineList.add(machine);

        when(auditRepository.findAllIp()).thenReturn(stringList);
        when(machineListFactory.create(stringList)).thenReturn(machineList);

        Collection<Machine> list = machineController.find();
        assertFalse(list.isEmpty());
        assertEquals(machineList, list);
    }



}
