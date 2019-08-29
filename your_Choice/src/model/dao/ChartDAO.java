package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.TableChartDTO;
import util.DBUtil;

public class ChartDAO {
	public static ArrayList<TableChartDTO> getAllChart() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TableChartDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select userinfo.usernum, userinfo.nickname, vote.vhuman, vote.vai, userinfo.age, userinfo.sex, userinfo.location from userinfo, vote where userinfo.usernum = vote.usernum");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<TableChartDTO>();
			while(rset.next()){
				list.add(new TableChartDTO(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getString(6), rset.getString(7)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
