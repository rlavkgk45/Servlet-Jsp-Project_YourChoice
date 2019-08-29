package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.UserInfoDTO;
import util.DBUtil;

public class UserInfoDAO {
	public static boolean addUserInfo(UserInfoDTO voter) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into userInfo values(seq_userinfo_userinfo.nextval, ?, ?, ?, ?)");
			pstmt.setString(1, voter.getNickName());
			pstmt.setString(2, voter.getSex());
			pstmt.setInt(3, voter.getAge());
			pstmt.setString(4, voter.getLocation());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean updateUserInfo(String nickName, int age) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update userInfo set age=? where nickName=?");
			pstmt.setInt(1, age);
			pstmt.setString(2, nickName);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean deleteUserInfo(String nickName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from userInfo where nickName=?");
			pstmt.setString(1, nickName);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static UserInfoDTO getUserInfo(String nickName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		UserInfoDTO userInfo = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select nickname, sex, age, location from UserInfo where nickName=?");
			pstmt.setString(1, nickName);
			rset = pstmt.executeQuery();
			if(rset.next()){
				userInfo = new UserInfoDTO(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getString(4));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return userInfo;
	}

	public static ArrayList<UserInfoDTO> getAllUserInfo() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<UserInfoDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select nickname, sex, age, location from userInfo");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<UserInfoDTO>();
			while(rset.next()){
				list.add(new UserInfoDTO(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getString(4)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static String getUserNickName(String nickName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String userInfo = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select nickname from UserInfo where nickName=?");
			pstmt.setString(1, nickName);
			rset = pstmt.executeQuery();
			if(rset.next()){
				userInfo = rset.getString(1);
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return userInfo;
	}
}
