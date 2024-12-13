package com.javaee.pryectoBack.datatypes;

import com.javaee.pryectoBack.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class DTOPerfilUsuarioTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        DTOUsuario usuario = new DTOUsuario("1", "probanto1@gmail.com", "German", "Gutierrez", "elguti", "en su casa", "099111111", "Uruguay","imagen", "imagenPerfil", "jpg");

        List<DTOInteres> intereses = new ArrayList<>();
        DTOInteres dtoInteres = new DTOInteres();
        dtoInteres.setIdInteres(1);
        dtoInteres.setInteres("Asado");
        intereses.add(dtoInteres);

        List<DTOMultimedia> galerias = new ArrayList<>();
        DTOMultimedia dtomulti = new DTOMultimedia(0,"fotos","fotos nomb","jpg","3");
        galerias.add(dtomulti);

        List<DTOPublicacion> publicaciones = new ArrayList<>();
        DTOTipo dtoTipo = new DTOTipo(1, tipos.foto);
        Date date = new Date(2021, Calendar.JUNE,21);
        List<DTOComentario> comentarios = new ArrayList<>();
        Date date1 = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(1,"Evento de prueba",date1, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");
        DTOPublicacion dtoPublicacion = new DTOPublicacion(1,"contenido",date,dtoTipo,"1","jpg","Nombre Imagen",comentarios,dtoEvento,dtoPerfilUsuario);
        publicaciones.add(dtoPublicacion);

        dtoPerfilUsuario.setUsuario(usuario);
        dtoPerfilUsuario.setIntereses(intereses);
        dtoPerfilUsuario.setGalerias(galerias);
        dtoPerfilUsuario.setPublicaciones(publicaciones);

    }

    private DTOPerfilUsuario dtoPerfilUsuario = new DTOPerfilUsuario();

    @Test
    public void dtoPerfilUsuarioDefault(){
        DTOPerfilUsuario dtoPerUs = new DTOPerfilUsuario();
        Assert.assertNotNull(dtoPerUs);
    }

    @Test
    public void dtoPerfilUsuarioParams(){

        DTOUsuario usuario = new DTOUsuario("1", "probanto1@gmail.com", "German", "Gutierrez", "elguti", "en su casa", "099111111", "Uruguay","imagen", "imagenPerfil", "jpg");
        List<DTOInteres> intereses = new ArrayList<>();
        DTOInteres dtoInteres = new DTOInteres();
        dtoInteres.setIdInteres(1);
        dtoInteres.setInteres("Asado");
        intereses.add(dtoInteres);
        List<DTOMultimedia> galerias = new ArrayList<>();
        DTOMultimedia dtomulti = new DTOMultimedia(0,"fotos","fotos nomb","jpg","3");
        galerias.add(dtomulti);
        List<DTOPublicacion> publicaciones = new ArrayList<>();
        DTOTipo dtoTipo = new DTOTipo(1, tipos.foto);
        Date date = new Date(2021, Calendar.JUNE,21);
        List<DTOComentario> comentarios = new ArrayList<>();
        Date date1 = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(1,"Evento de prueba",date1, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");
        DTOPublicacion dtoPublicacion = new DTOPublicacion(1,"contenido",date,dtoTipo,"1","jpg","Nombre Imagen",comentarios,dtoEvento,dtoPerfilUsuario);
        publicaciones.add(dtoPublicacion);

        DTOPerfilUsuario dtoPerUs = new DTOPerfilUsuario(usuario,intereses,galerias,publicaciones);
        Assert.assertNotNull(dtoPerUs);
    }

    @Test
    public void dtoPerfilUsuarioObjPerfil(){
        DTOUsuario dtoUsuario = new DTOUsuario("1", "probanto1@gmail.com", "German", "Gutierrez", "elguti", "en su casa", "099111111", "Uruguay","imagen", "imagenPerfil", "jpg");
        Usuario user = new Usuario(dtoUsuario);
        PerfilUsuario perUs = new PerfilUsuario();
        perUs.setExtension("jpg");
        perUs.setImagenPerfil("");
        perUs.setNombreImagen("");
        perUs.setUsuario(user);
        user.setPerfil(perUs);
        perUs = new PerfilUsuario(user,dtoUsuario);
        DTOPerfilUsuario dtoPerfUs = new DTOPerfilUsuario(perUs);

        Assert.assertNotNull(dtoPerfUs);
    }

    @Test
    public void getUsuario() {
        DTOUsuario dtoUsuario = new DTOUsuario("1", "probanto1@gmail.com", "German", "Gutierrez", "elguti", "en su casa", "099111111", "Uruguay","imagen", "imagenPerfil", "jpg");
        Usuario user = new Usuario(dtoUsuario);
        PerfilUsuario perUs = new PerfilUsuario();
        perUs.setExtension("jpg");
        perUs.setImagenPerfil("");
        perUs.setNombreImagen("");
        perUs.setUsuario(user);
        user.setPerfil(perUs);
        DTOUsuario dtoUs = new DTOUsuario(user);
        DTOUsuario dtoUser = dtoPerfilUsuario.getUsuario();
        Assert.assertNotNull(dtoUser);
    }

    @Test
    public void setUsuario() {
        DTOUsuario dtoUsuario = new DTOUsuario("2", "probanto2@gmail.com", "German", "Gutierrez", "elguti", "en su casa", "099111111", "Uruguay","imagen", "imagenPerfil", "jpg");
        dtoPerfilUsuario.setUsuario(dtoUsuario);

        Assert.assertEquals("2",dtoPerfilUsuario.getUsuario().getIdPersona());
        Assert.assertEquals("probanto2@gmail.com",dtoPerfilUsuario.getUsuario().getEmail());
    }

    @Test
    public void getIntereses() {
        List<DTOInteres> inter = dtoPerfilUsuario.getIntereses();
        Assert.assertNotNull(inter);
    }

    @Test
    public void setIntereses() {
        dtoPerfilUsuario.setIntereses(null);
        Assert.assertNull(dtoPerfilUsuario.getIntereses());

        List<DTOInteres> inter = new ArrayList<>();
        dtoPerfilUsuario.setIntereses(inter);
        Assert.assertNotNull(dtoPerfilUsuario.getIntereses());
    }

    @Test
    public void getGalerias() {
        List<DTOMultimedia> multi = dtoPerfilUsuario.getGalerias();
        Assert.assertNotNull(multi);
    }

    @Test
    public void setGalerias() {
        dtoPerfilUsuario.setGalerias(null);
        Assert.assertNull(dtoPerfilUsuario.getGalerias());

        List<DTOMultimedia> multi = new ArrayList<>();
        dtoPerfilUsuario.setGalerias(multi);
        Assert.assertNotNull(dtoPerfilUsuario.getGalerias());
    }

    @Test
    public void getPublicaciones() {
        List<DTOPublicacion> pubs = dtoPerfilUsuario.getPublicaciones();
        Assert.assertNotNull(pubs);
    }

    @Test
    public void setPublicaciones() {
        dtoPerfilUsuario.setPublicaciones(null);
        Assert.assertNull(dtoPerfilUsuario.getPublicaciones());

        List<DTOPublicacion> pubs = new ArrayList<>();
        dtoPerfilUsuario.setPublicaciones(pubs);
        Assert.assertNotNull(dtoPerfilUsuario.getPublicaciones());
    }
}
