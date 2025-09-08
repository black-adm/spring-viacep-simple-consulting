package com.syscode42.viacep.controller;

import com.syscode42.viacep.dto.ViaCepResultDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("consulta-cep")
public class ViaCepController {

    private final WebClient client;

    public ViaCepController(WebClient client) {
        this.client = client;
    }

    @GetMapping("{cep}")
    public Mono<ViaCepResultDto> search(@PathVariable("cep") String cep) {
        String url = "https://viacep.com.br/ws/%s/json";

        return client.get()
                .uri(String.format(url, cep))
                .retrieve()
                .bodyToMono(ViaCepResultDto.class);
    }
}
