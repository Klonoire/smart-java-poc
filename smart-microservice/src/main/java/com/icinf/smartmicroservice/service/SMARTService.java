package com.icinf.smartmicroservice.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinf.smartmicroservice.entity.SMART;
import com.icinf.smartmicroservice.feignclients.NoteFeignClient;
import com.icinf.smartmicroservice.model.Note;
import com.icinf.smartmicroservice.repository.SMARTRepository;

@Service
public class SMARTService {
    
    @Autowired
    private SMARTRepository repository;

    @Autowired
    NoteFeignClient noteFeignClient;

    public SMART getPathById(int id){
        return repository.findById(id).orElse(null);
    }

    public List<SMART> getPaths(){
        return repository.findAll();
    }

    public SMART save(SMART smart){
        SMART newPath = repository.save(smart);
        return newPath;
    }

    public Note save(int smartId, Note note){
        note.setSmartId(smartId);
        Note newNote = noteFeignClient.save(note);
        return newNote;
    }
    public Map<String, Object> getPathAndNotes(int id){
        Map<String, Object> result = new HashMap<>();
        SMART smart = repository.findById(id).orElse(null);
        if (smart == null){
            result.put("Mensaje","Patron correspondiente no existe.");
            return result;
        }
        result.put("Patron", smart);
        List<Note> notes = noteFeignClient.getbySMARTId(id);
        if(notes.isEmpty()){
            result.put("Notes","La combinacion no tiene notas asociadas a esta");
        }else{
            result.put("Notes", notes);
        }return result;
        
    }
}
