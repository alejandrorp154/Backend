package com.javaee.pryectoBack.datatypes;

import com.javaee.pryectoBack.model.Interes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class DTOInteresTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        dtoInteres.setInteres("Asado");
        dtoInteres.setIdInteres(1);
        List<DTOPerfilUsuario> perfiles = new ArrayList<>();

    }

    private DTOInteres dtoInteres = new DTOInteres();

    @Test
    public void dtoInteresDefault(){
        DTOInteres dtoInt = new DTOInteres();
        Assert.assertNotNull(dtoInt);
    }

    @Test
    public void dtoInteresParamInteres(){
        DTOInteres dtoInteres = new DTOInteres();
        dtoInteres.setIdInteres(1);
        dtoInteres.setInteres("Milanesa");
        List<DTOPerfilUsuario> perfilUsuarios = new ArrayList<>();
        dtoInteres.setPerfiles(perfilUsuarios);
        Interes inter = new Interes(dtoInteres);

        DTOInteres dtoInter = new DTOInteres(inter);
        Assert.assertNotNull(dtoInter);
    }

    @Test
    public void getIdInteres() {
        int idInter = dtoInteres.getIdInteres();
        Assert.assertEquals(1, idInter);
    }

    @Test
    public void setIdInteres() {
        dtoInteres.setIdInteres(2);
        Assert.assertEquals(2,dtoInteres.getIdInteres());
    }

    @Test
    public void getPerfiles() {
        List<DTOPerfilUsuario> perfiles = dtoInteres.getPerfiles();
        Assert.assertNotNull(perfiles);
    }

    @Test
    public void setPerfiles() {
        dtoInteres.setPerfiles(null);
        List<DTOPerfilUsuario> perfiles = new ArrayList<>();
        dtoInteres.setPerfiles(perfiles);
        Assert.assertNotNull(dtoInteres.getPerfiles());
    }

    @Test
    public void getInteres() {
        String inter = dtoInteres.getInteres();
        Assert.assertEquals("Asado",inter);
    }

    @Test
    public void setInteres() {
        dtoInteres.setInteres("Pizza");
        Assert.assertEquals("Pizza",dtoInteres.getInteres());
    }
}
