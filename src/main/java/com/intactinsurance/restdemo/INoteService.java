package com.intactinsurance.restdemo;

import java.util.List;
import java.util.Optional;

public interface INoteService {
	
	List<Note> findAll();
	
	Note save(Note aNote);
	
	void deleteById(int Id);

	Optional<Note> findById(int id);

}
