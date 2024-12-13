package com.javaee.pryectoBack.datatypes;

import com.javaee.pryectoBack.model.PerfilUsuario;
import com.javaee.pryectoBack.model.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DTOUsuarioPerfilTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        dtoUsuarioPerfil.setIdPersona("1");
        dtoUsuarioPerfil.setEmail("probando@mail.com");
        dtoUsuarioPerfil.setNombre("Juan");
        dtoUsuarioPerfil.setApellido("Alvez");
        dtoUsuarioPerfil.setNickname("juanA");
        dtoUsuarioPerfil.setImagenPerfil("Imagen perfil 287482749");
        dtoUsuarioPerfil.setNombreImagen("Nombre imagen");
        dtoUsuarioPerfil.setPais("Uruguay");
        dtoUsuarioPerfil.setExtensionImagen("jpg");
        dtoUsuarioPerfil.setDireccion("En su casa");
        dtoUsuarioPerfil.setCelular("099111123");
    }

    private DTOUsuarioPerfil dtoUsuarioPerfil = new DTOUsuarioPerfil();

    @Test
    public void dtoUsuarioPerfilDefault(){
        DTOUsuarioPerfil dtoUsPer = new DTOUsuarioPerfil();
        Assert.assertNotNull(dtoUsPer);
    }

    @Test
    public void dtoUsuarioPerfilObj(){
        DTOUsuario dtoUser = new DTOUsuario("1", "probanto1@gmail.com", "Peter", "Montes", "monters", "en su casa1", "099111111", "Uruguay","imagen1", "imagenPerfil1", "jpg");
        Usuario user = new Usuario(dtoUser);
        PerfilUsuario perfilUsuario = new PerfilUsuario();
        perfilUsuario.setExtension("jpg");
        perfilUsuario.setImagenPerfil("Imagen de Perfil 827384y234");
        perfilUsuario.setNombreImagen("Nombre Imagen");
        user.setPerfil(perfilUsuario);

        DTOUsuarioPerfil dtoPerUs = new DTOUsuarioPerfil(user);
        Assert.assertNotNull(dtoPerUs);
    }

    @Test
    public void getIdPersona() {
        String idPer = dtoUsuarioPerfil.getIdPersona();
        Assert.assertEquals("1",idPer);
    }

    @Test
    public void setIdPersona() {
        dtoUsuarioPerfil.setIdPersona("2");
        Assert.assertEquals("2",dtoUsuarioPerfil.getIdPersona());
    }

    @Test
    public void getEmail() {
        String email = dtoUsuarioPerfil.getEmail();
        Assert.assertEquals("probando@mail.com",email);
    }

    @Test
    public void setEmail() {
        dtoUsuarioPerfil.setEmail("test@mail.com");
        Assert.assertEquals("test@mail.com",dtoUsuarioPerfil.getEmail());
    }

    @Test
    public void getNombre() {
        String nomb = dtoUsuarioPerfil.getNombre();
        Assert.assertEquals("Juan",nomb);
    }

    @Test
    public void setNombre() {
        dtoUsuarioPerfil.setNombre("Pedro");
        Assert.assertEquals("Pedro",dtoUsuarioPerfil.getNombre());
    }

    @Test
    public void getApellido() {
        String apelli = dtoUsuarioPerfil.getApellido();
        Assert.assertEquals("Alvez",apelli);
    }

    @Test
    public void setApellido() {
        dtoUsuarioPerfil.setApellido("Francces");
        Assert.assertEquals("Francces",dtoUsuarioPerfil.getApellido());
    }

    @Test
    public void getNickname() {
        String nick = dtoUsuarioPerfil.getNickname();
        Assert.assertEquals("juanA",nick);
    }

    @Test
    public void setNickname() {
        dtoUsuarioPerfil.setNickname("juanDeArco");
        Assert.assertEquals("juanDeArco",dtoUsuarioPerfil.getNickname());
    }

    @Test
    public void getImagenPerfil() {
        String imaPer = dtoUsuarioPerfil.getImagenPerfil();
        Assert.assertEquals("Imagen perfil 287482749",imaPer);
    }

    @Test
    public void setImagenPerfil() {
        dtoUsuarioPerfil.setImagenPerfil("Cambio imagen 838394");
        Assert.assertEquals("Cambio imagen 838394",dtoUsuarioPerfil.getImagenPerfil());
    }

    @Test
    public void getNombreImagen() {
        String nomImag = dtoUsuarioPerfil.getNombreImagen();
        Assert.assertEquals("Nombre imagen", nomImag);
    }

    @Test
    public void setNombreImagen() {
        dtoUsuarioPerfil.setNombreImagen("Image name");
        Assert.assertEquals("Image name",dtoUsuarioPerfil.getNombreImagen());
    }

    @Test
    public void getPais() {
        String pais = dtoUsuarioPerfil.getPais();
        Assert.assertEquals("Uruguay",pais);
    }

    @Test
    public void setPais() {
        dtoUsuarioPerfil.setPais("Bolivia");
        Assert.assertEquals("Bolivia",dtoUsuarioPerfil.getPais());
    }

    @Test
    public void getExtensionImagen() {
        String ext = dtoUsuarioPerfil.getExtensionImagen();
        Assert.assertEquals("jpg",ext);
    }

    @Test
    public void setExtensionImagen() {
        dtoUsuarioPerfil.setExtensionImagen("gif");
        Assert.assertEquals("gif",dtoUsuarioPerfil.getExtensionImagen());
    }

    @Test
    public void getDireccion() {
        String direcc = dtoUsuarioPerfil.getDireccion();
        Assert.assertEquals("En su casa",direcc);
    }

    @Test
    public void setDireccion() {
        dtoUsuarioPerfil.setDireccion("En estadio centenario");
        Assert.assertEquals("En estadio centenario",dtoUsuarioPerfil.getDireccion());
    }

    @Test
    public void getCelular() {
        String cel = dtoUsuarioPerfil.getCelular();
        Assert.assertEquals("099111123",cel);
    }

    @Test
    public void setCelular() {
        dtoUsuarioPerfil.setCelular("093123987");
        Assert.assertEquals("093123987",dtoUsuarioPerfil.getCelular());
    }
}
