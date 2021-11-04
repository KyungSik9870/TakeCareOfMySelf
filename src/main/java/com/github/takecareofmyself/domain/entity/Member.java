package com.github.takecareofmyself.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Member Entity
 *
 * @author : KSRYU
 * @since 2021/11/04
 **/
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "TGC_MEMBER_TB")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TGC_MEMBER_ID")
	private Long id;

	@Column(name = "TGC_MEMBER_USERNAME")
	private String username;

	@Column(name = "TGC_MEMBER_EMAIL")
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "TGC_MEMBER_ROLE")
	private Role role;

	private Member(String username, String email, Role role) {
		this.username = username;
		this.email = email;
		this.role = role;
	}

	public static Member of(String username, String email, Role role) {
		return new Member(username, email, role);
	}
}
