package tra.codline.almuiayed.inventory.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

        @NotBlank private String name;
        @NotBlank private String category;
        @DecimalMin("0.01") private BigDecimal price;
        @Min(0) private Integer availableQuantity;
    }
