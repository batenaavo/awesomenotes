package com.awesomenotes.backend.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.awesomenotes.backend.model.Note;

public interface NoteDao extends CrudRepository<Note, Integer>{
    @Query(value = "SELECT * FROM Note n WHERE n.user_id = ?1", nativeQuery = true)
     List<Note> findAllUserNotes(int id);
}