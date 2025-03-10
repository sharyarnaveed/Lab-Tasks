package com.example.demo.services;

import com.example.demo.model.BookingModel;
import com.example.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
