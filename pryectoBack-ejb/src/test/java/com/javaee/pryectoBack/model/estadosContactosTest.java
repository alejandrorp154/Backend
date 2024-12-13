package com.javaee.pryectoBack.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class estadosContactosTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void values() {
    }

    @Test
    public void valueOf() {
        Assert.assertEquals(estadosContactos.valueOf("pendiente").toString(), estadosContactos.pendiente.toString());
        Assert.assertEquals(estadosContactos.valueOf("aceptada").toString(), estadosContactos.aceptada.toString());
        Assert.assertEquals(estadosContactos.valueOf("cancelada").toString(), estadosContactos.cancelada.toString());
        Assert.assertEquals(estadosContactos.valueOf("borrado").toString(), estadosContactos.borrado.toString());
    }
}
