package uk.co.smitek.dddhex.dddhex.orders.application.domain;

import org.jmolecules.ddd.annotation.ValueObject;
import uk.co.smitek.dddhex.dddhex.common.ProductId;

@ValueObject
public record LineItem(ProductId id, LineItem lineItem) {

}
