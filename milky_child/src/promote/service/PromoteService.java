package promote.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import model.vo.Promote;
import promote.dao.PromoteDAO;

public class PromoteService {

	public String getPromoteNum() {
		Connection conn = getConnection();
		
		String result = new PromoteDAO().getPromoteNum(conn);
		
		close(conn);
		
		return result;
	}

	public int insertPromoteApplication(Promote p) {
		Connection conn = getConnection();
		
		int result = new PromoteDAO().insertPromoteApplication(conn, p);
		
		if(result > 0)commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public List<Promote> getPromoteList() {
		Connection conn = getConnection();
		
		List<Promote> list = new PromoteDAO().getPromoteList(conn);
		
		close(conn);
		
		return list;
	}

	public Promote getPromote(String promoteNum) {
		Connection conn = getConnection();
		
		Promote result = new PromoteDAO().getPromote(conn, promoteNum);
		
		close(conn);
		
		return result;
	}

	public int promotedUpdate(String promoteNum, String resultGrade) {
		Connection conn = getConnection();
		
		int result = new PromoteDAO().PromotedUpdate(conn, promoteNum, resultGrade);

		if(result > 0)commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

}
