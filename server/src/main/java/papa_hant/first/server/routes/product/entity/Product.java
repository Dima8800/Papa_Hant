package papa_hant.first.server.routes.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import papa_hant.first.server.routes.product.entity.dto.ProductDto;
import papa_hant.first.server.routes.typeProduct.entity.TypeProduct;

@Data
@Entity
@Table(name = "Product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String color; // с маленькой буквы

    @Column
    private String price;

    @Column
    private int discount = 0; // значение указывается в процентах

    public Product(ProductDto dto, TypeProduct type) {
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.price = dto.getPrice();
        this.color = dto.getColor();
        this.type = type;
    }

    @ManyToOne
    private TypeProduct type;

//    @Column
//    private Long idVideo;

//    @Column
//    private Long idPhoto;
}
