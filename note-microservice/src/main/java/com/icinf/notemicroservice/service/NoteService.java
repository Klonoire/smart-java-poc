package com.icinf.notemicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinf.notemicroservice.entity.Note;
import com.icinf.notemicroservice.repository.NoteRepository;

@Service
public class NoteService {
    
    @Autowired
    NoteRepository noteRepository;
    

    public List<Note> getAll(){
        return noteRepository.findAll();
    }

    public Note getNotebyId(int id){
        return noteRepository.findById(id).orElse(null);
    }

    public List<Note> findbySMARTidNote(int smartid){
        return noteRepository.findBySmartId(smartid);
    }
   
    public Note save(Note note){
        Note newNote = noteRepository.save(note);
        return newNote;
    }
}

// List<Note> notes = new ArrayList<Note>(Arrays.asList(new Note(1, 3, "Do", 130.81, 5),
//     new Note(2, 3, "Do#", 138.59, 12),
//     new Note(3, 3, "Re", 146.83, 2),
//     new Note(4, 3, "Re#", 155.56, 3),
//     new Note(5, 3, "Mi", 164.81, 8),
//     new Note(6, 3, "Fa", 174.61, 10),
//     new Note(7, 3, "Fa#", 185.00, 6),
//     new Note(8, 3, "Sol", 196.00, 11),
//     new Note(9, 3, "Sol#", 207.65, 7),
//     new Note(10, 3, "La", 220.00, 1),
//     new Note(11, 3, "La#", 233.08, 9),
//     new Note(12, 3, "Si", 246.94, 4)));