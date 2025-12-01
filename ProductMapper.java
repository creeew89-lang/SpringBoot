package tra.codline.almuiayed.inventory;

import org.mapstruct.Mapper;
import tra.codline.almuiayed.inventory.dto.ProductResponse;
import tra.codline.almuiayed.inventory.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toResponse(Product product);
}
