package com.SimplePhoneBook.WebApp.repository;

import com.SimplePhoneBook.WebApp.model.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneBookRepository extends JpaRepository<PhoneBook, Long> {

}
