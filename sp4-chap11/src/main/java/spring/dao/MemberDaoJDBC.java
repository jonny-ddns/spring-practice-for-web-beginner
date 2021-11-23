package spring.dao;

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
import spring.vo.Member;

public class MemberDaoJDBC implements MemberDao{

	private JdbcTemplate jdbcTemplate;
	
	public MemberDaoJDBC(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Member selectByEmail(String email) {
		System.out.println(this + " - selectByEmail");		
		String query = "SELECT * FROM member WHERE email = ?";
		
		//1)
		List<Member> list = jdbcTemplate.query(
			query
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
		final String QUERY = "insert into member(email, password, name, regdate) values(?, ?, ?, ?);";
		KeyHolder keyHolder = new GeneratedKeyHolder();		
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement( QUERY, new String[] {"id"} );
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
		String query = "update member set name=?, password=? where email=?;";
		
		jdbcTemplate.update(
			query
			, member.getName()
			, member.getPassword()
			, member.getEmail()
		);
	}

	@Override
	public List<Member> selectAll() {
		System.out.println(this + " - selectAll");
		String query = "SELECT * FROM member";		
		
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
			query  
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
		String query = "SELECT COUNT(*) FROM member";
		
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
		return jdbcTemplate.queryForObject(query, Integer.class);
	}	
}
