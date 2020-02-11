package carePet.service;

import java.sql.Connection;
import java.util.List;

import carePet.dao.CarePetDAO;
import model.vo.CarePet;

import static common.JDBCTemplate.*;

public class CarePetService {

	public List<CarePet> carePetBoardList() {
		Connection conn = getConnection();
		
		List<CarePet> list = new CarePetDAO().carePetBoardList(conn);
		
		close(conn);
		
		return list;
	}

	public CarePet CarePetBoardView(String carePublicationNum) {
		Connection conn = getConnection();
		
		CarePet result = new CarePetDAO().CarePetBoardView(conn, carePublicationNum);
		
		close(conn);
		
		return result;
	}

}
