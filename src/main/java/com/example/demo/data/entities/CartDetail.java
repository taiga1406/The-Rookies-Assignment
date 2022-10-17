package com.example.demo.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "cart_detail")
public class CartDetail {
	@Id
    @Column(name = "cart_id")
    private int cartId;

    @Id
    @Column(name = "product_id")
    private int proId;

    @Column(name = "quantity")
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name = "cart_id", insertable = false, updatable = false)
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "pro_id", insertable = false, updatable = false)
    private Product product;
}
