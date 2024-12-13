package com.javaee.pryectoBack.service;

import com.javaee.pryectoBack.data.ControladorConfigSistemaDA;
import com.javaee.pryectoBack.data.ControladorConfigSistemaDALocal;
import com.javaee.pryectoBack.datatypes.DTOConfiguracion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ControladorConfigSistemaTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private ControladorConfigSistemaDALocal controladorConfigSistemaDA = new ControladorConfigSistemaDA();

    @InjectMocks
    private ControladorConfigSistemaLocal controladorConfigSistema = new ControladorConfigSistema();


    @Test
    public void configurarNotificaciones() {
        DTOConfiguracion dtoConfig = new DTOConfiguracion(1,true,true,true,true,true,true,true,true,true,true,true,true,true,true,"1");
        Mockito.when(controladorConfigSistemaDA.configurarNotificaciones(Mockito.any(DTOConfiguracion.class))).thenReturn(dtoConfig);
        DTOConfiguracion res = controladorConfigSistema.configurarNotificaciones(dtoConfig);
        Assert.assertNotNull(res);
    }

    @Test
    public void getByIdPersona() {
        DTOConfiguracion dtoConfig = new DTOConfiguracion(1,true,true,true,true,true,true,true,true,true,true,true,true,true,true,"1");
        Mockito.when(controladorConfigSistemaDA.getByIdPersona(Mockito.anyString(),Mockito.anyBoolean())).thenReturn(dtoConfig);
        DTOConfiguracion res = controladorConfigSistema.getByIdPersona("1",true);
        Assert.assertNotNull(res);
    }
}
