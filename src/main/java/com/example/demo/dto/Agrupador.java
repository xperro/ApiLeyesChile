package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Agrupador {

    @JacksonXmlProperty(isAttribute = true, localName = "idAgrupador")
    private int idAgrupador;

    // ojo: mapear <Descripcion> con D mayúscula
    @JacksonXmlProperty(localName = "Descripcion")
    private String descripcion;

    public Agrupador() {}

    public int getIdAgrupador() { 
        return idAgrupador; 
    }
    public void setIdAgrupador(int idAgrupador) { 
        this.idAgrupador = idAgrupador; 
    }

    // Thymeleaf va a invocar getDescripcion()
    public String getDescripcion() { 
        return descripcion; 
    }
    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion; 
    }
}
