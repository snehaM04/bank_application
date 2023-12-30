package com.example.onlineBankingSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @Column(name="customer_id")
    private Long customerId;
    @Column(name="first_name")
    private String firstName;

    public String getPassword() {
        return password;
    }

    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="phone_number",length = 10)
    private String phoneNumber;
    @Column(name="password",length = 15)
    private String password;
    @Column(name="address",columnDefinition = "text")
    private String address;

    public Long getcustomerId() {
        return customerId;
    }
    public Customer(Long customerId) {
        this.customerId = customerId;
    }
    public Customer()
    {
        //default constructor;
    }
    public void setcustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getEmail() {
        return email;
    }

}
