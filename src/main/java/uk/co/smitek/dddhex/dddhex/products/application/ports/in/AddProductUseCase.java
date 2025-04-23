package uk.co.smitek.dddhex.dddhex.products.application.ports.in;

import uk.co.smitek.dddhex.dddhex.common.ProductId;

import java.math.BigDecimal;

public interface AddProductUseCase {

    record AddProductCommand(String name, String description, BigDecimal price) {
    }

    ProductId execute(AddProductCommand command);

}
