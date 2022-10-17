package com.example.demo.data.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "account")
public class Account {
	
	/* Câu hỏi : Có cần thiết Validate không , nếu có thì Validate những gì,
	 *  ví dụ ở entity Product thì Validate các column như thế nào ? */
	
	@Id
	@Column(name = "account_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	
	@Column(name = "username",unique = true)
	@Size(
			min = 6,
			max = 30,
			message = "Username must between {min} to {max} characters"
			)
	@NotNull(message = "Username is null")
	@NotBlank(message = "Username is null")
	private String username;
	
	@Column(name = "password")
	@Size(
			min = 6,
			message = "Min password length is {min} characters"
			)
    @NotNull(message = "Password is null")
    @NotBlank(message = "Password is null")
	private String password;
	
	@Column(name = "name")
	@Size(
			min = 2,
			message = "Min name length is {min} characters"
			)
    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
	private String name;
	
	@Column(name = "phone")
	@Size(
			min = 10,
			max = 11,
			message = "Phone must between {min} and {max} characters")
	private String phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "email")
    @NotNull(message = "Email is required")
    @NotBlank(message = "Email is required")
	private String email;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "role")
	private String role;

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<Cart> carts;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<Order> orders;
    
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<ProductRate> ratings;
	
}
