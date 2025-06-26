package com.example.demo.client;

import com.example.demo.dto.AgrupadorWrapper;
import com.example.demo.dto.CategoriasWrapper;
import com.example.demo.dto.NormasWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class LeyChileLegacyClient {

    private final RestTemplate rt;
    private final XmlMapper xml;

    public LeyChileLegacyClient(RestTemplate rt, XmlMapper xml) {
        this.rt = rt;
        this.xml = xml;
    }

    public CategoriasWrapper getCategorias() throws JsonProcessingException {
        String xmlStr = rt.getForObject(
            "https://www.leychile.cl/Consulta/obtxml?opt=30&tipCat=0",
            String.class
        );
        
        return xml.readValue(xmlStr, CategoriasWrapper.class);
    }

    public AgrupadorWrapper getAgrupadores(int idCategoria) throws JsonProcessingException {
        String url = String.format(
            "https://www.leychile.cl/Consulta/obtxml?opt=31&agr=%d",
            idCategoria
        );
                System.out.println(url);

        String xmlStr = rt.getForObject(url, String.class);
        return xml.readValue(xmlStr, AgrupadorWrapper.class);
    }

    /**
     * Obtiene las normas de un agrupador (opt=37).
     * Si la consulta devuelve 404, devuelve un wrapper vacío.
     */
    public NormasWrapper getNormasPorAgrupador(int idAgrupador) throws JsonProcessingException {
        String url = String.format(
            "https://www.leychile.cl/Consulta/obtxml?opt=37&idAgrupador=%d",
            idAgrupador
        );
                System.out.println(url);

        try {
            String xmlStr = rt.getForObject(url, String.class);
            return xml.readValue(xmlStr, NormasWrapper.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return new NormasWrapper();
            }
            throw e;
        }
    }

    /**
     * Obtiene las normas de un agrupador ordenadas por materia (opt=36).
     */
    public NormasWrapper getNormasPorTipoNumero(int idAgrupador) throws JsonProcessingException {
        String url = String.format(
            "https://www.leychile.cl/Consulta/obtxml?opt=36&idAgrupador=%d",
            idAgrupador
        );
        System.out.println(url);
        String xmlStr = rt.getForObject(url, String.class);
        return xml.readValue(xmlStr, NormasWrapper.class);
    }
}
