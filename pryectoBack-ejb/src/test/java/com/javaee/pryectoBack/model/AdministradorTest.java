package com.javaee.pryectoBack.model;

import com.javaee.pryectoBack.datatypes.DTOAdministrador;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.Assert;


@RunWith(MockitoJUnitRunner.class)
public class AdministradorTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void administrador(){
        Administrador adm = new Administrador();

        DTOAdministrador dtoAdm2 = new DTOAdministrador("1","admin@gmail.com","Alvaro","Alvez");

        Administrador adm2 = new Administrador(dtoAdm2);

        Assert.assertEquals(dtoAdm2.getIdPersona(),adm2.getIdPersona());
        Assert.assertEquals(dtoAdm2.getEmail(),adm2.getEmail());
        Assert.assertEquals(dtoAdm2.getNombre(),adm2.getNombre());
        Assert.assertEquals(dtoAdm2.getApellido(),adm2.getApellido());
    }
}
