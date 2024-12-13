package com.javaee.pryectoBack.datatypes;

import com.javaee.pryectoBack.model.Configuracion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DTOConfiguracionTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        dtoConfiguracion.setIdConfiguracion(1);
        dtoConfiguracion.setAltaPublicacion(true);
        dtoConfiguracion.setAltaContacto(true);
        dtoConfiguracion.setReaccionPublicacion(true);
        dtoConfiguracion.setComentarPublicacion(true);
        dtoConfiguracion.setAltaEvento(true);
        dtoConfiguracion.setInvitacionUsuario(true);
        dtoConfiguracion.setSalirEvento(true);
        dtoConfiguracion.setRecuperarContrasenia(true);
        dtoConfiguracion.setBloquearUsuario(true);
        dtoConfiguracion.setDesbloquearUsuario(true);
        dtoConfiguracion.setChatUsuario(true);
        dtoConfiguracion.setBajaEvento(true);
        dtoConfiguracion.setModificacionEvento(true);
        dtoConfiguracion.setEmailNotification(true);
        dtoConfiguracion.setIdPersona("1");
    }

    private DTOConfiguracion dtoConfiguracion = new DTOConfiguracion();

    @Test
    public void dtoConfiguracion(){
        DTOConfiguracion dtoConf = new DTOConfiguracion();
        Assert.assertNotNull(dtoConf);
    }

    @Test
    public void dtoConfiguracionParams(){
        DTOConfiguracion dtoConf = new DTOConfiguracion(1,true,true,true,true,true,true,true,true,true,true,true,true,true,true,"2");
        Assert.assertNotNull(dtoConf);
    }

    @Test
    public void dtoConfiguracionObj(){
        Configuracion conf = new Configuracion(true);
        DTOConfiguracion dtoConf = new DTOConfiguracion(conf);

        Assert.assertEquals(0,dtoConf.getIdConfiguracion());
        Assert.assertTrue(dtoConf.isAltaPublicacion());
        Assert.assertTrue(dtoConf.isAltaContacto());
        Assert.assertTrue(dtoConf.isReaccionPublicacion());
        Assert.assertTrue(dtoConf.isComentarPublicacion());
        Assert.assertTrue(dtoConf.isAltaEvento());
        Assert.assertTrue(dtoConf.isInvitacionUsuario());
        Assert.assertTrue(dtoConf.isSalirEvento());
        Assert.assertTrue(dtoConf.isRecuperarContrasenia());
        Assert.assertTrue(dtoConf.isBloquearUsuario());
        Assert.assertTrue(dtoConf.isDesbloquearUsuario());
        Assert.assertTrue(dtoConf.isChatUsuario());
        Assert.assertTrue(dtoConf.isBajaEvento());
        Assert.assertTrue(dtoConf.isModificacionEvento());
        Assert.assertTrue(dtoConf.isEmailNotification());
        Assert.assertEquals(null,dtoConf.getIdPersona());
    }

    @Test
    public void getIdConfiguracion() {
        int idConfig = dtoConfiguracion.getIdConfiguracion();
        Assert.assertEquals(1,idConfig);
    }

    @Test
    public void setIdConfiguracion() {
        dtoConfiguracion.setIdConfiguracion(2);
        Assert.assertEquals(2, dtoConfiguracion.getIdConfiguracion());
    }

    @Test
    public void isAltaPublicacion() {
        boolean altaPub = dtoConfiguracion.isAltaContacto();
        Assert.assertTrue(altaPub);
    }

    @Test
    public void setAltaPublicacion() {
        dtoConfiguracion.setAltaPublicacion(false);
        Assert.assertFalse(dtoConfiguracion.isAltaPublicacion());
    }

    @Test
    public void isAltaContacto() {
        boolean altaCont = dtoConfiguracion.isAltaContacto();
        Assert.assertTrue(altaCont);
    }

    @Test
    public void setAltaContacto() {
        dtoConfiguracion.setAltaContacto(false);
        Assert.assertFalse(dtoConfiguracion.isAltaContacto());
    }

    @Test
    public void isReaccionPublicacion() {
        boolean reaccionPub = dtoConfiguracion.isReaccionPublicacion();
        Assert.assertTrue(reaccionPub);
    }

    @Test
    public void setReaccionPublicacion() {
        dtoConfiguracion.setReaccionPublicacion(false);
        Assert.assertFalse(dtoConfiguracion.isReaccionPublicacion());
    }

    @Test
    public void isComentarPublicacion() {
        boolean comentPub = dtoConfiguracion.isComentarPublicacion();
        Assert.assertTrue(comentPub);
    }

    @Test
    public void setComentarPublicacion() {
        dtoConfiguracion.setComentarPublicacion(false);
        Assert.assertFalse(dtoConfiguracion.isComentarPublicacion());
    }

    @Test
    public void isAltaEvento() {
        boolean altaEven = dtoConfiguracion.isAltaEvento();
        Assert.assertTrue(altaEven);
    }

    @Test
    public void setAltaEvento() {
        dtoConfiguracion.setAltaEvento(false);
        Assert.assertFalse(dtoConfiguracion.isAltaEvento());
    }

    @Test
    public void isInvitacionUsuario() {
        boolean invitacUsu = dtoConfiguracion.isInvitacionUsuario();
        Assert.assertTrue(invitacUsu);
    }

    @Test
    public void setInvitacionUsuario() {
        dtoConfiguracion.setInvitacionUsuario(false);
        Assert.assertFalse(dtoConfiguracion.isInvitacionUsuario());
    }

    @Test
    public void isSalirEvento() {
        boolean salirEven = dtoConfiguracion.isSalirEvento();
        Assert.assertTrue(salirEven);
    }

    @Test
    public void setSalirEvento() {
        dtoConfiguracion.setSalirEvento(false);
        Assert.assertFalse(dtoConfiguracion.isSalirEvento());
    }

    @Test
    public void isRecuperarContrasenia() {
        boolean recuContra = dtoConfiguracion.isRecuperarContrasenia();
        Assert.assertTrue(recuContra);
    }

    @Test
    public void setRecuperarContrasenia() {
        dtoConfiguracion.setRecuperarContrasenia(false);
        Assert.assertFalse(dtoConfiguracion.isRecuperarContrasenia());
    }

    @Test
    public void isBloquearUsuario() {
        boolean bloquearUsu = dtoConfiguracion.isBloquearUsuario();
        Assert.assertTrue(bloquearUsu);
    }

    @Test
    public void setBloquearUsuario() {
        dtoConfiguracion.setBloquearUsuario(false);
        Assert.assertFalse(dtoConfiguracion.isBloquearUsuario());
    }

    @Test
    public void isDesbloquearUsuario() {
        boolean desbloqueUsu = dtoConfiguracion.isDesbloquearUsuario();
        Assert.assertTrue(desbloqueUsu);
    }

    @Test
    public void setDesbloquearUsuario() {
        dtoConfiguracion.setDesbloquearUsuario(false);
        Assert.assertFalse(dtoConfiguracion.isDesbloquearUsuario());
    }

    @Test
    public void isChatUsuario() {
        boolean chatUsu = dtoConfiguracion.isChatUsuario();
        Assert.assertTrue(chatUsu);
    }

    @Test
    public void setChatUsuario() {
        dtoConfiguracion.setChatUsuario(false);
        Assert.assertFalse(dtoConfiguracion.isChatUsuario());
    }

    @Test
    public void isBajaEvento() {
        boolean bajaEvent = dtoConfiguracion.isBajaEvento();
        Assert.assertTrue(bajaEvent);
    }

    @Test
    public void setBajaEvento() {
        dtoConfiguracion.setBajaEvento(false);
        Assert.assertFalse(dtoConfiguracion.isBajaEvento());
    }

    @Test
    public void isModificacionEvento() {
        boolean modEvento = dtoConfiguracion.isModificacionEvento();
        Assert.assertTrue(modEvento);
    }

    @Test
    public void setModificacionEvento() {
        dtoConfiguracion.setModificacionEvento(false);
        Assert.assertFalse(dtoConfiguracion.isModificacionEvento());
    }

    @Test
    public void getIdPersona() {
        String idPersona = dtoConfiguracion.getIdPersona();
        Assert.assertEquals("1",idPersona);
    }

    @Test
    public void setIdPersona() {
        dtoConfiguracion.setIdPersona("2");
        Assert.assertEquals("2",dtoConfiguracion.getIdPersona());
    }

    @Test
    public void isEmailNotification() {
        boolean emailNoti = dtoConfiguracion.isEmailNotification();
        Assert.assertTrue(emailNoti);
    }

    @Test
    public void setEmailNotification() {
        dtoConfiguracion.setEmailNotification(false);
        Assert.assertFalse(dtoConfiguracion.isEmailNotification());
    }
}
