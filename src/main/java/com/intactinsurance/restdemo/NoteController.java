package com.intactinsurance.restdemo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NoteController {
	
	private NoteService ns;
	private NoteModelAssembler na;
	
	@Autowired
	public NoteController(NoteService ns, NoteModelAssembler na) {
		this.ns = ns;
		this.na = na;
	}
	
	@GetMapping("/notes")
	CollectionModel<EntityModel<Note>> getNotes(){
		List<EntityModel<Note>> notes = ns.findAll().stream().map(
				note -> na.toModel(note)).collect(Collectors.toList());
		
		return CollectionModel.of(notes, 
				linkTo(methodOn(NoteController.class).getNotes()).withSelfRel());
		
	}
	
	@PostMapping("/notes")
	Note newNote(@RequestBody Note aNote) {
		return ns.save(aNote);
	}
	
	@GetMapping("/notes/{id}")
	EntityModel<Note> getNote(@PathVariable int id) {
		Note n = ns.findById(id).orElseThrow(() -> new NoteNotFoundException(id));
		return na.toModel(n);
	}
	
	@PutMapping("/notes/{id}")
	Note replaceNote(@RequestBody Note aNote, @PathVariable int id) {
	    return ns.updateNote(aNote, id);
	}

	@DeleteMapping("/notes/{id}")
	void deleteNote(@PathVariable int id) {
		ns.deleteById(id);
	}
}
