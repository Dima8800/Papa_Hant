package papa_hant.first.server.routes.Basket.Entities;

import lombok.Data;
import papa_hant.first.server.routes.Product.Entities.Product;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_user", length = 20)
    private Long idUser;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "basket_id")
    private List<Product> items;

    @Column(name = "price", length = 20)
    private String price;

    @Column(name = "status", length = 20)
    private String status;
}
