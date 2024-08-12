package itmo.deniill;

import java.util.List;

public interface CatClient {
    List<CatDto> getCatsByCriteria(String id, String name, String breed, String colour, String ownerId);
}
