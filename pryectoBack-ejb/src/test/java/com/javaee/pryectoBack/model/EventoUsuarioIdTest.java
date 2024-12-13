package com.javaee.pryectoBack.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.Assert;


@RunWith(MockitoJUnitRunner.class)
public class EventoUsuarioIdTest {


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        eventoUsuario.setIdPersona("1");
        eventoUsuario.setIdEvento(1);
    }

    private EventoUsuarioId eventoUsuario = new EventoUsuarioId();

    @Test
    public void eventoUsuarioIdDefault(){
        EventoUsuarioId eveUsId = new EventoUsuarioId();
        Assert.assertNotNull(eveUsId);
    }

    @Test
    public void eventoUsuarioParams(){
        EventoUsuarioId eveUsId = new EventoUsuarioId("4",4);
        Assert.assertNotNull(eveUsId);
    }

    @Test
    public void getIdPersona() {
        String idPersona = eventoUsuario.getIdPersona();
        Assert.assertEquals(idPersona,"1");
    }

    @Test
    public void setIdPersona() {
        eventoUsuario.setIdPersona("2");
        Assert.assertEquals(eventoUsuario.getIdPersona(),"2");
    }

    @Test
    public void getIdEvento() {
        int idEvento = eventoUsuario.getIdEvento();
        Assert.assertEquals(idEvento,1);
    }

    @Test
    public void setIdEvento() {
        eventoUsuario.setIdEvento(2);
        Assert.assertEquals(eventoUsuario.getIdEvento(),2);
    }
}
