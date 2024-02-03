package com.tdw.todowith.domain.team;

import java.util.ArrayList;
import java.util.List;

import com.tdw.todowith.domain.BaseTimeEntity;
import com.tdw.todowith.domain.memberteam.MemberTeam;

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
public class Team extends BaseTimeEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private Long id;

	private String teamName;

	@Enumerated(EnumType.STRING)
	private TeamStatus status;

	private String teamIntroduce;

	private String teamCode;

	@OneToMany(mappedBy = "team")
	private List<MemberTeam> memberTeams = new ArrayList<>();
}
