package com.itwill.matzip.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itwill.matzip.domain.Member;
import com.itwill.matzip.domain.enums.MemberRole;
import com.itwill.matzip.dto.MemberSecurityDto;
import com.itwill.matzip.dto.MemberSignupRequestDto;
import com.itwill.matzip.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService{

	private final MemberRepository memberDao;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.info("loadUserByUsername(username={})", username);
		
		Optional<Member> opt = memberDao.findByUsername(username);
		
		if(opt.isPresent()) {
			log.info(opt.toString());
			return MemberSecurityDto.fromEntity(opt.get());
		}else {
			throw new UsernameNotFoundException(username + " 찾을 수 없음");
		}
	}
	
	public void createMember(MemberSignupRequestDto dto) {
		log.info("createMember : {}", dto);
		
		Member entity = dto.toEntity(passwordEncoder);
		entity.addRole(MemberRole.USER);
		
		memberDao.save(entity);
	}

	public String checkUsername(String username) {
		log.info("checkUsername(username = {})", username);
		
		Optional<Member> opt = memberDao.findByUsername(username);
		if(opt.isPresent()) {
			log.info(opt.toString());
			return "Y";
		}else {
			return "N";
		}
	}

	public String checkNickname(String nickname) {
		log.info("checkNickname(nickname = {})", nickname);
		
		Member m = memberDao.findByNickname(nickname);

		if(m != null) {
			return "Y";
		}else {
			return "N";
		}
	}

	public Member checkEmail(String email) {
		log.info("checkEmail(email = {})", email);
		
		Member m = memberDao.findByEmail(email);

		return m;
	}

	//이메일 인증키와 username이 맞는지 비교
	public boolean authKey(String key, String username) {
		boolean result = passwordEncoder.matches(username, key);
		
		return result;
	}

	
	@Transactional
	public void updatePwd(String username, String pwd) {
		log.info("updatePwd(username : {}, pwd : {}", username, pwd);
		
		Member entity =memberDao.findByUsername(username).orElseThrow();
		entity.pwdUpdate(passwordEncoder.encode(pwd));
	}
}
