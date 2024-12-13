package com.javaee.pryectoBack.datatypes;

import com.javaee.pryectoBack.model.UsuarioContacto;
import com.javaee.pryectoBack.model.estadosContactos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Date;


@RunWith(MockitoJUnitRunner.class)
public class DTOUsuarioContactoTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        dtoUsuarioContacto.setIdPersona("1");
        dtoUsuarioContacto.setContactoIdPersona("2");
        dtoUsuarioContacto.setEstadoContactos(estadosContactos.aceptada);
        Date date = new Date(2021, Calendar.JUNE,21);
        dtoUsuarioContacto.setFechaContactos(date);
    }

    private DTOUsuarioContacto dtoUsuarioContacto = new DTOUsuarioContacto();

    @Test
    public void dtoUsuarioContectoDefault(){
        DTOUsuarioContacto dtoUsCon = new DTOUsuarioContacto();
        Assert.assertNotNull(dtoUsCon);
    }

    @Test
    public void dtoUsuarioContectoObj(){
        UsuarioContacto usuaConta = new UsuarioContacto();
        usuaConta.setEstadoContactos(estadosContactos.aceptada);
        usuaConta.setIdPersona("1");
        usuaConta.setContactoIdPersona("2");
        Date date = new Date(2021, Calendar.JUNE,21);
        usuaConta.setFechaContactos(date);
        DTOUsuarioContacto dtoUsCon = new DTOUsuarioContacto(usuaConta);
        Assert.assertNotNull(dtoUsCon);
    }

    @Test
    public void getIdPersona() {
        String idPer = dtoUsuarioContacto.getIdPersona();
        Assert.assertEquals("1",idPer);
    }

    @Test
    public void setIdPersona() {
        dtoUsuarioContacto.setIdPersona("55");
        Assert.assertEquals("55",dtoUsuarioContacto.getIdPersona());
    }

    @Test
    public void getContactoIdPersona() {
        String idPerCon = dtoUsuarioContacto.getContactoIdPersona();
        Assert.assertEquals("2",idPerCon);
    }

    @Test
    public void setContactoIdPersona() {
        dtoUsuarioContacto.setContactoIdPersona("43");
        Assert.assertEquals("43",dtoUsuarioContacto.getContactoIdPersona());
    }

    @Test
    public void getFechaContactos() {
        Date date = dtoUsuarioContacto.getFechaContactos();
        Assert.assertEquals(new Date(2021, Calendar.JUNE,21),date);
    }

    @Test
    public void setFechaContactos() {
        Date date = new Date(2021, Calendar.DECEMBER,12);
        dtoUsuarioContacto.setFechaContactos(date);
        Assert.assertEquals(new Date(2021, Calendar.DECEMBER,12),dtoUsuarioContacto.getFechaContactos());
    }

    @Test
    public void getEstadoContactos() {
        estadosContactos status = dtoUsuarioContacto.getEstadoContactos();
        Assert.assertEquals(estadosContactos.aceptada,status);
    }

    @Test
    public void setEstadoContactos() {
        dtoUsuarioContacto.setEstadoContactos(estadosContactos.pendiente);
        Assert.assertEquals(estadosContactos.pendiente,dtoUsuarioContacto.getEstadoContactos());
    }
}
