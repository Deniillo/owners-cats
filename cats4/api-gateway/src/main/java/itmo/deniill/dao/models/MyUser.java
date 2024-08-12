package itmo.deniill.dao.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(nullable = true)
    private int ownerId;

    public MyUser(String username, String password, Role role, int ownerId) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.ownerId = ownerId;
    }
}
