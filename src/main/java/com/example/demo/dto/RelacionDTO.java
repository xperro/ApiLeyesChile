package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RelacionDTO {
    @JacksonXmlProperty(isAttribute = true, localName = "tipoRelacion")
    private String tipoRelacion;

    @JacksonXmlProperty(localName = "Enlace")
    private String enlace;

    @JacksonXmlProperty(localName = "Categoria")
    private String categoria;

    @JacksonXmlProperty(localName = "Informacion")
    private String informacion;

    // (opcional) @JacksonXmlProperty(localName="NroBoletin") si lo usas

    // getters y setters...
    public String getTipoRelacion() { return tipoRelacion; }
    public void setTipoRelacion(String tipoRelacion) { this.tipoRelacion = tipoRelacion; }

    public String getEnlace() { return enlace; }
    public void setEnlace(String enlace) { this.enlace = enlace; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getInformacion() { return informacion; }
    public void setInformacion(String informacion) { this.informacion = informacion; }
}
