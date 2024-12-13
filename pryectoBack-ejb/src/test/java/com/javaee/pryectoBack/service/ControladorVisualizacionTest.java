package com.javaee.pryectoBack.service;

import com.javaee.pryectoBack.data.ControladorVisualizacionDA;
import com.javaee.pryectoBack.data.ControladorVisualizacionDALocal;
import com.javaee.pryectoBack.datatypes.*;
import com.javaee.pryectoBack.model.estados;
import com.javaee.pryectoBack.model.rangos;
import com.javaee.pryectoBack.model.tipos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class ControladorVisualizacionTest {


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private ControladorVisualizacionDALocal controladorVisualizacionDA = new ControladorVisualizacionDA();

    @InjectMocks
    private ControladorVisualizacionLocal controladorVisualizacion = new ControladorVisualizacion();

    @Test
    public void obtenerGaleriaFoto() {
        List<DTOMultimedia> galeria = new ArrayList<>();
        DTOMultimedia dtomul1 = new DTOMultimedia(1,"www.youtube.com/slashMorgan","imagen","jpg","1");
        DTOMultimedia dtomul2 = new DTOMultimedia(2,"www.youtube.com/slashMorgan2","imagen2","jpg","1");
        galeria.add(dtomul1);
        galeria.add(dtomul2);
        Mockito.when(controladorVisualizacionDA.obtenerGaleriaFoto(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(galeria);
        List<DTOMultimedia> res = controladorVisualizacion.obtenerGaleriaFoto("1",0,5);
        Assert.assertNotNull(res);
    }

    @Test
    public void visualizarPerfil() {

        DTOPerfilUsuario dtoPerfilU = new DTOPerfilUsuario();

        DTOUsuario usuario = new DTOUsuario("1","user1@gmail.com","Gabriel", "Mankers","gabiM","estadio centenario 1233","099111222","Uruguay","imagen823e09e2enLaCancha","image","jpg");
        dtoPerfilU.setUsuario(usuario);

        List<DTOInteres> intereses = new ArrayList<>();
        DTOInteres dtoint1 = new DTOInteres();
        dtoint1.setIdInteres(1);
        dtoint1.setInteres("Choripan");
        List<DTOPerfilUsuario> dpu = new ArrayList<>();
        dtoint1.setPerfiles(dpu);

        DTOInteres dtoint2 = new DTOInteres();
        dtoint2.setIdInteres(1);
        dtoint2.setInteres("Milanga");
        List<DTOPerfilUsuario> dpu2 = new ArrayList<>();
        dtoint2.setPerfiles(dpu2);
        intereses.add(dtoint1);
        intereses.add(dtoint2);
        dtoPerfilU.setIntereses(intereses);

        List<DTOMultimedia> galerias = new ArrayList<>();
        DTOMultimedia dtomul1 = new DTOMultimedia(1,"www.youtube.com/twing","twing","jpg","1");
        DTOMultimedia dtomul2 = new DTOMultimedia(2,"www.youtube.com/twing2","twing2","jpg","1");
        galerias.add(dtomul1);
        galerias.add(dtomul2);
        dtoPerfilU.setGalerias(galerias);

        List<DTOPublicacion> publicaciones = new ArrayList<>();
        Date date = new Date(2021,Calendar.JUNE,21);
        Date date2 = new Date(2021,Calendar.JUNE,23);
        Date date3 = new Date(2021,Calendar.JUNE,21);
        DTOTipo dtoTipo = new DTOTipo(1, tipos.texto);
        List<DTOComentario> dtocoment = new ArrayList<>();
        DTOUbicacion dtoub = new DTOUbicacion(22,5433354,534235,date3,"Detalles de la ubicación del evento","Uruguay");
        DTOEvento event = new DTOEvento(1,"Esto es un evento",date,date2, estados.enCurso,1,"1","Gabriel",dtoub,"image","esta en la imagen en si","jpg");
        DTOPublicacion dtoPub1 = new DTOPublicacion(1,"HAciendo pruebas",date,dtoTipo,"1","text","pruebas",dtocoment,event,dtoPerfilU);

        Date date21 = new Date(2021, Calendar.DECEMBER,21);
        Date date31 = new Date(2021,Calendar.DECEMBER,23);
        Date date41 = new Date(2021,Calendar.DECEMBER,21);
        DTOTipo dtoTipo2 = new DTOTipo(1, tipos.texto);
        List<DTOComentario> dtocoment2 = new ArrayList<>();
        DTOUbicacion dtoub2 = new DTOUbicacion(31,746456,553434,date21,"Detalles de la ubicación del evento 2","Jamaica");
        DTOEvento event2 = new DTOEvento(1,"Esto es un evento 2",date31,date41, estados.enCurso,1,"1","Juan",dtoub2,"image","esta en la imagen en si 2","jpg");
        DTOPublicacion dtoPub2 = new DTOPublicacion(1,"HAciendo pruebas 2",date21,dtoTipo2,"1","text","pruebas 2",dtocoment2,event2,dtoPerfilU);

        publicaciones.add(dtoPub2);
        publicaciones.add(dtoPub1);
        dtoPerfilU.setPublicaciones(publicaciones);

        Mockito.when(controladorVisualizacionDA.visualizarPerfil(Mockito.anyString())).thenReturn(dtoPerfilU);
        DTOPerfilUsuario res = controladorVisualizacion.visualizarPerfil("1");
        Assert.assertNotNull(res);
    }

    @Test
    public void obtenerSugerenciaAmigos() {
        List<DTOUsuario> usuarios = new ArrayList<>();
        DTOUsuario usuario = new DTOUsuario("1","user1@gmail.com","Gabriel", "Mankers","gabiM","estadio centenario 1111","099111222","Uruguay","imagen823e09e2enLaCancha","image","jpg");
        DTOUsuario usuario2 = new DTOUsuario("2","user2@gmail.com","Juan", "Manei","juanMan","estadio centenario 2222","099222333","Uruguay","imagen823e09e2enLaCancha 2","image2","jpg");
        DTOUsuario usuario3 = new DTOUsuario("3","user3@gmail.com","MArcos", "Matos","MAcosMat","estadio centenario 3333","099333444","Uruguay","imagen823e09e2enLaCancha 3","image3","jpg");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        Mockito.when(controladorVisualizacionDA.obtenerSugerenciaAmigos(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(usuarios);
        List<DTOUsuario> res = controladorVisualizacion.obtenerSugerenciaAmigos("3",0,5);
        Assert.assertNotNull(res);
    }

    @Test
    public void obtenerAmigos() {
        List<DTOUsuario> usuarios = new ArrayList<>();
        DTOUsuario usuario = new DTOUsuario("1","user1@gmail.com","Gabriel", "Mankers","gabiM","estadio centenario 1111","099111222","Uruguay","imagen823e09e2enLaCancha","image","jpg");
        DTOUsuario usuario2 = new DTOUsuario("2","user2@gmail.com","Juan", "Manei","juanMan","estadio centenario 2222","099222333","Uruguay","imagen823e09e2enLaCancha 2","image2","jpg");
        DTOUsuario usuario3 = new DTOUsuario("3","user3@gmail.com","MArcos", "Matos","MAcosMat","estadio centenario 3333","099333444","Uruguay","imagen823e09e2enLaCancha 3","image3","jpg");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        Mockito.when(controladorVisualizacionDA.obtenerAmigos(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(usuarios);
        List<DTOUsuario> res = controladorVisualizacion.obtenerAmigos("4",0,5);
        Assert.assertNotNull(res);
    }

    @Test
    public void obtenerUsuarios() {
        List<DTOUsuario> usuarios = new ArrayList<>();
        DTOUsuario usuario = new DTOUsuario("1","user1@gmail.com","Gabriel", "Mankers","gabiM","estadio centenario 1111","099111222","Uruguay","imagen823e09e2enLaCancha","image","jpg");
        DTOUsuario usuario2 = new DTOUsuario("2","user2@gmail.com","Juan", "Manei","juanMan","estadio centenario 2222","099222333","Uruguay","imagen823e09e2enLaCancha 2","image2","jpg");
        DTOUsuario usuario3 = new DTOUsuario("3","user3@gmail.com","MArcos", "Matos","MAcosMat","estadio centenario 3333","099333444","Uruguay","imagen823e09e2enLaCancha 3","image3","jpg");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        Mockito.when(controladorVisualizacionDA.obtenerUsuarios(Mockito.anyInt(),Mockito.anyInt())).thenReturn(usuarios);
        List<DTOUsuario> res = controladorVisualizacion.obtenerUsuarios(0,5);
        Assert.assertNotNull(res);
    }

    @Test
    public void visualizarProgreso() {
        DTOUsuarioMedalla dtoUsuarioMedalla = new DTOUsuarioMedalla("1","Test@gmail.com","Marcos","Alvarez","marcosAl",1,2048,"unos cuantos", rangos.diamondWolf);
        Mockito.when(controladorVisualizacionDA.visualizarProgreso(Mockito.anyString())).thenReturn(dtoUsuarioMedalla);

        DTOUsuarioMedalla res = controladorVisualizacion.visualizarProgreso("1");
        Assert.assertNotNull(res);
    }

    @Test
    public void seleccionarTipoEstadistica() {
        List<DTOEstadistica> estadisticas = new ArrayList<>();
        DTOEstadistica dtoEstad1 = new DTOEstadistica("Javier",12454);
        DTOEstadistica dtoEstad2 = new DTOEstadistica("Guzmán", 14445);
        estadisticas.add(dtoEstad1);
        estadisticas.add(dtoEstad2);

        Mockito.when(controladorVisualizacionDA.seleccionarTipoEstadistica(Mockito.anyString())).thenReturn(estadisticas);
        List<DTOEstadistica> res = controladorVisualizacion.seleccionarTipoEstadistica("datos");
        Assert.assertNotNull(res);
    }

    @Test
    public void obtenerSolicitudesPendientes() {
        List<DTOUsuario> usuarios = new ArrayList<>();
        DTOUsuario usuario = new DTOUsuario("1","user1@gmail.com","Gabriel", "Mankers","gabiM","estadio centenario 1111","099111222","Uruguay","imagen823e09e2enLaCancha","image","jpg");
        DTOUsuario usuario2 = new DTOUsuario("2","user2@gmail.com","Juan", "Manei","juanMan","estadio centenario 2222","099222333","Uruguay","imagen823e09e2enLaCancha 2","image2","jpg");
        DTOUsuario usuario3 = new DTOUsuario("3","user3@gmail.com","MArcos", "Matos","MAcosMat","estadio centenario 3333","099333444","Uruguay","imagen823e09e2enLaCancha 3","image3","jpg");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        Mockito.when(controladorVisualizacionDA.obtenerSolicitudesPendientes(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(usuarios);
        List<DTOUsuario> res = controladorVisualizacion.obtenerSolicitudesPendientes("4",0,5);
        Assert.assertNotNull(res);
    }
}
