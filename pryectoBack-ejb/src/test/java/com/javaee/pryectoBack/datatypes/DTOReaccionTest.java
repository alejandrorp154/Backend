package com.javaee.pryectoBack.datatypes;

import com.javaee.pryectoBack.model.reacciones;
import org.bson.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DTOReaccionTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        dtoReaccion.setIdComentarioReaccion("1");
        dtoReaccion.setIdPublicacion(1);
        dtoReaccion.setIdPersona("1");
        dtoReaccion.setReaccion(reacciones.MeGusta);
    }

    private DTOReaccion dtoReaccion = new DTOReaccion();

    @Test
    public void dtoReaccionDefault(){
        DTOReaccion dtoReac = new DTOReaccion();
        Assert.assertNotNull(dtoReac);
    }

    @Test
    public void dtoReaccionParams(){
        DTOReaccion dtoReacc = new DTOReaccion("1",1,"1",reacciones.MeGusta);
        Assert.assertNotNull(dtoReacc);
    }

    @Test
    public void getIdComentario() {
        String idComen = dtoReaccion.getIdComentario();
        Assert.assertEquals("1",idComen);
    }

    @Test
    public void setIdComentarioReaccion() {
        dtoReaccion.setIdComentarioReaccion("2");
        Assert.assertEquals("2",dtoReaccion.getIdComentario());
    }

    @Test
    public void getIdPublicacion() {
        int idPub = dtoReaccion.getIdPublicacion();
        Assert.assertEquals(1,idPub);
    }

    @Test
    public void setIdPublicacion() {
        dtoReaccion.setIdPublicacion(2);
        Assert.assertEquals(2,dtoReaccion.getIdPublicacion());
    }

    @Test
    public void getIdPersona() {
        String idPer = dtoReaccion.getIdPersona();
        Assert.assertEquals("1",idPer);
    }

    @Test
    public void setIdPersona() {
        dtoReaccion.setIdPersona("2");
        Assert.assertEquals("2",dtoReaccion.getIdPersona());
    }

    @Test
    public void getReaccion() {
        reacciones reac = dtoReaccion.getReaccion();
        Assert.assertEquals(reacciones.MeGusta,reac);
    }

    @Test
    public void setReaccion() {
        dtoReaccion.setReaccion(reacciones.NoMeGusta);
        Assert.assertEquals(reacciones.NoMeGusta,dtoReaccion.getReaccion());
    }

    @Test
    public void getDocumentPublicacion() {
        Document doc = dtoReaccion.getDocumentPublicacion();
        Assert.assertNotNull(doc);
    }

    @Test
    public void getDocumentComentario() {
        Document doc = dtoReaccion.getDocumentComentario();
        Assert.assertNotNull(doc);
    }
}
