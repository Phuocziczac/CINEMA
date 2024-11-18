package com.poly.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Bill_Services")
public class BillService {

    @EmbeddedId
    private BillServicesId id;

    @ManyToOne
    @MapsId("billId")
    @JoinColumn(name = "Bill_ID", referencedColumnName = "id", nullable = false)
    private Bill bill;

    @ManyToOne
    @MapsId("servicesId")
    @JoinColumn(name = "Services_ID", referencedColumnName = "id", nullable = false)
    private Service services;

    @Column(name = "Quantity", nullable = false)
    private int quantity;
}
