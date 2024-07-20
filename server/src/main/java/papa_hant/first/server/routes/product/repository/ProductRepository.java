package papa_hant.first.server.routes.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import papa_hant.first.server.routes.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
