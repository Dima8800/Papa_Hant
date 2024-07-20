package papa_hant.first.server.routes.user.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "UserEntity")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_User")
    private long id;

    @Column(name = "phone", length = 20, unique = true)
    private String phone;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private String banReason;

    @Column
    private boolean banned;

    public User(String phone, String fullName,Role role){
        this.phone = phone;
        this.role = role;
        this.surname = fullName.split(" ")[0];
        this.name = fullName.split(" ")[1];
        this.banned = false;
    }
}
