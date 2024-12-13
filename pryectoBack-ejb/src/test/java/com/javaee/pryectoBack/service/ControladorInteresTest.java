package com.javaee.pryectoBack.service;

import com.javaee.pryectoBack.data.ControladorInteresDA;
import com.javaee.pryectoBack.data.ControladorInteresDALocal;
import com.javaee.pryectoBack.datatypes.DTOInteres;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class ControladorInteresTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private ControladorInteresDALocal controladorInteresDA = new ControladorInteresDA();

    @InjectMocks
    private ControladorInteresLocal controladorInteres = new ControladorInteres();

    @Test
    public void alta() {
        DTOInteres dtoInter = new DTOInteres();
        dtoInter.setInteres("Asado");
        dtoInter.setIdInteres(1);

        Mockito.when(controladorInteresDA.alta(Mockito.any(DTOInteres.class))).thenReturn(dtoInter);

        DTOInteres res = controladorInteres.alta(dtoInter);
        Assert.assertNotNull(res);
    }

    @Test
    public void baja() {
        Mockito.when(controladorInteresDA.baja(Mockito.anyInt())).thenReturn(true);
        boolean res = controladorInteres.baja(1);
        Assert.assertTrue(res);
    }

    @Test
    public void modificar() {
        DTOInteres dtoInter = new DTOInteres();
        dtoInter.setInteres("Asado");
        dtoInter.setIdInteres(1);

        Mockito.when(controladorInteresDA.modificar(Mockito.any(DTOInteres.class))).thenReturn(dtoInter);
        DTOInteres res = controladorInteres.modificar(dtoInter);
        Assert.assertNotNull(res);
    }

    @Test
    public void getById() {
        DTOInteres dtoInter = new DTOInteres();
        dtoInter.setInteres("Asado");
        dtoInter.setIdInteres(1);

        Mockito.when(controladorInteresDA.getById(Mockito.anyInt())).thenReturn(dtoInter);
        DTOInteres res = controladorInteres.getById(1);
        Assert.assertNotNull(res);
    }

    @Test
    public void getAll() {
        List<DTOInteres> intereses = new ArrayList<>();

        DTOInteres dtoInter = new DTOInteres();
        dtoInter.setInteres("Asado");
        dtoInter.setIdInteres(1);

        DTOInteres dtoInter2 = new DTOInteres();
        dtoInter2.setInteres("Pizza");
        dtoInter2.setIdInteres(2);

        intereses.add(dtoInter);
        intereses.add(dtoInter2);

        Mockito.when(controladorInteresDA.getAll(Mockito.anyInt(),Mockito.anyInt())).thenReturn(intereses);
        List<DTOInteres> res = controladorInteres.getAll(0,5);
        Assert.assertNotNull(res);
    }

    @Test
    public void suscribe() {
        Mockito.when(controladorInteresDA.suscribe(Mockito.anyString(),Mockito.anyInt())).thenReturn(true);
        boolean res = controladorInteres.suscribe("1",1);
        Assert.assertTrue(res);
    }

    @Test
    public void desuscribe() {
        Mockito.when(controladorInteresDA.desuscribe(Mockito.anyString(),Mockito.anyInt())).thenReturn(true);
        boolean res = controladorInteres.desuscribe("1",1);
        Assert.assertTrue(res);
    }
}
