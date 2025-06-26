package com.example.demo.controller;

import com.example.demo.client.LeyChileLegacyClient;
import com.example.demo.dto.Agrupador;
import com.example.demo.dto.AgrupadorWrapper;
import com.example.demo.dto.Categoria;
import com.example.demo.dto.NormaAgrupador;
import com.example.demo.dto.CategoriasWrapper;
import com.example.demo.dto.NormasWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/api/leychile/legacy")
public class LeyChileController {

    private final LeyChileLegacyClient client;

    public LeyChileController(LeyChileLegacyClient client) {
        this.client = client;
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> categorias() {
        try {
            CategoriasWrapper wrapper = client.getCategorias();
            return ResponseEntity.ok(wrapper.getCategorias());
        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/agrupadores/{idCategoria}")
    public ResponseEntity<List<Agrupador>> agrupadores(@PathVariable int idCategoria) {
        try {
            AgrupadorWrapper wrapper = client.getAgrupadores(idCategoria);
            return ResponseEntity.ok(wrapper.getAgrupadores());
        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/normas/{idAgrupador}/tipo-numero")
    public ResponseEntity<List<NormaAgrupador>> normasPorTipoNumero(@PathVariable int idAgrupador) {
        try {
            NormasWrapper wrapper = client.getNormasPorTipoNumero(idAgrupador);
            return ResponseEntity.ok(wrapper.getNormas());
        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/normas/{idAgrupador}/tipo-materia")
    public ResponseEntity<List<NormaAgrupador>> normasPorTipoMateria(@PathVariable int idAgrupador) {
        try {
            NormasWrapper wrapper = client.getNormasPorTipoNumero(idAgrupador);
            return ResponseEntity.ok(wrapper.getNormas());
        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
