package com.javaee.pryectoBack.model;

import com.javaee.pryectoBack.datatypes.DTOTipo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class TipoTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        tipo.setIdPublicacion(1);
        tipo.setTipo(tipos.mapa);
    }

    private Tipo tipo = new Tipo();

    @Test
    public void tipo(){
        Tipo ti = new Tipo();
        Assert.assertNotNull(ti);
    }

    @Test
    public void tipoDTO(){
        DTOTipo dtoTipo = new DTOTipo(2,tipos.enlaceExterno);
        Tipo ti = new Tipo(dtoTipo);
        Assert.assertNotNull(ti);
        Assert.assertEquals(2,ti.getIdPublicacion());
        Assert.assertEquals(tipos.enlaceExterno,ti.getTipo());
    }

    @Test
    public void getIdPublicacion() {
        int idpublicacion = tipo.getIdPublicacion();
        Assert.assertEquals(1,idpublicacion);
    }

    @Test
    public void setIdPublicacion() {
        tipo.setIdPublicacion(2);
        Assert.assertEquals(2,tipo.getIdPublicacion());
    }

    @Test
    public void getTipo() {
        tipos ti = tipo.getTipo();
        Assert.assertEquals(tipos.mapa,ti);
    }

    @Test
    public void setTipo() {
        tipo.setTipo(tipos.mapa);
        Assert.assertEquals(tipos.mapa,tipo.getTipo());
    }
}
