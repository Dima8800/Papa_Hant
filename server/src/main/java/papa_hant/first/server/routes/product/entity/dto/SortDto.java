package papa_hant.first.server.routes.product.entity.dto;

import lombok.Data;

@Data
public class SortDto {
    private int page;

    private int limit;

    private Long Type;
}
