package com.poly.model;



import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode  // Tự động sinh equals và hashCode
public class BillSeatsId implements Serializable {
    private int bill;  // Kiểu dữ liệu của trường khóa chính trong entity Bill
    private int seat;  // Kiểu dữ liệu của trường khóa chính trong entity Seat
}
