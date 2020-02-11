package partner.service;

import java.sql.Connection;
import java.util.List;

import model.vo.Partner;
import partner.dao.PartnerDAO;

import static common.JDBCTemplate.*;

public class PartnerService {

	public List<Partner> partnerList(String field) {
		Connection conn = getConnection();
		
		List<Partner> list = new PartnerDAO().partnerList(conn, field);
		
		close(conn);
				
		return list;
	}

}
