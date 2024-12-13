package com.javaee.pryectoBack.datatypes;

import com.javaee.pryectoBack.model.estadosContactos;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DTOEventoUsuarioTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        dtoEventoUsuario.setIdPersona("1");
        dtoEventoUsuario.setIdEvento(1);
        dtoEventoUsuario.setEstadoContactos(estadosContactos.aceptada);
    }

    private DTOEventoUsuario dtoEventoUsuario = new DTOEventoUsuario();

    @Test
    public void dtoEventoUsuarioDefault(){
        DTOEventoUsuario dtoEvUs = new DTOEventoUsuario();
        Assert.assertNotNull(dtoEvUs);
    }

    @Test
    public void getIdPersona() {
        String idPer = dtoEventoUsuario.getIdPersona();
        Assert.assertEquals("1",idPer);
    }

    @Test
    public void setIdPersona() {
        dtoEventoUsuario.setIdPersona("2");
        Assert.assertEquals("2",dtoEventoUsuario.getIdPersona());
    }

    @Test
    public void getIdEvento() {
        int idEven = dtoEventoUsuario.getIdEvento();
        Assert.assertEquals(1,idEven);
    }

    @Test
    public void setIdEvento() {
        dtoEventoUsuario.setIdEvento(2);
        Assert.assertEquals(2,dtoEventoUsuario.getIdEvento());
    }

    @Test
    public void getEstadoContactos() {
        estadosContactos status = dtoEventoUsuario.getEstadoContactos();
        Assert.assertEquals(estadosContactos.aceptada, status);
    }

    @Test
    public void setEstadoContactos() {
        dtoEventoUsuario.setEstadoContactos(estadosContactos.pendiente);
        Assert.assertEquals(estadosContactos.pendiente,dtoEventoUsuario.getEstadoContactos());
    }
}
