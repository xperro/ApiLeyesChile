package com.example.demo.controller;

import com.example.demo.client.LeyChileLegacyClient;
import com.example.demo.client.NormasClient;
import com.example.demo.dto.Agrupador;
import com.example.demo.dto.AgrupadorWrapper;
import com.example.demo.dto.Categoria;
import com.example.demo.dto.NormaAgrupador;
import com.example.demo.dto.NormaDTO;
import com.example.demo.dto.NormasWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class ViewController {

    private final LeyChileLegacyClient legacy;
    private final NormasClient normas;

    public ViewController(LeyChileLegacyClient legacy,
            NormasClient normas) {
        this.legacy = legacy;
        this.normas = normas;
    }

    /**
     * 1. Lista todas las categorías *
     */
    @GetMapping("/ver-categorias")
    public String verCategorias(Model model) throws JsonProcessingException {
        model.addAttribute("categorias", legacy.getCategorias().getCategorias());
        return "categorias";  // plantilla: categorias.html
    }

    /**
     * 2. Lista los agrupadores de una categoría *
     */
    @GetMapping("/ver-agrupadores")
    public String verAgrupadores(
            @RequestParam("cat") int idCategoria,
            Model model
    ) throws Exception {
        AgrupadorWrapper wrapper = legacy.getAgrupadores(idCategoria);
        List<Agrupador> lista = wrapper.getAgrupadores();

        // -- DEPURACIÓN --
        System.out.println("DEBUG: # agrupadores recibidos = "
                + (lista == null ? "null" : lista.size()));
        lista.forEach(a
                -> System.out.println("  -> " + a.getIdAgrupador() + " : " + a.getDescripcion())
        );
        // -- /DEPURACIÓN --

        model.addAttribute("agrupadores", lista);
        model.addAttribute("idCategoria", idCategoria);
        return "agrupadores";
    }

    /**
     * 3. Lista normas de un agrupador (por tipo/número) *
     */
    @GetMapping("/ver-normas")
    public String verNormas(
            @RequestParam("cat") int catId,
            @RequestParam("agr") int agrId,
            Model model
    ) throws JsonProcessingException {
        // a) cargar el agrupador y la lista de normas
        AgrupadorWrapper aw = legacy.getAgrupadores(catId);
        Agrupador agrupador = aw.getAgrupadores().stream()
                .filter(a -> a.getIdAgrupador() == agrId)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agrupador no encontrado"));
        NormasWrapper nw = legacy.getNormasPorTipoNumero(agrId);

        // b) pasar todo al modelo
        model.addAttribute("idCategoria", catId);
        model.addAttribute("idAgrupador", agrId);
        model.addAttribute("agrupador", agrupador);
        model.addAttribute("normas", nw.getLista());
        return "normas";
    }

    /**
     * 4. Ver detalle de una norma escogida *
     */
    @GetMapping("/ver-ley")
    public String verLey(
            @RequestParam String tipo,
            @RequestParam String org,
            @RequestParam String fechaPub,
            @RequestParam String numero,
            Model model
    ) throws Exception {
        NormaDTO dto = normas.getNormaDTO(tipo, org, fechaPub, numero);
        model.addAttribute("ley", dto);
        return "ley";  // plantilla: ley.html
    }

    @GetMapping("/ver-norma-legacy")
    public String verNormaLegacy(
            @RequestParam("cat") int catId,
            @RequestParam("agr") int agrId,
            @RequestParam("idNorma") int idNorma,
            Model model
    ) throws JsonProcessingException {
        NormasWrapper nw = legacy.getNormasPorTipoNumero(agrId);
        NormaAgrupador norma = nw.getLista().stream()
                .filter(n -> n.getIdNorma() == idNorma)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Norma no encontrada"));
        model.addAttribute("idCategoria", catId);
        model.addAttribute("idAgrupador", agrId);
        model.addAttribute("norma", norma);
        return "norma-legacy";
    }

}
