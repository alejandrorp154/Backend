package com.javaee.pryectoBack.datatypes;

import com.javaee.pryectoBack.model.PerfilUsuario;
import com.javaee.pryectoBack.model.Usuario;
import com.javaee.pryectoBack.model.estadosContactos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DTOUsuarioEventoTest {

    @Before
    public void init() {
      MockitoAnnotations.initMocks(this);

      dtoUsuarioEvento.setIdPersona("1");
      dtoUsuarioEvento.setNombre("Juan");
      dtoUsuarioEvento.setApellido("Alvez");
      dtoUsuarioEvento.setNickname("juanA");
      dtoUsuarioEvento.setImagenPerfil("Imagen perfil 287482749");
      dtoUsuarioEvento.setNombreImagen("Nombre imagen");
      dtoUsuarioEvento.setExtensionImagen("jpg");
      dtoUsuarioEvento.setEstadoContactos(estadosContactos.aceptada);
      dtoUsuarioEvento.setOwner(true);

    }

    private DTOUsuarioEvento dtoUsuarioEvento = new DTOUsuarioEvento();

    @Test
    public void dtoUsuarioEventoDefault(){
        DTOUsuarioEvento dtoUsEv = new DTOUsuarioEvento();
        Assert.assertNotNull(dtoUsEv);
    }

    @Test
    public void dtoUsuarioEventoObj(){
        DTOUsuario dtoUser = new DTOUsuario("3", "probanto3@gmail.com", "Peter", "Montes", "monters", "en su casa3", "099333333", "Brasil","imagen3", "imagenPerfil3", "jpg");
        Usuario us = new Usuario(dtoUser);
        PerfilUsuario perUs = new PerfilUsuario();
        perUs.setImagenPerfil("Imagen perfil 287482749");
        perUs.setNombreImagen("Nombre imagen");
        perUs.setExtension("jpg");
        us.setPerfil(perUs);
        DTOUsuarioEvento dtoUsEv = new DTOUsuarioEvento(us, estadosContactos.aceptada);
        Assert.assertNotNull(dtoUsEv);
    }

    @Test
    public void getIdPersona() {
        String idPer = dtoUsuarioEvento.getIdPersona();
        Assert.assertEquals("1",idPer);
    }

    @Test
    public void setIdPersona() {
        dtoUsuarioEvento.setIdPersona("2");
        Assert.assertEquals("2",dtoUsuarioEvento.getIdPersona());
    }

    @Test
    public void getNombre() {
        String nomb = dtoUsuarioEvento.getNombre();
        Assert.assertEquals("Juan",nomb);
    }

    @Test
    public void setNombre() {
        dtoUsuarioEvento.setNombre("Pedro");
        Assert.assertEquals("Pedro",dtoUsuarioEvento.getNombre());
    }

    @Test
    public void getApellido() {
        String appe = dtoUsuarioEvento.getApellido();
        Assert.assertEquals("Alvez",appe);
    }

    @Test
    public void setApellido() {
        dtoUsuarioEvento.setApellido("Berrner");
        Assert.assertEquals("Berrner",dtoUsuarioEvento.getApellido());
    }

    @Test
    public void getNickname() {
        String nick = dtoUsuarioEvento.getNickname();
        Assert.assertEquals("juanA", nick);
    }

    @Test
    public void setNickname() {
        dtoUsuarioEvento.setNickname("pedroM");
        Assert.assertEquals("pedroM",dtoUsuarioEvento.getNickname());
    }

    @Test
    public void getImagenPerfil() {
        String ima = dtoUsuarioEvento.getImagenPerfil();
        Assert.assertEquals("Imagen perfil 287482749",ima);
    }

    @Test
    public void setImagenPerfil() {
        dtoUsuarioEvento.setImagenPerfil("Imagen");
        Assert.assertEquals("Imagen",dtoUsuarioEvento.getImagenPerfil());
    }

    @Test
    public void getNombreImagen() {
        String nomIma = dtoUsuarioEvento.getNombreImagen();
        Assert.assertEquals("Nombre imagen", nomIma);
    }

    @Test
    public void setNombreImagen() {
        dtoUsuarioEvento.setNombreImagen("Image name");
        Assert.assertEquals("Image name",dtoUsuarioEvento.getNombreImagen());
    }

    @Test
    public void getExtensionImagen() {
        String ext = dtoUsuarioEvento.getExtensionImagen();
        Assert.assertEquals("jpg", ext);
    }

    @Test
    public void setExtensionImagen() {
        dtoUsuarioEvento.setExtensionImagen("gif");
        Assert.assertEquals("gif",dtoUsuarioEvento.getExtensionImagen());
    }

    @Test
    public void getEstadoContactos() {
        estadosContactos status = dtoUsuarioEvento.getEstadoContactos();
        Assert.assertEquals(estadosContactos.aceptada,status);
    }

    @Test
    public void setEstadoContactos() {
        dtoUsuarioEvento.setEstadoContactos(estadosContactos.pendiente);
        Assert.assertEquals(estadosContactos.pendiente,dtoUsuarioEvento.getEstadoContactos());
    }

    @Test
    public void isOwner() {
        boolean own = dtoUsuarioEvento.isOwner();
        Assert.assertTrue(own);
    }

    @Test
    public void setOwner() {
        dtoUsuarioEvento.setOwner(false);
        Assert.assertFalse(dtoUsuarioEvento.isOwner());
    }
}
