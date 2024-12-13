package com.javaee.pryectoBack.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.Assert;

import java.util.Calendar;
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioContactoTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        usuarioContacto.setIdPersona("1");
        usuarioContacto.setContactoIdPersona("2");
        Date date = new Date(2021, Calendar.JUNE,29);
        usuarioContacto.setFechaContactos(date);
        usuarioContacto.setEstadoContactos(estadosContactos.aceptada);
    }

    private UsuarioContacto usuarioContacto = new UsuarioContacto();

    @Test
    public void usuarioContacto(){
        UsuarioContacto userContact = new UsuarioContacto();
        Assert.assertNotNull(userContact);
    }

    @Test
    public void getIdPersona() {
        String idPersona = usuarioContacto.getIdPersona();
        Assert.assertEquals("1",idPersona);
    }

    @Test
    public void setIdPersona() {
        usuarioContacto.setIdPersona("10");
        Assert.assertEquals("10",usuarioContacto.getIdPersona());
    }

    @Test
    public void getFechaContactos() {
        Date date = usuarioContacto.getFechaContactos();
        Assert.assertEquals(new Date(2021, Calendar.JUNE,29),date);
    }

    @Test
    public void setFechaContactos() {
        Date date = new Date(2021, Calendar.JANUARY,15);
        usuarioContacto.setFechaContactos(date);
        Assert.assertEquals(new Date(2021, Calendar.JANUARY,15),usuarioContacto.getFechaContactos());
    }

    @Test
    public void getContactoIdPersona() {
        String idContactoPersona = usuarioContacto.getContactoIdPersona();
        Assert.assertEquals("2",idContactoPersona);
    }

    @Test
    public void setContactoIdPersona() {
        usuarioContacto.setContactoIdPersona("20");
        Assert.assertEquals("20",usuarioContacto.getContactoIdPersona());
    }

    @Test
    public void getEstadoContactos() {
        estadosContactos estado = usuarioContacto.getEstadoContactos();
        Assert.assertEquals(estadosContactos.aceptada,estado);
    }

    @Test
    public void setEstadoContactos() {
        usuarioContacto.setEstadoContactos(estadosContactos.pendiente);
        Assert.assertEquals(estadosContactos.pendiente,usuarioContacto.getEstadoContactos());
    }
}
