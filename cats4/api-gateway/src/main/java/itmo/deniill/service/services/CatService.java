package itmo.deniill.service.services;

import itmo.deniill.CatDto;

import java.util.List;

public interface CatService {
    void createCat(CatDto catDto, Integer ownerId);
    void friendship(int catId1, int catId2, Integer ownerId);
    void unFriendship(int catId1, int catId2, Integer ownerId);
    void deleteCatById(int catId, Integer ownerId);
    List<CatDto> getCatsByCriteria(String id, String name, String breed, String colour, String ownerId);
}
