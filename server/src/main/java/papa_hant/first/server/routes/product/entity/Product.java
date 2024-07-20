package papa_hant.first.server.routes.product.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String price;

    @Column
    private int discount = 0; // значение указывается в процентах

//    @Column
//    private Long id_photo;
}
