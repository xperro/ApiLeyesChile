package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "Categorias")
public class AgrupadorWrapper {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Categoria")
    private List<Agrupador> agrupadores;

    public AgrupadorWrapper() {}

    public List<Agrupador> getAgrupadores() {
        return agrupadores;
    }
    public void setAgrupadores(List<Agrupador> agrupadores) {
        this.agrupadores = agrupadores;
    }
}
