package com.intactinsurance.restdemo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class NoteModelAssembler implements RepresentationModelAssembler<Note, EntityModel<Note>>{

	@Override
	public EntityModel<Note> toModel(Note note) {
		return EntityModel.of(note, 
				linkTo(methodOn(NoteController.class).getNote(note.getId())).withSelfRel(),
				linkTo(methodOn(NoteController.class).getNotes()).withRel("notes"));
	}
}
