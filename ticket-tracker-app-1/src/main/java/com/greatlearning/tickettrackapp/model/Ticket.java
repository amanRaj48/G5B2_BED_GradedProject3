package com.greatlearning.tickettrackapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tickets")
@NoArgsConstructor
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "title")
	private String title;
	@Column(name = "Date")
	private String date;
	@Column(name = "description")
	private String description;
	@Column(columnDefinition = "LONGTEXT", name = "content")
	private String content;

	public long getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getDate() {
		return this.date;
	}

	public String getDescription() {
		return this.description;
	}

	public String getContent() {
		return this.content;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setContent(String content) {
		this.content = content;
	}

}