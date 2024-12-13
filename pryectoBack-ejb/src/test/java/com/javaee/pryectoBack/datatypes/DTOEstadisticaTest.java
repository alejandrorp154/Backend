package com.javaee.pryectoBack.datatypes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DTOEstadisticaTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        dtoEstadistica.setCantidadUsuariosRegistrados(1600L);
        dtoEstadistica.setNombrePais("Uruguay");
        dtoEstadistica.setNombreUsuario("Juan");
        dtoEstadistica.setNombreMedalla("Alfa Wolf");
        dtoEstadistica.setCantidadPuntos(2500);
        dtoEstadistica.setCantidadVisitas(1200);
    }

    private DTOEstadistica dtoEstadistica = new DTOEstadistica();

    @Test
    public void dtoEstadisticaDefault(){
        DTOEstadistica dtoEst = new DTOEstadistica();
        Assert.assertNotNull(dtoEst);
    }

    @Test
    public void dtoEstadisticaCantidadVisitasUsua(){
        DTOEstadistica dtoEst = new DTOEstadistica("Juan", 1544);
        Assert.assertNotNull(dtoEst);
    }

    @Test
    public void dtoEstadisticaCantUsuarioRegistroPais(){
        DTOEstadistica dtoEsta = new DTOEstadistica(new Long(500),"Uruguay");
        Assert.assertNotNull(dtoEsta);
    }

    @Test
    public void getCantidadUsuariosRegistrados() {
        Long cantUsuReg = dtoEstadistica.getCantidadUsuariosRegistrados();
        Assert.assertEquals((Long)1600L,cantUsuReg);
    }

    @Test
    public void setCantidadUsuariosRegistrados() {
        dtoEstadistica.setCantidadUsuariosRegistrados(500L);
        Assert.assertEquals((Long)500L,dtoEstadistica.getCantidadUsuariosRegistrados());
    }

    @Test
    public void getNombrePais() {
        String pais = dtoEstadistica.getNombrePais();
        Assert.assertEquals("Uruguay",pais);
    }

    @Test
    public void setNombrePais() {
        dtoEstadistica.setNombrePais("Paraguay");
        Assert.assertEquals("Paraguay",dtoEstadistica.getNombrePais());
    }

    @Test
    public void getNombreUsuario() {
        String nomUsu = dtoEstadistica.getNombreUsuario();
        Assert.assertEquals("Juan",nomUsu);
    }

    @Test
    public void setNombreUsuario() {
        dtoEstadistica.setNombreUsuario("Alberto");
        Assert.assertEquals("Alberto",dtoEstadistica.getNombreUsuario());
    }

    @Test
    public void getNombreMedalla() {
        String nomMedalla = dtoEstadistica.getNombreMedalla();
        Assert.assertEquals("Alfa Wolf",nomMedalla);
    }

    @Test
    public void setNombreMedalla() {
        dtoEstadistica.setNombreMedalla("Iron Wolf");
        Assert.assertEquals("Iron Wolf", dtoEstadistica.getNombreMedalla());
    }

    @Test
    public void getCantidadPuntos() {
        Integer puntos = dtoEstadistica.getCantidadPuntos();
        Assert.assertEquals((Integer)2500,puntos);
    }

    @Test
    public void setCantidadPuntos() {
        dtoEstadistica.setCantidadPuntos(1400);
        Assert.assertEquals((Integer)1400,dtoEstadistica.getCantidadPuntos());
    }

    @Test
    public void getCantidadVisitas() {
        Integer cantVisit = dtoEstadistica.getCantidadVisitas();
        Assert.assertEquals((Integer)1200,cantVisit);
    }

    @Test
    public void setCantidadVisitas() {
        dtoEstadistica.setCantidadVisitas(200);
        Assert.assertEquals((Integer)200,dtoEstadistica.getCantidadVisitas());
    }
}
