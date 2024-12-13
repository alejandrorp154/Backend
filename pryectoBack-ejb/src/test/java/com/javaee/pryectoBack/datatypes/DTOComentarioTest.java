package com.javaee.pryectoBack.datatypes;

import org.bson.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class DTOComentarioTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        dtoComentario.setIdComentario("1");
        dtoComentario.setContenido("Contenido");
        Date date = new Date(2021, Calendar.JUNE,21);
        dtoComentario.setFecha(date);
        dtoComentario.setIdPublicacion(1);
        dtoComentario.setIdComentarioPadre("");
        dtoComentario.setIdPersona("1");
        List<DTOComentario> comentariosHijos = new ArrayList<>();
        dtoComentario.setComentariosHijos(comentariosHijos);
        dtoComentario.setCantidadLikes(15);
        dtoComentario.setCantidadDislikes(5);
    }

    private DTOComentario dtoComentario = new DTOComentario();

    @Test
    public void dtoComentariosDefault(){
        DTOComentario dtoCom = new DTOComentario();
        Assert.assertNotNull(dtoCom);
    }

    @Test
    public void dtoComentarioParams(){
        Date date = new Date(2021, Calendar.JANUARY,2);
        DTOComentario dtoComent = new DTOComentario("15","Conte",date,18,"4","");

        Assert.assertNotNull(dtoComent);
        Assert.assertEquals("15",dtoComent.getIdComentario());
        Assert.assertEquals("Conte",dtoComent.getContenido());
        Assert.assertEquals(new Date(2021, Calendar.JANUARY,2),dtoComent.getFecha());
        Assert.assertEquals(18,dtoComent.getIdPublicacion());
        Assert.assertEquals("4",dtoComent.getIdPersona());
        Assert.assertEquals("",dtoComent.getIdComentarioPadre());
    }



    @Test
    public void dtoComentarioDocument(){
        Document docu = dtoComentario.getDocument();
        DTOComentario dtoComent = new DTOComentario(docu);
        Assert.assertNotNull(dtoComent);
    }

    @Test
    public void getIdComentario() {
        String idComent = dtoComentario.getIdComentario();
        Assert.assertEquals("1",idComent);
    }

    @Test
    public void setIdComentario() {
        dtoComentario.setIdComentario("2");
        Assert.assertEquals("2",dtoComentario.getIdComentario());
    }

    @Test
    public void getContenido() {
        String cont = dtoComentario.getContenido();
        Assert.assertEquals("Contenido",cont);
    }

    @Test
    public void setContenido() {
        dtoComentario.setContenido("Cont");
        Assert.assertEquals("Cont",dtoComentario.getContenido());
    }

    @Test
    public void getFecha() {
        Date date = dtoComentario.getFecha();
        Assert.assertEquals(new Date(2021, Calendar.JUNE,21),date);
    }

    @Test
    public void setFecha() {
        Date date = new Date(2021, Calendar.NOVEMBER,11);
        dtoComentario.setFecha(date);
        Assert.assertEquals(new Date(2021, Calendar.NOVEMBER,11), dtoComentario.getFecha());
    }

    @Test
    public void getIdPublicacion() {
        int idPub = dtoComentario.getIdPublicacion();
        Assert.assertEquals(1,idPub);
    }

    @Test
    public void setIdPublicacion() {
        dtoComentario.setIdPublicacion(2);
        Assert.assertEquals(2,dtoComentario.getIdPublicacion());
    }

    @Test
    public void getIdPersona() {
        String idPers = dtoComentario.getIdPersona();
        Assert.assertEquals("1",idPers);
    }

    @Test
    public void setIdPersona() {
        dtoComentario.setIdPersona("2");
        Assert.assertEquals("2",dtoComentario.getIdPersona());
    }

    @Test
    public void getIdComentarioPadre() {
        String idComPadre = dtoComentario.getIdComentarioPadre();
        Assert.assertEquals("",idComPadre);
    }

    @Test
    public void setIdComentarioPadre() {
        dtoComentario.setIdComentarioPadre("5");
        Assert.assertEquals("5",dtoComentario.getIdComentarioPadre());
    }

    @Test
    public void getDocument() {
        Document docu = dtoComentario.getDocument();
        Assert.assertNotNull(docu);
    }

    @Test
    public void getComentariosHijos() {
        List<DTOComentario> comentHijos = dtoComentario.getComentariosHijos();
        Assert.assertNotNull(comentHijos);
    }

    @Test
    public void setComentariosHijos() {
        dtoComentario.setComentariosHijos(null);
        List<DTOComentario> comentHijos = new ArrayList<>();
        dtoComentario.setComentariosHijos(comentHijos);
        Assert.assertNotNull(dtoComentario.getComentariosHijos());
    }

    @Test
    public void getCantidadLikes() {
        Integer like = dtoComentario.getCantidadLikes();
        Assert.assertEquals(new Integer(15),like);
    }

    @Test
    public void setCantidadLikes() {
        dtoComentario.setCantidadLikes(20);
        Assert.assertEquals(new Integer(20),dtoComentario.getCantidadLikes());
    }

    @Test
    public void getCantidadDislikes() {
        Integer disLike = dtoComentario.getCantidadDislikes();
        Assert.assertEquals(new Integer(5),disLike);
    }

    @Test
    public void setCantidadDislikes() {
        dtoComentario.setCantidadDislikes(1);
        Assert.assertEquals(new Integer(1),dtoComentario.getCantidadDislikes());
    }
}
