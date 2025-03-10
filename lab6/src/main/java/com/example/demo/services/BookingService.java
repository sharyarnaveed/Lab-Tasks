package com.example.demo.services;

import com.example.demo.model.BookingModel;
import com.example.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookingService {

    @Autowired
    private BookingRepository Brepo;

    public BookingModel savedata(BookingModel user)
    {


        return Brepo.save(user);
    }


    public List<BookingModel> getdata()
    {
        return Brepo.findAll();
    }


    public Optional<BookingModel> findByid(Long id)
    {
        return  Brepo.findById(id);
    }


    public void deletebyid(Long id)
    {
        Brepo.deleteById(id);
    }


}
