package com.SimplePhoneBook.WebApp.service;

import com.SimplePhoneBook.WebApp.model.PhoneBook;
import com.SimplePhoneBook.WebApp.repository.PhoneBookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PhoneBookServiceImpl implements PhoneBookService {
    @Autowired
    private PhoneBookRepository phoneBookRepository;

    @Override
    public List<PhoneBook> getAllContact() {
        return phoneBookRepository.getAllContact();
    }

    @Override
    public List<PhoneBook> getContactStartWithLetter(String contactName) {
        return getContactStartWithLetter(contactName);
    }

    @Override
    public List<PhoneBook> getContactByPhoneNumber(int phoneNumber) {
        return phoneBookRepository.getContactByPhoneNumber(phoneNumber);
    }
}
