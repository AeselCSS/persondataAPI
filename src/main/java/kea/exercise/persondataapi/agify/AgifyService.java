package kea.exercise.persondataapi.agify;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AgifyService {
    private final WebClient webClient;

    public AgifyService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.agify.io").build();
    }
}
