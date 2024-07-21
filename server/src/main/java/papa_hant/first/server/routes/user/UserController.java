package papa_hant.first.server.routes.user;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import papa_hant.first.server.App.models.Response.Types.Response;
import papa_hant.first.server.routes.user.dto.codeDto;
import papa_hant.first.server.routes.user.service.UserService;

@Tag(name = "Сервис пользователей (админ)")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public Response saveUser(@RequestHeader String phoneNumber, @RequestBody String fullName){
        return this.userService.saveUser(phoneNumber, fullName);
    }

    @PostMapping("/code")
    public Response chekCode(@RequestBody codeDto login){
        return this.userService.checkCode(login.getPhone(), login.getCode());
    }

    @GetMapping("/{id}")
    public Response getUserById(@RequestHeader String Authorization, @PathVariable Long id){
        return this.userService.getUserById(Authorization, id);
    }

    @PutMapping("/ban/{id}")
    public Response banUserById(@RequestHeader String Authorization, @PathVariable Long id, @RequestBody String banReason){
        return this.userService.banUserById(Authorization, id, banReason);
    }

    @PutMapping("/admin/{id}")
    public Response setAdmin(@PathVariable Long id){
        return this.userService.setAdmin(id);
    }
}