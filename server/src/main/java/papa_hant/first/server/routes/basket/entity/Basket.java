package papa_hant.first.server.routes.basket.entity;

import jakarta.persistence.*;
import lombok.Data;
import papa_hant.first.server.routes.product.entity.Product;
import papa_hant.first.server.routes.user.entities.User;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column
    private BasketType type;

    @ElementCollection
    private List<Product> products;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime paidAt;

    @Column(length = 20)
    private String contactPhone;

    @Column
    private int Price;

    public Basket() {
        this.createdAt = LocalDateTime.now();
    }
}
