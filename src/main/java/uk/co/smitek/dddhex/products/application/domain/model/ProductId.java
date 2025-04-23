package uk.co.smitek.dddhex.products.application.domain.model;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record ProductId(Long value) {
}
