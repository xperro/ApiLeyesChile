package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "Norma")
public class NormaAgrupador {

    @JacksonXmlProperty(isAttribute = true, localName = "idNorma")
    private int idNorma;

    @JacksonXmlProperty(localName = "Grupo")
    private String grupo;

    @JacksonXmlProperty(localName = "Materia")
    private String materia;

    @JacksonXmlProperty(localName = "FechaPublicacion")
    private String fechaPublicacion;

    @JacksonXmlProperty(localName = "FechaPromulgacion")
    private String fechaPromulgacion;

    @JacksonXmlProperty(localName = "Titulo")
    private String titulo;

    @JacksonXmlProperty(localName = "Url")
    private String url;

    @JacksonXmlProperty(localName = "ExtractoTexto")
    private String extractoTexto;

    // Aquí usamos tu TiposWrapper para envolver la lista de <TipoNumero>
    @JacksonXmlProperty(localName = "TiposNumeros")
    private TiposWrapper tipos;

    // Para las relaciones (lista de <Relacion> dentro de <Relaciones>)
    @JacksonXmlElementWrapper(localName = "Relaciones")
    @JacksonXmlProperty(localName = "Relacion")
    private List<RelacionDTO> relas;

    // ---- getters y setters ----

    public int getIdNorma() { return idNorma; }
    public void setIdNorma(int idNorma) { this.idNorma = idNorma; }

    public String getGrupo() { return grupo; }
    public void setGrupo(String grupo) { this.grupo = grupo; }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }

    public String getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getFechaPromulgacion() { return fechaPromulgacion; }
    public void setFechaPromulgacion(String fechaPromulgacion) {
        this.fechaPromulgacion = fechaPromulgacion;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getExtractoTexto() { return extractoTexto; }
    public void setExtractoTexto(String extractoTexto) {
        this.extractoTexto = extractoTexto;
    }

    public TiposWrapper getTipos() { return tipos; }
    public void setTipos(TiposWrapper tipos) { this.tipos = tipos; }

    public List<RelacionDTO> getRelas() { return relas; }
    public void setRelas(List<RelacionDTO> relas) { this.relas = relas; }
}
