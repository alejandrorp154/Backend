package com.javaee.pryectoBack.service;

import com.javaee.pryectoBack.data.ControladorEventoDA;
import com.javaee.pryectoBack.data.ControladorEventoDALocal;
import com.javaee.pryectoBack.datatypes.*;
import com.javaee.pryectoBack.model.estados;
import com.javaee.pryectoBack.model.estadosContactos;
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
public class ControladorEventoTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private ControladorEventoDALocal controladorEventoDA = new ControladorEventoDA();

    @InjectMocks
    private ControladorEventoLocal controladorEvento = new ControladorEvento();


    @Test
    public void crearEvento() {
        Date date = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento evento = new DTOEvento(1,"Evento de prueba",date, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");

        Mockito.when(controladorEventoDA.crearEvento(Mockito.any(DTOEvento.class))).thenReturn(evento);
        DTOEvento res = controladorEvento.crearEvento(evento);
        Assert.assertNotNull(res);
    }

    @Test
    public void eliminarEvento() {
        Mockito.when(controladorEventoDA.eliminarEvento(Mockito.anyInt(),Mockito.anyString())).thenReturn(true);
        boolean res = controladorEvento.eliminarEvento(1,"1");
        Assert.assertTrue(res);
    }

    @Test
    public void modificar() {
        Date date = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento evento = new DTOEvento(1,"Evento de prueba",date, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");

        Mockito.when(controladorEventoDA.modificar(Mockito.any(DTOEvento.class))).thenReturn(evento);
        DTOEvento res = controladorEvento.modificar(evento);
        Assert.assertNotNull(res);
    }

    @Test
    public void agregarUsuario() {
        Mockito.when(controladorEventoDA.agregarUsuario(Mockito.anyInt(),Mockito.anyString(),Mockito.anyString())).thenReturn(true);
        boolean res = controladorEvento.agregarUsuario(1,"1","2");
        Assert.assertTrue(res);
    }

    @Test
    public void removerUsuario() {
        Mockito.when(controladorEventoDA.removerUsuario(Mockito.anyInt(),Mockito.anyString())).thenReturn(true);
        boolean res = controladorEvento.removerUsuario(1,"1");
        Assert.assertTrue(res);
    }

    @Test
    public void dejar() {
        Mockito.when(controladorEventoDA.dejar(Mockito.anyInt(),Mockito.anyString())).thenReturn(true);
        boolean res = controladorEvento.dejar(1,"1");
        Assert.assertTrue(res);
    }

    @Test
    public void obtenerEventos() {
        List<DTOEvento> eventos = new ArrayList<>();

        Date date = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento evento = new DTOEvento(1,"Evento de prueba",date, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");

        Date date10 = new Date(2021, Calendar.JUNE,21);
        Date date20 = new Date(2021,Calendar.JUNE,23);
        Date date30 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub2 = new DTOUbicacion(22,5433354,534235,date30,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento evento2 = new DTOEvento(1,"Evento de prueba",date10, date20, estados.enCurso,1,"1","Javier",dtoub2,"nombre imagen para mostrar del evento","image249824","jpg");

        eventos.add(evento);
        eventos.add(evento2);
        Mockito.when(controladorEventoDA.obtenerEventos(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(eventos);

        List<DTOEvento> res = controladorEvento.obtenerEventos("1",0,5);
        Assert.assertNotNull(res);
    }

    @Test
    public void obtenerInvitacionesPendientes() {
        List<DTOEvento> eventos = new ArrayList<>();

        Date date = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,25);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento evento = new DTOEvento(1,"Evento de prueba",date, date2, estados.pendiente,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");

        Date date10 = new Date(2021, Calendar.JUNE,21);
        Date date20 = new Date(2021,Calendar.JUNE,23);
        Date date30 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub2 = new DTOUbicacion(22,5433354,534235,date30,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento evento2 = new DTOEvento(1,"Evento de prueba",date10, date20, estados.pendiente,1,"1","Javier",dtoub2,"nombre imagen para mostrar del evento","image249824","jpg");

        eventos.add(evento);
        eventos.add(evento2);

        Mockito.when(controladorEventoDA.obtenerInvitacionesPendientes(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(eventos);
        List<DTOEvento> res = controladorEvento.obtenerInvitacionesPendientes("1",0,5);
        Assert.assertNotNull(res);
    }

    @Test
    public void responderIvitacion() {
        DTOEventoUsuario dtoEventoUsuario = new DTOEventoUsuario();
        dtoEventoUsuario.setIdPersona("1");
        dtoEventoUsuario.setIdEvento(1);
        dtoEventoUsuario.setEstadoContactos(estadosContactos.aceptada);

        Mockito.when(controladorEventoDA.responderIvitacion(Mockito.any(DTOEventoUsuario.class))).thenReturn(true);
        boolean res = controladorEvento.responderIvitacion(dtoEventoUsuario);
        Assert.assertTrue(res);
    }

    @Test
    public void obtenerEventoById(){
        DTODetalleEvento dtoDetalleEvent = new DTODetalleEvento();
        dtoDetalleEvent.setIdEvento(1);
        dtoDetalleEvent.setDescripcion("Un evento");
        Date date = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,23);
        dtoDetalleEvent.setFechaInicio(date);
        dtoDetalleEvent.setFechaFin(date2);
        dtoDetalleEvent.setEstado(estados.enCurso);
        dtoDetalleEvent.setIdPublicacion(1);
        dtoDetalleEvent.setIdChat("1");
        dtoDetalleEvent.setNombre("Event name");
        DTOUbicacion dtoUb = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        dtoDetalleEvent.setUbicacion(dtoUb);
        dtoDetalleEvent.setNombreImagen("Image name");
        dtoDetalleEvent.setImagen("ImageItSelf8274924");
        dtoDetalleEvent.setExtension("jpg");
        dtoDetalleEvent.setOwner(false);
        dtoDetalleEvent.setEstadoSolicitud(estadosContactos.aceptada);

        List<DTOUsuarioEvento> invitados = new ArrayList<>();

        DTOUsuarioEvento dtoUsuarioEvento = new DTOUsuarioEvento();
        dtoUsuarioEvento.setIdPersona("1");
        dtoUsuarioEvento.setNombre("Sam");
        dtoUsuarioEvento.setApellido("Gomyi");
        dtoUsuarioEvento.setNickname("samG");
        dtoUsuarioEvento.setImagenPerfil("Imagen perfil");
        dtoUsuarioEvento.setNombreImagen("nombre imagen");
        dtoUsuarioEvento.setExtensionImagen("jpg");
        dtoUsuarioEvento.setEstadoContactos(estadosContactos.aceptada);
        dtoUsuarioEvento.setOwner(false);

        DTOUsuarioEvento dtoUsuarioEvento2 = new DTOUsuarioEvento();
        dtoUsuarioEvento2.setIdPersona("2");
        dtoUsuarioEvento2.setNombre("Tony");
        dtoUsuarioEvento2.setApellido("Alvez");
        dtoUsuarioEvento2.setNickname("tonyA");
        dtoUsuarioEvento2.setImagenPerfil("Imagen perfil2");
        dtoUsuarioEvento2.setNombreImagen("nombre imagen2");
        dtoUsuarioEvento2.setExtensionImagen("jpg");
        dtoUsuarioEvento2.setEstadoContactos(estadosContactos.aceptada);
        dtoUsuarioEvento2.setOwner(false);

        invitados.add(dtoUsuarioEvento);
        invitados.add(dtoUsuarioEvento2);
        dtoDetalleEvent.setInvitados(invitados);

        Mockito.when(controladorEventoDA.obtenerEventoById(Mockito.anyInt())).thenReturn(dtoDetalleEvent);
        DTODetalleEvento res = controladorEvento.obtenerEventoById(1);
        Assert.assertNotNull(res);
    }
}
