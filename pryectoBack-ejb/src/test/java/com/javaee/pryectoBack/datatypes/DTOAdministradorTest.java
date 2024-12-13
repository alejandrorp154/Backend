package com.javaee.pryectoBack.datatypes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DTOAdministradorTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        dtoAdministrador.setIdPersona("1");
        dtoAdministrador.setNombre("Tony");
        dtoAdministrador.setApellido("Garcia");
        dtoAdministrador.setEmail("probando@mail.com");
    }

    private DTOAdministrador dtoAdministrador = new DTOAdministrador();

    @Test
    public void dtoAdministradorDefault() {
        DTOAdministrador dtoAdmin = new DTOAdministrador();
        Assert.assertNotNull(dtoAdmin);
    }

    @Test
    public void dtoAdministradorParams() {
        DTOAdministrador dtoAdmin = new DTOAdministrador("1","email@mail.com","Alberto","Ganduglia");
        Assert.assertNotNull(dtoAdmin);
    }

    @Test
    public void getIdPersona() {
        String idPersona = dtoAdministrador.getIdPersona();
        Assert.assertEquals("1",idPersona);
    }

    @Test
    public void setIdPersona() {
        dtoAdministrador.setIdPersona("2");
        Assert.assertEquals("2",dtoAdministrador.getIdPersona());
    }

    @Test
    public void getEmail() {
        String mail = dtoAdministrador.getEmail();
        Assert.assertEquals("probando@mail.com",mail);
    }

    @Test
    public void setEmail() {
        dtoAdministrador.setEmail("cambio@mail.com");
        Assert.assertEquals("cambio@mail.com",dtoAdministrador.getEmail());
    }

    @Test
    public void getNombre() {
        String nomb = dtoAdministrador.getNombre();
        Assert.assertEquals("Tony",nomb);
    }

    @Test
    public void setNombre() {
        dtoAdministrador.setNombre("Juan");
        Assert.assertEquals("Juan",dtoAdministrador.getNombre());
    }

    @Test
    public void getApellido() {
        String apell = dtoAdministrador.getApellido();
        Assert.assertEquals("Garcia",apell);
    }

    @Test
    public void setApellido() {
        dtoAdministrador.setApellido("Muniz");
        Assert.assertEquals("Muniz",dtoAdministrador.getApellido());
    }
}
