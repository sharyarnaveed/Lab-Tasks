package com.example.demo.controller;


import com.example.demo.model.BookingModel;
import com.example.demo.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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


@PutMapping("/update/{myId}")
    public BookingModel updateBook(@PathVariable Long myId, @RequestBody BookingModel NewEntry)
{
    BookingModel oldEntry=Bservice.findByid(myId).orElse(null);
    if (oldEntry != null) {
        oldEntry.setPatientName(NewEntry.getPatientName());
        oldEntry.setDrName(NewEntry.getDrName());
        oldEntry.setStatus(NewEntry.getStatus());

        // Ensure the ID remains the same
        oldEntry.setId(myId);

        return Bservice.savedata(oldEntry);
    } else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found");
    }
}

}
