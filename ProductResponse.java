package tra.codline.almuiayed.inventory.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductResponse {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private Boolean active;
}
