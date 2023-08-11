package com.intactinsurance.restdemo;

import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class Note {
	
	private int id;
	private String title;
	private String details;
	private String date;
	private String[] checkboxes;
	
	public Note() {};
	
	public Note(String title, String date, String details, String[] checkboxes) {
		this.title = title;
		this.details = details;
		this.date = date;
		this.checkboxes = checkboxes;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDetails() {
		return this.details;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String[] getCheckboxes() {
		return this.checkboxes;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setCheckboxes(String[] checkboxes) {
		this.checkboxes = checkboxes;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		} 
		if(!(o instanceof Note)) {
			return false;
		}
		Note note = (Note) o;
		return Objects.equals(this.id, note.id) && Objects.equals(this.title, note.title) && Objects.equals(this.details, note.details)
				&& Objects.equals(this.date, note.date) && Objects.equals(this.checkboxes, note.checkboxes);
	}

}
