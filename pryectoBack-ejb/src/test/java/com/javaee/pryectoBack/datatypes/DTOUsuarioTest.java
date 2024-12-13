package com.javaee.pryectoBack.datatypes;

import com.javaee.pryectoBack.model.PerfilUsuario;
import com.javaee.pryectoBack.model.Usuario;
import com.javaee.pryectoBack.model.rangos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DTOUsuarioTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        dtoUsuario.setIdPersona("1");
        dtoUsuario.setEmail("probando@mail.com");
        dtoUsuario.setNombre("Juan");
        dtoUsuario.setApellido("Alvez");
        dtoUsuario.setNickname("juanA");
        dtoUsuario.setDireccion("En su casa");
        dtoUsuario.setCelular("099111123");
        DTOMedalla dtoMed = new DTOMedalla(1,1000,"Al máximo", rangos.alfaWolf,dtoUsuario);
        dtoUsuario.setMedalla(dtoMed);
        dtoUsuario.setPais("Uruguay");
        dtoUsuario.setImagenPerfil("Imagen perfil 287482749");
        dtoUsuario.setNombreImagen("Nombre imagen");
        dtoUsuario.setExtension("jpg");

    }

    private DTOUsuario dtoUsuario = new DTOUsuario();

    @Test
    public void dtoUsuarioDefault(){
        DTOUsuario dtoUs = new DTOUsuario();
        Assert.assertNotNull(dtoUs);
    }

    @Test
    public void dtoUsuarioParams(){
        DTOUsuario dtoUs = new DTOUsuario("1","probanto@mail.com","Juan","Alvez","juanA","En su casa","099111123","Uruguay","","","");
        Assert.assertNotNull(dtoUs);
    }

    @Test
    public void dtoUsuarioObj(){
        DTOUsuario dtoUs = new DTOUsuario("1","probanto@mail.com","Juan","Alvez","juanA","En su casa","099111123","Uruguay","","","");
        Usuario user = new Usuario(dtoUs);
        PerfilUsuario perfilUsuario = new PerfilUsuario();
        perfilUsuario.setExtension("jpg");
        perfilUsuario.setImagenPerfil("Imagen de Perfil 827384y234");
        perfilUsuario.setNombreImagen("Nombre Imagen");
        user.setPerfil(perfilUsuario);
        DTOUsuario dtoUser = new DTOUsuario(user);
        Assert.assertNotNull(dtoUser);
    }

    @Test
    public void getIdPersona() {
        String idPer = dtoUsuario.getIdPersona();
        Assert.assertEquals("1",idPer);
    }

    @Test
    public void setIdPersona() {
        dtoUsuario.setIdPersona("2");
        Assert.assertEquals("2",dtoUsuario.getIdPersona());
    }

    @Test
    public void getEmail() {
        String email = dtoUsuario.getEmail();
        Assert.assertEquals("probando@mail.com",email);
    }

    @Test
    public void setEmail() {
        dtoUsuario.setEmail("test@mail.com");
        Assert.assertEquals("test@mail.com",dtoUsuario.getEmail());
    }

    @Test
    public void getNombre() {
        String nomb = dtoUsuario.getNombre();
        Assert.assertEquals("Juan",nomb);
    }

    @Test
    public void setNombre() {
        dtoUsuario.setNombre("Pedro");
        Assert.assertEquals("Pedro",dtoUsuario.getNombre());
    }

    @Test
    public void getApellido() {
        String apelli = dtoUsuario.getApellido();
        Assert.assertEquals("Alvez",apelli);
    }

    @Test
    public void setApellido() {
        dtoUsuario.setApellido("Francces");
        Assert.assertEquals("Francces",dtoUsuario.getApellido());
    }

    @Test
    public void getNickname() {
        String nick = dtoUsuario.getNickname();
        Assert.assertEquals("juanA",nick);
    }

    @Test
    public void setNickname() {
        dtoUsuario.setNickname("juanDeArco");
        Assert.assertEquals("juanDeArco",dtoUsuario.getNickname());
    }

    @Test
    public void getDireccion() {
        String direc = dtoUsuario.getDireccion();
        Assert.assertEquals("En su casa",direc);
    }

    @Test
    public void setDireccion() {
        dtoUsuario.setDireccion("En estadio centenario");
        Assert.assertEquals("En estadio centenario",dtoUsuario.getDireccion());
    }

    @Test
    public void getCelular() {
        String cel = dtoUsuario.getCelular();
        Assert.assertEquals("099111123",cel);
    }

    @Test
    public void setCelular() {
        dtoUsuario.setCelular("093678999");
        Assert.assertEquals("093678999",dtoUsuario.getCelular());
    }

    @Test
    public void getMedalla() {
        DTOMedalla dtoMedalla = dtoUsuario.getMedalla();
        Assert.assertNotNull(dtoMedalla);
        Assert.assertEquals(1,dtoMedalla.getIdMedalla());
        Assert.assertEquals(1000,dtoMedalla.getCantidadPuntos());
        Assert.assertEquals("Al máximo",dtoMedalla.getLogros());
        Assert.assertEquals(rangos.alfaWolf,dtoMedalla.getRango());
    }

    @Test
    public void setMedalla() {
        DTOMedalla dtoMedalla = new DTOMedalla(20,2544,"Va mejor", rangos.diamondWolf,dtoUsuario);
        dtoUsuario.setMedalla(dtoMedalla);
        Assert.assertEquals(20,dtoMedalla.getIdMedalla());
        Assert.assertEquals(2544,dtoMedalla.getCantidadPuntos());
        Assert.assertEquals("Va mejor",dtoMedalla.getLogros());
        Assert.assertEquals(rangos.diamondWolf,dtoMedalla.getRango());
    }

    @Test
    public void getPais() {
        String pais = dtoUsuario.getPais();
        Assert.assertEquals("Uruguay",pais);
    }

    @Test
    public void setPais() {
        dtoUsuario.setPais("Rusia");
        Assert.assertEquals("Rusia",dtoUsuario.getPais());
    }

    @Test
    public void getImagenPerfil() {
        String imaPer = dtoUsuario.getImagenPerfil();
        Assert.assertEquals("Imagen perfil 287482749",imaPer);
    }

    @Test
    public void setImagenPerfil() {
        dtoUsuario.setImagenPerfil("Cambio imagen 838394");
        Assert.assertEquals("Cambio imagen 838394",dtoUsuario.getImagenPerfil());
    }

    @Test
    public void getNombreImagen() {
        String nomImag = dtoUsuario.getNombreImagen();
        Assert.assertEquals("Nombre imagen", nomImag);
    }

    @Test
    public void setNombreImagen() {
        dtoUsuario.setNombreImagen("Image name");
        Assert.assertEquals("Image name",dtoUsuario.getNombreImagen());
    }

    @Test
    public void getExtension() {
        String ext = dtoUsuario.getExtension();
        Assert.assertEquals("jpg",ext);
    }

    @Test
    public void setExtension() {
        dtoUsuario.setExtension("gif");
        Assert.assertEquals("gif",dtoUsuario.getExtension());
    }
}
