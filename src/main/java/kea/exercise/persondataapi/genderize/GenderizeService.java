package kea.exercise.persondataapi.genderize;

import kea.exercise.persondataapi.agify.AgifyResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class GenderizeService {
    private final WebClient webClient;

    public GenderizeService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.genderize.io").build();
    }

    public GenderizeResponse getGenderizeResponse(String fullName) {
        System.out.println("fullName: " + fullName);
        return webClient.get()
                .uri("?name=" + fullName)
                .retrieve()
                .bodyToMono(GenderizeResponse.class)
                .block();
    }
}
