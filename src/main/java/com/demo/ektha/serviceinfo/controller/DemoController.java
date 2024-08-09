package com.demo.ektha.serviceinfo.controller;

import com.demo.ektha.serviceinfo.Model.Notes;
import com.demo.ektha.serviceinfo.repositotory.NotesRepositotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    NotesRepositotory notesRepositotory;

    @GetMapping("/")
    public String Welcome() {

        return " Welcome to java";
    }

//    @PostMapping("/add-notes")
//    public ResponseEntity<Notes> addNotes(@RequestBody Notes notes) {
//        Notes _notes =notesRepositotory.save(new Notes(notes.getTittle(),notes.getDescription()));
//        return new ResponseEntity<>(_notes,HttpStatus.CREATED);

        @PostMapping("/add-notes")
        public ResponseEntity<Notes> addNotes(@RequestBody Notes notes) {
            Notes savedNote = notesRepositotory.save(notes);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedNote);
        }


    @GetMapping("/all-notes")
    public ResponseEntity<List<Notes>>getAllNotes() {
        List<Notes> notes = notesRepositotory.findAll();
        return new ResponseEntity<>(notes, HttpStatus.OK);

    }
}
