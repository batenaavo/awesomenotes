package com.awesomenotes.backend.controller;

import java.util.List;

import com.awesomenotes.backend.dao.NoteDao;
import com.awesomenotes.backend.model.Note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteDao dao;

    @PostMapping("/add")
    public String addNote(@RequestBody Note note) {
        dao.save(note);
        return "success";
    }

    // MUST RECEIVE ID IN BODY
    @PutMapping("/edit")
    public String editNote(@RequestBody Note note) {
            dao.save(note);
            return "success";
    }

    @DeleteMapping("/delete")
    public String deleteNote(@RequestBody int id){
        if(dao.findById(id).isPresent()){
            Note note = dao.findById(id).get();
            dao.delete(note);
            return "success";
        }
        else{
            return "invalid id";
        }
    }

    @GetMapping("")
    public List<Note> getUserNotes(int id) {
        return (List<Note>) dao.findAllUserNotes(id);
    }
}