package com.SimplePhoneBook.WebApp.service;

import com.SimplePhoneBook.WebApp.model.PhoneBook;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhoneBookService {
    public List<PhoneBook> getAllContact();

    public List<PhoneBook> getContactStartWithLetter(@Param("c") String contactName);

    public List<PhoneBook> getContactByPhoneNumber(@Param("c") int phoneNumber);
}
