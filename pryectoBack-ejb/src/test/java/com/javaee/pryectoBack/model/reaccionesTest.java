package com.javaee.pryectoBack.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class reaccionesTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void values() {
//        Assert.assertEquals(reacciones.valueOf("NoMeGusta").toString() , reacciones.NoMeGusta.toString());
//        Assert.assertEquals(reacciones.valueOf("MeGusta").toString() , reacciones.MeGusta.toString());
    }

    @Test
    public void valueOf() {
        Assert.assertEquals(reacciones.valueOf("NoMeGusta").toString() , reacciones.NoMeGusta.toString());
        Assert.assertEquals(reacciones.valueOf("MeGusta").toString() , reacciones.MeGusta.toString());
    }
}
