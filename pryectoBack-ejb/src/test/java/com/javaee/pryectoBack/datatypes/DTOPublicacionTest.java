package com.javaee.pryectoBack.datatypes;

import com.javaee.pryectoBack.model.Publicacion;
import com.javaee.pryectoBack.model.estados;
import com.javaee.pryectoBack.model.tipos;
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
public class DTOPublicacionTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        dtoPublicacion.setIdPublicacion(1);
        dtoPublicacion.setContenido("Contenido pub");
        Date date = new Date(2021, Calendar.JUNE,21);
        dtoPublicacion.setFecha(date);
        DTOTipo dtoTipo = new DTOTipo(1, tipos.texto);
        dtoPublicacion.setTipo(dtoTipo);
        dtoPublicacion.setIdPersona("1");
        dtoPublicacion.setExtension("jpg");
        dtoPublicacion.setNombre("Publicacion 1");
        List<DTOComentario> comentarioReacciones = new ArrayList<>();
        dtoPublicacion.setComentarioReacciones(comentarioReacciones);
        Date date1 = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(1,"Evento de prueba",date1, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");
        dtoPublicacion.setEvento(dtoEvento);
        DTOPerfilUsuario dtoPerfilUsuario = new DTOPerfilUsuario();
        DTOUsuario dtoUser = new DTOUsuario("1", "probanto3@gmail.com", "Peter", "Montes", "monters", "en su casa3", "099333333", "Brasil","imagen3", "imagenPerfil3", "jpg");
        dtoPerfilUsuario.setUsuario(dtoUser);
        dtoPublicacion.setPerfil(dtoPerfilUsuario);
        dtoPublicacion.setCantidadLikes(100);
        dtoPublicacion.setCantidadDislikes(5);
        dtoPublicacion.setCantidadComentarios(0);
    }

    private DTOPublicacion dtoPublicacion = new DTOPublicacion();

    @Test
    public void dtoPublicacionDefault(){
        DTOPublicacion dtoPub = new DTOPublicacion();
        Assert.assertNotNull(dtoPub);
    }

    @Test
    public void dtoPublicacionParams(){
        Date date = new Date(2021, Calendar.JUNE,21);
        DTOTipo dtoTipo = new DTOTipo(1, tipos.foto);
        List<DTOComentario> dtoCome = new ArrayList<>();
        Date date1 = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(1,"Evento de prueba",date1, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");
        DTOPerfilUsuario dtoPerfilUsuario = new DTOPerfilUsuario();
        DTOUsuario dtoUser = new DTOUsuario("1", "probanto3@gmail.com", "Peter", "Montes", "monters", "en su casa3", "099333333", "Brasil","imagen3", "imagenPerfil3", "jpg");
        dtoPerfilUsuario.setUsuario(dtoUser);
        DTOPublicacion dtoPub = new DTOPublicacion(1,"COntenido pub",date,dtoTipo,"1","jpg","Nombre pub",dtoCome,dtoEvento,dtoPerfilUsuario);
        Assert.assertNotNull(dtoPub);
    }

    @Test
    public void dtoPublicacionObj(){
        Date date = new Date(2021, Calendar.JUNE,21);
        DTOTipo dtoTipo = new DTOTipo(1,tipos.foto);
        List<DTOComentario> comentarios = new ArrayList<>();
        Date date1 = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(1,"Evento de prueba",date1, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");
        DTOPerfilUsuario dtoPerfilUsuario = new DTOPerfilUsuario();
        DTOUsuario dtoUser = new DTOUsuario("1", "probanto3@gmail.com", "Peter", "Montes", "monters", "en su casa3", "099333333", "Brasil","imagen3", "imagenPerfil3", "jpg");
        dtoPerfilUsuario.setUsuario(dtoUser);
        DTOPublicacion dtoPublicacion = new DTOPublicacion(1,"contenido",date,dtoTipo,"1","jpg","Nombre Imagen",comentarios,dtoEvento,dtoPerfilUsuario);
        Publicacion publicacion = new Publicacion(dtoPublicacion);
        DTOPublicacion dtoPub = new DTOPublicacion(publicacion);
        Assert.assertNotNull(dtoPub);
    }

    @Test
    public void getIdPublicacion() {
        int idPub = dtoPublicacion.getIdPublicacion();
        Assert.assertEquals(1,idPub);
    }

    @Test
    public void setIdPublicacion() {
        dtoPublicacion.setIdPublicacion(2);
        Assert.assertEquals(2,dtoPublicacion.getIdPublicacion());
    }

    @Test
    public void getContenido() {
        String conte = dtoPublicacion.getContenido();
        Assert.assertEquals("Contenido pub",conte);
    }

    @Test
    public void setContenido() {
        dtoPublicacion.setContenido("Content");
        Assert.assertEquals("Content",dtoPublicacion.getContenido());
    }

    @Test
    public void getFecha() {
        Date date = dtoPublicacion.getFecha();
        Assert.assertEquals(new Date(2021, Calendar.JUNE,21),date);
    }

    @Test
    public void setFecha() {
        Date date = new Date(2021, Calendar.AUGUST,1);
        dtoPublicacion.setFecha(date);
        Assert.assertEquals(new Date(2021, Calendar.AUGUST,1),dtoPublicacion.getFecha());
    }

    @Test
    public void getTipo() {
        DTOTipo dtoTipo = dtoPublicacion.getTipo();
        Assert.assertNotNull(dtoTipo);
        Assert.assertEquals(tipos.texto,dtoTipo.getTipo());
        Assert.assertEquals(1,dtoTipo.getIdPublicacion());
    }

    @Test
    public void setTipo() {
        DTOTipo dtoTipo = new DTOTipo(2,tipos.mapa);
        Assert.assertNotNull(dtoTipo);
        Assert.assertEquals(tipos.mapa,dtoTipo.getTipo());
        Assert.assertEquals(2,dtoTipo.getIdPublicacion());
    }

    @Test
    public void getIdPersona() {
        String idPer = dtoPublicacion.getIdPersona();
        Assert.assertEquals(dtoPublicacion.getIdPersona(), idPer);
    }

    @Test
    public void setIdPersona() {
        dtoPublicacion.setIdPersona("2");
        Assert.assertEquals("2",dtoPublicacion.getIdPersona());
    }

    @Test
    public void getExtension() {
        String ext = dtoPublicacion.getExtension();
        Assert.assertEquals("jpg",ext);
    }

    @Test
    public void setExtension() {
        dtoPublicacion.setExtension("gif");
        Assert.assertEquals("gif",dtoPublicacion.getExtension());
    }

    @Test
    public void getNombre() {
        String nombre = dtoPublicacion.getNombre();
        Assert.assertEquals("Publicacion 1",nombre);
    }

    @Test
    public void setNombre() {
        dtoPublicacion.setNombre("Pub 2");
        Assert.assertEquals("Pub 2",dtoPublicacion.getNombre());
    }

    @Test
    public void getComentarioReacciones() {
        List<DTOComentario> coments = dtoPublicacion.getComentarioReacciones();
        Assert.assertNotNull(coments);
    }

    @Test
    public void setComentarioReacciones() {
        dtoPublicacion.setComentarioReacciones(null);
        Assert.assertNull(dtoPublicacion.getComentarioReacciones());
        List<DTOComentario> coments = new ArrayList<>();
        dtoPublicacion.setComentarioReacciones(coments);
        Assert.assertNotNull(dtoPublicacion.getComentarioReacciones());
    }

    @Test
    public void getEvento() {
        DTOEvento dtoEv = dtoPublicacion.getEvento();
        Assert.assertNotNull(dtoEv);
        Assert.assertEquals(1,dtoEv.getIdEvento());
        Assert.assertEquals("Evento de prueba",dtoEv.getDescripcion());
    }

    @Test
    public void setEvento() {
        Date date1 = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(2,"Event desc",date1, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");

        dtoPublicacion.setEvento(dtoEvento);
        Assert.assertNotNull(dtoPublicacion.getEvento());
        Assert.assertEquals(2,dtoPublicacion.getEvento().getIdEvento());
        Assert.assertEquals("Event desc",dtoPublicacion.getEvento().getDescripcion());
    }

    @Test
    public void getPerfil() {
        DTOPerfilUsuario dtoPerUs = dtoPublicacion.getPerfil();
        Assert.assertNotNull(dtoPerUs);
        Assert.assertEquals("1",dtoPublicacion.getPerfil().getUsuario().getIdPersona());
        Assert.assertEquals("probanto3@gmail.com",dtoPublicacion.getPerfil().getUsuario().getEmail());
    }

    @Test
    public void setPerfil() {
        DTOPerfilUsuario dtoPerfilUsuario = new DTOPerfilUsuario();
        DTOUsuario dtoUser = new DTOUsuario("2", "test@gmail.com", "Peter", "Montes", "monters", "en su casa3", "099333333", "Brasil","imagen3", "imagenPerfil3", "jpg");
        dtoPerfilUsuario.setUsuario(dtoUser);
        dtoPublicacion.setPerfil(dtoPerfilUsuario);

        Assert.assertEquals("2",dtoPublicacion.getPerfil().getUsuario().getIdPersona());
        Assert.assertEquals("test@gmail.com",dtoPublicacion.getPerfil().getUsuario().getEmail());
    }

    @Test
    public void getCantidadLikes() {
        Integer cantLike = dtoPublicacion.getCantidadLikes();
        Assert.assertEquals((Integer)100,cantLike);
    }

    @Test
    public void setCantidadLikes() {
        dtoPublicacion.setCantidadLikes(200);
        Assert.assertEquals((Integer)200,dtoPublicacion.getCantidadLikes());
    }

    @Test
    public void getCantidadDislikes() {
        Integer canDisLike = dtoPublicacion.getCantidadDislikes();
        Assert.assertEquals((Integer)5,canDisLike);
    }

    @Test
    public void setCantidadDislikes() {
        dtoPublicacion.setCantidadDislikes(10);
        Assert.assertEquals((Integer)10,dtoPublicacion.getCantidadDislikes());
    }

    @Test
    public void getCantidadComentarios() {
        Integer cantComs = dtoPublicacion.getCantidadComentarios();
        Assert.assertEquals((Integer)0,cantComs);
    }

    @Test
    public void setCantidadComentarios() {
        dtoPublicacion.setCantidadComentarios(4);
        Assert.assertEquals((Integer)4,dtoPublicacion.getCantidadComentarios());
    }
}
