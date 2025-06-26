package com.example.demo.client;

import com.example.demo.dto.NormaDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class NormasClient {

    private final RestTemplate rt;
    private final ObjectMapper objectMapper;

    public NormasClient(RestTemplate rt) {
        this.rt = rt;
        this.objectMapper = new ObjectMapper();
    }

    public NormaDTO getNormaDTO(String tipo, String org,
                                String fechaPub, String numero) throws Exception {
        String tipoNorma = tipo.trim().toLowerCase().replace(" ", "-");
        String organismo = org.trim().toLowerCase().replace(" ", "-");
        String url = String.format(
          "https://datos.bcn.cl/recurso/cl/%s/%s/%s/%s/datos.json",
          tipoNorma, organismo, fechaPub.trim(), numero.trim()
        );
                System.out.println(url);

        // Obtiene JSON bruto como String
        String rawJson = rt.getForObject(url, String.class);
        // Parsea manualmente con Jackson JSON
        Map<String, Object> raw = objectMapper.readValue(
            rawJson,
            new TypeReference<Map<String, Object>>() {}
        );

        // Extrae la URI del sujeto
        String subject = raw.keySet().iterator().next();
        @SuppressWarnings("unchecked")
        Map<String, List<Map<String, Object>>> props =
            (Map<String, List<Map<String, Object>>>) raw.get(subject);

        // Extrae campos
        String titulo = props.get("http://purl.org/dc/elements/1.1/title")
                             .get(0).get("value").toString();
        String numeroNorma = props.get("http://datos.bcn.cl/ontologies/bcn-norms#hasNumber")
                                  .get(0).get("value").toString();
        String fecha = props.get("http://datos.bcn.cl/ontologies/bcn-norms#publishDate")
                            .get(0).get("value").toString();

        return new NormaDTO(subject, titulo, numeroNorma, fecha);
    }
}
