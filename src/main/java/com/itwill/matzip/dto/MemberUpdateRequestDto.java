package com.itwill.matzip.dto;

import java.time.LocalDate;

import com.itwill.matzip.domain.Gender;
import com.itwill.matzip.domain.Member;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MemberUpdateRequestDto {
	private String username;
	private String email;
	private String nickname;
	private LocalDate birth;
	private Gender gender;
	
	public Member toEntity() {
		return Member.builder()
										.kakaoClientId(username)
										.email(email)
										.nickname(nickname)
										.birth(birth)
										.gender(gender)
										.build();
	}
}
