// src/main/java/com/example/demo/controller/NormasController.java
package com.example.demo.controller;

import com.example.demo.client.NormasClient;
import com.example.demo.dto.NormaDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leyes")
public class NormasController {

    private final NormasClient client;

    public NormasController(NormasClient client) {
        this.client = client;
    }

    @GetMapping("/{tipo}/{org}/{fechaPub}/{numero}")
    public NormaDTO getNorma(
        @PathVariable String tipo,
        @PathVariable String org,
        @PathVariable String fechaPub,
        @PathVariable String numero
    ) throws Exception {
        return client.getNormaDTO(tipo, org, fechaPub, numero);
    }
}
