package com.javaee.pryectoBack.datatypes;

import com.javaee.pryectoBack.model.Medalla;
import com.javaee.pryectoBack.model.Usuario;
import com.javaee.pryectoBack.model.rangos;
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
public class DTOUsuarioMedallaTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

       dtoUsuarioMedalla.setIdPersona("1");
       dtoUsuarioMedalla.setEmail("probando@mail.com");
       dtoUsuarioMedalla.setNombre("Juan");
       dtoUsuarioMedalla.setApellido("Alvez");
       dtoUsuarioMedalla.setNickname("juanA");
       dtoUsuarioMedalla.setIdMedalla(1);
       dtoUsuarioMedalla.setCantidadPuntos(1450);
       dtoUsuarioMedalla.setLogros("Vas bien");
       dtoUsuarioMedalla.setRango(rangos.diamondWolf);
    }

    private DTOUsuarioMedalla dtoUsuarioMedalla = new DTOUsuarioMedalla();

    @Test
    public void dtoUsuarioMedallaDefault(){
        DTOUsuarioMedalla dtoUsMed = new DTOUsuarioMedalla();
        Assert.assertNotNull(dtoUsMed);
    }

    @Test
    public void dtoUsuarioMedallaParams(){
        DTOUsuarioMedalla dtoUsMed = new DTOUsuarioMedalla("1","probando@mail.com","Juan","Alvez","juanA",1,1450,"Va bien",rangos.diamondWolf);
        Assert.assertNotNull(dtoUsMed);
    }

    @Test
    public void dtoUsuarioMedallaObj(){
        DTOUsuario dtoUser = new DTOUsuario("1", "probanto1@gmail.com", "Peter", "Montes", "monters", "en su casa1", "099111111", "Uruguay","imagen1", "imagenPerfil1", "jpg");
        Usuario user = new Usuario(dtoUser);
        Medalla medalla = new Medalla();
        medalla.setIdMedalla(1);
        medalla.setCantidadPuntos(1500);
        medalla.setLogros("Vamos en camino");
        medalla.setRango(rangos.diamondWolf);
        user.setMedalla(medalla);

        DTOUsuarioMedalla dtoUsMed = new DTOUsuarioMedalla(user);
        Assert.assertNotNull(dtoUsMed);
    }

    @Test
    public void getIdPersona() {
        String idPer = dtoUsuarioMedalla.getIdPersona();
        Assert.assertEquals("1",idPer);
    }

    @Test
    public void setIdPersona() {
        dtoUsuarioMedalla.setIdPersona("2");
        Assert.assertEquals("2",dtoUsuarioMedalla.getIdPersona());
    }

    @Test
    public void getEmail() {
        String email = dtoUsuarioMedalla.getEmail();
        Assert.assertEquals("probando@mail.com",email);
    }

    @Test
    public void setEmail() {
        dtoUsuarioMedalla.setEmail("test@mail.com");
        Assert.assertEquals("test@mail.com",dtoUsuarioMedalla.getEmail());
    }

    @Test
    public void getNombre() {
        String nomb = dtoUsuarioMedalla.getNombre();
        Assert.assertEquals("Juan",nomb);
    }

    @Test
    public void setNombre() {
        dtoUsuarioMedalla.setNombre("Pedro");
        Assert.assertEquals("Pedro",dtoUsuarioMedalla.getNombre());
    }

    @Test
    public void getApellido() {
        String apelli = dtoUsuarioMedalla.getApellido();
        Assert.assertEquals("Alvez",apelli);
    }

    @Test
    public void setApellido() {
        dtoUsuarioMedalla.setApellido("Francces");
        Assert.assertEquals("Francces",dtoUsuarioMedalla.getApellido());
    }

    @Test
    public void getNickname() {
        String nick = dtoUsuarioMedalla.getNickname();
        Assert.assertEquals("juanA",nick);
    }

    @Test
    public void setNickname() {
        dtoUsuarioMedalla.setNickname("juanDeArco");
        Assert.assertEquals("juanDeArco",dtoUsuarioMedalla.getNickname());
    }

    @Test
    public void getIdMedalla() {
        int idMed = dtoUsuarioMedalla.getIdMedalla();
        Assert.assertEquals(1,idMed);
    }

    @Test
    public void setIdMedalla() {
        dtoUsuarioMedalla.setIdMedalla(2);
        Assert.assertEquals(2, dtoUsuarioMedalla.getIdMedalla());
    }

    @Test
    public void getCantidadPuntos() {
        float punt = dtoUsuarioMedalla.getCantidadPuntos();
        Assert.assertEquals(1450f,punt,1450f-punt);
    }

    @Test
    public void setCantidadPuntos() {
        dtoUsuarioMedalla.setCantidadPuntos(1500);
        Assert.assertEquals(1500f,dtoUsuarioMedalla.getCantidadPuntos(),1500f- dtoUsuarioMedalla.getCantidadPuntos());
    }

    @Test
    public void getLogros() {
        String logro = dtoUsuarioMedalla.getLogros();
        Assert.assertEquals("Vas bien",logro);
    }

    @Test
    public void setLogros() {
        dtoUsuarioMedalla.setLogros("Mucho mejor");
        Assert.assertEquals("Mucho mejor",dtoUsuarioMedalla.getLogros());
    }

    @Test
    public void getRango() {
        rangos ran = dtoUsuarioMedalla.getRango();
        Assert.assertEquals(rangos.diamondWolf, ran);
    }

    @Test
    public void setRango() {
        dtoUsuarioMedalla.setRango(rangos.alfaWolf);
        Assert.assertEquals(rangos.alfaWolf,dtoUsuarioMedalla.getRango());
    }
}
