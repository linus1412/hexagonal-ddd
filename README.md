# Sample of a hexagonal architecture project using DDD

This branch secondary-access is a reproducer.

It aims to highlight the differences between @SecondaryPort classes and @SecondaryAdapter classes being able to reference @Application classes.

```java
@Application // (in ...application.domain.model package-info.java
@AggregateRoot
public class Product {
}
```

```java
@SecondaryPort // (in ...application.ports.out package-info.java)
public interface SaveProductPort {
    void save(Product product);
}
```

```java
@SecondaryAdapter // (in ...adaptors.out package-info.java)
@Component
class SaveProductAdaptor implements SaveProductPort {
    @Override
    public void save(Product product) {
    }
}
```

in HexagonalDddTest there are two ArchUnit tests validating the JMolecules Hexagonal Architecture rules with different strictness levels:
- secondariesCanAccessApplication_When_SEMI_STRICT
- secondariesCanAccessApplication_When_STRICT

#### secondariesCanAccessApplication_When_SEMI_STRICT
This test fails as SaveProductPort is not allowed to reference Product.  I would expect both SaveProductPort and SaveProductAdapter to be able to access the Product class, but only the adaptor can.  This makes no sense as the adaptor is an implementation of the SaveProductPort interface

### secondariesCanAccessApplication_When_STRICT
This test passes as expected as neither SaveProductPort nor SaveProductAdapter can reference the Product class.
