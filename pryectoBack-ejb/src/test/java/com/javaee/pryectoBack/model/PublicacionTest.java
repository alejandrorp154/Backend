package com.javaee.pryectoBack.model;

import com.javaee.pryectoBack.datatypes.*;
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
public class PublicacionTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        publicacion.setIdPublicacion(1);
        publicacion.setContenido("Contenido de publicacion");
        publicacion.setExtension("texto");
        publicacion.setNombre("public1");
        DTOTipo dtoTipo = new DTOTipo(1,tipos.mapa);
        Tipo tipo = new Tipo(dtoTipo);
        publicacion.setTipo(tipo);

        PerfilUsuario perfilUsuario = new PerfilUsuario();
        DTOUsuario dtoUser = new DTOUsuario("1", "probanto1@gmail.com", "Peter", "Montes", "monters", "en su casa1", "099111111", "Uruguay","imagen1", "imagenPerfil1", "jpg");
        Usuario user = new Usuario(dtoUser);
        perfilUsuario.setUsuario(user);
        perfilUsuario.setIdPersona("3");
        publicacion.setPerfil(perfilUsuario);

        Date date = new Date(2021, Calendar.JUNE,21);
        publicacion.setFecha(date);
        Date date1 = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(10,"Evento de prueba",date1, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");

        Evento evento = new Evento(dtoEvento);
        publicacion.setEvento(evento);

    }

    private Publicacion publicacion = new Publicacion();

    @Test
    public void publicacionDefault(){
        Publicacion pub = new Publicacion();
        Assert.assertNotNull(pub);
    }

    @Test
    public void publicacionDTO(){
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
        Assert.assertNotNull(publicacion);
    }

    @Test
    public void getIdPublicacion() {
        int idPublicacion = publicacion.getIdPublicacion();
        Assert.assertEquals(1,idPublicacion);
    }

    @Test
    public void setIdPublicacion() {
        publicacion.setIdPublicacion(2);
        Assert.assertEquals(2,publicacion.getIdPublicacion());
    }

    @Test
    public void getContenido() {
        String contenido = publicacion.getContenido();
        Assert.assertEquals("Contenido de publicacion",contenido);
    }

    @Test
    public void setContenido() {
        publicacion.setContenido("Change content");
        Assert.assertEquals("Change content",publicacion.getContenido());
    }

    @Test
    public void getFecha() {
        Date date = publicacion.getFecha();
        Assert.assertEquals(new Date(2021, Calendar.JUNE,21),date);
    }

    @Test
    public void setFecha() {
        Date date = new Date(2021, Calendar.JUNE,25);
        publicacion.setFecha(date);
        Assert.assertEquals(new Date(2021, Calendar.JUNE,25),publicacion.getFecha());
    }

    @Test
    public void getTipo() {
        Tipo tipo = publicacion.getTipo();
        Assert.assertEquals(1,tipo.getIdPublicacion());
        Assert.assertEquals(tipos.mapa,tipo.getTipo());
    }

    @Test
    public void setTipo() {
        DTOTipo dtoTipo = new DTOTipo(3,tipos.foto);
        Tipo tipo = new Tipo(dtoTipo);
        publicacion.setTipo(tipo);
        Assert.assertEquals(tipos.foto,publicacion.getTipo().getTipo());
        Assert.assertEquals(3,publicacion.getTipo().getIdPublicacion());
    }

    @Test
    public void getEvento() {
        Evento evento = publicacion.getEvento();
        Assert.assertEquals(0,evento.getIdEvento());
        Assert.assertEquals("Evento de prueba",evento.getDescripcion());
    }

    @Test
    public void setEvento() {
        Date date1 = new Date(2021, Calendar.JUNE,25);
        Date date2 = new Date(2021,Calendar.JUNE,28);
        Date date3 = new Date(2021,Calendar.JUNE,28);
        DTOUbicacion dtoub = new DTOUbicacion(22,600000,300000,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(15,"Evento de prueba 15",date1, date2, estados.pendiente,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");
        Evento evento = new Evento(dtoEvento);
        publicacion.setEvento(evento);

        Assert.assertEquals(0,publicacion.getEvento().getIdEvento());
        Assert.assertEquals("Evento de prueba 15",publicacion.getEvento().getDescripcion());
        Assert.assertEquals(estados.pendiente,publicacion.getEvento().getEstado());
    }

    @Test
    public void getPerfil() {
        PerfilUsuario perfilUsuario = publicacion.getPerfil();
        Assert.assertEquals("1",perfilUsuario.getUsuario().getIdPersona());
        Assert.assertEquals("probanto1@gmail.com",perfilUsuario.getUsuario().getEmail());
    }

    @Test
    public void setPerfil() {
        PerfilUsuario perfilUsuario = new PerfilUsuario();
        DTOUsuario dtoUser = new DTOUsuario("3", "probanto3@gmail.com", "Peter3", "Montes3", "monters3", "en su casa3", "099333333", "Brasil","imagen3", "imagenPerfil3", "jpg");
        Usuario user = new Usuario(dtoUser);
        perfilUsuario.setUsuario(user);
        perfilUsuario.setIdPersona("3");
        publicacion.setPerfil(perfilUsuario);

        Assert.assertEquals("3",publicacion.getPerfil().getIdPersona());
        Assert.assertEquals("probanto3@gmail.com",publicacion.getPerfil().getUsuario().getEmail());
        Assert.assertEquals("Peter3",publicacion.getPerfil().getUsuario().getNombre());

    }

    @Test
    public void getExtension() {
        String ext = publicacion.getExtension();
        Assert.assertEquals("texto",ext);
    }

    @Test
    public void setExtension() {
        publicacion.setExtension("gif");
        Assert.assertEquals("gif",publicacion.getExtension());
    }

    @Test
    public void getNombre() {
        String nombre = publicacion.getNombre();
        Assert.assertEquals("public1",nombre);
    }

    @Test
    public void setNombre() {
        publicacion.setNombre("nombre publicacion");
        Assert.assertEquals("nombre publicacion",publicacion.getNombre());
    }
}
