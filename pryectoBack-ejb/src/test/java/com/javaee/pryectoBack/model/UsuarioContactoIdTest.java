package com.javaee.pryectoBack.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.Assert;


@RunWith(MockitoJUnitRunner.class)
public class UsuarioContactoIdTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        usuarioContactoId.setIdPersona("1");
        usuarioContactoId.setContactoIdPersona("2");
    }

    private UsuarioContactoId usuarioContactoId = new UsuarioContactoId();

    @Test
    public void usuarioContactoIdDefault(){
        UsuarioContactoId userContactId = new UsuarioContactoId();
        Assert.assertNotNull(userContactId);
    }

    @Test
    public void usuarioContactoIdParams(){
        String id1 = "1";
        String id2 = "2";
        UsuarioContactoId userContactId = new UsuarioContactoId(id1,id2);

        Assert.assertNotNull(userContactId);
        Assert.assertEquals("1",userContactId.getIdPersona());
        Assert.assertEquals("2",userContactId.getContactoIdPersona());
    }

    @Test
    public void getIdPersona() {
        String id = usuarioContactoId.getIdPersona();
        Assert.assertEquals("1",id);
    }

    @Test
    public void setIdPersona() {
        usuarioContactoId.setIdPersona("10");
        Assert.assertEquals("10",usuarioContactoId.getIdPersona());
    }

    @Test
    public void getContactoIdPersona() {
        String idC = usuarioContactoId.getContactoIdPersona();
        Assert.assertEquals("2",idC);
    }

    @Test
    public void setContactoIdPersona() {
        usuarioContactoId.setContactoIdPersona("20");
        Assert.assertEquals("20",usuarioContactoId.getContactoIdPersona());
    }
}
