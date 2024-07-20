package papa_hant.first.server.routes.product;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import papa_hant.first.server.App.models.Response.Types.Response;
import papa_hant.first.server.routes.product.service.ProductService;

@Tag(name = "Сервис товаров")
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    public Response saveProduct(){
        return null;
    }

    public Response editProduct(){
        return null;
    }

    public Response deleteById(){
        return null;
    }

    public Response findById(){
        return null;
    }

    public Response findAllByPage(){
        return null;
    }

    public Response findAllByTypeAndPage(){
        return null;
    }
}
