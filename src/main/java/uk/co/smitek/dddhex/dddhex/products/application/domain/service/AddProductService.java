package uk.co.smitek.dddhex.dddhex.products.application.domain.service;

import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;
import uk.co.smitek.dddhex.dddhex.common.ProductId;
import uk.co.smitek.dddhex.dddhex.products.application.domain.model.Product;
import uk.co.smitek.dddhex.dddhex.products.application.ports.in.AddProductUseCase;
import uk.co.smitek.dddhex.dddhex.products.application.ports.out.SaveProductPort;

@Application
@Service
@RequiredArgsConstructor
class AddProductService implements AddProductUseCase {

    private final SaveProductPort saveProductPort;

    @Override
    public ProductId execute(AddProductCommand command) {

        Product product = Product.createProduct(command.name(), command.description());
        saveProductPort.save(product);

        return product.getId();
    }
}
