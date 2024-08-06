package com.example.ToDo_App.model;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Model class used for DB data

@Entity
public class TodoItem {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	
	@Nonnull
	private String title;
	private boolean done;
	
	
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private LocalDate Duedate;
	
	public TodoItem(Long id, String title, boolean done, LocalDate duedate) {
		super();
		this.id = id;
		this.title = title;
		this.done = done;
		Duedate = duedate;
	}

	public Long getId() {
		return id;
	}

	public TodoItem() {
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public LocalDate getDuedate() {
		return Duedate;
	}

	public void setDuedate(LocalDate duedate) {
		Duedate = duedate;
	}	
	
}
