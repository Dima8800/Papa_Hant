package papa_hant.first.server.routes.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import papa_hant.first.server.App.models.Response.Types.Response;
import papa_hant.first.server.App.models.Response.Types.ResponseData;
import papa_hant.first.server.routes.token.TokenService;
import papa_hant.first.server.routes.user.entities.Role;
import papa_hant.first.server.routes.user.entities.User;
import papa_hant.first.server.routes.user.repository.UserRepository;

import java.util.Optional;

/**
 * ## Сервис пользователей
 *
 * @author Горелов Дмитрий
 * */

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    private final TimedMap code;

    private final TokenService tokenService;

    /**
     * Заргестрировать пользователя
     * */

    public Response saveUser(String phoneNumber, String fullname){
        try {
            this.code.put(phoneNumber,
                    phoneNumber.charAt(3) + phoneNumber.charAt(5) + phoneNumber.charAt(6) + phoneNumber.charAt(8)
            );

            if (repository.findByPhone(phoneNumber) != null){
                return new ResponseData<>(HttpStatus.OK.value(), "Пользователь зарегистрирован", this.repository.findByPhone(phoneNumber));
            }

            this.repository.save(new User(phoneNumber, fullname, Role.unAuth));
            return new Response(HttpStatus.OK.value(), "Пользователь не зарегистрирован");
        }catch (Exception err){
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), err.getMessage());
        }
    }

    /**
     * Проверка кода авторизации пользователя
     * */

    public Response checkCode(String phoneNubmer, Integer code){
        try {
            if (this.code.get(phoneNubmer) == code){
                User user = this.repository.findByPhone(phoneNubmer);
                user.setRole(Role.user);

                this.repository.save(user);
                return new ResponseData<>(HttpStatus.OK.value(), "Успешная авторизация",
                        tokenService.generateToken(this.repository.findByPhone(phoneNubmer)
                ));
            }
            return new Response(HttpStatus.UNAUTHORIZED.value(), "Неверный код");
        }catch (Exception err){
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), err.getMessage());
        }
    }

    /**
     * Получить пользователя по id (Может только админ)
     * */

    public Response getUserById(String Authorization, Long id){
        try {
            if (!roleVerification(Authorization)){
                return new Response(HttpStatus.FORBIDDEN.value(), "Нет доступа");
            }

            Optional<User> user = this.repository.findById(id);

            if (user.isEmpty()){
                return new Response(HttpStatus.NOT_FOUND.value(), "Такого пользователя нет");
            }

            return new ResponseData<>(HttpStatus.OK.value(), "Успешно получено", user.get());
        }catch (Exception err){
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), err.getMessage());
        }
    }

    /**
     * Заблокировать пользователя по id (Может только админ)
     * */

    public Response banUserById(String Authorization, Long id, String banReason){
        try {
            if (!roleVerification(Authorization)){
                return new Response(HttpStatus.FORBIDDEN.value(), "Нет доступа");
            }

            Optional<User> current = this.repository.findById(id);

            if (current.isEmpty()){
                return new Response(HttpStatus.NOT_FOUND.value(), "Такого пользователя нет");
            }

            User user = current.get();
            user.setBanned(true);
            user.setBanReason(banReason);

            this.repository.save(user);
            return new Response(HttpStatus.OK.value(), "Успешно забанен");
        }catch (Exception err){
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), err.getMessage());
        }
    }

    /**
     * Сделать пользователя админом
     * */

    public Response setAdmin(Long id){
        try {
            User user = this.repository.findById(id).get();
            user.setRole(Role.admin);

            this.repository.save(user);
            return new Response(HttpStatus.OK.value(), "Успешно выолпнеон");
        }catch (Exception err){
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), err.getMessage());
        }
    }

    public User getUser(String Authorization){
        try {
            return this.repository.findById(
                    this.tokenService.getUserIdFromJWT(Authorization)
            ).get();
        }catch (Exception err){
            throw new RuntimeException(err.getMessage());
        }
    }

    public boolean roleVerification(String Authorization){
        User admin = this.repository.findById(
                tokenService.getUserIdFromJWT(Authorization)
        ).get();

        if (admin.getRole() == Role.admin){
            return true;
        }
        return false;
    }
}
