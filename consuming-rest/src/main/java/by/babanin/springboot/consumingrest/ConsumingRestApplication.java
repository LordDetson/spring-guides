package by.babanin.springboot.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;

@SpringBootApplication
public class ConsumingRestApplication {

    private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);
    private static final String urlRandomQuoteJson = "https://gturnquist-quoters.cfapps.io/api/random";

    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner commandLineRunner(RestTemplate restTemplate) {
        return args -> {
            Quote quote = restTemplate.getForObject(urlRandomQuoteJson, Quote.class);
            log.info("{} from {}", quote, urlRandomQuoteJson);
        };
    }
}
