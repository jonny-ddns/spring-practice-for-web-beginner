package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dao.MemberDao;
import spring.vo.Member;

public class MainForMemberDao {
	private static MemberDao memberDao;
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		memberDao = ctx.getBean("memberDaoJdbc", MemberDao.class);

		MainForMemberDao main = new MainForMemberDao();
		main.selectAll();
		main.updateMember();
		main.insertMember();
		ctx.close();
	}	
	
	private void selectAll() {
		System.out.println(this + " - selectAll");
		int total = memberDao.count();
		System.out.println("전체 데이터 = " + total);
		List<Member> list = memberDao.selectAll();
		for(Member m : list) {
			System.out.println(m.getId() + " | "+ m.getEmail()+ " | "+ m.getName());
		}
	}
	
	private void updateMember() {
		System.out.println(this + " - updateMember");
		Member member = memberDao.selectByEmail("test@test.com");
		String oldpw = member.getPassword();
		String newpw = Double.toHexString(Math.random());
		System.out.printf("이전 pw = [%s], 새로운 pw = [%s]\n", oldpw, newpw);
		member.changePassword(oldpw, newpw);				
		memberDao.update(member);
		System.out.println("암호변경 완료");
	}
	
	private void insertMember() {
		System.out.println(this + " - insertMember");
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd_HHmmss");
		String prefix = sdf.format(new Date());
		String email = "@test.com";
		String name = "testUser_";
		String password = Double.toString(Math.random()).substring(2);
		
		Member member = new Member(prefix + email, password, name + prefix, new Date());
		memberDao.insert(member);
		System.out.println("데이터 추가 완료 | " + member);
	}	
}
