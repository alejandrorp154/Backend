package com.javaee.pryectoBack.datatypes;

import com.javaee.pryectoBack.model.Evento;
import com.javaee.pryectoBack.model.estados;
import com.javaee.pryectoBack.model.estadosContactos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Date;


@RunWith(MockitoJUnitRunner.class)
public class DTOEventoTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        dtoEvento.setIdEvento(1);
        dtoEvento.setDescripcion("Descripcion");
        Date fechaInicio = new Date(2021,Calendar.FEBRUARY,22);
        Date fechaFin = new Date(2021,Calendar.FEBRUARY,22);
        dtoEvento.setFechaInicio(fechaInicio);
        dtoEvento.setFechaFin(fechaFin);
        dtoEvento.setEstado(estados.enCurso);
        dtoEvento.setIdPublicacion(1);
        dtoEvento.setIdPersona("1");
        dtoEvento.setIdChat("1");
        dtoEvento.setNombre("Evento nombre");
        Date date = new Date(2021,Calendar.FEBRUARY,22);
        DTOUbicacion dtoUb = new DTOUbicacion(22,5433354,534235,date,"Detalles de la ubicación del evento","Uruguay");
        dtoEvento.setUbicacion(dtoUb);
        dtoEvento.setNombreImagen("");
        dtoEvento.setImagen("");
        dtoEvento.setExtension("");
        dtoEvento.setOwner(true);
        dtoEvento.setEstadoSolicitud(estadosContactos.aceptada);
    }

    private DTOEvento dtoEvento = new DTOEvento();

    @Test
    public void dtoEventoDefault(){
        DTOEvento dtoEve = new DTOEvento();
        Assert.assertNotNull(dtoEve);
    }

    @Test
    public void dtoEventoAllParams(){
        Date dateInicio = new Date(2021, Calendar.JUNE,21);
        Date dateFin = new Date(2021, Calendar.JUNE,21);
        Date date = new Date(2021, Calendar.JUNE,21);
        DTOUbicacion dtoUb = new DTOUbicacion(22,5433354,534235,date,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEve = new DTOEvento(1,"Descripcion",dateInicio,dateFin, estados.enCurso,1,"1","Juan",dtoUb,"","","");
        Assert.assertNotNull(dtoEve);
    }

    @Test
    public void dtoEventoParamEvento(){
        Date date = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(1,"Evento de prueba",date, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");
        Evento res = new Evento(dtoEvento);
        DTOEvento dtoEven = new DTOEvento(res);
        Assert.assertNotNull(dtoEven);
    }


    @Test
    public void getIdEvento() {
        int idEven = dtoEvento.getIdEvento();
        Assert.assertEquals(1,idEven);
    }

    @Test
    public void setIdEvento() {
        dtoEvento.setIdEvento(2);
        Assert.assertEquals(2,dtoEvento.getIdEvento());
    }

    @Test
    public void getDescripcion() {
        String desc = dtoEvento.getDescripcion();
        Assert.assertEquals("Descripcion", desc);
    }

    @Test
    public void setDescripcion() {
        dtoEvento.setDescripcion("New Desc");
        Assert.assertEquals("New Desc",dtoEvento.getDescripcion());
    }

    @Test
    public void getFechaInicio() {
        Date inicio = dtoEvento.getFechaInicio();
        Assert.assertEquals(new Date(2021,Calendar.FEBRUARY,22), inicio);
    }

    @Test
    public void setFechaInicio() {
        dtoEvento.setFechaInicio(new Date(2021,Calendar.AUGUST,3));
        Assert.assertEquals(new Date(2021,Calendar.AUGUST,3),dtoEvento.getFechaInicio());
    }

    @Test
    public void getFechaFin() {
        Date fin = dtoEvento.getFechaFin();
        Assert.assertEquals(new Date(2021,Calendar.FEBRUARY,22), fin);
    }

    @Test
    public void setFechaFin() {
        dtoEvento.setFechaFin(new Date(2021,Calendar.AUGUST,3));
        Assert.assertEquals(new Date(2021,Calendar.AUGUST,3),dtoEvento.getFechaFin());
    }

    @Test
    public void getEstado() {
        estados res = dtoEvento.getEstado();
        Assert.assertEquals(estados.enCurso,res);
    }

    @Test
    public void setEstado() {
        dtoEvento.setEstado(estados.cancelado);
        Assert.assertEquals(estados.cancelado, dtoEvento.getEstado());
    }

    @Test
    public void getIdPublicacion() {
        int idPub = dtoEvento.getIdPublicacion();
        Assert.assertEquals(1,idPub);
    }

    @Test
    public void setIdPublicacion() {
        dtoEvento.setIdPublicacion(2);
        Assert.assertEquals(2,dtoEvento.getIdPublicacion());
    }

    @Test
    public void getIdPersona() {
        String idPerso = dtoEvento.getIdPersona();
        Assert.assertEquals("1",idPerso);
    }

    @Test
    public void setIdPersona() {
        dtoEvento.setIdPersona("2");
        Assert.assertEquals("2",dtoEvento.getIdPersona());
    }

    @Test
    public void getIdChat() {
        String idChat = dtoEvento.getIdChat();
        Assert.assertEquals("1",idChat);
    }

    @Test
    public void setIdChat() {
        dtoEvento.setIdChat("2");
        Assert.assertEquals("2",dtoEvento.getIdChat());
    }

    @Test
    public void getNombre() {
        String nombreEven = dtoEvento.getNombre();
        Assert.assertEquals("Evento nombre", nombreEven);
    }

    @Test
    public void setNombre() {
        dtoEvento.setNombre("event name");
        Assert.assertEquals("event name",dtoEvento.getNombre());
    }

    @Test
    public void getUbicacion() {
        DTOUbicacion dtoUb = dtoEvento.getUbicacion();
        Assert.assertNotNull(dtoUb);
    }

    @Test
    public void setUbicacion() {
        Date date = new Date(2021,Calendar.FEBRUARY,22);
        DTOUbicacion dtoUb = new DTOUbicacion(6,540000,66000,date,"Detalles de la ubicación del evento","Uruguay");
        dtoEvento.setUbicacion(dtoUb);

        Assert.assertEquals(6,dtoEvento.getUbicacion().getIdUbicacion());
        Assert.assertEquals(540000,dtoEvento.getUbicacion().getLongitud(),540000-dtoEvento.getUbicacion().getLongitud());
        Assert.assertEquals(66000,dtoEvento.getUbicacion().getLatitud(),60000-dtoEvento.getUbicacion().getLatitud());
    }

    @Test
    public void getNombreImagen() {
        String nomIma = dtoEvento.getNombreImagen();
        Assert.assertEquals("",nomIma);
    }

    @Test
    public void setNombreImagen() {
        dtoEvento.setNombreImagen("Nombre img");
        Assert.assertEquals("Nombre img",dtoEvento.getNombreImagen());
    }

    @Test
    public void getImagen() {
        String img = dtoEvento.getImagen();
        Assert.assertEquals("",img);
    }

    @Test
    public void setImagen() {
        dtoEvento.setImagen("imagen en si");
        Assert.assertEquals("imagen en si",dtoEvento.getImagen());
    }

    @Test
    public void getExtension() {
        String ext = dtoEvento.getExtension();
        Assert.assertEquals("",ext);
    }

    @Test
    public void setExtension() {
        dtoEvento.setExtension("gif");
        Assert.assertEquals("gif",dtoEvento.getExtension());
    }

    @Test
    public void isOwner() {
        boolean own = dtoEvento.isOwner();
        Assert.assertTrue(own);
    }

    @Test
    public void setOwner() {
        dtoEvento.setOwner(false);
        Assert.assertFalse(dtoEvento.isOwner());
    }

    @Test
    public void getEstadoSolicitud() {
        estadosContactos status = dtoEvento.getEstadoSolicitud();
        Assert.assertEquals(estadosContactos.aceptada,status);
    }

    @Test
    public void setEstadoSolicitud() {
        dtoEvento.setEstadoSolicitud(estadosContactos.pendiente);
        Assert.assertEquals(estadosContactos.pendiente,dtoEvento.getEstadoSolicitud());
    }
}
