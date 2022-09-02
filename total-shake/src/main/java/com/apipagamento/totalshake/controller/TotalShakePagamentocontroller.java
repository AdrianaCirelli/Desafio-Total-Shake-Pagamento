package com.apipagamento.totalshake.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestController
@RequestMapping("")
public class TotalShakePagamentocontroller {
    @GetMapping
    public HashMap<String, Object> healthCheck() {
        var response = new HashMap<String, Object>();
        response.put("api", "Total Shake Pagamento API");
        response.put("status",200);
        response.put("timestamp", LocalDateTime.now());
        return response;
    }

}
