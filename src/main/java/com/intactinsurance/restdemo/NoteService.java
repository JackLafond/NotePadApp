package com.intactinsurance.restdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class NoteService implements INoteService{
	
	private List<Note> notes;
	
	public NoteService() {
		String[] GroceryChecks = {"Bananas", "Milk", "Cheese", "Yogurt"};
		String[] ShowsChecks = {"Jury Duty - prime video", "Full Swing - netflix", "GOT - HBO"};
		String[] ToDoChecks = {"Laundry", "Groceries", "Clean", "Check Emails", "Make Dinner Reservation"};
		String[] MovieChecks = {"Oppenheimer", "Dune Part 2", "The Creator"};
		String[] SchoolChecks = {"Pens", "Pencils", "Notebooks", "Sticky Notes"};
		
		this.notes = new ArrayList<Note>();
		this.notes.add(new Note("Groceries", "6/14/23", "Grocery List", GroceryChecks));
		this.notes.add(new Note("Shows", "7/1/23", "Shows to Watch", ShowsChecks));
		this.notes.add(new Note("Chores", "7/10/23", "Chores Around House", ToDoChecks));
		this.notes.add(new Note("Movies", "7/14/23", "Upcoming Movies, Need to Get Tix", MovieChecks));
		this.notes.add(new Note("Supplies", "7/5/23", "Back to School Supplies For 2023", SchoolChecks));
		
		for(int i = 0; i < this.notes.size(); i++) {
			this.notes.get(i).setId(i+1);
		}
	}

	@Override
	public List<Note> findAll() {
		
		return notes;
	}

	@Override
	public Note save(Note aNote) {
		if(!aNote.getTitle().isEmpty() && !aNote.getDate().isEmpty()) {
			this.notes.add(aNote);
			this.notes.get(this.notes.size() - 1).setId(this.notes.size());
			return aNote;
		}
		return null;
	}

	@Override
	public Optional<Note> findById(int id) {
		Optional<Note> aNote = Optional.empty();
		if(id <= this.notes.size() && id > 0) {
			aNote = Optional.of(this.notes.get(id-1));
		}
		return aNote; 
	}

	@Override
	public void deleteById(int id) {
		if(id > 0 && id <= this.notes.size()) {
			this.notes.remove(id - 1);
			setNewIds(id);
		}
		
	}

	private void setNewIds(int id) {
		for(int i = id - 1; i < this.notes.size(); i++) {
			this.notes.get(i).setId(i + 1);
		}
	}

	public Note updateNote(Note aNote, int id) {
		if(id > 0 && id <= this.notes.size()) {
			this.notes.get(id-1).setTitle(aNote.getTitle());
			this.notes.get(id-1).setDate(aNote.getDate());
			this.notes.get(id-1).setDetails(aNote.getDetails());
			this.notes.get(id-1).setCheckboxes(aNote.getCheckboxes());
			return this.notes.get(id-1);
		} else if(id > this.notes.size()) {
			save(aNote);
			return aNote;
		}
		return null;
	}

}
