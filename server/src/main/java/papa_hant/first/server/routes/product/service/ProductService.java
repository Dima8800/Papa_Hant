package papa_hant.first.server.routes.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import papa_hant.first.server.routes.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
}
