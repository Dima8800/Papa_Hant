package papa_hant.first.server.routes.product.entity.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String name;

    private String description;

    private String price;

    private String color;

    private Long type;
}
