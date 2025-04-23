package uk.co.smitek.dddhex.products.application.ports.in;

import java.math.BigDecimal;

public interface AddProductUseCase {

    record AddProductCommand(String name, String description, BigDecimal price) {
    }

    Long execute(AddProductCommand command);

}
