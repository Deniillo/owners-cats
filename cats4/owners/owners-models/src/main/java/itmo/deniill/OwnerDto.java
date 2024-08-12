package itmo.deniill;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Builder
@Jacksonized
@ToString
public class OwnerDto {
    private int id;
    private String name;
    private LocalDate birthday;

    public OwnerDto(int id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }
}