package com.example.demo.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "product_image")
public class ProductImage {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int image_id;

    @Column(name = "img_url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
