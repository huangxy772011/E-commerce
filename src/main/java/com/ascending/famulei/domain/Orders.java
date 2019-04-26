package com.ascending.famulei.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "orders_id_seq")
    @SequenceGenerator(name = "orders_id_seq", sequenceName = "orders_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "time_ordered")
    private String timeOrdered;

    @Column(name = "amount")
    private long amount;


    @ManyToOne(fetch = FetchType.LAZY)
    // lazy vs. eager
    @JoinColumn (name = "customer_id")
    private Customer customer;

    public void setOrderName(String iphoneCase) {
        this.orderName = iphoneCase;
    }

    public Long getId() {
        return this.id;
    }

}
