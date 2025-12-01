package tra.codline.almuiayed.inventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tra.codline.almuiayed.inventory.model.Product;
import tra.codline.almuiayed.inventory.repositry.ProductRepository;
import tra.codline.almuiayed.inventory.ProductService;
import tra.codline.almuiayed.inventory.dto.ProductRequest;
import tra.codline.almuiayed.inventory.dto.ProductResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public ProductResponse create(ProductRequest request) {
        return null;
    }

    @Override
    public List<ProductResponse> getAllActive() {
        return List.of();
    }

    @Override
    public ProductResponse getById(Long id) {
        return null;
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        return null;
    }

    @Override

    public void softDelete(Long id){
        Product p = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        p.setActive(false);
        repository.save(p);
    }
    private ProductResponse toDto(Product p ){
        ProductResponse dto = new ProductResponse();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setPrice(p.getPrice().doubleValue());
        dto.setActive(p.isActive());
        return dto;
    }
}
