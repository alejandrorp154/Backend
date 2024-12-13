package com.javaee.pryectoBack.service;

import com.javaee.pryectoBack.datatypes.*;
import com.javaee.pryectoBack.model.UsuarioContacto;
import com.javaee.pryectoBack.model.estadosContactos;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.javaee.pryectoBack.data.ControladorUsuarioDA;
import com.javaee.pryectoBack.data.ControladorUsuarioDALocal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;


@RunWith(MockitoJUnitRunner.class)
public class ControladorUsuarioTest {


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private ControladorUsuarioDALocal controladorUsuarioDAMock = new ControladorUsuarioDA();

    @InjectMocks
    private ControladorUsuarioLocal controladorUsuario = new ControladorUsuario();

    @Test
    public void editarPerfil() {
        DTOUsuarioPerfil dtoUserPerfil = new DTOUsuarioPerfil();
        dtoUserPerfil.setIdPersona("1");
        dtoUserPerfil.setEmail("probanto1@gmail.com");
        dtoUserPerfil.setNombre("German");
        dtoUserPerfil.setApellido("Gutierrez");
        dtoUserPerfil.setNickname("elguti");
        dtoUserPerfil.setImagenPerfil("imagenPerfil9238453");
        dtoUserPerfil.setNombreImagen("imagen");
        dtoUserPerfil.setPais("Uruguay");
        dtoUserPerfil.setExtensionImagen("jpg");
        dtoUserPerfil.setDireccion("en su casa");
        dtoUserPerfil.setCelular("099111111");

        DTOUsuario dtoUser = new DTOUsuario("1", "probanto1@gmail.com", "German", "Gutierrez", "elguti", "en su casa", "099111111", "Uruguay","imagen", "imagenPerfil", "jpg");

        Mockito.when(controladorUsuarioDAMock.editarPerfil(Mockito.any(DTOUsuarioPerfil.class))).thenReturn(dtoUser);
        DTOUsuario res = controladorUsuario.editarPerfil(dtoUserPerfil);
        Assert.assertNotNull(res);
    }

    @Test
    public void registrarUsuario() {

        DTOUsuario dtoUser = new DTOUsuario("1", "probanto1@gmail.com", "German", "Gutierrez", "elguti", "en su casa", "099111111", "Uruguay","imagen", "imagenPerfil", "jpg");
        Mockito.when(controladorUsuarioDAMock.registrarUsuario(Mockito.any(DTOUsuario.class))).thenReturn(dtoUser);
        DTOUsuario dtoUsuarioControler = controladorUsuario.registrarUsuario(dtoUser);
        Assert.assertNotNull(dtoUsuarioControler);
    }

    @Test
    public void subirFoto() {
        DTOMultimedia dtoMultimedia = new DTOMultimedia(1,"www.taringa.com/image/algoParaMostrar.jpg","imagen","jpg","1");
        Mockito.when(controladorUsuarioDAMock.subirFoto(Mockito.any(DTOMultimedia.class))).thenReturn(true);
        boolean res = controladorUsuario.subirFoto(dtoMultimedia);
        Assert.assertTrue(res);
    }

    @Test
    public void agregarContacto() {
        Mockito.when(controladorUsuarioDAMock.agregarContacto(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
        boolean res = controladorUsuario.agregarContacto("1", "2");
        Assert.assertTrue(res);
    }

    @Test
    public void bajaContacto() {
        Mockito.when(controladorUsuarioDAMock.bajaContacto(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
        boolean res = controladorUsuario.bajaContacto("1", "2");
        Assert.assertTrue(res);
    }

    @Test
    public void eliminarCuenta() {
        Mockito.when(controladorUsuarioDAMock.eliminarCuenta(Mockito.anyString())).thenReturn(true);
        boolean res = controladorUsuario.eliminarCuenta("1");
        Assert.assertTrue(res);
    }

    @Test
    public void bajaUsuarioAdmin() {
        Mockito.when(controladorUsuarioDAMock.bajaUsuarioAdmin(Mockito.anyString())).thenReturn(true);
        boolean res = controladorUsuario.bajaUsuarioAdmin("1");
        Assert.assertTrue(res);
    }

    @Test
    public void modificarUsuarioAdmin() {
        DTOAdministrador dtoAdministrador = new DTOAdministrador("20","admin20@gmail.com","Peter","Pan");
        Mockito.when(controladorUsuarioDAMock.modificarUsuarioAdmin(Mockito.any(DTOAdministrador.class))).thenReturn(dtoAdministrador);
        DTOAdministrador res = controladorUsuario.modificarUsuarioAdmin(dtoAdministrador);
        Assert.assertNotNull(res);
    }

    @Test
    public void bloquearUsuario() {
        Mockito.when(controladorUsuarioDAMock.bloquearUsuario(Mockito.anyString())).thenReturn(true);
        boolean res = controladorUsuario.bloquearUsuario("1");
        Assert.assertTrue(res);
    }

    @Test
    public void desbloquearUsuario() {
        Mockito.when(controladorUsuarioDAMock.desbloquearUsuario(Mockito.anyString())).thenReturn(true);
        boolean res = controladorUsuario.desbloquearUsuario("1");
        Assert.assertTrue(res);
    }

    @Test
    public void datosUsuarioInicioSesion() {
//        DTOUsuarioInicioSesion dtoUsuarioInicioSesion = new DTOUsuarioInicioSesion("1","usuarioInicioSession@gmail.com","Franco","Amaral","francoAmaral", "una imagen para mostrar en el front","jpg","imagen",false);
        DTOUsuarioInicioSesion dtoUsuarioInicioSesion = new DTOUsuarioInicioSesion();
        Mockito.when(controladorUsuarioDAMock.datosUsuarioInicioSesion(Mockito.anyString())).thenReturn(dtoUsuarioInicioSesion);
        DTOUsuarioInicioSesion res = controladorUsuario.datosUsuarioInicioSesion("1");
        Assert.assertNotNull(res);
    }

    @Test
    public void respuestaContacto() {

        UsuarioContacto userContact = new UsuarioContacto();
        userContact.setContactoIdPersona("1");
        userContact.setContactoIdPersona("2");
        Date date = new Date(2021,05,21);
        userContact.setFechaContactos(date);
        userContact.setEstadoContactos(estadosContactos.pendiente);

        DTOUsuarioContacto dtoUsuarioContacto = new DTOUsuarioContacto(userContact);
        DTOUsuarioContacto result = new DTOUsuarioContacto();
        Mockito.when(controladorUsuarioDAMock.respuestaContacto(Mockito.any(DTOUsuarioContacto.class))).thenReturn(result);
        DTOUsuarioContacto res = controladorUsuario.respuestaContacto(dtoUsuarioContacto);
        Assert.assertNotNull(res);
    }

    @Test
    public void altaUsuarioAdmin() {
        DTOAdministrador dtoAdministrador = new DTOAdministrador("20","admin20@gmail.com","Luis","Alvarez");
        DTOAdministrador result = new DTOAdministrador();
        Mockito.when(controladorUsuarioDAMock.altaUsuarioAdmin(Mockito.any(DTOAdministrador.class))).thenReturn(result);
        DTOAdministrador res = controladorUsuario.altaUsuarioAdmin(dtoAdministrador);
        Assert.assertNotNull(res);
    }

    @Test
    public void getPerfil(){
        DTOUsuarioPerfil dtoUsuarioPerfil = new DTOUsuarioPerfil();
        dtoUsuarioPerfil.setIdPersona("1");
        dtoUsuarioPerfil.setEmail("probando@gmail.com");
        dtoUsuarioPerfil.setNombre("Andrés");
        dtoUsuarioPerfil.setApellido("Gutierrez");
        dtoUsuarioPerfil.setNickname("andresG");
        dtoUsuarioPerfil.setImagenPerfil("imagenItSelf9281732123");
        dtoUsuarioPerfil.setNombreImagen("image");
        dtoUsuarioPerfil.setPais("Uruguay");
        dtoUsuarioPerfil.setExtensionImagen("jpg");
        dtoUsuarioPerfil.setDireccion("en el estadio centenario");
        dtoUsuarioPerfil.setCelular("099111111");

        Mockito.when(controladorUsuarioDAMock.getPerfil(Mockito.anyString())).thenReturn(dtoUsuarioPerfil);
        DTOUsuarioPerfil res = controladorUsuario.getPerfil("1");
        Assert.assertNotNull(res);
    }
}
