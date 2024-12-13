package com.javaee.pryectoBack.datatypes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DTOUsuarioInicioSesionTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        dtoUsuarioInicioSesion.setIdPersona("1");
        dtoUsuarioInicioSesion.setEmail("probando@mail.com");
        dtoUsuarioInicioSesion.setNombre("Juan");
        dtoUsuarioInicioSesion.setApellido("Alvez");
        dtoUsuarioInicioSesion.setNickname("juanA");
        dtoUsuarioInicioSesion.setImagenPerfil("Imagen perfil 287482749");
        dtoUsuarioInicioSesion.setExtension("jpg");
        dtoUsuarioInicioSesion.setNombreImagen("Nombre imagen");
        dtoUsuarioInicioSesion.setAdministrador(true);
        dtoUsuarioInicioSesion.setBloqueado(false);

    }

    private DTOUsuarioInicioSesion dtoUsuarioInicioSesion = new DTOUsuarioInicioSesion();

    @Test
    public void setDtoUsuarioInicioSesionDefault(){
        DTOUsuarioInicioSesion dtoUsInSe = new DTOUsuarioInicioSesion();
        Assert.assertNotNull(dtoUsInSe);
    }

    @Test
    public void setDtoUsuarioInicioSesionParams(){
        DTOUsuarioInicioSesion dtoUsInSe = new DTOUsuarioInicioSesion("1","probando@mail.com","Juan","Alvez","juanA","Imagen perfil 287482749","jpg","Nombre imagen",true,false);
        Assert.assertNotNull(dtoUsInSe);
    }

    @Test
    public void getIdPersona() {
        String idPer = dtoUsuarioInicioSesion.getIdPersona();
        Assert.assertEquals("1",idPer);
    }

    @Test
    public void setIdPersona() {
        dtoUsuarioInicioSesion.setIdPersona("2");
        Assert.assertEquals("2",dtoUsuarioInicioSesion.getIdPersona());
    }

    @Test
    public void getEmail() {
        String email = dtoUsuarioInicioSesion.getEmail();
        Assert.assertEquals("probando@mail.com",email);
    }

    @Test
    public void setEmail() {
        dtoUsuarioInicioSesion.setEmail("test@mail.com");
        Assert.assertEquals("test@mail.com",dtoUsuarioInicioSesion.getEmail());
    }

    @Test
    public void getNombre() {
        String nomb = dtoUsuarioInicioSesion.getNombre();
        Assert.assertEquals("Juan",nomb);
    }

    @Test
    public void setNombre() {
        dtoUsuarioInicioSesion.setNombre("Pedro");
        Assert.assertEquals("Pedro",dtoUsuarioInicioSesion.getNombre());
    }

    @Test
    public void getApellido() {
        String apelli = dtoUsuarioInicioSesion.getApellido();
        Assert.assertEquals("Alvez",apelli);
    }

    @Test
    public void setApellido() {
        dtoUsuarioInicioSesion.setApellido("Francces");
        Assert.assertEquals("Francces",dtoUsuarioInicioSesion.getApellido());
    }

    @Test
    public void getNickname() {
        String nick = dtoUsuarioInicioSesion.getNickname();
        Assert.assertEquals("juanA",nick);
    }

    @Test
    public void setNickname() {
        dtoUsuarioInicioSesion.setNickname("juanDeArco");
        Assert.assertEquals("juanDeArco",dtoUsuarioInicioSesion.getNickname());
    }

    @Test
    public void getImagenPerfil() {
        String imaPer = dtoUsuarioInicioSesion.getImagenPerfil();
        Assert.assertEquals("Imagen perfil 287482749",imaPer);
    }

    @Test
    public void setImagenPerfil() {
        dtoUsuarioInicioSesion.setImagenPerfil("Cambio imagen 838394");
        Assert.assertEquals("Cambio imagen 838394",dtoUsuarioInicioSesion.getImagenPerfil());
    }

    @Test
    public void getExtension() {
        String ext = dtoUsuarioInicioSesion.getExtension();
        Assert.assertEquals("jpg",ext);
    }

    @Test
    public void setExtension() {
        dtoUsuarioInicioSesion.setExtension("gif");
        Assert.assertEquals("gif",dtoUsuarioInicioSesion.getExtension());
    }

    @Test
    public void getNombreImagen() {
        String nomImag = dtoUsuarioInicioSesion.getNombreImagen();
        Assert.assertEquals("Nombre imagen", nomImag);
    }

    @Test
    public void setNombreImagen() {
        dtoUsuarioInicioSesion.setNombreImagen("Image name");
        Assert.assertEquals("Image name",dtoUsuarioInicioSesion.getNombreImagen());
    }

    @Test
    public void isAdministrador() {
        boolean admin = dtoUsuarioInicioSesion.isAdministrador();
        Assert.assertTrue(admin);
    }

    @Test
    public void setAdministrador() {
        dtoUsuarioInicioSesion.setAdministrador(false);
        Assert.assertFalse(dtoUsuarioInicioSesion.isAdministrador());
    }

    @Test
    public void isBloqueado() {
        boolean block = dtoUsuarioInicioSesion.isBloqueado();
        Assert.assertFalse(block);
    }

    @Test
    public void setBloqueado() {
        dtoUsuarioInicioSesion.setBloqueado(true);
        Assert.assertTrue(dtoUsuarioInicioSesion.isBloqueado());
    }
}
