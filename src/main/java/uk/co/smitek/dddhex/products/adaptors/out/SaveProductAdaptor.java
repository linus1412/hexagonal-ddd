package uk.co.smitek.dddhex.products.adaptors.out;

import org.springframework.stereotype.Component;
import uk.co.smitek.dddhex.products.application.domain.model.Product;
import uk.co.smitek.dddhex.products.application.ports.out.SaveProductPort;

@Component
class SaveProductAdaptor implements SaveProductPort {

    @Override
    public void save(Product product) {

    }

}
