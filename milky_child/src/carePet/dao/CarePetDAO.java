package carePet.dao;

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

import model.vo.CarePet;

import static common.JDBCTemplate.*;

public class CarePetDAO {

	private Properties prop = new Properties();
	
	public CarePetDAO() {
		String fileName = CarePetDAO.class.getResource("/sql/carePet/query.properties").getPath();

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

	public List<CarePet> carePetBoardList(Connection conn) {
		List<CarePet> list = new ArrayList<CarePet>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("carePetBoardList");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new CarePet(rset.getString("care_publication_num"), 
									 rset.getString("care_breed"), 
									 rset.getString("care_name"), 
									 rset.getInt("care_age"), 
									 rset.getDate("care_receive_day"), 
									 rset.getString("care_gender"), 
									 rset.getString("care_cha"), 
									 rset.getString("care_con"),
									 rset.getString("care_find_loc"),
									 rset.getString("care_regi_NO"),
									 rset.getString("care_shelter")));
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

	public CarePet CarePetBoardView(Connection conn, String carePublicationNum) {
		CarePet result = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("carePetBoardView");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, carePublicationNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = new CarePet(rset.getString("care_publication_num"), 
									 rset.getString("care_breed"), 
									 rset.getString("care_name"), 
									 rset.getInt("care_age"), 
									 rset.getDate("care_receive_day"), 
									 rset.getString("care_gender"), 
									 rset.getString("care_cha"), 
									 rset.getString("care_con"),
									 rset.getString("care_find_loc"),
									 rset.getString("care_regi_NO"),
									 rset.getString("care_shelter"));
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

}
