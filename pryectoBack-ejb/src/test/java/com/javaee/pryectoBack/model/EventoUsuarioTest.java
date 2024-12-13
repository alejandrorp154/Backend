package com.javaee.pryectoBack.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.Assert;


@RunWith(MockitoJUnitRunner.class)
public class EventoUsuarioTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        eventoUsuario.setIdEvento(1);
        eventoUsuario.setIdPersona("2");
        eventoUsuario.setIdPersonaInvitador("1");
        eventoUsuario.setEstadoContactos(estadosContactos.pendiente);
    }

    private EventoUsuario eventoUsuario = new EventoUsuario();

    @Test
    public void eventoUsuarioDefault(){
        EventoUsuario eveUs = new EventoUsuario();
        Assert.assertNotNull(eveUs);
    }

    @Test
    public void eventoUsuarioParams(){
        EventoUsuario evenUs = new EventoUsuario("2",1,estadosContactos.pendiente,"1");
        Assert.assertNotNull(evenUs);
    }

    @Test
    public void getIdPersona() {
        String idPersona = eventoUsuario.getIdPersona();
        Assert.assertEquals(idPersona,"2");
    }

    @Test
    public void setIdPersona() {
        eventoUsuario.setIdPersona("3");
        Assert.assertEquals(eventoUsuario.getIdPersona(),"3");
    }

    @Test
    public void getIdEvento() {
        int idEvento = eventoUsuario.getIdEvento();
        Assert.assertEquals(idEvento,1);
    }

    @Test
    public void setIdEvento() {
        eventoUsuario.setIdEvento(3);
        Assert.assertEquals(eventoUsuario.getIdEvento(),3);
    }

    @Test
    public void getEstadoContactos() {
        estadosContactos estado = eventoUsuario.getEstadoContactos();
        Assert.assertEquals(estado,estadosContactos.pendiente);
    }

    @Test
    public void setEstadoContactos() {
        eventoUsuario.setEstadoContactos(estadosContactos.aceptada);
        Assert.assertEquals(eventoUsuario.getEstadoContactos(),estadosContactos.aceptada);
    }

    @Test
    public void getIdPersonaInvitador() {
        String idInvitador = eventoUsuario.getIdPersonaInvitador();
        Assert.assertEquals(idInvitador,"1");
    }

    @Test
    public void setIdPersonaInvitador() {
        eventoUsuario.setIdPersonaInvitador("3");
        Assert.assertEquals(eventoUsuario.getIdPersonaInvitador(),"3");
    }
}
