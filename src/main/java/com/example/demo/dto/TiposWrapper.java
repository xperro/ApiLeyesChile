package com.example.demo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TiposWrapper {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "TipoNumero")
    private List<TipoNumeroDTO> lista;

    public List<TipoNumeroDTO> getLista() {
        return lista;
    }

    public void setLista(List<TipoNumeroDTO> lista) {
        this.lista = lista;
    }
}
