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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DTODetalleEventoTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        dtoDetalleEvento.setIdEvento(1);
        dtoDetalleEvento.setDescripcion("Descripcion Evento");
        Date dateIni = new Date(2021, Calendar.AUGUST,23);
        Date dateFin = new Date(2021, Calendar.AUGUST,23);
        dtoDetalleEvento.setFechaInicio(dateIni);
        dtoDetalleEvento.setFechaFin(dateFin);
        dtoDetalleEvento.setEstado(estados.enCurso);
        dtoDetalleEvento.setIdPublicacion(1);
        dtoDetalleEvento.setIdPersona("1");
        dtoDetalleEvento.setIdChat("1");
        dtoDetalleEvento.setNombre("Evento1");
        Date date = new Date(2021, Calendar.JUNE,23);
        DTOUbicacion dtoUb = new DTOUbicacion(1,5433354,534235,date,"Detalles de la ubicación del evento","Uruguay");
        dtoDetalleEvento.setUbicacion(dtoUb);
        dtoDetalleEvento.setNombreImagen("Nombre Imagen");
        dtoDetalleEvento.setImagen("Imagen en si 39849274");
        dtoDetalleEvento.setExtension("jpg");
        dtoDetalleEvento.setOwner(true);
        dtoDetalleEvento.setEstadoSolicitud(estadosContactos.aceptada);
        List<DTOUsuarioEvento> invitados = new ArrayList<>();

        DTOUsuarioEvento dtoUsEv1 = new DTOUsuarioEvento();
        dtoUsEv1.setIdPersona("1");
        dtoUsEv1.setNombre("Juan");
        dtoUsEv1.setApellido("Alvez");
        dtoUsEv1.setNickname("juanA");
        dtoUsEv1.setImagenPerfil("");
        dtoUsEv1.setNombreImagen("");
        dtoUsEv1.setExtensionImagen("");
        dtoUsEv1.setEstadoContactos(estadosContactos.aceptada);
        dtoUsEv1.setOwner(true);

        DTOUsuarioEvento dtoUsEv2 = new DTOUsuarioEvento();
        dtoUsEv2.setIdPersona("2");
        dtoUsEv2.setNombre("Miguel");
        dtoUsEv2.setApellido("Plunter");
        dtoUsEv2.setNickname("migueP");
        dtoUsEv2.setImagenPerfil("");
        dtoUsEv2.setNombreImagen("");
        dtoUsEv2.setExtensionImagen("");
        dtoUsEv2.setEstadoContactos(estadosContactos.aceptada);
        dtoUsEv2.setOwner(false);

        invitados.add(dtoUsEv1);
        invitados.add(dtoUsEv2);

        dtoDetalleEvento.setInvitados(invitados);

    }

    private DTODetalleEvento dtoDetalleEvento = new DTODetalleEvento();

    @Test
    public void dtoDetalleEventoDefault() {
        DTODetalleEvento dtoDeEve = new DTODetalleEvento();
        Assert.assertNotNull(dtoDeEve);
    }

    @Test
    public void dtoDetalleEventoParams() {
        Date date = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(1,"Evento de prueba",date, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");
        Evento res = new Evento(dtoEvento);
        DTODetalleEvento dtoUsEve = new DTODetalleEvento(res,dtoDetalleEvento.getInvitados());

        Assert.assertNotNull(dtoUsEve);
    }

    @Test
    public void getIdEvento() {
        int idEvento = dtoDetalleEvento.getIdEvento();
        Assert.assertEquals(1,idEvento);
    }

    @Test
    public void setIdEvento() {
        dtoDetalleEvento.setIdEvento(2);
        Assert.assertEquals(2,dtoDetalleEvento.getIdEvento());
    }

    @Test
    public void getDescripcion() {
        String desc = dtoDetalleEvento.getDescripcion();
        Assert.assertEquals("Descripcion Evento",desc);
    }

    @Test
    public void setDescripcion() {
        dtoDetalleEvento.setDescripcion("New descri");
        Assert.assertEquals("New descri",dtoDetalleEvento.getDescripcion());
    }

    @Test
    public void getFechaInicio() {
        Date date = dtoDetalleEvento.getFechaInicio();
        Assert.assertEquals(new Date(2021, Calendar.AUGUST,23) ,date);
    }

    @Test
    public void setFechaInicio() {
        dtoDetalleEvento.setFechaInicio(new Date(2021, Calendar.AUGUST,25));
        Assert.assertEquals(new Date(2021, Calendar.AUGUST,25),dtoDetalleEvento.getFechaInicio());
    }

    @Test
    public void getFechaFin() {
        Date date = dtoDetalleEvento.getFechaFin();
        Assert.assertEquals(new Date(2021, Calendar.AUGUST,23),date);
    }

    @Test
    public void setFechaFin() {
        dtoDetalleEvento.setFechaFin(new Date(2021, Calendar.AUGUST,28));
        Assert.assertEquals(new Date(2021, Calendar.AUGUST,28),dtoDetalleEvento.getFechaFin());
    }

    @Test
    public void getEstado() {
        estados est = dtoDetalleEvento.getEstado();
        Assert.assertEquals(estados.enCurso,est);
    }

    @Test
    public void setEstado() {
        dtoDetalleEvento.setEstado(estados.cancelado);
        Assert.assertEquals(estados.cancelado,dtoDetalleEvento.getEstado());
    }

    @Test
    public void getIdPublicacion() {
    }

    @Test
    public void setIdPublicacion() {
        int idPub = dtoDetalleEvento.getIdPublicacion();
        Assert.assertEquals(1,idPub);
    }

    @Test
    public void getIdPersona() {
        String idPer = dtoDetalleEvento.getIdPersona();
        Assert.assertEquals("1",idPer);
    }

    @Test
    public void setIdPersona() {
        dtoDetalleEvento.setIdPersona("2");
        Assert.assertEquals("2",dtoDetalleEvento.getIdPersona());
    }

    @Test
    public void getIdChat() {
        String idChat = dtoDetalleEvento.getIdChat();
        Assert.assertEquals("1",idChat);
    }

    @Test
    public void setIdChat() {
        dtoDetalleEvento.setIdChat("2");
        Assert.assertEquals("2",dtoDetalleEvento.getIdChat());
    }

    @Test
    public void getNombre() {
        String nomb = dtoDetalleEvento.getNombre();
        Assert.assertEquals("Evento1",nomb);
    }

    @Test
    public void setNombre() {
        dtoDetalleEvento.setNombre("Evento2");
        Assert.assertEquals("Evento2",dtoDetalleEvento.getNombre());
    }

    @Test
    public void getUbicacion() {
        DTOUbicacion dtoUb = dtoDetalleEvento.getUbicacion();
        Assert.assertNotNull(dtoUb);
    }

    @Test
    public void setUbicacion() {
        Date date = new Date(2021,Calendar.AUGUST,3);
        DTOUbicacion dtoUb = new DTOUbicacion(1,50000,6000,date,"Detalles","Paraguay");
        dtoDetalleEvento.setUbicacion(dtoUb);
        Assert.assertNotNull(dtoDetalleEvento.getUbicacion());
        Assert.assertEquals(new Date(2021, Calendar.AUGUST,3),dtoDetalleEvento.getUbicacion().getFecha());
        Assert.assertEquals(1,dtoDetalleEvento.getUbicacion().getIdUbicacion());
        Assert.assertEquals("Detalles",dtoDetalleEvento.getUbicacion().getDescripcion());
        Assert.assertEquals("Paraguay",dtoDetalleEvento.getUbicacion().getPais());
    }

    @Test
    public void getNombreImagen() {
        String nomIma = dtoDetalleEvento.getNombreImagen();
        Assert.assertEquals("Nombre Imagen",nomIma);
    }

    @Test
    public void setNombreImagen() {
        dtoDetalleEvento.setNombreImagen("Image name");
        Assert.assertEquals("Image name",dtoDetalleEvento.getNombreImagen());
    }

    @Test
    public void getImagen() {
        String ima = dtoDetalleEvento.getImagen();
        Assert.assertEquals("Imagen en si 39849274",ima);
    }

    @Test
    public void setImagen() {
        dtoDetalleEvento.setImagen("Imagen 9387593");
        Assert.assertEquals("Imagen 9387593",dtoDetalleEvento.getImagen());
    }

    @Test
    public void getExtension() {
         String ext = dtoDetalleEvento.getExtension();
         Assert.assertEquals("jpg", ext);
    }

    @Test
    public void setExtension() {
        dtoDetalleEvento.setExtension("gif");
        Assert.assertEquals("gif",dtoDetalleEvento.getExtension());
    }

    @Test
    public void isOwner() {
        boolean owner = dtoDetalleEvento.isOwner();
        Assert.assertTrue(owner);
    }

    @Test
    public void setOwner() {
        dtoDetalleEvento.setOwner(false);
        Assert.assertFalse(dtoDetalleEvento.isOwner());
    }

    @Test
    public void getEstadoSolicitud() {
        estadosContactos est = dtoDetalleEvento.getEstadoSolicitud();
        Assert.assertEquals(estadosContactos.aceptada, est);
    }

    @Test
    public void setEstadoSolicitud() {
        dtoDetalleEvento.setEstadoSolicitud(estadosContactos.pendiente);
        Assert.assertEquals(estadosContactos.pendiente,dtoDetalleEvento.getEstadoSolicitud());
    }

    @Test
    public void getInvitados() {
        List<DTOUsuarioEvento> invits = dtoDetalleEvento.getInvitados();
        Assert.assertNotNull(invits);
        Assert.assertEquals(2,invits.size());
    }

    @Test
    public void setInvitados() {
        List<DTOUsuarioEvento> invits = new ArrayList<>();
        DTOUsuarioEvento dtoUsEv1 = new DTOUsuarioEvento();
        dtoUsEv1.setIdPersona("1");
        dtoUsEv1.setNombre("Juan");
        dtoUsEv1.setApellido("Alvez");
        dtoUsEv1.setNickname("juanA");
        dtoUsEv1.setImagenPerfil("");
        dtoUsEv1.setNombreImagen("");
        dtoUsEv1.setExtensionImagen("");
        dtoUsEv1.setEstadoContactos(estadosContactos.aceptada);
        dtoUsEv1.setOwner(true);
        invits.add(dtoUsEv1);

        dtoDetalleEvento.setInvitados(invits);

        Assert.assertNotNull(dtoDetalleEvento.getInvitados());
        Assert.assertEquals(1,dtoDetalleEvento.getInvitados().size());

    }
}
