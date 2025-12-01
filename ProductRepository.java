package tra.codline.almuiayed.inventory.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import tra.codline.almuiayed.inventory.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository <Product, Long>{
    List <Product> findAllByActiveTrue();
    Optional <Product> findAllByActiveTrue(Long id);

}
