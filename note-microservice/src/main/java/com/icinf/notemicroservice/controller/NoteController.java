package com.icinf.notemicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icinf.notemicroservice.entity.Note;
import com.icinf.notemicroservice.service.NoteService;

@RestController
@RequestMapping("/note")
public class NoteController {
    
    @Autowired
    NoteService noteService;

    @GetMapping
    public ResponseEntity<List<Note>> getAll() {
        List<Note> notes = noteService.getAll();
        if(notes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getbyId(@PathVariable("id") int id) {
        Note note = noteService.getNotebyId(id);
        if(note == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(note);
    }

    @PostMapping()
    public ResponseEntity<Note> save(@RequestBody Note note) {
        Note newnote = noteService.save(note);
        return ResponseEntity.ok(newnote);
        
    }
    @GetMapping("bySMART/{smartId}")
    public ResponseEntity<List<Note>> getbySMARTId(@PathVariable("smartId") int smartId) {
        List<Note> notes = noteService.findbySMARTidNote(smartId);
        if(notes == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notes);
    }
}
