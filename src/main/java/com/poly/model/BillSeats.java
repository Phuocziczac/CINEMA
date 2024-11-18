package com.poly.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Bill_Seats")
public class BillSeats {

    @EmbeddedId
    private BillSeatsId id;

    @ManyToOne
    @MapsId("billId")
    @JoinColumn(name = "Bill_ID", referencedColumnName = "id", nullable = false)
    private Bill bill;

    @ManyToOne
    @MapsId("seatId")
    @JoinColumn(name = "Seat_ID", referencedColumnName = "id", nullable = false)
    private Seat seat;
}
