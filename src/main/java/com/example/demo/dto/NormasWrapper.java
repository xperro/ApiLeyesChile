package com.example.demo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "NormasDestacadas")
public class NormasWrapper {

    @JacksonXmlProperty(isAttribute = true, localName = "idCategoria")
    private int idCategoria;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Norma")
    private List<NormaAgrupador> normas;

    // getters y setters

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public List<NormaAgrupador> getNormas() {
        return normas;
    }

    public void setNormas(List<NormaAgrupador> normas) {
        this.normas = normas;
    }

   
    public List<NormaAgrupador> getLista() {
        return normas;
    }
    public void setLista(List<NormaAgrupador> lista) {
        this.normas = lista;
    }
}
