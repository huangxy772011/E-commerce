package com.ascending.famulei.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "invt_id_seq")
    @SequenceGenerator(name = "invt_id_seq", sequenceName = "invt_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "department")
    private String department;

    @Column(name = "category")
    private String category;

    @Column(name = "amount")
    private int amount;

    @Column(name = "location")
    private String location;


    @ManyToOne(fetch = FetchType.LAZY)
    // lazy vs. eager
    @JoinColumn (name = "vendor_id")
    private Vendor vendor;

    public void setDepartment(String food) {
        this.department = food;
    }

    public Long getId() {
        return this.id;
    }

//    public Long getId() {
//        return id;
//    }
//
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public Vendor getVendor() {
//        return vendor;
//    }
//
//    public void setVendor(Vendor vendor) {
//        this.vendor = vendor;
//    }

}
