package com.tbp.controller.factory;


import com.tbp.controller.dto.Machine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MachineListFactoryTest {

    MachineListFactory machineListFactory;

    @Before
    public void before() {
        machineListFactory = new MachineListFactory();
    }


    @Test
    public void testCreate() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        List<Machine> machineList = machineListFactory.create(list);
        Assert.assertNotNull(machineList);
        Assert.assertEquals(list.get(0), machineList.get(0).getIp());
        Assert.assertEquals(list.get(1), machineList.get(1).getIp());

        Assert.assertTrue(machineListFactory.create(null).isEmpty());
        Assert.assertTrue(machineListFactory.create(new ArrayList<String>()).isEmpty());

    }



}
