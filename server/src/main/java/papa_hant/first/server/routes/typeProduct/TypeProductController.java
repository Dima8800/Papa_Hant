package papa_hant.first.server.routes.typeProduct;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import papa_hant.first.server.App.models.Response.Types.Response;
import papa_hant.first.server.routes.typeProduct.entity.dto.TypeProductDto;
import papa_hant.first.server.routes.typeProduct.service.TypeProductService;

@Tag(name = "Сервис типов товара (админ)")
@RestController
@RequestMapping("/typeProduct")
@RequiredArgsConstructor
public class TypeProductController {
    private final TypeProductService service;

    @PostMapping
    @Operation(summary = "Добавить новый тип товара")
    public Response saveType(@RequestBody TypeProductDto typeProductDto){
        return this.service.saveType(typeProductDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить существующий тип")
    public Response updateType(@PathVariable Long id, @RequestBody TypeProductDto typeProductDto){
        return this.service.updateType(id, typeProductDto);
    }

    @Operation(summary = "Удалить тип товара")
    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Long id){
        return this.service.deleteById(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Найти один тип")
    public Response findById(@PathVariable Long id){
        return this.service.findById(id);
    }

    @GetMapping
    @Operation(summary = "Получить все типы товаров")
    public Response findAll(){
        return this.service.findAll();
    }
}
