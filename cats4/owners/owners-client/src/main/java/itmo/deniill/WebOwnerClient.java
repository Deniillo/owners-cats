package itmo.deniill;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class WebOwnerClient implements OwnerClient {
    String baseUrl = "http://localhost:8035/owners/";
    @Override
    public OwnerDto getOwnerById(int ownerId) {
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String url = baseUrl + "ownerId?=%s".formatted(ownerId);
        return restTemplate.getForObject(url, OwnerDto.class);
    }

    @Override
    public List<OwnerDto> getAllOwners() {
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String url = baseUrl;
        OwnerDto[] owners = restTemplate.getForObject(url, OwnerDto[].class);
        if (owners != null) {
            return new ArrayList<>(Arrays.asList(owners));
        } else {
            return null;
        }
    }
}
