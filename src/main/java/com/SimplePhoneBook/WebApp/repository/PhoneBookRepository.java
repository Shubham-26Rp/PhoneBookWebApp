package com.SimplePhoneBook.WebApp.repository;

import com.SimplePhoneBook.WebApp.model.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhoneBookRepository extends JpaRepository<PhoneBook, Long> {
    @Query("select o from Phone_Book o")
    public List<PhoneBook> getAllContact();

    @Query("select o from Phone_Book o where o.contactName LIKE :c%")
    public List<PhoneBook> getContactStartWithLetter(@Param("c") String contactName);

    @Query("select o from Phone_Book o where o.phoneNumber=:c")
    public List<PhoneBook> getContactByPhoneNumber(@Param("c") int phoneNumber);

}
