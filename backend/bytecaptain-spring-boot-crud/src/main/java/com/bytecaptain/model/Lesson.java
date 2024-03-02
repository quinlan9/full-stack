package com.bytecaptain.model;

//change javax to jakarta
//Spring Boot 版本（3.1.4）已经迁移到使用 Jakarta EE 9 的命名空间（即 jakarta.* 而不是 javax.*）
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Lesson {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String description;

	public Lesson() {

	}

	public Lesson(long id, String username, String description) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
