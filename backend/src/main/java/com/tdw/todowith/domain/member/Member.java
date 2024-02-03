package com.tdw.todowith.domain.member;

import java.util.ArrayList;
import java.util.List;

import com.tdw.todowith.domain.BaseTimeEntity;
import com.tdw.todowith.domain.memberteam.MemberTeam;
import com.tdw.todowith.domain.work.Work;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;

	private String email;

	private String password;

	private String phone;

	private String name;

	@Enumerated(EnumType.STRING)
	private MemberStatus status;

	@OneToMany(mappedBy = "member")
	private List<MemberTeam> memberTeams = new ArrayList<>();

	private String selfIntroduce;

}
