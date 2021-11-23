package spring.dao;

import java.util.List;
import spring.vo.Member;

public interface MemberDao {
	public Member selectByEmail(String email);
	
	public void insert(Member member);
	
	public void update(Member member);
	
	public List<Member> selectAll();
	
	public int count();
}
