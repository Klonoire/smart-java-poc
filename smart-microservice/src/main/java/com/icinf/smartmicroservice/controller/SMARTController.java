package com.icinf.smartmicroservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icinf.smartmicroservice.entity.SMART;
import com.icinf.smartmicroservice.model.Note;
import com.icinf.smartmicroservice.service.SMARTService;


@RestController
@RequestMapping("/smart")
public class SMARTController {
    
    @Autowired
    SMARTService service;
    
    @GetMapping
    public ResponseEntity<List<SMART>>getAll(){
        List<SMART> paths= service.getPaths();
        if(paths.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(paths);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SMART> getById(@PathVariable("id") int id) { 
        SMART path = service.getPathById(id);
        if (path == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(path);
    }

    @PostMapping()
    public ResponseEntity<SMART> save(@RequestBody SMART path){
        SMART newpath = service.save(path);
        return ResponseEntity.ok(newpath);
    }

    @PostMapping("/savenote/{smartId}")
    public ResponseEntity<Note> saveNote(@PathVariable("smartId") int smartId, @RequestBody Note note){
        if(service.getPathById(smartId)== null){
            return ResponseEntity.notFound().build();
        }
        Note newnote = service.save(smartId, note);
        return ResponseEntity.ok(newnote);
    }

    @GetMapping("/getAll/{smartId}")
    public ResponseEntity<Map<String, Object>> getAllNotes(@PathVariable("smartId") int smartId) {
        Map<String, Object> result = service.getPathAndNotes(smartId);
        return ResponseEntity.ok(result);
    }
}