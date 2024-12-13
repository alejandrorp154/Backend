package com.javaee.pryectoBack.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ConfiguracionTest {


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        this.configuracion = new Configuracion();

        this.configuracion.setIdConfiguracion(1);
        this.configuracion.setAltaPublicacion(true);
        this.configuracion.setAltaContacto(true);
        this.configuracion.setReaccionPublicacion(true);
        this.configuracion.setComentarPublicacion(true);
        this.configuracion.setAltaEvento(true);
        this.configuracion.setInvitacionUsuario(true);
        this.configuracion.setSalirEvento(true);
        this.configuracion.setRecuperarContrasenia(true);
        this.configuracion.setBloquearUsuario(true);
        this.configuracion.setDesbloquearUsuario(true);
        this.configuracion.setChatUsuario(true);
        this.configuracion.setBajaEvento(true);
        this.configuracion.setModificacionEvento(true);
        this.configuracion.setEmailNotification(true);
        this.configuracion.setIdPersona("1");
    }

    private Configuracion configuracion = new Configuracion();

    @Test
    public void configuracionDefault(){
        Configuracion conf = new Configuracion();
        Assert.assertNotNull(conf);
    }

    @Test
    public void configuracionBoolean(){
        Configuracion conf = new Configuracion(true);
        Assert.assertNotNull(conf);
    }

    @Test
    public void setIdConfiguracion() {
        configuracion.setIdConfiguracion(1);
        Assert.assertEquals(1,configuracion.getIdConfiguracion());
    }

    @Test
    public void setAltaPublicacion() {
        configuracion.setAltaPublicacion(false);
        Assert.assertFalse(configuracion.isAltaPublicacion());
    }

    @Test
    public void setAltaContacto() {
        configuracion.setAltaContacto(false);
        Assert.assertFalse(configuracion.isAltaContacto());
    }

    @Test
    public void setReaccionPublicacion() {
        configuracion.setReaccionPublicacion(false);
        Assert.assertFalse(configuracion.isReaccionPublicacion());
    }

    @Test
    public void setComentarPublicacion() {
        configuracion.setComentarPublicacion(false);
        Assert.assertFalse(configuracion.isComentarPublicacion());
    }

    @Test
    public void setAltaEvento() {
        configuracion.setAltaEvento(false);
        Assert.assertFalse(configuracion.isAltaEvento());
    }

    @Test
    public void setInvitacionUsuario() {
        configuracion.setInvitacionUsuario(false);
        Assert.assertFalse(configuracion.isInvitacionUsuario());
    }

    @Test
    public void setSalirEvento() {
        configuracion.setSalirEvento(false);
        Assert.assertFalse(configuracion.isSalirEvento());
    }

    @Test
    public void setRecuperarContrasenia() {
        configuracion.setRecuperarContrasenia(false);
        Assert.assertFalse(configuracion.isRecuperarContrasenia());
    }

    @Test
    public void setBloquearUsuario() {
        configuracion.setBloquearUsuario(false);
        Assert.assertFalse(configuracion.isBloquearUsuario());
    }

    @Test
    public void setDesbloquearUsuario() {
        configuracion.setDesbloquearUsuario(false);
        Assert.assertFalse(configuracion.isDesbloquearUsuario());
    }

    @Test
    public void setChatUsuario() {
        configuracion.setChatUsuario(false);
        Assert.assertFalse(configuracion.isChatUsuario());
    }

    @Test
    public void setBajaEvento() {
        configuracion.setBajaEvento(false);
        Assert.assertFalse(configuracion.isBajaEvento());
    }

    @Test
    public void setModificacionEvento() {
        configuracion.setModificacionEvento(false);
        Assert.assertFalse(configuracion.isModificacionEvento());
    }

    @Test
    public void setIdPersona() {
        configuracion.setIdPersona("1");
        Assert.assertEquals("1",configuracion.getIdPersona());
    }

    @Test
    public void getIdPersona() {
        String res = configuracion.getIdPersona();
        Assert.assertEquals("1",res);
    }

    @Test
    public void setEmailNotification() {
        configuracion.setEmailNotification(false);
        Assert.assertFalse(configuracion.isEmailNotification());
    }

    @Test
    public void getIdConfiguracion() {
        int res = configuracion.getIdConfiguracion();
        Assert.assertEquals(1,res);

    }

    @Test
    public void isAltaPublicacion() {
        boolean res = configuracion.isAltaPublicacion();
        Assert.assertTrue(res);
    }

    @Test
    public void isAltaContacto() {
        boolean res = configuracion.isAltaContacto();
        Assert.assertTrue(res);
    }

    @Test
    public void isReaccionPublicacion() {
        boolean res = configuracion.isReaccionPublicacion();
        Assert.assertTrue(res);
    }

    @Test
    public void isComentarPublicacion() {
        boolean res = configuracion.isComentarPublicacion();
        Assert.assertTrue(res);
    }

    @Test
    public void isAltaEvento() {
        boolean res = configuracion.isAltaEvento();
        Assert.assertTrue(res);
    }

    @Test
    public void isInvitacionUsuario() {
        boolean res = configuracion.isInvitacionUsuario();
        Assert.assertTrue(res);
    }

    @Test
    public void isSalirEvento() {
        boolean res = configuracion.isSalirEvento();
        Assert.assertTrue(res);
    }

    @Test
    public void isRecuperarContrasenia() {
        boolean res = configuracion.isRecuperarContrasenia();
        Assert.assertTrue(res);
    }

    @Test
    public void isBloquearUsuario() {
        boolean res = configuracion.isBloquearUsuario();
        Assert.assertTrue(res);
    }

    @Test
    public void isDesbloquearUsuario() {
        boolean res = configuracion.isDesbloquearUsuario();
        Assert.assertTrue(res);
    }

    @Test
    public void isChatUsuario() {
        boolean res = configuracion.isChatUsuario();
        Assert.assertTrue(res);
    }

    @Test
    public void isBajaEvento() {
        boolean res = configuracion.isBajaEvento();
        Assert.assertTrue(res);
    }

    @Test
    public void isModificacionEvento() {
        boolean res = configuracion.isModificacionEvento();
        Assert.assertTrue(res);
    }



    @Test
    public void isEmailNotification() {
        boolean res = configuracion.isEmailNotification();
        Assert.assertTrue(res);
    }
}
