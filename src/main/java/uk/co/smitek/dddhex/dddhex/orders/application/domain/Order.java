package uk.co.smitek.dddhex.dddhex.orders.application.domain;

import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Identity;

import java.util.List;

@AggregateRoot
public class Order {

    @Identity
    private Long id;

    private List<LineItem> lineItems;

    public void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }

}
