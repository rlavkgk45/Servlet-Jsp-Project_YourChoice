package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.UserInfoDTO;
import model.dto.VoteDTO;
import util.DBUtil;

public class VoteDAO {
	
	//트리거로 구현 되어 있음
	public static boolean addVote(VoteDTO voteResult) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into vote values(seq_userinfo_userinfo.nextval, ?, ?)");
			pstmt.setInt(1, voteResult.getVHuman());
			pstmt.setInt(2, voteResult.getVAi());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean updateVHuman(String nickName, String question) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			if(question.equals("h")) {
				pstmt = con.prepareStatement("update vote set vHuman=vHuman+1  where usernum = (select userinfo.usernum from userinfo, vote where userinfo.usernum = vote.usernum and userinfo.nickname = ?)");
			}else if(question.equals("a")){
				pstmt = con.prepareStatement("update vote set vAi=vAi+1  where usernum = (select userinfo.usernum from userinfo, vote where userinfo.usernum = vote.usernum and userinfo.nickname = ?)");
			}
			
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
	
	public static boolean updateVAi(String nickName, int vAi) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update vote set vAi=? where usernum = (select v.usernum from userinfo u, vote v where u.usernum = v.usernum and u.nickname = ?");
			pstmt.setInt(1, vAi);
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

	public static boolean deleteVote(String nickName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from vote where usernum = (select v.usernum from userinfo u, vote v where u.usernum = v.usernum and u.nickname = ?");
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

	public static VoteDTO getVote(String nickName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		VoteDTO vote = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select vHuman, vAi from vote where usernum = (select v.usernum from userinfo u, vote v where u.usernum = v.usernum and u.nickname = ?)");
			pstmt.setString(1, nickName);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				vote = new VoteDTO(rset.getInt(1), rset.getInt(2));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return vote;
	}

	public static ArrayList<VoteDTO> getAllVote() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<VoteDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select vHuman, vAi from vote");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<VoteDTO>();
			while(rset.next()){
				list.add(new VoteDTO(rset.getInt(1), rset.getInt(2)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}