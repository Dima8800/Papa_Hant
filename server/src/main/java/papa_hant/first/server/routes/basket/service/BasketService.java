package papa_hant.first.server.routes.basket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import papa_hant.first.server.routes.basket.repository.BasketRepository;

/**
 * ## Сервис корзины
 *
 * @author Горелов Дмитрий
 * */

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository repository;
}
