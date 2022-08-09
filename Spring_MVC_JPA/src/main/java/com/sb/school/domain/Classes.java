package com.sb.school.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "CLASSES")
public class Classes {
	@Id
	@Column(name = "CLASS_CODE")
	private String class_code;
	
	@Column(name = "SUBJECT")
	private String subject;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "class_code")
	private List<User> users = new ArrayList<User>();

	public String getClass_code() {
		return class_code;
	}

	public void setClass_code(String class_code) {
		this.class_code = class_code;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}