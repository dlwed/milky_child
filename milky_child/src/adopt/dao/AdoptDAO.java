package adopt.dao;

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

import model.vo.Adopt;
import static common.JDBCTemplate.*;

public class AdoptDAO {
	
	private Properties prop = new Properties();

	public AdoptDAO() {

		String fileName = AdoptDAO.class.getResource("/sql/adopt/query.properties").getPath();

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

	public String getAdoptNum(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("getAdoptNum");
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

	public int insertAdoptApplication(Connection conn, Adopt a) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertAdoptApplication");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, a.getAdoptNum());
			pstmt.setString(2, a.getMemberId());
			pstmt.setString(3, a.getCarePublicationNum());
			pstmt.setString(4, a.getAPAgreementFile());
			pstmt.setString(5, a.getPetApplicationFile());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<Adopt> getAdoptList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		String query = prop.getProperty("getAdoptList");
		List<Adopt> list = new ArrayList<Adopt>();
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Adopt(rset.getString("adopt_num"), rset.getString("member_ID"), rset.getString("care_publication_num"), rset.getString("AP_Agreement_File"), rset.getString("pet_Application_File"), rset.getDate("application_Date"), rset.getDate("check_Date"), rset.getString("adopt_result")));
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

}
