package papa_hant.first.server.routes.product;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import papa_hant.first.server.App.models.Response.Types.Response;
import papa_hant.first.server.routes.product.entity.dto.SortDto;
import papa_hant.first.server.routes.product.entity.dto.ProductDto;
import papa_hant.first.server.routes.product.service.ProductService;

@Tag(name = "Сервис товаров")
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping()
    public Response saveProduct(@RequestBody ProductDto dto){
        return this.service.saveProduct(dto);
    }

    @PutMapping("/discount/{id}")
    public Response setDiscountById(@PathVariable Long id, @RequestBody int discount){
        return this.service.setDiscountById(id, discount);
    }

    @PutMapping("/{id}")
    public Response editProduct(@PathVariable Long id, @RequestBody ProductDto dto){
        return this.service.editProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Long id){
        return this.service.deleteById(id);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable Long id){
        return this.service.findById(id);
    }

    @GetMapping
    public Response findAllByTypeAndPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int limit, @RequestParam(required = false) Long type) {
        return this.service.findAllByTypeAndPage(page, limit, type);
    }
}
