package itmo.deniill.service.services;

import itmo.deniill.CatDto;

import java.util.List;

public interface CatImmutableService {
    List<CatDto> getCatsByCriteria(String id, String name, String breed, String colour, String ownerId);
}
