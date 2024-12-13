package com.javaee.pryectoBack.model;

import com.javaee.pryectoBack.datatypes.DTOEvento;
import com.javaee.pryectoBack.datatypes.DTOUbicacion;
import com.javaee.pryectoBack.datatypes.DTOUsuario;
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
public class UsuarioTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        usuario.setIdPersona("1");
        usuario.setEmail("user@gmail.com");
        usuario.setNombre("Guzman");
        usuario.setApellido("Ramirez");
        usuario.setNickname("guzram");
        usuario.setDireccion("en su casa");
        usuario.setCelular("099123456");
        usuario.setPais("Uruguay");
        Medalla medalla = new Medalla();
        medalla.setIdMedalla(1);
        medalla.setCantidadPuntos(1500);
        medalla.setLogros("Vamos en camino");
        medalla.setRango(rangos.diamondWolf);
        usuario.setMedalla(medalla);
        usuario.setEstaBloqueado(false);
        List<Notificacion> notificaciones = new ArrayList<>();
        usuario.setNotificaciones(notificaciones);
        List<Ubicacion> ubicacions = new ArrayList<>();
        usuario.setUbicaciones(ubicacions);
        List<Evento> eventos = new ArrayList<>();
        usuario.setCreadorDeEventos(eventos);

        PerfilUsuario perfilUsuario = new PerfilUsuario();
        perfilUsuario.setExtension("jpg");
        perfilUsuario.setImagenPerfil("Imagen de Perfil 827384y234");
        perfilUsuario.setNombreImagen("Nombre Imagen");
        usuario.setPerfil(perfilUsuario);

    }

    private Usuario usuario = new Usuario();

    @Test
    public void usuarioDefault(){
        Usuario user = new Usuario();
        Assert.assertNotNull(user);
    }

    @Test
    public void usuarioDTO(){
        DTOUsuario dtoUsuario = new DTOUsuario("1","probando@mail.com","Luis","Marquez","luisM","en mi casa","099123123","Uruguay","Imagen de Perfil","Image","jpg");
        Usuario user = new Usuario(dtoUsuario);
        Assert.assertNotNull(user);
        Assert.assertEquals("1",user.getIdPersona());
        Assert.assertEquals("probando@mail.com",user.getEmail());
        Assert.assertEquals("Luis",user.getNombre());
        Assert.assertEquals("Marquez",user.getApellido());
        Assert.assertEquals("luisM",user.getNickname());
        Assert.assertEquals("099123123",user.getCelular());
        Assert.assertEquals("Uruguay",user.getPais());
    }

    @Test
    public void getNotificaciones() {
        List<Notificacion> notificacions = usuario.getNotificaciones();
        Assert.assertNotNull(notificacions);
    }

    @Test
    public void setNotificaciones() {
        Notificacion noti = new Notificacion();
        noti.setIdNotificacion(1);
        noti.setContenido("pruebas");
        List<Notificacion> notificaciones = new ArrayList<>();
        notificaciones.add(noti);
        usuario.setNotificaciones(notificaciones);

        Assert.assertNotNull(usuario.getNotificaciones());
        Assert.assertEquals(1,usuario.getNotificaciones().size());
        Assert.assertEquals("pruebas",usuario.getNotificaciones().get(0).getContenido());
        Assert.assertEquals(1,usuario.getNotificaciones().get(0).getIdNotificacion());
    }

    @Test
    public void getUbicaciones() {
        List<Ubicacion> ubicaciones = usuario.getUbicaciones();
        Assert.assertNotNull(ubicaciones);
        Assert.assertEquals(0,ubicaciones.size());
    }

    @Test
    public void setUbicaciones() {
        Date date = new Date(2021, Calendar.JUNE,29);
        DTOUbicacion dtoub = new DTOUbicacion(22,50000,60000,date,"Detalles de la ubicación del evento","Uruguay");

        Ubicacion ubi = new Ubicacion(dtoub);
        usuario.getUbicaciones().add(ubi);

        Assert.assertNotNull(usuario.getUbicaciones());
        Assert.assertEquals(50000,usuario.getUbicaciones().get(0).getLongitud(),(50000-ubi.getLongitud()));
        Assert.assertEquals(60000,usuario.getUbicaciones().get(0).getLatitud(),(60000-ubi.getLatitud()));
        Assert.assertEquals("Uruguay",usuario.getUbicaciones().get(0).getPais());
    }

    @Test
    public void getNickname() {
        String nick = usuario.getNickname();
        Assert.assertEquals("guzram",nick);
    }

    @Test
    public void setNickname() {
        usuario.setNickname("Marzug");
        Assert.assertEquals("Marzug",usuario.getNickname());
    }

    @Test
    public void getCelular() {
        String cel = usuario.getCelular();
        Assert.assertEquals("099123456",cel);
    }

    @Test
    public void setCelular() {
        usuario.setCelular("098654321");
        Assert.assertEquals("098654321",usuario.getCelular());
    }

    @Test
    public void getDireccion() {
        String direccion = usuario.getDireccion();
        Assert.assertEquals("en su casa",direccion);
    }

    @Test
    public void setDireccion() {
        usuario.setDireccion("En esta nueva casa");
        Assert.assertEquals("En esta nueva casa",usuario.getDireccion());
    }

    @Test
    public void getCreadorDeEventos() {
        List<Evento> creadorEventos = usuario.getCreadorDeEventos();
        Assert.assertNotNull(creadorEventos);
    }

    @Test
    public void setCreadorDeEventos() {
        Date date = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(0,"Evento de prueba",date, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");

        Evento event = new Evento(dtoEvento);
        usuario.getCreadorDeEventos().add(event);

        Assert.assertNotNull(usuario.getCreadorDeEventos());
        Assert.assertEquals(0,usuario.getCreadorDeEventos().get(0).getIdEvento());
        Assert.assertEquals("Evento de prueba",usuario.getCreadorDeEventos().get(0).getDescripcion());
        Assert.assertEquals("nombre imagen para mostrar del evento",usuario.getCreadorDeEventos().get(0).getNombreImagen());
        Assert.assertEquals(estados.enCurso,usuario.getCreadorDeEventos().get(0).getEstado());
    }

    @Test
    public void getPerfil() {
        PerfilUsuario perfilUsuario = usuario.getPerfil();
        Assert.assertNotNull(perfilUsuario);
        Assert.assertEquals("jpg",perfilUsuario.getExtension());
        Assert.assertEquals("Imagen de Perfil 827384y234",perfilUsuario.getImagenPerfil());
        Assert.assertEquals("Nombre Imagen",perfilUsuario.getNombreImagen());
    }

    @Test
    public void setPerfil() {
        usuario.setPerfil(null);
        Assert.assertNull(usuario.getPerfil());
    }

    @Test
    public void getMedalla() {
        Medalla medalla = usuario.getMedalla();

        Assert.assertNotNull(medalla);
        Assert.assertEquals(1,medalla.getIdMedalla());
        Assert.assertEquals(1500,medalla.getCantidadPuntos());
        Assert.assertEquals("Vamos en camino",medalla.getLogros());
    }

    @Test
    public void setMedalla() {
        Medalla medalla = new Medalla();
        medalla.setIdMedalla(1);
        medalla.setCantidadPuntos(0);
        medalla.setLogros("Recien empezando");
        medalla.setRango(rangos.ironWolf);

        usuario.setMedalla(medalla);

        Assert.assertNotNull(usuario.getMedalla());
        Assert.assertEquals(1,usuario.getMedalla().getIdMedalla());
        Assert.assertEquals(0,usuario.getMedalla().getCantidadPuntos());
        Assert.assertEquals("Recien empezando",usuario.getMedalla().getLogros());
    }

    @Test
    public void getEstaBloqueado() {
        boolean bloqueado = usuario.getEstaBloqueado();
        Assert.assertFalse(bloqueado);
    }

    @Test
    public void setEstaBloqueado() {
        usuario.setEstaBloqueado(true);
        Assert.assertTrue(usuario.getEstaBloqueado());
    }

    @Test
    public void getPais() {
        String pais = usuario.getPais();
        Assert.assertEquals("Uruguay",pais);
    }

    @Test
    public void setPais() {
        usuario.setPais("España");
        Assert.assertEquals("España",usuario.getPais());
    }
}
