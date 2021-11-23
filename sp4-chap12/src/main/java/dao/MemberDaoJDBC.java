package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import vo.Member;

//db 접근해 데이터 변경하는 클래스
/*
 * JdbcTemplate
 * 스프링에서 제공하는 jdbc 프로그래밍 전용 객체
 */
public class MemberDaoJDBC implements MemberDao{

	private JdbcTemplate jdbcTemplate;
	
	public MemberDaoJDBC(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Member selectByEmail(String email) {
		System.out.println(this + " - selectByEmail");		
		String sql = "SELECT * FROM member WHERE email = ?";
		
		List<Member> list = jdbcTemplate.query(
			sql
			, new RowMapper<Member>() {
				@Override
				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {						
					return new Member(
						rs.getString("email")
						, rs.getString("password")
						, rs.getString("name")
						, rs.getTimestamp("regdate")
					).setId(rs.getLong("id"));
				}
			}, email);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void insert(final Member member) {
		System.out.println(this + " - insert");
		final String SQL = "insert into member(email, password, name, regdate) values(?, ?, ?, ?);";
		KeyHolder keyHolder = new GeneratedKeyHolder();		
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement( SQL, new String[] {"id"} );
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				return pstmt;
			}}
			, keyHolder);
		
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}

	@Override
	public void update(Member member) {
		System.out.println(this + " - update");
		String sql = "update member set name=?, password=? where email=?;";
		
		jdbcTemplate.update(
			sql
			, member.getName()
			, member.getPassword()
			, member.getEmail()
		);
	}

	@Override
	public List<Member> selectAll() {
		System.out.println(this + " - selectAll");
		String sql = "SELECT * FROM member";		
		
//		List<Member> list = jdbcTemplate.query(
//			query  
//			, new RowMapper<Member>() {
//				@Override
//				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//					return new Member(
//						rs.getString("email")
//						, rs.getString("password")
//						, rs.getString("name")
//						, rs.getTimestamp("regdate")
//					).setId(rs.getLong("id"));
//				}
//			}
//		);
//		return list;
		
		return jdbcTemplate.query(
			sql  
			, new RowMapper<Member>() {
				@Override
				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new Member(
						rs.getString("email")
						, rs.getString("password")
						, rs.getString("name")
						, rs.getTimestamp("regdate")
					).setId(rs.getLong("id"));
				}
			}
		);
	}
	
	@Override
	public int count() {
		System.out.println(this + " - count");
		String sql = "SELECT COUNT(*) FROM member";
		
//		List<Integer> list = jdbcTemplate.query(
//			"select count(*) from member"
//			, new RowMapper<Integer>() {					
//				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
//					return rs.getInt(1);
//				}
//			}				
//		);
//		return list.get(0);
		
		//좀더 간결한 코드
//		Integer count = jdbcTemplate.queryForObject(
//				"select count(*) from member"
//				, Integer.class);
//		return count;
		
		//좀더
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}	
}
