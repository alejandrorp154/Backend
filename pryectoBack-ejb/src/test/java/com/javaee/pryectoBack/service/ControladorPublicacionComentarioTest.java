package com.javaee.pryectoBack.service;

import com.javaee.pryectoBack.data.ControladorPublicacionComentarioDA;
import com.javaee.pryectoBack.data.ControladorPublicacionComentarioDALocal;
import com.javaee.pryectoBack.datatypes.*;
import com.javaee.pryectoBack.model.estados;
import com.javaee.pryectoBack.model.reacciones;
import com.javaee.pryectoBack.model.tipos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class ControladorPublicacionComentarioTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private ControladorPublicacionComentarioDALocal controladorPublicacionComentarioDA = new ControladorPublicacionComentarioDA();

    @InjectMocks
    private ControladorPublicacionComentarioLocal controladorPublicacionComentario = new ControladorPublicacionComentario();

    @Test
    public void altaComentario() {
        Date date = new Date(2021, Calendar.JUNE,21);
        DTOComentario dtoComentario = new DTOComentario("1","Este es mi primer comentario",date,15,"1",null);

        Mockito.when(controladorPublicacionComentarioDA.altaComentario(Mockito.any(DTOComentario.class))).thenReturn(dtoComentario);
        DTOComentario res = controladorPublicacionComentario.altaComentario(dtoComentario);
        Assert.assertNotNull(res);
    }
    @Test
    public void bajaComentario() {
        Mockito.when(controladorPublicacionComentarioDA.bajaComentario(Mockito.anyString())).thenReturn(true);
        boolean res = controladorPublicacionComentario.bajaComentario("1");
        Assert.assertTrue(res);
    }

    @Test
    public void modificarComentario() {
        Date date = new Date(2021, Calendar.JUNE,21);
        DTOComentario dtoComent = new DTOComentario("1","Primer comentario",date,1,"1","");
        Mockito.when(controladorPublicacionComentarioDA.modificarComentario(Mockito.any(DTOComentario.class))).thenReturn(true);
        boolean res = controladorPublicacionComentario.modificarComentario(dtoComent);
        Assert.assertTrue(res);
    }

    @Test
    public void reaccionarComentario() {
        DTOReaccion dtoReaccion = new DTOReaccion("1",1,"1", reacciones.MeGusta);

        Mockito.when(controladorPublicacionComentarioDA.reaccionarComentario(Mockito.any(DTOReaccion.class))).thenReturn(true);
        boolean res = controladorPublicacionComentario.reaccionarComentario(dtoReaccion);
        Assert.assertTrue(res);
    }

    @Test
    public void reaccionPublicacion() {
        DTOReaccion dtoReaccion = new DTOReaccion("1",1,"1", reacciones.MeGusta);

        Mockito.when(controladorPublicacionComentarioDA.reaccionPublicacion(Mockito.any(DTOReaccion.class))).thenReturn(true);
        boolean res = controladorPublicacionComentario.reaccionPublicacion(dtoReaccion);
        Assert.assertTrue(res);
    }

    @Test
    public void obtenerPublicaciones() {
        List<DTOPublicacionPerfilUsuario> publicaciones = new ArrayList<>();

        DTOPublicacionPerfilUsuario dtopublicacionUser = new DTOPublicacionPerfilUsuario();
        dtopublicacionUser.setIdPublicacion(1);
        dtopublicacionUser.setContenido("Primer publicacion contenido");
        Date date = new Date(2021, Calendar.JUNE,21);
        dtopublicacionUser.setFecha(date);
        DTOTipo dtoTipo = new DTOTipo(1,tipos.texto);
        dtopublicacionUser.setTipo(dtoTipo);
        dtopublicacionUser.setExtension("text");
        dtopublicacionUser.setNombre("Primera publicacion titulo");
        List<DTOComentario> dtoComentarios = new ArrayList<>();
        dtopublicacionUser.setComentarioReacciones(dtoComentarios);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoUb = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(1,"una buena fiesta",date2,date3, estados.enCurso,1,"1","Javier",dtoUb,"none","none","none");
        dtopublicacionUser.setEvento(dtoEvento);
        DTOPerfilUsuario dtoPerfilUsuario = new DTOPerfilUsuario();
        DTOUsuario usuario = new DTOUsuario("1","user1@gmail.com","Gabriel", "Mankers","gabiM","estadio centenario 1233","099111222","Uruguay","imagen823e09e2enLaCancha","image","jpg");
        dtoPerfilUsuario.setUsuario(usuario);
        dtopublicacionUser.setPerfil(dtoPerfilUsuario);
        dtopublicacionUser.setCantidadLikes(10);
        dtopublicacionUser.setCantidadDislikes(2);
        dtopublicacionUser.setCantidadComentarios(0);
        dtopublicacionUser.setIdPersona("1");
        dtopublicacionUser.setEmail("probandoPublicaciones@gmail.com");
        dtopublicacionUser.setNickname("Bockler");
        dtopublicacionUser.setImagenPerfil("imagenEnSi28974278492");
        dtopublicacionUser.setExtensionImagenPerfil("jpg");
        dtopublicacionUser.setNombreImagenPerfil("image");



        DTOPublicacionPerfilUsuario dtopublicacionUser2 = new DTOPublicacionPerfilUsuario();
        dtopublicacionUser2.setIdPublicacion(2);
        dtopublicacionUser2.setContenido("Primer publicacion contenido");
        Date date10 = new Date(2021, Calendar.JUNE,21);
        dtopublicacionUser2.setFecha(date10);
        DTOTipo dtoTipo2 = new DTOTipo(2,tipos.foto);
        dtopublicacionUser2.setTipo(dtoTipo2);
        dtopublicacionUser2.setExtension("foto");
        dtopublicacionUser2.setNombre("Primera publicacion titulo");
        List<DTOComentario> dtoComentarios2 = new ArrayList<>();
        dtopublicacionUser2.setComentarioReacciones(dtoComentarios2);
        Date date20 = new Date(2021,Calendar.JUNE,23);
        Date date30 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoUb2 = new DTOUbicacion(22,5433354,534235,date30,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento2 = new DTOEvento(1,"una buena fiesta",date20,date30, estados.enCurso,1,"1","Javier se va de joda",dtoUb2,"imageEvent","imageItSelf8927492","jpg");
        dtopublicacionUser2.setEvento(dtoEvento2);
        DTOPerfilUsuario dtoPerfilUsuario2 = new DTOPerfilUsuario();
        DTOUsuario usuario2 = new DTOUsuario("1","user1@gmail.com","Gabriel", "Mankers","gabiM","estadio centenario 1233","099111222","Uruguay","imagen823e09e2enLaCancha","image","jpg");
        dtoPerfilUsuario2.setUsuario(usuario2);
        dtopublicacionUser2.setPerfil(dtoPerfilUsuario2);
        dtopublicacionUser2.setCantidadLikes(10);
        dtopublicacionUser2.setCantidadDislikes(2);
        dtopublicacionUser2.setCantidadComentarios(0);
        dtopublicacionUser2.setIdPersona("1");
        dtopublicacionUser2.setEmail("probandoPublicaciones@gmail.com");
        dtopublicacionUser2.setNickname("Bockler");
        dtopublicacionUser2.setImagenPerfil("imagenEnSi28974278492");
        dtopublicacionUser2.setExtensionImagenPerfil("jpg");
        dtopublicacionUser2.setNombreImagenPerfil("image");

        publicaciones.add(dtopublicacionUser);
        publicaciones.add(dtopublicacionUser2);

        Mockito.when(controladorPublicacionComentarioDA.obtenerPublicaciones(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(publicaciones);
        List<DTOPublicacionPerfilUsuario> res = controladorPublicacionComentario.obtenerPublicaciones("1",0,5);
        Assert.assertNotNull(res);
    }

    @Test
    public void obtenerPublicacion(){

        DTOPublicacionPerfilUsuario dtopublicacionUser = new DTOPublicacionPerfilUsuario();
        dtopublicacionUser.setIdPublicacion(1);
        dtopublicacionUser.setContenido("Primer publicacion contenido");
        Date date = new Date(2021, Calendar.JUNE,21);
        dtopublicacionUser.setFecha(date);
        DTOTipo dtoTipo = new DTOTipo(1,tipos.texto);
        dtopublicacionUser.setTipo(dtoTipo);
        dtopublicacionUser.setExtension("text");
        dtopublicacionUser.setNombre("Primera publicacion titulo");
        List<DTOComentario> dtoComentarios = new ArrayList<>();
        dtopublicacionUser.setComentarioReacciones(dtoComentarios);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoUb = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(1,"una buena fiesta",date2,date3, estados.enCurso,1,"1","Javier",dtoUb,"none","none","none");
        dtopublicacionUser.setEvento(dtoEvento);
        DTOPerfilUsuario dtoPerfilUsuario = new DTOPerfilUsuario();
        DTOUsuario usuario = new DTOUsuario("1","user1@gmail.com","Gabriel", "Mankers","gabiM","estadio centenario 1233","099111222","Uruguay","imagen823e09e2enLaCancha","image","jpg");
        dtoPerfilUsuario.setUsuario(usuario);
        dtopublicacionUser.setPerfil(dtoPerfilUsuario);
        dtopublicacionUser.setCantidadLikes(10);
        dtopublicacionUser.setCantidadDislikes(2);
        dtopublicacionUser.setCantidadComentarios(0);
        dtopublicacionUser.setIdPersona("1");
        dtopublicacionUser.setEmail("probandoPublicaciones@gmail.com");
        dtopublicacionUser.setNickname("Bockler");
        dtopublicacionUser.setImagenPerfil("imagenEnSi28974278492");
        dtopublicacionUser.setExtensionImagenPerfil("jpg");
        dtopublicacionUser.setNombreImagenPerfil("image");

        Mockito.when(controladorPublicacionComentarioDA.obtenerPublicacion(Mockito.anyInt())).thenReturn(dtopublicacionUser);
        DTOPublicacionPerfilUsuario res = controladorPublicacionComentario.obtenerPublicacion(1);
        Assert.assertNotNull(res);
    }

    @Test
    public void modificarPublicacion() {
        Date date = new Date(2021, Calendar.JUNE,21);

        DTOTipo dtoTipo = new DTOTipo(1, tipos.texto);

        List<DTOComentario> comentariosReaccion = new ArrayList<>();
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoUb = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(1,"una buena fiesta",date2,date3, estados.enCurso,1,"1","Javier",dtoUb,"none","none","none");

        DTOPerfilUsuario dtoPerfilUsuario = new DTOPerfilUsuario();
        DTOUsuario usuario = new DTOUsuario("1","user1@gmail.com","Gabriel", "Mankers","gabiM","estadio centenario 1233","099111222","Uruguay","imagen823e09e2enLaCancha","image","jpg");
        dtoPerfilUsuario.setUsuario(usuario);

        DTOPublicacion dtopublic = new DTOPublicacion(1,"Primera publicación",date,dtoTipo,"1","text","Primera publicación",comentariosReaccion,dtoEvento,dtoPerfilUsuario);

        Mockito.when(controladorPublicacionComentarioDA.modificarPublicacion(Mockito.any(DTOPublicacion.class))).thenReturn(true);
        boolean res = controladorPublicacionComentario.modificarPublicacion(dtopublic);
        Assert.assertTrue(res);
    }

    @Test
    public void bajaPublicacion() {
        Mockito.when(controladorPublicacionComentarioDA.bajaPublicacion(Mockito.anyInt())).thenReturn(true);
        boolean res = controladorPublicacionComentario.bajaPublicacion(1);
        Assert.assertTrue(res);
    }



    @Test
    public void altaPublicacion() {
        Date date = new Date(2021, Calendar.JUNE,21);

        DTOTipo dtoTipo = new DTOTipo(1, tipos.texto);

        List<DTOComentario> comentariosReaccion = new ArrayList<>();
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoUb = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(1,"una buena fiesta",date2,date3, estados.enCurso,1,"1","Javier",dtoUb,"none","none","none");

        DTOPerfilUsuario dtoPerfilUsuario = new DTOPerfilUsuario();
        DTOUsuario usuario = new DTOUsuario("1","user1@gmail.com","Gabriel", "Mankers","gabiM","estadio centenario 1233","099111222","Uruguay","imagen823e09e2enLaCancha","image","jpg");
        dtoPerfilUsuario.setUsuario(usuario);

        DTOPublicacion dtopublic = new DTOPublicacion(1,"Primera publicación",date,dtoTipo,"1","text","Primera publicación",comentariosReaccion,dtoEvento,dtoPerfilUsuario);

        Mockito.when(controladorPublicacionComentarioDA.altaPublicacion(Mockito.any(DTOPublicacion.class))).thenReturn(dtopublic);
        DTOPublicacion res = controladorPublicacionComentario.altaPublicacion(dtopublic);
        Assert.assertNotNull(res);
    }

    @Test
    public void getComentarios(){
        List<DTOComentario> comentarios = new ArrayList<>();

        Date date = new Date(2021, Calendar.JUNE,21);
        DTOComentario dtoComent = new DTOComentario("1","Primer comentario",date,1,"1","");
        DTOComentario dtoComent2 = new DTOComentario("2","Segundo comentario",date,1,"1","");
        DTOComentario dtoComent3 = new DTOComentario("3","Tercero comentario",date,1,"1","");
        comentarios.add(dtoComent);
        comentarios.add(dtoComent2);
        comentarios.add(dtoComent3);

        Mockito.when(controladorPublicacionComentarioDA.getComentarios(1)).thenReturn(comentarios);
        List<DTOComentario> res = controladorPublicacionComentario.getComentarios(1);
        Assert.assertNotNull(res);
    }
}
