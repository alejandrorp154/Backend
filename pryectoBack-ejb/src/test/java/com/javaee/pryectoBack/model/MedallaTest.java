package com.javaee.pryectoBack.model;

import com.javaee.pryectoBack.datatypes.DTOMedalla;
import com.javaee.pryectoBack.datatypes.DTOUsuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class MedallaTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        medalla.setIdMedalla(0);
        medalla.setLogros("Logros");
        medalla.setRango(rangos.alfaWolf);
        medalla.setCantidadPuntos(1500);
        Usuario user = new Usuario();
        user.setIdPersona("1");
        medalla.setUsuario(user);
    }

    private Medalla medalla = new Medalla();

    @Test
    public void medallaDefault(){
        Medalla meda = new Medalla();
        Assert.assertNotNull(meda);
    }

    @Test
    public void medallaDTO(){
        Medalla meda = new Medalla(null);
        Assert.assertNotNull(meda);
        DTOUsuario dtoUser = new DTOUsuario("1", "probanto1@gmail.com", "German", "Gutierrez", "elguti", "en su casa", "099111111", "Uruguay","imagen", "imagenPerfil", "jpg");

        DTOMedalla dtomed = new DTOMedalla(meda.getIdMedalla(),meda.getCantidadPuntos(),meda.getLogros(),meda.getRango(),dtoUser);
        meda = new Medalla(dtomed);
        Assert.assertNotNull(meda);
    }

    @Test
    public void getUsuario() {
        Usuario user = medalla.getUsuario();
        Assert.assertNotNull(user);
    }

    @Test
    public void setUsuario() {
        Usuario us = new Usuario();
        us.setIdPersona("99");
        medalla.setUsuario(us);
        Assert.assertEquals("99",medalla.getUsuario().getIdPersona());
    }

    @Test
    public void getIdMedalla() {
        int idMedalla = medalla.getIdMedalla();
        Assert.assertEquals(0,idMedalla);
    }

    @Test
    public void setIdMedalla() {
        medalla.setIdMedalla(5);
        Assert.assertEquals(5,medalla.getIdMedalla());
    }

    @Test
    public void getCantidadPuntos() {
        int puntos = medalla.getCantidadPuntos();
        Assert.assertEquals(1500,puntos);
    }

    @Test
    public void setCantidadPuntos() {
        medalla.setCantidadPuntos(2000);
        Assert.assertEquals(2000,medalla.getCantidadPuntos());
    }

    @Test
    public void getLogros() {
        String logro = medalla.getLogros();
        Assert.assertEquals("Logros",logro);
    }

    @Test
    public void setLogros() {
        medalla.setLogros("Todos mis logros");
        Assert.assertEquals("Todos mis logros",medalla.getLogros());
    }

    @Test
    public void getRango() {
        rangos ran = medalla.getRango();
        Assert.assertEquals(rangos.alfaWolf,ran);
    }

    @Test
    public void setRango() {
        medalla.setRango(rangos.diamondWolf);
        Assert.assertEquals(rangos.diamondWolf,medalla.getRango());
    }
}
