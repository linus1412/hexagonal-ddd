package uk.co.smitek.dddhex.products.application.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Identity;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@AggregateRoot
@Getter
@Setter
public class Product {

    private static AtomicLong idGenerator = new AtomicLong(0);

    @Identity
    private ProductId id;

    private UUID code;

    private String name;

    private String description;

    private Product(ProductId id, UUID code, String name, String description) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public static Product createProduct(String name, String description) {
        return new Product(
                new ProductId(idGenerator.getAndIncrement()),
                UUID.randomUUID(),
                name,
                description
        );
    }

}
