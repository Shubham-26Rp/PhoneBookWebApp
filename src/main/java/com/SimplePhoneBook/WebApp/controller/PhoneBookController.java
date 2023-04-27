package com.SimplePhoneBook.WebApp.controller;

import com.SimplePhoneBook.WebApp.model.PhoneBook;
import com.SimplePhoneBook.WebApp.repository.PhoneBookRepository;
import com.SimplePhoneBook.WebApp.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PhoneBookController {
    @Autowired
    PhoneBookRepository phoneBookRepository;

    PhoneBookService phoneBookService;

    @PostMapping("/phonebook")
    public String CreateNewContact(@RequestBody PhoneBook phoneBook) {
        phoneBookRepository.save(phoneBook);
        return "New Contact Created in Database";
    }

    @GetMapping("/phonebook")
    public ResponseEntity<List<PhoneBook>> getAllContacts() {
        List<PhoneBook> phoneBooks = new ArrayList<>();
        phoneBookRepository.findAll().forEach(phoneBooks::add);
        return new ResponseEntity<List<PhoneBook>>(phoneBooks, HttpStatus.OK);
    }

    @GetMapping("/phonebook/{id}")
    public ResponseEntity<PhoneBook> getContactById(@PathVariable long id) {
        Optional<PhoneBook> phoneBook = phoneBookRepository.findById(id);
        if (phoneBook.isPresent()) {
            return new ResponseEntity<PhoneBook>(phoneBook.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<PhoneBook>(phoneBook.get(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/phonebook/{id}")
    public String updateContactById(@PathVariable long id, @RequestBody PhoneBook phoneBook) {
        Optional<PhoneBook> contact = phoneBookRepository.findById(id);
        if (contact.isPresent()) {
            PhoneBook existContact = contact.get();
            existContact.setPhoneNumber(phoneBook.getPhoneNumber());
            existContact.setContactName(phoneBook.getContactName());
            phoneBookRepository.save(phoneBook);
            return "Contact Details save in phone Book Against Id" + id + "updated";
        } else {
            return "Contact Details doesn't exist in phone Book " + id;
        }
    }

    @DeleteMapping("/phonebook/{id}")
    public String deleteContactById(@PathVariable Long id) {
        phoneBookRepository.deleteById(id);
        return "Contact Deleted from PhoneBook Successfully";
    }

    @DeleteMapping("/phonebook")
    public String deleteAllContact() {
        phoneBookRepository.deleteAll();
        return "All Contact Deleted from PhoneBook Successfully";
    }

    @GetMapping("/getAllContactForJPAQL")
    public List<PhoneBook> getAllContact() {
        return phoneBookService.getAllContact();
    }

    @GetMapping("/getContactByPhoneNumber")
    public List<PhoneBook> getContactByPhNumberJPAQL(@PathVariable int phoneNumber) {
        return phoneBookService.getContactByPhoneNumber(phoneNumber);
    }
}
