package com.javaee.pryectoBack.model;

import com.javaee.pryectoBack.datatypes.DTOMultimedia;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MultimediaTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        multimedia.setIdMultimedia(1);
        multimedia.setContenido("imagen");
        multimedia.setContenido("Imagen en si 789234235");
        multimedia.setNombre("Nombre multimedia");
        multimedia.setExtension("jpg");
        PerfilUsuario perfilUsuario = new PerfilUsuario();
        perfilUsuario.setIdPersona("1");
        multimedia.setPerfil(perfilUsuario);

    }

    private Multimedia multimedia = new Multimedia();

    @Test
    public void multimediaDefault(){
        Multimedia multi = new Multimedia();
        Assert.assertNotNull(multi);
    }

    @Test
    public void multimediaParams(){
        DTOMultimedia dtomulti = new DTOMultimedia(2,"fotos","fotos nomb","jpg","2");
        PerfilUsuario perfilUser = new PerfilUsuario();
        perfilUser.setIdPersona("2");

        Multimedia multi = new Multimedia(dtomulti,perfilUser);
        Assert.assertNotNull(multi);
    }

    @Test
    public void getIdMultimedia() {
        int idmultimedia = multimedia.getIdMultimedia();
        Assert.assertEquals(1,idmultimedia);
    }

    @Test
    public void setIdMultimedia() {
        multimedia.setIdMultimedia(2);
        Assert.assertEquals(2,multimedia.getIdMultimedia());
    }

    @Test
    public void getContenido() {
        String content = multimedia.getContenido();
        Assert.assertEquals("Imagen en si 789234235",content);
    }

    @Test
    public void setContenido() {
        multimedia.setContenido("foto");
        Assert.assertEquals("foto",multimedia.getContenido());
    }

    @Test
    public void getNombre() {
        String nombre = multimedia.getNombre();
        Assert.assertEquals("Nombre multimedia",nombre);
    }

    @Test
    public void setNombre() {
        multimedia.setNombre("Multi name");
        Assert.assertEquals("Multi name",multimedia.getNombre());
    }

    @Test
    public void getExtension() {
        String exte = multimedia.getExtension();
        Assert.assertEquals("jpg",exte);
    }

    @Test
    public void setExtension() {
        multimedia.setExtension("gif");
        Assert.assertEquals("gif",multimedia.getExtension());
    }

    @Test
    public void getPerfil() {
        PerfilUsuario perfil = multimedia.getPerfil();
        Assert.assertNotNull(perfil);
    }

    @Test
    public void setPerfil() {
        PerfilUsuario perfil = new PerfilUsuario();
        perfil.setIdPersona("20");
        multimedia.setPerfil(perfil);
        Assert.assertEquals("20",multimedia.getPerfil().getIdPersona());
    }
}
