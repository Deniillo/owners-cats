package itmo.deniill.service.services;

import itmo.deniill.OwnerDto;

public interface OwnerMutableService {
    void createOwner(OwnerDto ownerDto);
    void deleteOwnerById(int ownerId);
}
