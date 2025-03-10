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


@GetMapping("/id/{myId}")
    public BookingModel GetbookingById(@PathVariable Long myId)
{
return Bservice.findByid(myId).orElse(null);
}


@DeleteMapping("/id/{myId}")

public void deleteappointment(@PathVariable Long myId)
{
    Bservice.deletebyid(myId);
}


}
