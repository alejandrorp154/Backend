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
public class DTOPublicacionPerfilUsuarioTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        dtoPublicacionPerfilUsuario.setIdPublicacion(1);
        dtoPublicacionPerfilUsuario.setContenido("COntenido pub per usu");
        Date date = new Date(2021, Calendar.JUNE,21);
        dtoPublicacionPerfilUsuario.setFecha(date);
        DTOTipo dtoTipo = new DTOTipo(1, tipos.texto);
        dtoPublicacionPerfilUsuario.setTipo(dtoTipo);
        dtoPublicacionPerfilUsuario.setExtension("jpg");
        dtoPublicacionPerfilUsuario.setNombre("Pub per usu name");
        List<DTOComentario> comentarioReacciones = new ArrayList<>();
        dtoPublicacionPerfilUsuario.setComentarioReacciones(comentarioReacciones);
        Date date1 = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(1,"Evento de prueba",date1, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");
        dtoPublicacionPerfilUsuario.setEvento(dtoEvento);
        DTOPerfilUsuario dtoPerfilUsuario = new DTOPerfilUsuario();
        DTOUsuario dtoUser = new DTOUsuario("1", "probanto@gmail.com", "Peter", "Montes", "monters", "en su casa3", "099333333", "Brasil","imagen3", "imagenPerfil3", "jpg");
        dtoPerfilUsuario.setUsuario(dtoUser);
        dtoPublicacionPerfilUsuario.setPerfil(dtoPerfilUsuario);
        dtoPublicacionPerfilUsuario.setCantidadLikes(344);
        dtoPublicacionPerfilUsuario.setCantidadDislikes(13);
        dtoPublicacionPerfilUsuario.setCantidadComentarios(0);
        dtoPublicacionPerfilUsuario.setIdPersona("1");
        dtoPublicacionPerfilUsuario.setEmail("probanto@gmail.com");
        dtoPublicacionPerfilUsuario.setNickname("monters");
        dtoPublicacionPerfilUsuario.setImagenPerfil("");
        dtoPublicacionPerfilUsuario.setExtensionImagenPerfil("");
        dtoPublicacionPerfilUsuario.setNombreImagenPerfil("");
    }

    private DTOPublicacionPerfilUsuario dtoPublicacionPerfilUsuario = new DTOPublicacionPerfilUsuario();

    @Test
    public void dtoPublicacionUsuarioDefault(){
        DTOPublicacionPerfilUsuario dtoPubPerUsu = new DTOPublicacionPerfilUsuario();
        Assert.assertNotNull(dtoPubPerUsu);
    }

    @Test
    public void dtoPublicacionUsuarioObj(){
        DTOUsuario dtoUser = new DTOUsuario("1", "probanto@gmail.com", "Peter", "Montes", "monters", "en su casa3", "099333333", "Brasil","imagen3", "imagenPerfil3", "jpg");
        Usuario user = new Usuario(dtoUser);
        Date date = new Date(2021, Calendar.JUNE,21);
        DTOTipo dtoTipo = new DTOTipo(1,tipos.foto);
        List<DTOComentario> comentarios = new ArrayList<>();
        Date date1 = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(1,"Evento de prueba",date1, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");
        PerfilUsuario perfilUsuario = new PerfilUsuario();
        user.setPerfil(perfilUsuario);
        user.getPerfil().setExtension("jpg");
        user.getPerfil().setImagenPerfil("");
        user.getPerfil().setNombreImagen("");

        perfilUsuario.setUsuario(user);

        DTOPerfilUsuario dtoPerfilUsuario = new DTOPerfilUsuario(perfilUsuario);
        DTOPublicacion dtoPublicacion = new DTOPublicacion(1,"contenido",date,dtoTipo,"1","jpg","Nombre Imagen",comentarios,dtoEvento,dtoPerfilUsuario);
        Publicacion publicacion = new Publicacion(dtoPublicacion);
        DTOPublicacionPerfilUsuario dtoPubPerUsu = new DTOPublicacionPerfilUsuario( publicacion,user);
        Assert.assertNotNull(dtoPubPerUsu);
    }

    @Test
    public void getIdPublicacion() {
        int idPub = dtoPublicacionPerfilUsuario.getIdPublicacion();
        Assert.assertEquals(1,idPub);
    }

    @Test
    public void setIdPublicacion() {
        dtoPublicacionPerfilUsuario.setIdPublicacion(2);
        Assert.assertEquals(2, dtoPublicacionPerfilUsuario.getIdPublicacion());
    }

    @Test
    public void getContenido() {
        String conte = dtoPublicacionPerfilUsuario.getContenido();
        Assert.assertEquals("COntenido pub per usu",conte);
    }

    @Test
    public void setContenido() {
        dtoPublicacionPerfilUsuario.setContenido("Conte PuPeUs");
        Assert.assertEquals("Conte PuPeUs",dtoPublicacionPerfilUsuario.getContenido());
    }

    @Test
    public void getFecha() {
        Date date = dtoPublicacionPerfilUsuario.getFecha();
        Assert.assertEquals(new Date(2021, Calendar.JUNE,21),date);
    }

    @Test
    public void setFecha() {
        Date date = new Date(2021, Calendar.FEBRUARY,21);
        dtoPublicacionPerfilUsuario.setFecha(date);
        Assert.assertEquals( new Date(2021, Calendar.FEBRUARY,21),dtoPublicacionPerfilUsuario.getFecha());
    }

    @Test
    public void getTipo() {
        DTOTipo dtoTipo = dtoPublicacionPerfilUsuario.getTipo();
        Assert.assertEquals(1,dtoTipo.getIdPublicacion());
        Assert.assertEquals(tipos.texto,dtoTipo.getTipo());
    }

    @Test
    public void setTipo() {
        DTOTipo dtoTipo = new DTOTipo(2, tipos.mapa);
        dtoPublicacionPerfilUsuario.setTipo(dtoTipo);
        Assert.assertEquals(2,dtoPublicacionPerfilUsuario.getTipo().getIdPublicacion());
        Assert.assertEquals(tipos.mapa,dtoPublicacionPerfilUsuario.getTipo().getTipo());
    }

    @Test
    public void getExtension() {
        String ext = dtoPublicacionPerfilUsuario.getExtension();
        Assert.assertEquals("jpg",ext);
    }

    @Test
    public void setExtension() {
        dtoPublicacionPerfilUsuario.setExtension("gif");
        Assert.assertEquals("gif",dtoPublicacionPerfilUsuario.getExtension());
    }

    @Test
    public void getNombre() {
        String nomb = dtoPublicacionPerfilUsuario.getNombre();
        Assert.assertEquals("Pub per usu name",nomb);
    }

    @Test
    public void setNombre() {
        dtoPublicacionPerfilUsuario.setNombre("pub per usu name");
        Assert.assertEquals("pub per usu name",dtoPublicacionPerfilUsuario.getNombre());
    }

    @Test
    public void getComentarioReacciones() {
        List<DTOComentario> coments = dtoPublicacionPerfilUsuario.getComentarioReacciones();
        Assert.assertNotNull(coments);
    }

    @Test
    public void setComentarioReacciones() {
        dtoPublicacionPerfilUsuario.setComentarioReacciones(null);
        Assert.assertNull(dtoPublicacionPerfilUsuario.getComentarioReacciones());
        List<DTOComentario> coms = new ArrayList<>();
        dtoPublicacionPerfilUsuario.setComentarioReacciones(coms);
        Assert.assertNotNull(dtoPublicacionPerfilUsuario.getComentarioReacciones());
    }

    @Test
    public void getEvento() {
        DTOEvento dtoEven = dtoPublicacionPerfilUsuario.getEvento();
        Assert.assertNotNull(dtoEven);
    }

    @Test
    public void setEvento() {
        Date date1 = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(2,"Event test",date1, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");
        dtoPublicacionPerfilUsuario.setEvento(dtoEvento);

        Assert.assertNotNull(dtoPublicacionPerfilUsuario.getEvento());
        Assert.assertEquals(2,dtoPublicacionPerfilUsuario.getEvento().getIdEvento());
        Assert.assertEquals("Event test",dtoPublicacionPerfilUsuario.getEvento().getDescripcion());
    }

    @Test
    public void getPerfil() {
        DTOPerfilUsuario dtoPerUs = dtoPublicacionPerfilUsuario.getPerfil();
        Assert.assertNotNull(dtoPerUs);
    }

    @Test
    public void setPerfil() {
        dtoPublicacionPerfilUsuario.setPerfil(null);
        Assert.assertNull(dtoPublicacionPerfilUsuario.getPerfil());
        DTOPerfilUsuario dtoPerfilUsuario = new DTOPerfilUsuario();
        dtoPublicacionPerfilUsuario.setPerfil(dtoPerfilUsuario);
        Assert.assertNotNull(dtoPublicacionPerfilUsuario.getPerfil());
    }

    @Test
    public void getCantidadLikes() {
        Integer cantLike = dtoPublicacionPerfilUsuario.getCantidadLikes();
        Assert.assertEquals((Integer)344,cantLike);
    }

    @Test
    public void setCantidadLikes() {
        dtoPublicacionPerfilUsuario.setCantidadLikes(450);
        Assert.assertEquals((Integer)450,dtoPublicacionPerfilUsuario.getCantidadLikes());
    }

    @Test
    public void getCantidadDislikes() {
        Integer cantDislike = dtoPublicacionPerfilUsuario.getCantidadDislikes();
        Assert.assertEquals((Integer)13,cantDislike);
    }

    @Test
    public void setCantidadDislikes() {
        dtoPublicacionPerfilUsuario.setCantidadDislikes(15);
        Assert.assertEquals((Integer)15,dtoPublicacionPerfilUsuario.getCantidadDislikes());
    }

    @Test
    public void getCantidadComentarios() {
        Integer cantComs = dtoPublicacionPerfilUsuario.getCantidadComentarios();
        Assert.assertEquals((Integer)0,cantComs);
    }

    @Test
    public void setCantidadComentarios() {
        dtoPublicacionPerfilUsuario.setCantidadComentarios(5);
        Assert.assertEquals((Integer)5,dtoPublicacionPerfilUsuario.getCantidadComentarios());
    }

    @Test
    public void getIdPersona() {
        String idPerso = dtoPublicacionPerfilUsuario.getIdPersona();
        Assert.assertEquals("1",idPerso);
    }

    @Test
    public void setIdPersona() {
        dtoPublicacionPerfilUsuario.setIdPersona("2");
        Assert.assertEquals("2",dtoPublicacionPerfilUsuario.getIdPersona());
    }

    @Test
    public void getEmail() {
        String mail = dtoPublicacionPerfilUsuario.getEmail();
        Assert.assertEquals("probanto@gmail.com",mail);
    }

    @Test
    public void setEmail() {
        dtoPublicacionPerfilUsuario.setEmail("test@mail.com");
        Assert.assertEquals("test@mail.com",dtoPublicacionPerfilUsuario.getEmail());
    }

    @Test
    public void getNickname() {
        String nick = dtoPublicacionPerfilUsuario.getNickname();
        Assert.assertEquals("monters",nick);
    }

    @Test
    public void setNickname() {
        dtoPublicacionPerfilUsuario.setNickname("testMayor");
        Assert.assertEquals("testMayor",dtoPublicacionPerfilUsuario.getNickname());
    }

    @Test
    public void getImagenPerfil() {
        String imaPer = dtoPublicacionPerfilUsuario.getImagenPerfil();
        Assert.assertEquals("",imaPer);
    }

    @Test
    public void setImagenPerfil() {
        dtoPublicacionPerfilUsuario.setImagenPerfil("imagenPerfil");
        Assert.assertEquals("imagenPerfil",dtoPublicacionPerfilUsuario.getImagenPerfil());
    }

    @Test
    public void getExtensionImagenPerfil() {
        String ext = dtoPublicacionPerfilUsuario.getExtension();
        Assert.assertEquals("jpg",ext);
    }

    @Test
    public void setExtensionImagenPerfil() {
        dtoPublicacionPerfilUsuario.setExtensionImagenPerfil("PNG");
        Assert.assertEquals("PNG",dtoPublicacionPerfilUsuario.getExtensionImagenPerfil());
    }

    @Test
    public void getNombreImagenPerfil() {
        String nomImaP = dtoPublicacionPerfilUsuario.getNombreImagenPerfil();
        Assert.assertEquals("",nomImaP);
    }

    @Test
    public void setNombreImagenPerfil() {
        dtoPublicacionPerfilUsuario.setNombreImagenPerfil("Nombre imagen");
        Assert.assertEquals("Nombre imagen",dtoPublicacionPerfilUsuario.getNombreImagenPerfil());
    }
}
