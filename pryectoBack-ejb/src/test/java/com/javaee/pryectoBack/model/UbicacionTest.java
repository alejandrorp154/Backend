package com.javaee.pryectoBack.model;

import com.javaee.pryectoBack.datatypes.DTOEvento;
import com.javaee.pryectoBack.datatypes.DTOUbicacion;
import com.javaee.pryectoBack.datatypes.DTOUsuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Date;


@RunWith(MockitoJUnitRunner.class)
public class UbicacionTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        ubicacion.setIdUbicacion(1);
        ubicacion.setLongitud(50000);
        ubicacion.setLatitud(60000);
        ubicacion.setDescripcion("Descripcion ubicacion");
        Date date = new Date(2021, Calendar.JUNE,28);
        ubicacion.setFecha(date);
        ubicacion.setPais("Uruguay");
        DTOUsuario dtoUser = new DTOUsuario("1", "probanto1@gmail.com", "Luis", "Marquez", "luisM", "en su casa", "099111111", "Uruguay","imagen1", "imagenPerfil1", "jpg");
        Usuario user = new Usuario(dtoUser);
        ubicacion.setUsuario(user);

        Date date1 = new Date(2021, Calendar.JUNE,28);
        Date date2 = new Date(2021,Calendar.JUNE,29);
        Date date3 = new Date(2021,Calendar.JUNE,29);
        DTOUbicacion dtoub = new DTOUbicacion(22,50000,60000,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(0,"Evento de prueba",date1, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");
        Evento evento = new Evento(dtoEvento);
        ubicacion.setEvento(evento);
    }

    private Ubicacion ubicacion = new Ubicacion();

    @Test
    public void ubicacionDefault(){
        Ubicacion ubi = new Ubicacion();
        Assert.assertNotNull(ubi);
    }

    @Test
    public void ubicacionDTO(){
        Date date3 = new Date(2021,Calendar.JUNE,29);
        DTOUbicacion dtoub = new DTOUbicacion(22,50000,60000,date3,"Detalles de la ubicación del evento","Uruguay");

        Ubicacion ubi = new Ubicacion(dtoub);
        Assert.assertNotNull(ubi);
        Assert.assertEquals(50000,ubi.getLongitud(),(50000-ubi.getLongitud()));
        Assert.assertEquals(60000,ubi.getLatitud(),(60000-ubi.getLatitud()));
        Assert.assertEquals("Uruguay",ubi.getPais());
    }

    @Test
    public void getIdUbicacion() {
        int idUbicaci = ubicacion.getIdUbicacion();
        Assert.assertEquals(1,idUbicaci);
    }

    @Test
    public void setIdUbicacion() {
        ubicacion.setIdUbicacion(2);
        Assert.assertEquals(2,ubicacion.getIdUbicacion());
    }

    @Test
    public void getLongitud() {
        float longi = ubicacion.getLongitud();
        Assert.assertEquals(50000,longi,(50000-longi));
    }

    @Test
    public void setLongitud() {
        ubicacion.setLongitud(55000);
        Assert.assertEquals(55000,ubicacion.getLongitud(),(55000-ubicacion.getLongitud()));
    }

    @Test
    public void getLatitud() {
        float lati = ubicacion.getLatitud();
        Assert.assertEquals(60000,lati,(60000-lati));
    }

    @Test
    public void setLatitud() {
        ubicacion.setLatitud(66000);
        Assert.assertEquals(66000,ubicacion.getLatitud(),(66000-ubicacion.getLatitud()));
    }

    @Test
    public void getFecha() {
        Date date = ubicacion.getFecha();
        Assert.assertEquals(new Date(2021, Calendar.JUNE,28),date);
    }

    @Test
    public void setFecha() {
        Date date = new Date(2021, Calendar.AUGUST,15);
        ubicacion.setFecha(date);
        Assert.assertEquals(new Date(2021, Calendar.AUGUST,15),ubicacion.getFecha());
    }

    @Test
    public void getDescripcion() {
        String desc = ubicacion.getDescripcion();
        Assert.assertEquals("Descripcion ubicacion",desc);
    }

    @Test
    public void setDescripcion() {
        ubicacion.setDescripcion("Nueva descripcion");
        Assert.assertEquals("Nueva descripcion",ubicacion.getDescripcion());
    }

    @Test
    public void getUsuario() {
        Usuario user = ubicacion.getUsuario();
        Assert.assertNotNull(user);
        Assert.assertEquals("1",user.getIdPersona());
    }

    @Test
    public void setUsuario() {
        DTOUsuario dtoUser = new DTOUsuario("20", "probanto20@gmail.com", "Juan", "Alvarez", "juanA", "en su casa", "099202020", "Uruguay","imagen20", "imagenPerfil20", "jpg");
        Usuario user = new Usuario(dtoUser);
        ubicacion.setUsuario(user);

        Assert.assertNotNull(ubicacion.getUsuario());
        Assert.assertEquals("20",ubicacion.getUsuario().getIdPersona());
        Assert.assertEquals("probanto20@gmail.com",ubicacion.getUsuario().getEmail());
        Assert.assertEquals("juanA",ubicacion.getUsuario().getNickname());

    }

    @Test
    public void getDTO() {
        DTOUbicacion dtoUbicacion = ubicacion.getDTO();

        Assert.assertEquals(1,dtoUbicacion.getIdUbicacion());
        Assert.assertEquals(50000,dtoUbicacion.getLongitud(),(50000-dtoUbicacion.getLongitud()));
        Assert.assertEquals(60000,dtoUbicacion.getLatitud(),(60000-dtoUbicacion.getLatitud()));
        Assert.assertEquals(new Date(2021, Calendar.JUNE,28),dtoUbicacion.getFecha());
        Assert.assertEquals("Descripcion ubicacion",dtoUbicacion.getDescripcion());
        Assert.assertEquals("Uruguay",dtoUbicacion.getPais());
    }

    @Test
    public void getDistancia() {
        Ubicacion ubi1 = new Ubicacion();
        ubi1.setIdUbicacion(2);
        ubi1.setLongitud(50000);
        ubi1.setLatitud(60000);

        Ubicacion ubi2 = new Ubicacion();
        ubi2.setIdUbicacion(3);
        ubi2.setLongitud(55000);
        ubi2.setLatitud(65000);

        double distancia = ubicacion.getDistancia(ubi1,ubi2);

        Assert.assertNotEquals(0,distancia);
        Assert.assertTrue(distancia>0);
    }

    @Test
    public void getEvento() {
        Evento event = ubicacion.getEvento();

        Date date1 = new Date(2021, Calendar.JUNE,28);
        Date date2 = new Date(2021,Calendar.JUNE,29);
        Date date3 = new Date(2021,Calendar.JUNE,29);
        DTOUbicacion dtoub = new DTOUbicacion(22,50000,60000,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(0,"Evento de prueba",date1, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");
        Evento evento = new Evento(dtoEvento);

        Assert.assertNotNull(event);
        Assert.assertEquals(0,evento.getIdEvento());
        Assert.assertEquals("Evento de prueba",evento.getDescripcion());
        Assert.assertEquals(estados.enCurso,evento.getEstado());
    }

    @Test
    public void setEvento() {
        Date date1 = new Date(2021, Calendar.JUNE,2);
        Date date2 = new Date(2021,Calendar.JUNE,15);
        Date date3 = new Date(2021,Calendar.JUNE,16);
        DTOUbicacion dtoub = new DTOUbicacion(22,50000,60000,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(0,"Evento de prueba0",date1, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento0","image249824","jpg");
        Evento evento = new Evento(dtoEvento);
        ubicacion.setEvento(evento);

        Assert.assertNotNull("Evento de prueba0",ubicacion.getEvento().getDescripcion());
        Assert.assertEquals("nombre imagen para mostrar del evento0",ubicacion.getEvento().getNombreImagen());
        Assert.assertEquals(estados.enCurso,ubicacion.getEvento().getEstado());
    }

    @Test
    public void getPais() {
        String pais = ubicacion.getPais();
        Assert.assertEquals("Uruguay",pais);
    }

    @Test
    public void setPais() {
        ubicacion.setPais("Brasil");
        Assert.assertEquals("Brasil",ubicacion.getPais());
    }
}
