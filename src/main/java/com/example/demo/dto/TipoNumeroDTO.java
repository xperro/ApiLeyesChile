package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TipoNumeroDTO {

    @JacksonXmlProperty(localName = "Tipo")
    private Integer tipo;

    @JacksonXmlProperty(localName = "Numero")
    private String numero;

    @JacksonXmlProperty(localName = "Descripcion")
    private String descripcion;

    @JacksonXmlProperty(localName = "Abreviacion")
    private String abreviacion;

    @JacksonXmlProperty(localName = "Compuesto")
    private String compuesto;

    // getters y setters
    public Integer getTipo() { return tipo; }
    public void setTipo(Integer tipo) { this.tipo = tipo; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getAbreviacion() { return abreviacion; }
    public void setAbreviacion(String abreviacion) { this.abreviacion = abreviacion; }

    public String getCompuesto() { return compuesto; }
    public void setCompuesto(String compuesto) { this.compuesto = compuesto; }
}
