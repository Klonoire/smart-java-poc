package com.icinf.notemicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icinf.notemicroservice.entity.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

    List<Note> findBySmartId(int smartid);
}
