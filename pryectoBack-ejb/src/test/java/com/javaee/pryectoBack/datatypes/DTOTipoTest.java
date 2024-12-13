package com.javaee.pryectoBack.datatypes;

import com.javaee.pryectoBack.model.Tipo;
import com.javaee.pryectoBack.model.tipos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DTOTipoTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        dtoTipo.setIdPublicacion(1);
        dtoTipo.setTipo(tipos.texto);
    }

    private DTOTipo dtoTipo = new DTOTipo();

    @Test
    public void dtoTipoDefault(){
        DTOTipo dtoTi = new DTOTipo();
        Assert.assertNotNull(dtoTi);
    }

    @Test
    public void dtoTipoParams(){
        DTOTipo dtoTi = new DTOTipo(1,tipos.texto);
        Assert.assertEquals(1,dtoTi.getIdPublicacion());
        Assert.assertEquals(tipos.texto,dtoTi.getTipo());
    }

    @Test
    public void dtoTipoObj(){
        Tipo tipo = new Tipo();
        tipo.setIdPublicacion(1);
        tipo.setTipo(tipos.texto);

        DTOTipo dtoTi = new DTOTipo(tipo);
        Assert.assertNotNull(dtoTi);
        Assert.assertEquals(1,dtoTi.getIdPublicacion());
        Assert.assertEquals(tipos.texto,dtoTi.getTipo());
    }

    @Test
    public void getIdPublicacion() {
        int idPub = dtoTipo.getIdPublicacion();
        Assert.assertEquals(1, idPub);
    }

    @Test
    public void setIdPublicacion() {
        dtoTipo.setIdPublicacion(2);
        Assert.assertEquals(2,dtoTipo.getIdPublicacion());
    }

    @Test
    public void getTipo() {
        tipos ti = dtoTipo.getTipo();
        Assert.assertEquals(tipos.texto,ti);
    }

    @Test
    public void setTipo() {
        dtoTipo.setTipo(tipos.mapa);
        Assert.assertEquals(tipos.mapa,dtoTipo.getTipo());
    }
}
