package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Properties;

import member.model.vo.Member;

public class MemberDAO {
	private Properties prop = new Properties();
public MemberDAO() {
		String fileName = MemberDAO.class.getResource("/sql/member/member-query.properties")
										 .getPath();
		System.out.println("fileName@MemberDAO="+fileName);
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member selectOne(Connection conn, String memberId) {
		Member m =null;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOne");
		System.out.println(query);
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset= pstmt.executeQuery();
			while(rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setPassword(rset.getString("member_pwd"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberNickname(rset.getString("member_nickname"));
				m.setBirthDay(rset.getDate("member_birthday"));
				m.setPhone(rset.getString("member_phone"));
				m.setPwdHint(rset.getString("member_pwd_hint_code"));
				m.setPwdAns(rset.getString("member_pwd_ans"));
				m.setAddress(rset.getString("member_address"));
				m.setEmail(rset.getString("member_email"));
				m.setGrade(rset.getString("member_grade"));
				m.setGender(rset.getString("member_gender"));
				m.setAge(rset.getInt("member_age"));
				m.setOneFamily(rset.getString("member_onefamily"));
				m.setEnrollDate(rset.getDate("member_enroll_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(m);
		return m;
	}

	public int updateMember(Connection conn, Member m) {
		int result= 0;
		PreparedStatement pstmt = null;
		System.out.println(m);
		String query= prop.getProperty("updateMember");
		System.out.println(query);
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberNickname());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getOneFamily());
			pstmt.setString(6, m.getMemberId());
			
			result= pstmt.executeUpdate();
			
			System.out.println("내부"+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println(result+"다오단.");
		return result;
	}

	public int insertMember(Connection conn, Member m) {
		int result=0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertMember");
//		int year = Calendar.getInstance().get(Calendar.YEAR);
//		System.out.println(year);
		try {
			System.out.println("여기는 올까요 ?..");
			pstmt= conn.prepareStatement(query);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getMemberNickname());
			pstmt.setDate(5, m.getBirthDay());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getPwdHint());
			pstmt.setString(8, m.getPwdAns());
			pstmt.setString(9, m.getAddress());
			pstmt.setString(10, m.getEmail());
			pstmt.setString(11, m.getGender());
			pstmt.setInt(12,m.getAge());
			pstmt.setString(13, m.getOneFamily());
			System.out.println(m+"여기는 뭐가있누");
			result=pstmt.executeUpdate();
			System.out.println(result+"다다오");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Member selectOne1(Connection conn, String email) {
		Member m =null;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOne1");
		System.out.println();
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, email);
			rset= pstmt.executeQuery();
			System.out.println("이메일 받아봐."+email);
			System.out.println(query);
			System.out.println("여기는 돌아감?");
			while(rset.next()) {
				System.out.println("ㅇ들어가도록해.");
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setPassword(rset.getString("member_pwd"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberNickname(rset.getString("member_nickname"));
				m.setBirthDay(rset.getDate("member_birthday"));
				m.setPhone(rset.getString("member_phone"));
				m.setPwdAns(rset.getString("member_pwd_hint_code"));
				m.setPwdAns(rset.getString("member_pwd_ans"));
				m.setAddress(rset.getString("member_address"));
				m.setEmail(rset.getString("member_email"));
//				m.setGrade(rset.getString("member_grade"));
				m.setGender(rset.getString("member_gender"));
//				m.setAge(rset.getInt("member_age"));
				m.setOneFamily(rset.getString("member_onefamily"));
				m.setEnrollDate(rset.getDate("member_enroll_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(m);
		return m;
	}

	public int updateMember(Connection conn, String memberId, String pwd) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updatePassword");
		
		int result= 0;
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, pwd);
			pstmt.setString(2, memberId);
			System.out.println(query);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int promoteMember(Connection conn, String memberId, String resultGrade) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("promoteMember");
		
		int result= 0;
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, resultGrade);
			pstmt.setString(2, memberId);
			System.out.println(query);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}
}