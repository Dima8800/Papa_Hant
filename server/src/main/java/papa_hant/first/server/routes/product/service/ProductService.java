package papa_hant.first.server.routes.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import papa_hant.first.server.App.models.Response.Types.Response;
import papa_hant.first.server.App.models.Response.Types.ResponseData;
import papa_hant.first.server.routes.product.entity.Product;
import papa_hant.first.server.routes.product.entity.dto.ProductDto;
import papa_hant.first.server.routes.product.entity.dto.SortDto;
import papa_hant.first.server.routes.product.repository.ProductRepository;
import papa_hant.first.server.routes.typeProduct.service.TypeProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    private final TypeProductService typeProductService;

    // TODO: Проверка на админа

    public Response saveProduct(ProductDto dto){
        try {
            this.repository.save(new Product(dto,
                    typeProductService.findByIdNotAuth(
                            dto.getType()
                    )));
            return new Response(HttpStatus.CREATED.value(), "Успешно создано");
        }catch (Exception err){
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), err.getMessage());
        }
    }

    public Response findById(Long id){
        try {
            return new ResponseData<>(
                    HttpStatus.OK.value(),
                    "Успешно получено",
                    this.repository.findById(id));
        }catch (Exception err){
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), err.getMessage());
        }
    }

    // TODO: Проверка на админа

    public Response setDiscountById(Long id, int discount){
        try {
            Product product = this.repository.findById(id).get();

            if (product == null){
                return new Response(HttpStatus.NOT_FOUND.value(), "Такого товара нет");
            }

            product.setDiscount(discount);
            this.repository.save(product);

            return new Response(HttpStatus.OK.value(), "Успешно сохранено");
        }catch (Exception err){
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), err.getMessage());
        }
    }

    //TODO: Проверку на админа

    public Response deleteById(Long id){
        try {
            this.repository.deleteById(id);
            return new Response(HttpStatus.OK.value(), "Успешно удалено");
        }catch (Exception err){
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), err.getMessage());
        }
    }

    //TODO: Проверку на админа

    public Response editProduct(Long id, ProductDto dto){
        try {
            Product product = this.repository.findById(id).get();

            if (product == null){
                return new Response(HttpStatus.NOT_FOUND.value(), "Такого товара нет");
            }

            product.setName(dto.getName());
            product.setPrice(dto.getPrice());
            product.setColor(dto.getColor());
            product.setDescription(dto.getDescription());

            this.repository.save(product);
            return new Response(HttpStatus.OK.value(), "Успешно обновлено");
        }catch (Exception err){
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), err.getMessage());
        }
    }

    public Response findAllByTypeAndPage(int page, int limit, Long type){
        try {
            Pageable pageable = PageRequest.of(page, limit);

            if (type == null){
                return new ResponseData<>(HttpStatus.OK.value(),
                        "Успешно получено",
                        this.repository.findAll(pageable));
            }

            return new ResponseData<>(HttpStatus.OK.value(),
                    "Успешно получено",
                    this.repository.findAllByType(
                            typeProductService.findByIdNotAuth(type),
                            pageable)
            );
        }catch (Exception err){
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), err.getMessage());
        }
    }
}
