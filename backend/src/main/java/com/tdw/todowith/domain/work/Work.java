package com.tdw.todowith.domain.work;

import java.util.ArrayList;
import java.util.List;

import com.tdw.todowith.domain.BaseTimeEntity;
import com.tdw.todowith.domain.member.Member;
import com.tdw.todowith.domain.reply.Reply;
import com.tdw.todowith.domain.team.Team;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Work extends BaseTimeEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "work_id")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Team team;

	private int duration;

	private String content;

	@Enumerated(EnumType.STRING)
	private WorkStatus status;

	@OneToMany(mappedBy = "work")
	private List<Reply> replies = new ArrayList<>();

}
