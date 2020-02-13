package member.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;
public class MemberService {

	public static final String USER_MEMBER_ROLE = "U";
	public static final String ADMIN_MEMBER_ROLE = "A";
	
	public Member selectOne(String memberId) {
		Connection conn = getConnection();
		System.out.println(memberId+"서비스단");
		Member m = new MemberDAO().selectOne(conn,memberId);
		close(conn);
		return m;
	}

	public int updateMember(Member m) {
		Connection conn = getConnection();
		System.out.println("서비스단 멤버객체"+m);
		int result = new MemberDAO().updateMember(conn,m);
		System.out.println("업데이트 서비스단 "+result);
		
		if(result>0) {
			System.out.println("업데이트 성공");
		}else {
			System.out.println("업데이트 실패요");
		}
		
		close(conn);
		return result;
	}

	public int insertmember(Member m) {
		Connection conn= getConnection();
		int result=new MemberDAO().insertMember(conn,m);
		System.out.println("insertMember@service"+result);
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		return result;
	}

	public Member selectOne1(String email) {
		Connection conn = getConnection();
		System.out.println(email+"서비스단");
		Member m = new MemberDAO().selectOne1(conn,email);
		close(conn);
		return m;
	}

	public int updateMemberPwd(String memberId, String pwd) {
		Connection conn=getConnection();
		int result = new MemberDAO().updateMember(conn, memberId, pwd);
		System.out.println(result+"비밀번호 변경 서비스");
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		return result;
	}

	public int promoteMember(String memberId, String resultGrade) {
		Connection conn=getConnection();
		int result = new MemberDAO().promoteMember(conn, memberId, resultGrade);
		
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		return result;
	}

}
