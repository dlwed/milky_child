package partner.dao;

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

import carePet.dao.CarePetDAO;
import model.vo.Partner;
import static common.JDBCTemplate.*;

public class PartnerDAO {

	private Properties prop = new Properties();
	
	public PartnerDAO() {
		String fileName = CarePetDAO.class.getResource("/sql/partner/query.properties").getPath();
		
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

	public List<Partner> partnerList(Connection conn, String field) {
		List<Partner> list = new ArrayList<Partner>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("partnerList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, field);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Partner(rset.getString("coop_code"), rset.getString("coop_name"), rset.getString("coop_field"), rset.getString("coop_grade"), rset.getString("coop_call"), rset.getString("coop_fax"), rset.getDate("coop_contract_day"), rset.getString("coop_CEO_name"), rset.getString("coop_url")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

}
