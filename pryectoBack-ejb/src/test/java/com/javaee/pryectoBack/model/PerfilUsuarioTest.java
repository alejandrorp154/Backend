package com.javaee.pryectoBack.model;

import com.javaee.pryectoBack.datatypes.*;
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
public class PerfilUsuarioTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        perfilUsuario.setIdPersona("1");
        perfilUsuario.setExtension("jpg");
        perfilUsuario.setImagenPerfil("Image en si928347892423");
        perfilUsuario.setNombreImagen("Image");

        DTOUsuario dtoUser = new DTOUsuario("3", "probanto3@gmail.com", "Peter", "Montes", "monters", "en su casa3", "099333333", "Brasil","imagen3", "imagenPerfil3", "jpg");
        Usuario us = new Usuario(dtoUser);
        perfilUsuario.setUsuario(us);

        List<Publicacion> publicaciones = new ArrayList<>();
        perfilUsuario.setPublicaciones(publicaciones);

        DTOMultimedia dtomulti = new DTOMultimedia(0,"fotos","fotos nomb","jpg","3");
        PerfilUsuario perfilUser = new PerfilUsuario();
        perfilUser.setIdPersona("3");
        Multimedia multi = new Multimedia(dtomulti,perfilUser);
        List<Multimedia> galerias = new ArrayList<>();
        galerias.add(multi);
        perfilUsuario.setGalerias(galerias);

        DTOInteres dtoInteres = new DTOInteres();
        dtoInteres.setIdInteres(1);
        dtoInteres.setInteres("Milanesa");
        List<DTOPerfilUsuario> perfilUsuarios = new ArrayList<>();
        dtoInteres.setPerfiles(perfilUsuarios);
        Interes inter = new Interes(dtoInteres);
        List<Interes> intereses = new ArrayList<>();
        intereses.add(inter);
        perfilUsuario.setIntereses(intereses);

    }

    private PerfilUsuario perfilUsuario = new PerfilUsuario();

    @Test
    public void perfilUsuarioDefault(){
        PerfilUsuario perfilUsuario =new PerfilUsuario();
        Assert.assertNotNull(perfilUsuario);
    }

    @Test
    public void perfilUsuarioParams(){
        DTOUsuario dtoUser = new DTOUsuario("3", "probanto3@gmail.com", "Peter", "Montes", "monters", "en su casa3", "099333333", "Brasil","imagen3", "imagenPerfil3", "jpg");
        Usuario user = new Usuario(dtoUser);
        PerfilUsuario perfilUsuario = new PerfilUsuario(user,dtoUser);
        Assert.assertNotNull(perfilUsuario);
    }

    @Test
    public void perfilUsuarioDTO(){
        DTOUsuario dtoUser = new DTOUsuario("3", "probanto3@gmail.com", "Peter", "Montes", "monters", "en su casa3", "099333333", "Brasil","imagen3", "imagenPerfil3", "jpg");
        DTOPerfilUsuario dtoPerfilUsuario = new DTOPerfilUsuario();
        dtoPerfilUsuario.setUsuario(dtoUser);

        DTOMultimedia dtomulti = new DTOMultimedia(1,"fotos","fotos nomb","jpg","3");
        DTOMultimedia dtomulti2 = new DTOMultimedia(2,"fotos2","fotos nomb2","jpg","3");
        List<DTOMultimedia> galerias = new ArrayList<>();
        galerias.add(dtomulti);
        galerias.add(dtomulti2);
        dtoPerfilUsuario.setGalerias(galerias);

        List<DTOPublicacion> publicaciones = new ArrayList<>();
        dtoPerfilUsuario.setPublicaciones(publicaciones);

        PerfilUsuario perfilUsuario = new PerfilUsuario(dtoPerfilUsuario);
        Assert.assertNotNull(perfilUsuario);
    }

    @Test
    public void getUsuario() {
        Usuario user = perfilUsuario.getUsuario();
        Assert.assertNotNull(user);
        Assert.assertEquals("3",user.getIdPersona());
    }

    @Test
    public void setUsuario() {
        DTOUsuario dtoUser = new DTOUsuario("1", "probanto1@gmail.com", "Peter1", "Montes1", "monters1", "en su casa1", "099111111", "Brasil1","imagen1", "imagenPerfil1", "jpg");
        Usuario user = new Usuario(dtoUser);
        perfilUsuario.setUsuario(user);
        Assert.assertNotNull(user);
        Assert.assertEquals("1",user.getIdPersona());
    }

    @Test
    public void getIntereses() {
        List<Interes> intereses = perfilUsuario.getIntereses();
        Assert.assertNotNull(intereses);
        Assert.assertEquals(1,intereses.size());
        Assert.assertEquals("Milanesa",intereses.get(0).getInteres());
    }

    @Test
    public void setIntereses() {
        DTOInteres dtoInteres = new DTOInteres();
        dtoInteres.setIdInteres(2);
        dtoInteres.setInteres("Asado");
        List<DTOPerfilUsuario> perfilUsuarios = new ArrayList<>();
        dtoInteres.setPerfiles(perfilUsuarios);
        List<Interes> intereses = new ArrayList<>();
        Interes inter = new Interes(dtoInteres);
        intereses.add(inter);
        perfilUsuario.setIntereses(intereses);
        Assert.assertEquals("Asado",perfilUsuario.getIntereses().get(0).getInteres());
        Assert.assertEquals(2,perfilUsuario.getIntereses().get(0).getIdInteres());
    }

    @Test
    public void getGalerias() {
        List<Multimedia> galerias = perfilUsuario.getGalerias();
        Assert.assertNotNull(galerias);
        Assert.assertEquals(0,perfilUsuario.getGalerias().get(0).getIdMultimedia());
        Assert.assertEquals("fotos",perfilUsuario.getGalerias().get(0).getContenido());
    }

    @Test
    public void setGalerias() {
        List<Multimedia> galerias = new ArrayList<>();
        DTOMultimedia dtomulti = new DTOMultimedia(0,"fotones","Photo name","gif","3");
        PerfilUsuario perfilUser = new PerfilUsuario();
        perfilUser.setIdPersona("3");
        Multimedia multi = new Multimedia(dtomulti,perfilUser);
        galerias.add(multi);

        perfilUsuario.setGalerias(galerias);

        Assert.assertEquals("fotones",perfilUsuario.getGalerias().get(0).getContenido());
        Assert.assertEquals("Photo name",perfilUsuario.getGalerias().get(0).getNombre());
        Assert.assertEquals("gif",perfilUsuario.getGalerias().get(0).getExtension());
    }

    @Test
    public void getPublicaciones() {
        List<Publicacion> publicaciones = perfilUsuario.getPublicaciones();
        Assert.assertNotNull(publicaciones);
        Assert.assertEquals(0,perfilUsuario.getPublicaciones().size());
    }

    @Test
    public void setPublicaciones() {
        List<Publicacion> publicaciones = new ArrayList<>();
        Date date = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOTipo dtoTipo = new DTOTipo(1, tipos.texto);
        List<DTOComentario> dtocoment = new ArrayList<>();
        DTOPerfilUsuario dtoPerfilU = new DTOPerfilUsuario();
        DTOUsuario dtoUsuario = new DTOUsuario();
        dtoUsuario.setIdPersona("5");

        dtoPerfilU.setUsuario(dtoUsuario);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento event = new DTOEvento(1,"Esto es un evento",date,date2, estados.enCurso,1,"1","Gabriel",dtoub,"image","esta en la imagen en si","jpg");
        DTOPublicacion dtoPub1 = new DTOPublicacion(1,"HAciendo pruebas",date,dtoTipo,"1","text","pruebas",dtocoment,event,dtoPerfilU);
        Publicacion pub = new Publicacion(dtoPub1);

        publicaciones.add(pub);
        perfilUsuario.setPublicaciones(publicaciones);

        Assert.assertEquals(1,perfilUsuario.getPublicaciones().get(0).getIdPublicacion());
        Assert.assertEquals("HAciendo pruebas",perfilUsuario.getPublicaciones().get(0).getContenido());
        Assert.assertEquals("pruebas",perfilUsuario.getPublicaciones().get(0).getNombre());
    }

    @Test
    public void getIdPersona() {
        String idPersona = perfilUsuario.getIdPersona();
        Assert.assertEquals("1",idPersona);
    }

    @Test
    public void setIdPersona() {
        perfilUsuario.setIdPersona("2");
        Assert.assertEquals("2",perfilUsuario.getIdPersona());
    }

    @Test
    public void getImagenPerfil() {
        String imagenPerfil = perfilUsuario.getImagenPerfil();
        Assert.assertEquals("Image en si928347892423",imagenPerfil);
    }

    @Test
    public void setImagenPerfil() {
        perfilUsuario.setImagenPerfil("imagen123456");
        Assert.assertEquals("imagen123456",perfilUsuario.getImagenPerfil());
    }

    @Test
    public void getNombreImagen() {
        String nombreImagen = perfilUsuario.getNombreImagen();
        Assert.assertEquals("Image",nombreImagen);
    }

    @Test
    public void setNombreImagen() {
        perfilUsuario.setNombreImagen("Imagen nuevo nombre");
        Assert.assertEquals("Imagen nuevo nombre",perfilUsuario.getNombreImagen());
    }

    @Test
    public void getExtension() {
        String exten = perfilUsuario.getExtension();
        Assert.assertEquals("jpg",exten);
    }

    @Test
    public void setExtension() {
        perfilUsuario.setExtension("gif");
        Assert.assertEquals("gif",perfilUsuario.getExtension());
    }
}
