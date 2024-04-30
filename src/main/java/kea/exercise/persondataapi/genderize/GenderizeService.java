package kea.exercise.persondataapi.genderize;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GenderizeService {
    private final WebClient webClient;

    public GenderizeService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.genderize.io").build();
    }

    public GenderizeResponse getGenderizeResponse(String fullName) {
        return webClient.get()
                .uri("?name=" + fullName)
                .retrieve()
                .bodyToMono(GenderizeResponse.class)
                .block();
    }
}
