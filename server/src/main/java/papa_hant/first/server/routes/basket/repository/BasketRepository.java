package papa_hant.first.server.routes.basket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import papa_hant.first.server.routes.basket.entity.Basket;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
