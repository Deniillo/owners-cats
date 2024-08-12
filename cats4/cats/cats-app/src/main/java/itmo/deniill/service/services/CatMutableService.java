package itmo.deniill.service.services;

import itmo.deniill.models.CatIdContext;
import itmo.deniill.models.FriendshipContext;
import itmo.deniill.models.CreateCatContext;

public interface CatMutableService {
    void createCat(CreateCatContext message);
    void friendship(FriendshipContext message);
    void unFriendship(FriendshipContext message);
    void deleteCatById(CatIdContext messaged);
}
