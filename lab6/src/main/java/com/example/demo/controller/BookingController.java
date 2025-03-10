package com.example.demo.controller;


import com.example.demo.model.BookingModel;
import com.example.demo.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class BookingController {

    @Autowired
    private BookingService Bservice;

@PostMapping("/")
    public BookingModel savedata(@RequestBody BookingModel datae)
{
return Bservice.savedata(datae);
}

@GetMapping("/")
public List<BookingModel> getdata()
{
    return Bservice.getdata();
}


}
