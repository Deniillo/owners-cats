package itmo.deniill.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
@Jacksonized
public class FriendshipContext {
    private Integer catId1;
    private Integer catId2;
    private Integer ownerId;
}
