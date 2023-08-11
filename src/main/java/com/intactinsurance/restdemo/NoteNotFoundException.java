package com.intactinsurance.restdemo;

public class NoteNotFoundException extends RuntimeException {

	public NoteNotFoundException(int id) {
		super("Could not find note with id: " + id);
	}
}
