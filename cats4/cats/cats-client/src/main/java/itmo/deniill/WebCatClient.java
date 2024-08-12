package itmo.deniill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class WebCatClient implements CatClient{
    String baseUrl = "http://localhost:8034/cats/";

    @Override
    public List<CatDto> getCatsByCriteria(String id, String name, String breed, String colour, String ownerId) {
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String url = baseUrl;
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParamIfPresent("id", Optional.ofNullable(id))
                .queryParamIfPresent("breed", Optional.ofNullable(breed))
                .queryParamIfPresent("colour", Optional.ofNullable(colour))
                .queryParamIfPresent("name", Optional.ofNullable(name))
                .queryParamIfPresent("ownerId", Optional.ofNullable(ownerId));

        CatDto[] cats = restTemplate.getForObject(builder.toUriString(), CatDto[].class);
        if (cats != null) {
            return new ArrayList<>(Arrays.asList(cats));
        } else {
            return null;
        }
    }
}
