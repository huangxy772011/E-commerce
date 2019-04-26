package com.ascending.famulei.domain;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "vendor_id_seq")
    @SequenceGenerator(name = "vendor_id_seq", sequenceName = "vendor_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "department")
    private String department;

    @Column(name = "email")
    private String email;

    @Column(name = "location")
    private String location;

    @Column(name = "amount")
    private int amount;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vendor", cascade = CascadeType.ALL)
    private List<Inventory> inventory;

//    public void setDepartment(String food) {
//        this.department = food;
//    }
//
//    public Long getId() {
//        return this.id;
//    }
}

