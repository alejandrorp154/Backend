package com.javaee.pryectoBack.datatypes;

import com.javaee.pryectoBack.model.Ubicacion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Date;


@RunWith(MockitoJUnitRunner.class)
public class DTOUbicacionTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        dtoUbicacion.setIdUbicacion(1);
        dtoUbicacion.setLongitud(55.34232f);
        dtoUbicacion.setLatitud(56.7827f);
        Date date = new Date(2021, Calendar.JUNE,21);
        dtoUbicacion.setFecha(date);
        dtoUbicacion.setDescripcion("Descripcion de ubicacion");
        dtoUbicacion.setIdPersona("1");
        dtoUbicacion.setPais("Uruguay");
    }

    private DTOUbicacion dtoUbicacion = new DTOUbicacion();

    @Test
    public void dtoUbicacionDefault(){
        DTOUbicacion dtoUb = new DTOUbicacion();
        Assert.assertNotNull(dtoUb);
    }

    @Test
    public void dtoUbicacionParams(){
        Date date = new Date(2021, Calendar.JUNE,21);
        DTOUbicacion dtoUb = new DTOUbicacion(1,55.34232f,56.7827f,date,"Descripcion de ubicacion","1","Uruguay");
        Assert.assertNotNull(dtoUb);
        Assert.assertEquals(55.34232f,dtoUb.getLongitud(),(55.34232f-dtoUb.getLongitud()));
        Assert.assertEquals(56.7827f,dtoUb.getLatitud(),(56.7827f-dtoUb.getLatitud()));
        Assert.assertEquals("Descripcion de ubicacion",dtoUb.getDescripcion());
    }

    @Test
    public void dtoUbicacionParamsLess(){
        Date date = new Date(2021, Calendar.JUNE,21);
        DTOUbicacion dtoUb = new DTOUbicacion(1,55.34232f,56.7827f,date,"Descripcion de ubicacion","Uruguay");
        Assert.assertNotNull(dtoUb);
        Assert.assertEquals(55.34232f,dtoUb.getLongitud(),(55.34232f-dtoUb.getLongitud()));
        Assert.assertEquals(56.7827f,dtoUb.getLatitud(),(56.7827f-dtoUb.getLatitud()));
        Assert.assertEquals("Descripcion de ubicacion",dtoUb.getDescripcion());
    }

    @Test
    public void dtoUbicacionObj(){
        Date date = new Date(2021,Calendar.JUNE,29);
        DTOUbicacion dtoub = new DTOUbicacion(22,55.34232f,56.7827f,date,"Detalles de la ubicación","Uruguay");
        Ubicacion ubic = new Ubicacion(dtoub);
        DTOUbicacion dtoUb = new DTOUbicacion(ubic,"1");
        Assert.assertNotNull(dtoUb);
        Assert.assertEquals(55.34232f,dtoUb.getLongitud(),(55.34232f-dtoUb.getLongitud()));
        Assert.assertEquals(56.7827f,dtoUb.getLatitud(),(56.7827f-dtoUb.getLatitud()));
        Assert.assertEquals("Detalles de la ubicación",dtoUb.getDescripcion());
    }

    @Test
    public void dtoUbicacionObjLess(){
        Date date = new Date(2021,Calendar.JUNE,29);
        DTOUbicacion dtoub = new DTOUbicacion(22,55.34232f,56.7827f,date,"Detalles de la ubicación","Uruguay");
        Ubicacion ubic = new Ubicacion(dtoub);
        DTOUbicacion dtoUb = new DTOUbicacion(ubic);
        Assert.assertNotNull(dtoUb);
        Assert.assertEquals(55.34232f,dtoUb.getLongitud(),(55.34232f-dtoUb.getLongitud()));
        Assert.assertEquals(56.7827f,dtoUb.getLatitud(),(56.7827f-dtoUb.getLatitud()));
        Assert.assertEquals("Detalles de la ubicación",dtoUb.getDescripcion());
    }

    @Test
    public void getIdUbicacion() {
        int idUb = dtoUbicacion.getIdUbicacion();
        Assert.assertEquals(1,idUb);
    }

    @Test
    public void setIdUbicacion() {
        dtoUbicacion.setIdUbicacion(2);
        Assert.assertEquals(2,dtoUbicacion.getIdUbicacion());
    }

    @Test
    public void getLongitud() {
        float lon = dtoUbicacion.getLongitud();
        Assert.assertEquals(55.34232f,lon,(55.34232f-lon));
    }

    @Test
    public void setLongitud() {
        dtoUbicacion.setLongitud(65.34232f);
        Assert.assertEquals(65.34232f,dtoUbicacion.getLongitud(),(65.34232f-dtoUbicacion.getLongitud()));
    }

    @Test
    public void getLatitud() {
        float lat = dtoUbicacion.getLatitud();
        Assert.assertEquals(56.7827f,lat,(56.7827f-lat));
    }

    @Test
    public void setLatitud() {
        dtoUbicacion.setLatitud(44.7827f);
        Assert.assertEquals(44.7827f,dtoUbicacion.getLatitud(),(44.7827f-dtoUbicacion.getLatitud()));
    }

    @Test
    public void getFecha() {
        Date date = dtoUbicacion.getFecha();
        Assert.assertEquals(new Date(2021, Calendar.JUNE,21),date);
    }

    @Test
    public void setFecha() {
        Date date = new Date(2021, Calendar.FEBRUARY,2);
        dtoUbicacion.setFecha(date);
        Assert.assertEquals(new Date(2021, Calendar.FEBRUARY,2),dtoUbicacion.getFecha());
    }

    @Test
    public void getDescripcion() {
        String desc = dtoUbicacion.getDescripcion();
        Assert.assertEquals("Descripcion de ubicacion",desc);
    }

    @Test
    public void setDescripcion() {
        dtoUbicacion.setDescripcion("Nueva descripcion");
        Assert.assertEquals("Nueva descripcion",dtoUbicacion.getDescripcion());
    }

    @Test
    public void getIdPersona() {
        String idPer = dtoUbicacion.getIdPersona();
        Assert.assertEquals("1",idPer);
    }

    @Test
    public void setIdPersona() {
        dtoUbicacion.setIdPersona("2");
        Assert.assertEquals("2",dtoUbicacion.getIdPersona());
    }

    @Test
    public void getPais() {
        String pais = dtoUbicacion.getPais();
        Assert.assertEquals("Uruguay",pais);
    }

    @Test
    public void setPais() {
        dtoUbicacion.setPais("Paraguay");
        Assert.assertEquals("Paraguay",dtoUbicacion.getPais());
    }
}
