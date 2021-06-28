package com.work.service;

import java.util.ArrayList;

import com.work.dto.Member;
import com.work.exception.DuplicateException;
import com.work.exception.RecordNotFoundException;

public class MemberService {
	private int count = 0;
	
	/** 멤버서비스 위한 자료저장구조 */
	private ArrayList<Member> list = new ArrayList<Member>();
	
	/** 기본생성자	 */
	public MemberService() {
	}

	public void addMember(Member dto) throws DuplicateException {
		int index = exist(dto.getMemberId());
		if (index >= 0) {
				throw new DuplicateException(dto.getMemberId());
			} else {
				list.add(dto);
			}
	}
	
	public void addMember(String memberId, String memberPw, String name, String mobile, String email) throws DuplicateException {
		Member dto = new Member(memberId, memberPw, name, mobile, email);
		addMember(dto);		
	}

	public Member getMember(String memberId, String memberPw) throws RecordNotFoundException {
		return (Member)list.get(login(memberId,memberPw));
	}
	
	public Member getMember(int index) {
		System.out.println(list.get(index).toString());
		return list.get(index);
	}
	
	public int setMemberPw(int index, String modifyPw) throws RecordNotFoundException {
		list.get(index).setMemberPw(modifyPw);
		System.out.println("비밀번호 변경 완료");
		return index;
	}
	
	public void setName(int index, String modityName) throws RecordNotFoundException {
		list.get(index).setName(modityName);
		System.out.println("이름 변경 완료");
	}
	
	public void setMobile(int index, String modifyMobile) throws RecordNotFoundException {
		list.get(index).setMobile(modifyMobile);
		System.out.println("휴대폰 변경 완료");
	}
	
	public void setEmail(int index, String modifyEmail) throws RecordNotFoundException {
		list.get(index).setEmail(modifyEmail);
		System.out.println("이메일 변경 완료");
	}
	
	public void removeMember(int index) {
		list.remove(index);
	}
	
	public int exist(String memberId) {
		for(int index = 0; index < list.size(); index++) {
			if (list.get(index).getMemberId().equals(memberId)) {
				return index;
			}
		}
		return -1;
	}
	
	public int login(String memberId, String memberPw) throws RecordNotFoundException {
		int index = exist(memberId);
		if(index >= 0 && list.get(index).getMemberPw().equals(memberPw)) {
				return index;
		}
		throw new RecordNotFoundException();
	}
	
	public void findMemberId(String mobile, String email) {
		for(int index = 0; index < list.size(); index++) {
			Member member = list.get(index);
			if(member.getMobile().equals(mobile) && member.getEmail().equals(email)) {
				System.out.println("회원님의 아이디는 " + member.getMemberId().toString() + "입니다.");
			}
		}
	}
	
	public void findMemberPw(String memberId,String mobile, String email) {
		for(int index = 0; index < list.size(); index++) {
			Member member = list.get(index);
			if(member.getMemberId().equals(memberId) && member.getMobile().equals(mobile) && member.getEmail().equals(email)) {
				System.out.println("회원님의 비밀번호는 " + member.getMemberPw().toString() + "입니다.");
			}
		}
	}
	public int initMember() throws DuplicateException {
		Member dto1 = new Member("user01", "password01", "홍길동", "01012341000", "user01@work.com");
		Member dto2 = new Member("user02", "password02", "강감찬", "01012342000", "user02@work.com");
		
		addMember(dto1);
		addMember(dto2);
		
		
		return list.size();
	}
}
