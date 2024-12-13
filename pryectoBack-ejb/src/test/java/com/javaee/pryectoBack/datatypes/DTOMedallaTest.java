package com.javaee.pryectoBack.datatypes;

import com.javaee.pryectoBack.model.Medalla;
import com.javaee.pryectoBack.model.Usuario;
import com.javaee.pryectoBack.model.rangos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DTOMedallaTest {

    @Before
    public void init() {
      MockitoAnnotations.initMocks(this);

      dtoMedalla.setIdMedalla(1);
      dtoMedalla.setCantidadPuntos(1500);
      dtoMedalla.setLogros("Al máximo");
      dtoMedalla.setRango(rangos.alfaWolf);
      DTOUsuario dtoUsuario = new DTOUsuario("1","probando@mail.com","Luis","Marquez","luisM","en mi casa","099123123","Uruguay","Imagen de Perfil","Image","jpg");
      dtoMedalla.setUsuario(dtoUsuario);

    }

    private DTOMedalla dtoMedalla = new DTOMedalla();

    @Test
    public void dtoMedallaDefault(){
        DTOMedalla dtoMed = new DTOMedalla();
        Assert.assertNotNull(dtoMed);
    }

    @Test
    public void dtoMEdallaParamsAll(){
        DTOUsuario dtoUsuario = new DTOUsuario("1","probando@mail.com","Luis","Marquez","luisM","en mi casa","099123123","Uruguay","Imagen de Perfil","Image","jpg");
        DTOMedalla dtoMed = new DTOMedalla(1,1000,"Al máximo",rangos.alfaWolf,dtoUsuario);
        Assert.assertNotNull(dtoMed);
    }

    @Test
    public void dtoMedallaObj(){
        Medalla med = new Medalla();
        med.setIdMedalla(1);
        med.setCantidadPuntos(500);
        med.setLogros("Va bien");
        med.setRango(rangos.bronzeWolf);
        DTOUsuario dtoUsuario = new DTOUsuario("1","probando@mail.com","Luis","Marquez","luisM","en mi casa","099123123","Uruguay","Imagen de Perfil","Image","jpg");
        med.setUsuario(new Usuario(dtoUsuario));

        DTOMedalla dtoMed = new DTOMedalla(med);
        Assert.assertNotNull(dtoMed);
    }

    @Test
    public void getIdMedalla() {
      int idMeda = dtoMedalla.getIdMedalla();
      Assert.assertEquals(1,idMeda);
    }

    @Test
    public void setIdMedalla() {
      dtoMedalla.setIdMedalla(2);
      Assert.assertEquals(2,dtoMedalla.getIdMedalla());
    }

    @Test
    public void getCantidadPuntos() {
        int cantPunt = dtoMedalla.getCantidadPuntos();
        Assert.assertEquals(1500,cantPunt);
    }

    @Test
    public void setCantidadPuntos() {
        dtoMedalla.setCantidadPuntos(1000);
        Assert.assertEquals(1000,dtoMedalla.getCantidadPuntos());
    }

    @Test
    public void getLogros() {
        String logros = dtoMedalla.getLogros();
        Assert.assertEquals("Al máximo", logros);
    }

    @Test
    public void setLogros() {
        dtoMedalla.setLogros("Un poco menos");
        Assert.assertEquals("Un poco menos", dtoMedalla.getLogros());
    }

    @Test
    public void getRango() {
        rangos ran = dtoMedalla.getRango();
        Assert.assertEquals(rangos.alfaWolf, ran);
    }

    @Test
    public void setRango() {
        dtoMedalla.setRango(rangos.diamondWolf);
        Assert.assertEquals(rangos.diamondWolf,dtoMedalla.getRango());
    }

    @Test
    public void getUsuario() {
        DTOUsuario dtoUs = dtoMedalla.getUsuario();
        Assert.assertNotNull(dtoUs);
    }

    @Test
    public void setUsuario() {
        DTOUsuario dtoUsuario = new DTOUsuario("2","probando2@mail.com","Luis2","Marquez2","luisM2","en mi casa","099123123","Uruguay","Imagen de Perfil","Image2","jpg");
        dtoMedalla.setUsuario(dtoUsuario);
        Assert.assertNotNull(dtoMedalla.getUsuario());
        Assert.assertEquals("2",dtoMedalla.getUsuario().getIdPersona());
        Assert.assertEquals("probando2@mail.com",dtoMedalla.getUsuario().getEmail());
        Assert.assertEquals("Luis2",dtoMedalla.getUsuario().getNombre());
        Assert.assertEquals("Marquez2",dtoMedalla.getUsuario().getApellido());
    }
}
