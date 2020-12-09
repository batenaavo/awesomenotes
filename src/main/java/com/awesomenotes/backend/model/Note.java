package com.awesomenotes.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Note")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Note {
	@Id
	@GeneratedValue
	@Column(name = "note_id")
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "note_text")
	private String text;

	public Note(){}

	public Note(int id, int userId, String text){
		this.id = id;
		this.userId = userId;
		this.text = text;
	}

	public int getId(){
		return id;
	}

	public int getUserId(){
		return userId;
	}

	public String getText(){
		return text;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public void setId(int id){
		this.id = id;
	}

	public void setText(String text){
		this.text = text;
	}

}