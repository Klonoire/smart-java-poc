package com.icinf.smartmicroservice.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.icinf.smartmicroservice.model.Note;


@FeignClient(name ="note-microservice", url ="http://localhost:8002", path="/note")
public interface NoteFeignClient {
    
    @PostMapping()
    Note save(@RequestBody Note note);

    @GetMapping("/bySMART/{smartId}")
    List<Note> getbySMARTId(@PathVariable("smartId") int smartId); 
}