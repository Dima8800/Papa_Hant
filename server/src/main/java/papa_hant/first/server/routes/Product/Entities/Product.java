package papa_hant.first.server.routes.Product.Entities;

import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Data
@Entity
@Repository
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id_product", columnDefinition = "BIGINT", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Lob
    @Column(name = "image")
    private byte[] image;
}
