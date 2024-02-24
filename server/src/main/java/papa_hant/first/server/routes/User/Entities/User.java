package papa_hant.first.server.routes.User.Entities;

import lombok.Data;
import javax.persistence.*;
import org.springframework.stereotype.Repository;

@Data
@Entity
@Repository
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_User")
    private long id;

    @Column(name = "phone", length = 20, unique = true)
    private String phone;

    @Column(name = "role", length = 50)
    private String role;
}
