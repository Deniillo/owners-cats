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
public class CatIdContext {
    private Integer catId;
    private Integer ownerId;
}
