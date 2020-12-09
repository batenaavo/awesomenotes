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
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int id;
	private String username;
	private String password;

	public User(){}

	public User(int id, String username, String password){
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId(){
		return id;
	}

	public String getUsername(){
		return username;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public void setId(int id){
		this.id = id;
	}

	public void setUsername(String username){
		this.username = username;
	}

}