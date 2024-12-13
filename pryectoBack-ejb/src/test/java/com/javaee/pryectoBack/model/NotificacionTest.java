package com.javaee.pryectoBack.model;

import com.javaee.pryectoBack.datatypes.DTOUsuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class NotificacionTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        notificacion.setIdNotificacion(1);
        notificacion.setContenido("Una notificacion");
        List<Usuario> users = new ArrayList<>();
        DTOUsuario dtoUser = new DTOUsuario("1", "probanto1@gmail.com", "German", "Gutierrez", "elguti", "en su casa", "099111111", "Uruguay","imagen", "imagenPerfil", "jpg");
        Usuario us = new Usuario(dtoUser);

        DTOUsuario dtoUser2 = new DTOUsuario("2", "probanto2@gmail.com", "Marcos", "Gimenez", "marcgi", "en su casa", "099222222", "Paraguay","imagen2", "imagenPerfil2", "jpg");
        Usuario us2 = new Usuario(dtoUser2);

        users.add(us);
        users.add(us2);
        notificacion.setUsuarios(users);

    }

    private Notificacion notificacion = new Notificacion();

    @Test
    public void notificacionDefault(){
        Notificacion noti = new Notificacion();
        Assert.assertNotNull(noti);
    }

    @Test
    public void getIdNotificacion() {
        int idnoti = notificacion.getIdNotificacion();
        Assert.assertEquals(1,idnoti);
    }

    @Test
    public void setIdNotificacion() {
        notificacion.setIdNotificacion(2);
        Assert.assertEquals(2,notificacion.getIdNotificacion());
    }

    @Test
    public void getContenido() {
        String content = notificacion.getContenido();
        Assert.assertEquals("Una notificacion",content);
    }

    @Test
    public void setContenido() {
        notificacion.setContenido("2 notificacion");
        Assert.assertEquals("2 notificacion",notificacion.getContenido());
    }

    @Test
    public void getUsuarios() {
        List<Usuario> users = notificacion.getUsuarios();
        Assert.assertEquals(2,users.size());
        Assert.assertEquals("1",users.get(0).getIdPersona());
        Assert.assertEquals("2",users.get(1).getIdPersona());
    }

    @Test
    public void setUsuarios() {
        List<Usuario> users = new ArrayList<>();
        DTOUsuario dtoUser = new DTOUsuario("3", "probanto3@gmail.com", "Peter", "Montes", "monters", "en su casa3", "099333333", "Brasil","imagen3", "imagenPerfil3", "jpg");
        Usuario us = new Usuario(dtoUser);
        users.add(us);
        notificacion.setUsuarios(users);

        Assert.assertEquals(1,notificacion.getUsuarios().size());
        Assert.assertEquals("3",notificacion.getUsuarios().get(0).getIdPersona());
    }
}
