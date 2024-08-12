package itmo.deniill.service.dto;

import itmo.deniill.dao.models.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private int id;
    private String username;
    private String password;
    private Role role;
    private int ownerId;

    public UserDto(int id, String username, String password, Role role, int ownerId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.ownerId = ownerId;
    }
}
