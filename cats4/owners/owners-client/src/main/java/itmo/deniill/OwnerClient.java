package itmo.deniill;

import java.util.List;

public interface OwnerClient {
    OwnerDto getOwnerById(int ownerId);
    List<OwnerDto> getAllOwners();
}
