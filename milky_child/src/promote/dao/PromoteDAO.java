package promote.dao;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.vo.Promote;
import static common.JDBCTemplate.*;

public class PromoteDAO {
	
	private Properties prop = new Properties();

	public PromoteDAO() {

		String fileName = PromoteDAO.class.getResource("/sql/promote/query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getPromoteNum(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("getPromoteNum");
		String result = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getString("max_num");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int insertPromoteApplication(Connection conn, Promote p) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertPromoteApplication");
		System.out.println(query);
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getPromoteNum());
			pstmt.setString(2, p.getMemberId());
			pstmt.setString(3, p.getOldPromoteFile());
			pstmt.setString(4, p.getRenamedPromoteFile());
			pstmt.setString(5, p.getBeforeGrade());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<Promote> getPromoteList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		String query = prop.getProperty("getPromoteList");
		List<Promote> list = new ArrayList<Promote>();
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Promote(rset.getString("promote_num"), rset.getString("member_ID"), rset.getString("old_promote_File"), rset.getString("renamed_promote_File"), rset.getString("befere_grade"), rset.getDate("promote_apply_Date"), rset.getDate("check_Date"), rset.getString("result_grade")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public Promote getPromote(Connection conn, String promoteNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("getPromote");
		Promote result = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, promoteNum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result = new Promote(rset.getString("promote_num"), rset.getString("member_ID"), rset.getString("old_promote_File"), rset.getString("renamed_promote_File"), rset.getString("befere_grade"),  rset.getDate("promote_apply_Date"), rset.getDate("check_Date"), rset.getString("result_grade"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int PromotedUpdate(Connection conn, String promoteNum, String promoteResult) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("PromotedUpdate");
		int result = 0;
		
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, promoteResult);
			pstmt.setString(2, promoteNum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
