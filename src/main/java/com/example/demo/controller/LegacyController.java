
import com.example.demo.client.LeyChileLegacyClient;
import com.example.demo.dto.NormasWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class LegacyController {
  private final LeyChileLegacyClient legacy;
  public LegacyController(LeyChileLegacyClient legacy) {
    this.legacy = legacy;
  }

  @GetMapping("/ver-norma-legacy")
public String verNormaLegacy(
    @RequestParam int agrupador,
    @RequestParam int idNorma,
    Model m
) throws JsonProcessingException {
    NormasWrapper w = legacy.getNormasPorTipoNumero(agrupador);
    // ahora getLista() devuelve List<NormaAgrupador>, así que .stream() existe
    var opt = w.getLista().stream()
        .filter(n -> n.getIdNorma() == idNorma)
        .findAny();
    if (opt.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
        "Norma no encontrada en LeyChile");
    }
    m.addAttribute("norma", opt.get());
    return "norma-legacy";
}
}
