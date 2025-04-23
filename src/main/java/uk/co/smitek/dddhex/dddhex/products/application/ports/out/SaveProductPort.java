package uk.co.smitek.dddhex.dddhex.products.application.ports.out;

import uk.co.smitek.dddhex.dddhex.products.application.domain.model.Product;

public interface SaveProductPort {
    void save(Product product);
}
