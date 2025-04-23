package uk.co.smitek.dddhex.dddhex.products.adaptors.in;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.smitek.dddhex.dddhex.common.ProductId;
import uk.co.smitek.dddhex.dddhex.products.application.ports.in.AddProductUseCase;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
class AddProductRestController {

    private final AddProductUseCase addProductUseCase;

    public record ProductView(
            Long id,
            String name,
            String description
    ) {}

    public record AddProductRequest(String name,
                             String description) {}

    @PostMapping
    public ProductId addProduct(AddProductRequest request) {

        ProductId productId = addProductUseCase.execute(new AddProductUseCase.AddProductCommand(request.name(), request.description(), new BigDecimal("1.23")));

        return productId;
    }


}
