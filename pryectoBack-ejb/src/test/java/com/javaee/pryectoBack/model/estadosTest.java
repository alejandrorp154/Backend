package com.javaee.pryectoBack.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class estadosTest {

  @Before
  public void init(){
    MockitoAnnotations.initMocks(this);
  }

    @Test
    public void values() {
    }

    @Test
    public void valueOf() {
      Assert.assertEquals(estados.valueOf("pendiente").toString(), estados.pendiente.toString());
      Assert.assertEquals(estados.valueOf("enCurso").toString(), estados.enCurso.toString());
      Assert.assertEquals(estados.valueOf("cancelado").toString(), estados.cancelado.toString());
      Assert.assertEquals(estados.valueOf("terminado").toString(), estados.terminado.toString());
    }
}
