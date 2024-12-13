package com.javaee.pryectoBack.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.Assert;


@RunWith(MockitoJUnitRunner.class)
public class rangosTest {

    @Before
    public void init(){
      MockitoAnnotations.initMocks(this);
    }

    @Test
    public void values() {
    }

    @Test
    public void valueOf() {
      Assert.assertEquals(rangos.valueOf("ironWolf").toString(), rangos.ironWolf.toString());
      Assert.assertEquals(rangos.valueOf("bronzeWolf").toString(), rangos.bronzeWolf.toString());
      Assert.assertEquals(rangos.valueOf("silverWolf").toString(), rangos.silverWolf.toString());
      Assert.assertEquals(rangos.valueOf("goldWolf").toString(), rangos.goldWolf.toString());
      Assert.assertEquals(rangos.valueOf("platinumWolf").toString(), rangos.platinumWolf.toString());
      Assert.assertEquals(rangos.valueOf("diamondWolf").toString(), rangos.diamondWolf.toString());
      Assert.assertEquals(rangos.valueOf("masterWolf").toString(), rangos.masterWolf.toString());
      Assert.assertEquals(rangos.valueOf("alfaWolf").toString(), rangos.alfaWolf.toString());
    }
}
