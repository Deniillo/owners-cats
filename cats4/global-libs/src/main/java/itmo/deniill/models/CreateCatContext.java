package itmo.deniill.models;

import itmo.deniill.CatDto;
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
public class CreateCatContext {
    private CatDto catDto;
    private Integer ownerId;
}