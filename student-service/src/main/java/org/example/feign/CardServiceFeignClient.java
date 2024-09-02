package org.example.feign;

import org.example.model.request.CardRequest;
import org.example.model.response.CardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "card-service",url = "http://localhost:8082/api/v1/card")
public interface CardServiceFeignClient {
    @GetMapping("get-card/{cardId}")
    CardResponse getCardById(@PathVariable Long cardId);

    @PostMapping("create-card")
    CardResponse createCardById(@RequestBody CardRequest cardRequest);
}
