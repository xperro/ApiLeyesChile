package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Categoria {
    @JacksonXmlProperty(isAttribute = true, localName = "idCategoria")
    private int idCategoria;

    // Aquí DESCRIPCION con D mayúscula
    @JacksonXmlProperty(localName = "Descripcion")
    private String descripcion;

    // getters/setters
    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}