package com.example.demo.dto;

public class NormaDTO {
    private String id;
    private String titulo;
    private String numero;
    private String fechaPublicacion;

    public NormaDTO() {}

    public NormaDTO(String id, String titulo, String numero, String fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.numero = numero;
        this.fechaPublicacion = fechaPublicacion;
    }

    // getters y setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
