package papa_hant.first.server.routes.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import papa_hant.first.server.routes.product.entity.Product;
import papa_hant.first.server.routes.typeProduct.entity.TypeProduct;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByType(TypeProduct type, Pageable pageable);
}
