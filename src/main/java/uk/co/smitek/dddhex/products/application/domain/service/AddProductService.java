package uk.co.smitek.dddhex.products.application.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.smitek.dddhex.products.application.domain.model.Product;
import uk.co.smitek.dddhex.products.application.ports.in.AddProductUseCase;
import uk.co.smitek.dddhex.products.application.ports.out.SaveProductPort;

@Service
@RequiredArgsConstructor
class AddProductService implements AddProductUseCase {

    private final SaveProductPort saveProductPort;

    @Override
    public Long execute(AddProductCommand command) {

        Product product = Product.createProduct(command.name(), command.description());
        saveProductPort.save(product);

        return product.getId().value();
    }
}
