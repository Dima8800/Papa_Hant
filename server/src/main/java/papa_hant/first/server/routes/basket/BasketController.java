package papa_hant.first.server.routes.basket;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import papa_hant.first.server.App.models.Response.Types.Response;
import papa_hant.first.server.routes.basket.entity.BasketType;
import papa_hant.first.server.routes.basket.service.BasketService;

@Tag(name = "Сервис корзины")
@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService service;

    @PostMapping
    @Operation(description = "Добавить новый товар в корзину")
    public Response saveBasket(@RequestHeader String Authorization, @RequestBody Long id_Product){
        return null;
    }

    @GetMapping
    @Operation(description = "Получить корзину пользователя")
    public Response findBasketByUser(@RequestHeader String Authorization){
        return null;
    }

    @GetMapping("/{id}")
    @Operation(description = "Получить корзину по id (для админа)")
    public Response findBasketById(@RequestHeader String Authorization, @PathVariable Long id){
        return null;
    }

    @GetMapping("/all")
    @Operation(description = "Получить все корзины по типу (для админа)")
    public Response findBasketsByType(@RequestHeader String Authorization, @RequestBody BasketType type){
        return null;
    }
}