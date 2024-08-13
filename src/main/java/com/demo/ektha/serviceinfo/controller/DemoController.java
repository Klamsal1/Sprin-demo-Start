package com.demo.ektha.serviceinfo.controller;

import com.demo.ektha.serviceinfo.Model.Notes;
import com.demo.ektha.serviceinfo.repositotory.NotesRepositotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<Notes>> getAllNotes() {
        List<Notes> notes = notesRepositotory.findAll();
        return new ResponseEntity<>(notes, HttpStatus.OK);

    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Notes> getNoteById(@PathVariable Long id) {

        Notes notes = notesRepositotory.findById(id).orElse(null);
        if (notes != null) {
            return new ResponseEntity<>(notes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/note/{id}")
    public ResponseEntity<Notes> deleteNote(Long id) {
        notesRepositotory.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<Notes> updateNotes(@PathVariable Long id, @RequestBody Notes notes) {
        Optional<Notes> existingNoteOptional = notesRepositotory.findById(id);

        if (existingNoteOptional.isPresent()) {
            Notes existingNote = existingNoteOptional.get();
            existingNote.setTittle(notes.getTittle());
            existingNote.setDescription(notes.getDescription());

            Notes updatedNote = notesRepositotory.save(existingNote);
            return new ResponseEntity<>(updatedNote, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    }
