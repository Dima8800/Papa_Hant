package papa_hant.first.server.routes.typeProduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import papa_hant.first.server.routes.typeProduct.entity.TypeProduct;

@Repository
public interface TypeProductRepository extends JpaRepository<TypeProduct, Long> {
    TypeProduct findByName(String name);
}
