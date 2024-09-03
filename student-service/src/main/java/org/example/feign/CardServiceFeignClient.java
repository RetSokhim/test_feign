package org.example.feign;

import org.example.model.request.CardRequest;
import org.example.model.response.CardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "card-service",url = "http://localhost:8082/api/v1/card")
public interface CardServiceFeignClient {
    @GetMapping("get-card/{cardId}")
    CardResponse getCardById(@PathVariable Long cardId);

    @PostMapping("create-card")
    CardResponse createCardById(@RequestBody CardRequest cardRequest);

    @GetMapping("get-card-by-student/{studentId}")
    CardResponse getCardByStudentId(@PathVariable Long studentId);

    @DeleteMapping("delete-card-by-student/{studentId}")
    void deleteCardByStudentById(@PathVariable Long studentId);

    @PutMapping("update-card")
    CardResponse updateCardByStudentId(@RequestBody CardRequest cardRequest);
}
