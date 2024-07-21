package papa_hant.first.server.routes.typeProduct.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import papa_hant.first.server.App.models.Response.Types.Response;
import papa_hant.first.server.App.models.Response.Types.ResponseData;
import papa_hant.first.server.routes.typeProduct.entity.TypeProduct;
import papa_hant.first.server.routes.typeProduct.entity.dto.TypeProductDto;
import papa_hant.first.server.routes.typeProduct.repository.TypeProductRepository;
import papa_hant.first.server.routes.user.service.UserService;

/**
 * ## Сервис типов товара
 *
 * @author Горелов Дмитрий
 * */

@Service
@RequiredArgsConstructor
public class TypeProductService {
    private final TypeProductRepository repository;

    private final UserService userService;

    /**
     * Добавить новый Тип
     * */

    public Response saveType(TypeProductDto dto, String token){
        try {
            if (!userService.roleVerification(token)){
                return new Response(HttpStatus.FORBIDDEN.value(), "Нет доступа");
            }

            if (this.repository.findByName(dto.getName()) != null){
                return new Response(HttpStatus.CONTINUE.value(), "Товар с таким именем уже есть");
            }

            this.repository.save(new TypeProduct(
                    dto.getName(),
                    dto.getDescription()
            ));
            return new Response(HttpStatus.CREATED.value(), "Успешно создано");
        }catch (Exception err){
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), err.getMessage());
        }
    }

    /**
     * Изменить существующий Тип
     * */

    public Response updateType(Long id, TypeProductDto dto, String token){
        try {
            if (!userService.roleVerification(token)){
                return new Response(HttpStatus.FORBIDDEN.value(), "Нет доступа");
            }

            TypeProduct type = this.repository.findById(id).get();

            if (type == null){
                return new Response(HttpStatus.NOT_FOUND.value(), "Такого типа нет");
            }

            type.setDescription(dto.getDescription());
            type.setName(dto.getName());

            this.repository.save(type);
            return new Response(HttpStatus.OK.value(), "Успешно обновлено");
        }catch (Exception err){
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), err.getMessage());
        }
    }

    /**
     * Удалить Тип
     * */

    // TODO : Добавить проверку, что не используется в товарах

    public Response deleteById(Long id, String token){
        try {
            if (!userService.roleVerification(token)){
                return new Response(HttpStatus.FORBIDDEN.value(), "Нет доступа");
            }

            this.repository.deleteById(id);
            return new Response(HttpStatus.OK.value(), "Успешно удалено");
        }catch (Exception err){
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), err.getMessage());
        }
    }

    /**
     * Найти один Тип
     * */

    public Response findById(Long id, String token){
        try {
            if (!userService.roleVerification(token)){
                return new Response(HttpStatus.FORBIDDEN.value(), "Нет доступа");
            }

            return new ResponseData<>(HttpStatus.OK.value(),
                    "Успешно получено",
                    this.repository.findById(id));
        }catch (Exception err){
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), err.getMessage());
        }
    }

    /**
     * Найти все типы
     * */

    public Response findAll(){
        try {
            return new ResponseData<>(HttpStatus.OK.value(),
                    "Успешно получено",
                    this.repository.findAll());
        }catch (Exception err){
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), err.getMessage());
        }
    }

    public TypeProduct findByIdNotAuth(Long id){
        try {
            return this.repository.findById(id).get();
        }catch (Exception err){
            System.out.println(err.getMessage());
            return null;
        }
    }
}
