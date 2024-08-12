package itmo.deniill.service.specification;

import lombok.Data;

@Data
public class CatFilter {
    private CatFields field;
    private String value;

    public CatFilter(CatFields field, String value) {
        this.field = field;
        this.value = value;
    }
}
