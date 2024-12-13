package com.javaee.pryectoBack.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class tiposTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void values() {
    }

    @Test
    public void valueOf() {
        Assert.assertEquals(tipos.valueOf("enlaceExterno").toString(),tipos.enlaceExterno.toString());
        Assert.assertEquals(tipos.valueOf("texto").toString(),tipos.texto.toString());
        Assert.assertEquals(tipos.valueOf("foto").toString(),tipos.foto.toString());
        Assert.assertEquals(tipos.valueOf("mapa").toString(),tipos.mapa.toString());
    }
}
