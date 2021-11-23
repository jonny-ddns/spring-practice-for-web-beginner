package dao;

import java.util.List;

import vo.Member;

public class MemberDaoTest implements MemberDao {
	@Override
	public Member selectByEmail(String email) {
		return null;
	}

	@Override
	public void insert(Member member) {		
	}

	@Override
	public void update(Member member) {
	}

	@Override
	public List<Member> selectAll() {
		return null;
	}
	
	@Override
	public int count() {
		return 0;
	}
}
