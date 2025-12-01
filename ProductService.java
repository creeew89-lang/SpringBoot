package tra.codline.almuiayed.inventory;

import java.util.List;
import tra.codline.almuiayed.inventory.dto.ProductRequest;
import tra.codline.almuiayed.inventory.dto.ProductResponse;;

public interface ProductService {
    ProductResponse create(ProductRequest request);
    List <ProductResponse> getAllActive();
    ProductResponse getById(Long id);
    ProductResponse update(Long id, ProductRequest request);
    void softDelete(Long id);
}
