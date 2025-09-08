package com.syscode42.viacep.controller;

import com.syscode42.viacep.dto.ViaCepResultDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consulta-cep")
public class ViaCepController {

    @GetMapping("{cep}")
    public ViaCepResultDto search(@PathVariable("cep") String cep) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ViaCepResultDto> response =
                restTemplate.getForEntity(
                        String.format("https://viacep.com.br/ws/%s/json", cep),
                        ViaCepResultDto.class);

        return response.getBody();
    }
}
