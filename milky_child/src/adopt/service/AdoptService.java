package adopt.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import adopt.dao.AdoptDAO;
import model.vo.Adopt;

public class AdoptService {

	public String getAdoptNum() {
		Connection conn = getConnection();
		
		String result = new AdoptDAO().getAdoptNum(conn);
		
		close(conn);
		
		return result;
	}

	public int insertAdoptApplication(Adopt a) {
		Connection conn = getConnection();
		
		int result = new AdoptDAO().insertAdoptApplication(conn,a);
		
		if(result > 0)commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public List<Adopt> getAdoptList() {
		Connection conn = getConnection();
		
		List<Adopt> list = new AdoptDAO().getAdoptList(conn);
		
		close(conn);
		
		return list;
	}

}
