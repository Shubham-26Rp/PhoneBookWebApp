package com.SimplePhoneBook.WebApp.model;

import javax.persistence.*;

@Entity
@Table(name = "Phone_Book")
public class PhoneBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "contactName")
    private String contactName;
    @Column(name = "phoneNumber")
    private int phoneNumber;

    public Long getId() {
        return Id;
    }

    public String getContactName() {
        return contactName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneBook(Long id, String contactName, int phoneNumber) {
        Id = id;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public PhoneBook() {
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "Id=" + Id +
                ", contactName='" + contactName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
