package tra.codline.almuiayed.inventory.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tra.codline.almuiayed.inventory.dto.ProductRequest;
import tra.codline.almuiayed.inventory.dto.ProductResponse;
import tra.codline.almuiayed.inventory.ProductService;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid
                                                  @RequestBody ProductRequest request) {
        return
                ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllActive(){
        return ResponseEntity.ok(service.getAllActive());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse>
    getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse>
    update(@PathVariable Long id, @Valid @RequestBody ProductRequest request){
     return ResponseEntity.ok(service.update(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> softDelete(@PathVariable Long id){
        service.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
