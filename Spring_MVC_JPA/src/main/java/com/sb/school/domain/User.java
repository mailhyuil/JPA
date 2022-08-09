package com.sb.school.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "USERNAME")
	private String username;
	private String password;
	private String name;
	private String role;
	private String email;
	@ManyToOne
	@JoinColumn(name = "CLASS_CODE")
	private Classes class_code;
}
