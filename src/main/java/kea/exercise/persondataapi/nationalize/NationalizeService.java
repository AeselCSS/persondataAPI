package kea.exercise.persondataapi.nationalize;

import kea.exercise.persondataapi.genderize.GenderizeResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NationalizeService {

    private final WebClient webClient;

    public NationalizeService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.nationalize.io").build();
    }

    public NationalizeResponse getNationalizeResponse(String fullName) {
        return webClient.get()
                .uri("?name=" + fullName)
                .retrieve()
                .bodyToMono(NationalizeResponse.class)
                .block();
    }
}
