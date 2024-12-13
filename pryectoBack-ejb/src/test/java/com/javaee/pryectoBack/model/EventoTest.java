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
public class EventoTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        event.setIdEvento(1);
        event.setDescripcion("Descripcion evento");
        Date dateInit = new Date(2021, Calendar.JUNE,21);
        event.setFechaInicio(dateInit);
        Date dateEnd = new Date(2021, Calendar.JUNE,21);
        event.setFechaFin(dateEnd);
        event.setEstado(estados.enCurso);
        event.setIdChat("2");
        List<Publicacion> publicaciones = new ArrayList<>();
        event.setPublicaciones(publicaciones);
        Usuario user = new Usuario();
        user.setIdPersona("1");
        event.setUsuarioCreador(user);
        event.setNombre("Nombre event");
        Ubicacion ubi = new Ubicacion();
        event.setUbicacion(ubi);
        event.setNombreImagen("nombreImagen");
        event.setImagen("Imagen en si");
        event.setExtension("jpg");
    }

    private Evento event = new Evento();

    @Test
    public void eventoDefault(){
        Evento event = new Evento();
        Assert.assertNotNull(event);
    }

    @Test
    public void eventoDTO(){
        Date date = new Date(2021, Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento dtoEvento = new DTOEvento(1,"Evento de prueba",date, date2, estados.enCurso,1,"1","Javier",dtoub,"nombre imagen para mostrar del evento","image249824","jpg");

        Evento res = new Evento(dtoEvento);
        Assert.assertNotNull(res);
    }

    @Test
    public void getIdEvento() {
        int id = event.getIdEvento();
        Assert.assertEquals(1,id);
    }

    @Test
    public void setIdEvento() {
        event.setIdEvento(2);
        Assert.assertEquals(2,event.getIdEvento());
    }

    @Test
    public void getDescripcion() {
        String res = event.getDescripcion();
        Assert.assertEquals("Descripcion evento",res);
    }

    @Test
    public void setDescripcion() {
        event.setDescripcion("Cambio descri");
        Assert.assertEquals("Cambio descri",event.getDescripcion());
    }

    @Test
    public void getFechaInicio() {
        Date res = event.getFechaInicio();
        Assert.assertEquals(new Date(2021, Calendar.JUNE,21),res);
    }

    @Test
    public void setFechaInicio() {
        event.setFechaInicio(new Date(2021, Calendar.JUNE,22));
        Assert.assertEquals(new Date(2021, Calendar.JUNE,22),event.getFechaInicio());
    }

    @Test
    public void getFechaFin() {
        Date res = event.getFechaFin();
        Assert.assertEquals(new Date(2021, Calendar.JUNE,21),res);
    }

    @Test
    public void setFechaFin() {
        event.setFechaFin(new Date(2021, Calendar.JUNE,22));
        Assert.assertEquals(new Date(2021, Calendar.JUNE,22),event.getFechaFin());
    }

    @Test
    public void getEstado() {
        estados res = event.getEstado();
        Assert.assertEquals(estados.enCurso,res);
    }

    @Test
    public void setEstado() {
        event.setEstado(estados.terminado);
        Assert.assertEquals(estados.terminado,event.getEstado());
    }

    @Test
    public void getIdChat() {
        String res = event.getIdChat();
        Assert.assertEquals("2",res);
    }

    @Test
    public void setIdChat() {
        event.setIdChat("1");
        Assert.assertEquals("1",event.getIdChat());
    }

    @Test
    public void getPublicaciones() {
        List<Publicacion> pubs = new ArrayList<>();
        List<Publicacion> res = event.getPublicaciones();
        Assert.assertEquals(pubs,res);
    }

    @Test
    public void setPublicaciones() {
        List<Publicacion> pubs = new ArrayList<>();
        Assert.assertEquals(pubs,event.getPublicaciones());
    }

    @Test
    public void getUsuarioCreador() {
        Usuario res = event.getUsuarioCreador();
        Assert.assertNotNull(res);
    }

    @Test
    public void setUsuarioCreador() {
        DTOUsuario dtoUser = new DTOUsuario("1", "probanto1@gmail.com", "German", "Gutierrez", "elguti", "en su casa", "099111111", "Uruguay","imagen", "imagenPerfil", "jpg");
        Usuario res = new Usuario(dtoUser);
        event.setUsuarioCreador(null);
        event.setUsuarioCreador(res);
        Assert.assertNotNull(event.getUsuarioCreador());
    }

    @Test
    public void getNombre() {
        String nombre = event.getNombre();
        Assert.assertEquals("Nombre event",nombre);
    }

    @Test
    public void setNombre() {
        event.setNombre("Event name");
        Assert.assertEquals("Event name",event.getNombre());
    }

    @Test
    public void getUbicacion() {
        Ubicacion ubi = event.getUbicacion();
        Assert.assertNotNull(ubi);
    }

    @Test
    public void setUbicacion() {
        Date date = new Date(2021, Calendar.JUNE,21);
        DTOUbicacion dtoUb = new DTOUbicacion(22,5433354,534235,date,"Detalles de la ubicación del evento","Uruguay");
        Ubicacion ubi = new Ubicacion(dtoUb);
        event.setUbicacion(null);
        event.setUbicacion(ubi);
        Assert.assertNotNull(event.getUbicacion());
    }

    @Test
    public void getNombreImagen() {
        String nombreImagen = event.getNombreImagen();
        Assert.assertEquals("nombreImagen",nombreImagen);
    }

    @Test
    public void setNombreImagen() {
        event.setNombreImagen("Name Image");
        Assert.assertEquals("Name Image",event.getNombreImagen());
    }

    @Test
    public void getImagen() {
        String imagen = event.getImagen();
        Assert.assertEquals("Imagen en si",imagen);
    }

    @Test
    public void setImagen() {
        event.setImagen("Image it self");
        Assert.assertEquals("Image it self",event.getImagen());
    }

    @Test
    public void getExtension() {
        String exten = event.getExtension();
        Assert.assertEquals("jpg",exten);
    }

    @Test
    public void setExtension() {
        event.setExtension("gif");
        Assert.assertEquals("gif",event.getExtension());
    }
}
