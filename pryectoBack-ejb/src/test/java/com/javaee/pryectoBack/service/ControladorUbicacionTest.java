package com.javaee.pryectoBack.service;

import com.javaee.pryectoBack.data.ControladorUbicacionDA;
import com.javaee.pryectoBack.data.ControladorUbicacionDALocal;
import com.javaee.pryectoBack.datatypes.DTOUbicacion;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ControladorUbicacionTest {


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private ControladorUbicacionDALocal controladorUbicacionDA = new ControladorUbicacionDA();

    @InjectMocks
    private ControladorUbicacionLocal controladorUbicacion = new ControladorUbicacion();

    @Test
    public void alta() {
        Date date = new Date(2021, Calendar.JUNE,21);
        DTOUbicacion dtoUb = new DTOUbicacion(22,5433354,534235,date,"Detalles de la ubicación del evento","Uruguay");

        Mockito.when(controladorUbicacionDA.alta(Mockito.any(DTOUbicacion.class))).thenReturn(dtoUb);
        DTOUbicacion res = controladorUbicacion.alta(dtoUb);
        Assert.assertNotNull(res);
    }

    @Test
    public void obtenerUbicaciones() {
        List<DTOUbicacion> ubicaciones = new ArrayList<>();

        Date date = new Date(2021, Calendar.JUNE,21);
        DTOUbicacion dtoUb = new DTOUbicacion(22,5433354,534235,date,"Detalles de la ubicación del evento","Uruguay");

        Date date2 = new Date(2021, Calendar.DECEMBER,25);
        DTOUbicacion dtoUb2 = new DTOUbicacion(22,64,77,date2,"Detalles de la ubicación del evento","Uruguay");

        ubicaciones.add(dtoUb);
        ubicaciones.add(dtoUb2);

        Mockito.when(controladorUbicacionDA.obtenerUbicaciones(Mockito.anyString())).thenReturn(ubicaciones);
        List<DTOUbicacion> res = controladorUbicacion.obtenerUbicaciones("1");
        Assert.assertNotNull(res);
    }

    @Test
    public void baja() {
        Mockito.when(controladorUbicacionDA.baja(Mockito.anyInt())).thenReturn(true);
        boolean res = controladorUbicacion.baja(22);
        Assert.assertTrue(res);
    }

    @Test
    public void modificar() {
        Date date = new Date(2021, Calendar.JUNE,21);
        DTOUbicacion dtoUb = new DTOUbicacion(22,5433354,534235,date,"Detalles de la ubicación del evento","Uruguay");

        Mockito.when(controladorUbicacionDA.modificar(Mockito.any(DTOUbicacion.class))).thenReturn(true);
        boolean res = controladorUbicacion.modificar(dtoUb);
        Assert.assertTrue(res);

    }
}
