package com.javaee.pryectoBack.datatypes;

import com.javaee.pryectoBack.model.Multimedia;
import com.javaee.pryectoBack.model.PerfilUsuario;
import com.javaee.pryectoBack.model.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DTOMultimediaTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        dtoMultimedia.setidMultimedia(1);
        dtoMultimedia.setContenido("Contenido multi");
        dtoMultimedia.setExtension("gif");
        dtoMultimedia.setNombre("Nombre multi");
        dtoMultimedia.setIdPersona("1");
    }

    private DTOMultimedia dtoMultimedia = new DTOMultimedia();

    @Test
    public void dtoMultimediaDefault(){
        DTOMultimedia dtoMulti = new DTOMultimedia();
        Assert.assertNotNull(dtoMulti);
    }

    @Test
    public void dtoMultimediaParams(){
        DTOMultimedia dtoMulti = new DTOMultimedia(1,"Contenido","Algo de multimedia","jpg","1");
        Assert.assertNotNull(dtoMulti);
    }

    @Test
    public void dtoMultimediaObj(){
        Multimedia multi = new Multimedia();
        multi.setIdMultimedia(1);
        multi.setContenido("Contenido Multimedia");
        multi.setNombre("Multi 1");
        multi.setExtension("gif");

        PerfilUsuario perfilUsuario = new PerfilUsuario();
        Usuario user = new Usuario();
        user.setIdPersona("1");
        perfilUsuario.setUsuario(user);
        perfilUsuario.setExtension("jpg");
        perfilUsuario.setImagenPerfil("Imagen de Perfil 827384y234");
        perfilUsuario.setNombreImagen("Nombre Imagen");
        multi.setPerfil(perfilUsuario);

        DTOMultimedia dtoMult = new DTOMultimedia(multi);

        Assert.assertEquals(1,dtoMult.getidMultimedia());
        Assert.assertEquals("Contenido Multimedia",dtoMult.getContenido());
        Assert.assertEquals("Multi 1",dtoMult.getNombre());
        Assert.assertEquals("gif",dtoMult.getExtension());
        Assert.assertEquals("1",dtoMult.getIdPersona());
    }

    @Test
    public void getidMultimedia() {
        int idMulti = dtoMultimedia.getidMultimedia();
        Assert.assertEquals(1,idMulti);
    }

    @Test
    public void setidMultimedia() {
        dtoMultimedia.setidMultimedia(2);
        Assert.assertEquals(2,dtoMultimedia.getidMultimedia());
    }

    @Test
    public void getContenido() {
        String conten = dtoMultimedia.getContenido();
        Assert.assertEquals("Contenido multi",conten);
    }

    @Test
    public void setContenido() {
        dtoMultimedia.setContenido("Content mult");
        Assert.assertEquals("Content mult", dtoMultimedia.getContenido());
    }

    @Test
    public void getNombre() {
        String nombr = dtoMultimedia.getNombre();
        Assert.assertEquals("Nombre multi", nombr);
    }

    @Test
    public void setNombre() {
        dtoMultimedia.setNombre("Multi name");
        Assert.assertEquals("Multi name",dtoMultimedia.getNombre());
    }

    @Test
    public void getExtension() {
        String ext = dtoMultimedia.getExtension();
        Assert.assertEquals("gif",ext);
    }

    @Test
    public void setExtension() {
        dtoMultimedia.setExtension("mp3");
        Assert.assertEquals("mp3",dtoMultimedia.getExtension());
    }

    @Test
    public void getIdPersona() {
        String idPer = dtoMultimedia.getIdPersona();
        Assert.assertEquals("1",idPer);
    }

    @Test
    public void setIdPersona() {
        dtoMultimedia.setIdPersona("2");
        Assert.assertEquals("2",dtoMultimedia.getIdPersona());
    }
}
