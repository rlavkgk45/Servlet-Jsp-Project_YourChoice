package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.NotExistException;
import model.dto.ScatterChartDTO;
import model.dto.TableChartDTO;
import model.dto.UserInfoDTO;
import model.dto.VoteDTO;

public class YourChoiceService {

	public static void notExistUserInfo(String nickName) throws NotExistException, SQLException{
		System.out.println("service UserInfo notExistUserInfo");
		UserInfoDTO userInfo = UserInfoDAO.getUserInfo(nickName);
		if(userInfo == null){
			throw new NotExistException("검색하신 User정보가 없습니다.");
		}
	}

	public static boolean addUserInfo(UserInfoDTO voter) throws SQLException{
		System.out.println("service UserInfo add");
		return UserInfoDAO.addUserInfo(voter);
	}
	
	public static boolean updateUserInfo(String nickName, int age) throws SQLException, NotExistException{
		System.out.println("service UserInfo update");
		notExistUserInfo(nickName);
		return UserInfoDAO.updateUserInfo(nickName, age);
	}
	
	public boolean deleteUserInfo(String nickName) throws SQLException, NotExistException{
		System.out.println("service UserInfo delete");
		notExistUserInfo(nickName);
		return UserInfoDAO.deleteUserInfo(nickName);
	}
	
	public static ArrayList<UserInfoDTO> getAllUserInfo() throws SQLException{
		System.out.println("service userInfo all");
		return UserInfoDAO.getAllUserInfo();
	}
		
	public static UserInfoDTO getUserInfo(String nickName) throws SQLException, NotExistException{
		System.out.println("service userInfo nickName로 검색");
		UserInfoDTO userInfo = UserInfoDAO.getUserInfo(nickName);
		if(userInfo == null){
			throw new NotExistException("검색하신 nickName의 User정보가 없습니다.");
		}
		return userInfo;
	}
	
	public static String userNickName(String nickName) throws SQLException, NotExistException{
		System.out.println("service userInfo nickName 존재 하는지 확인");
		String userNickName = UserInfoDAO.getUserNickName(nickName);
		return userNickName;
	}

// ======================================================================================================
	
	public static void notExistVote(String nickName) throws NotExistException, SQLException{
		System.out.println("service Vote notExistUserInfo");
		VoteDTO vote = VoteDAO.getVote(nickName);
		if(vote == null){
			throw new NotExistException("검색하신 User정보가 없습니다.");
		}
	}

	public static boolean addVote(VoteDTO voteResult) throws SQLException{
		System.out.println("service Vote add");
		return VoteDAO.addVote(voteResult);
	}
	
	public static boolean updateVote(String nickName, String question) throws SQLException, NotExistException{
		System.out.println("service Vote(vHuman) update");
		notExistUserInfo(nickName);
		return VoteDAO.updateVHuman(nickName, question);
	}
	
	public boolean deleteVote(String nickName) throws SQLException, NotExistException{
		System.out.println("service Vote delete");
		notExistUserInfo(nickName);
		return VoteDAO.deleteVote(nickName);
	}
	
	public static ArrayList<VoteDTO> getAllVote() throws SQLException{
		System.out.println("service Vote all");
		return VoteDAO.getAllVote();
	}
		
	public static VoteDTO getVote(String nickName) throws SQLException, NotExistException{
		System.out.println("service Vote nickName로 검색");
		VoteDTO vote = VoteDAO.getVote(nickName);
		if(vote == null){
			throw new NotExistException("검색하신 nickName의 Vote정보가 없습니다.");
		}
		return vote;
	}
	
// ======================================================================================================
	
	public static ArrayList<TableChartDTO> getTableChart() throws SQLException{
		System.out.println("service TableChartDTO");
		return ChartDAO.getAllChart();
	}
	
	public static ArrayList getPieChart() throws SQLException{
		System.out.println("service getPieChart");
		ArrayList<TableChartDTO> list = ChartDAO.getAllChart();
		ArrayList al = new ArrayList();
		
		int getListSize = list.size();
		int getVHuman = 0;
		int getVAi = 0;
		
		for(int i=0; i<getListSize; i++) {
			getVAi = getVAi + list.get(i).getVHuman();
			getVHuman = getVHuman + list.get(i).getVAi();
		}
		al.add(getVAi);
		al.add(getVHuman);
		System.out.println(al);
		return al;
	}
	
	public static ArrayList getAgeInfo() throws SQLException{
		System.out.println("service getAgeInfo");
		ArrayList<TableChartDTO> list = ChartDAO.getAllChart();
		ArrayList<ScatterChartDTO> al = new ArrayList();
		
		int getListSize = list.size();
		
		for(int i=0; i<getListSize; i++) {
			al.add(new ScatterChartDTO(list.get(i).getAge(), list.get(i).getVAi()));
		}
		System.out.println(al);
		return al;
	}
	
	public static ArrayList getSexInfo() throws SQLException{
		System.out.println("service getSexInfo");
		ArrayList<TableChartDTO> list = ChartDAO.getAllChart();
		ArrayList al = new ArrayList();
		
		int getListSize = list.size();
		int sumVHumanM = 0;
		int sumVAiM = 0;
		int sumVHumanF = 0;
		int sumVAiF = 0;
		
		for(int i=0; i<getListSize; i++) {
			if(list.get(i).getSex().equals("male")) {
				sumVHumanM = sumVHumanM + list.get(i).getVHuman();
				sumVAiM = sumVAiM + list.get(i).getVAi();
			}else if(list.get(i).getSex().equals("female")) {
				sumVHumanF = sumVHumanF + list.get(i).getVHuman();
				sumVAiF = sumVAiF + list.get(i).getVAi();
			}
		}
		al.add(sumVHumanM);
		al.add(sumVAiM);
		al.add(sumVHumanF);
		al.add(sumVAiF);
		System.out.println(al);
		return al;
	}
	
	public static ArrayList getLocationInfo() throws SQLException{
		System.out.println("service getLocationInfo");
		ArrayList<TableChartDTO> list = ChartDAO.getAllChart();
		ArrayList al = new ArrayList();
		
		int getListSize = list.size();
		int suAi = 1;
		int suHuman = 1;
		
		int gangAi = 1;
		int gangHuman = 1;
		
		int northChungAi = 1;
		int northChungHuman = 1;
		
		int southChungAi = 1;
		int southChungHuman = 1;
		
		int northGyeongAi = 1;
		int northGyeongHuman = 1;
		
		int southGyeongAi = 1;
		int southGyeongHuman = 1;
		
		int northJeonAi = 1;
		int northJeonHuman = 1;
		
		int southJeonAi = 1;
		int southJeonHuman = 1;
		
		for(int i=0; i<getListSize; i++) {
			if(list.get(i).getLocation().equals("수도권")) {
				suAi = suAi + list.get(i).getVAi();
				suHuman = suHuman + list.get(i).getVHuman();
			}else if(list.get(i).getLocation().equals("강원도")) {
				gangAi = gangAi + list.get(i).getVAi();
				gangHuman = gangHuman + list.get(i).getVHuman();
			}else if(list.get(i).getLocation().equals("충청북도")) {
				northChungAi = northChungAi + list.get(i).getVAi();
				northChungHuman = northChungHuman +	list.get(i).getVHuman();
			}else if(list.get(i).getLocation().equals("충청남도")) {
				southChungAi = southChungAi + list.get(i).getVAi();
				southChungHuman = southChungHuman + list.get(i).getVHuman();
			}else if(list.get(i).getLocation().equals("경상북도")) {
				northGyeongAi = northGyeongAi + list.get(i).getVAi();
				northGyeongHuman = northGyeongHuman + list.get(i).getVHuman();
			}else if(list.get(i).getLocation().equals("경상남도")) {
				southGyeongAi = southGyeongAi + list.get(i).getVAi();
				southGyeongHuman = southGyeongHuman + list.get(i).getVHuman();
			}else if(list.get(i).getLocation().equals("전라북도")) {
				northJeonAi = northJeonAi + list.get(i).getVAi();
				northJeonHuman = northJeonHuman + list.get(i).getVHuman();
			}else if(list.get(i).getLocation().equals("전라남도")) {
				southJeonAi = southJeonAi + list.get(i).getVAi();
				southJeonHuman = southJeonHuman + list.get(i).getVHuman();
			}
		}
		
		   int suAipercent = (int) Math.floor(100*suAi/(suAi+suHuman));
		    int suNum = (int) Math.floor(suAi+suHuman);
		    al.add(suAipercent);
		    al.add(suNum);
		    
		    System.out.println(al + "1");
		    
		    int gangAipercent = (int) Math.floor(100*gangAi/(gangAi+gangHuman));
		    int gangNum = (int) Math.floor(gangAi+gangHuman);
		    al.add(gangAipercent);
		    al.add(gangNum);
		    
		    System.out.println(al + "2");
		    
		    int northChungAipercent = (int) Math.floor(100*northChungAi/(northChungAi+northChungHuman));
		    int northChungNum = (int) Math.floor(northChungAi+northChungHuman);
		    al.add(northChungAipercent);
		    al.add(northChungNum);
		    
		    System.out.println(al + "3");
		    
		    int southChungAipercent = (int) Math.floor(100*southChungAi/(southChungAi+southChungHuman));
		    int southChungNum = (int) Math.floor(southChungAi+southChungHuman);
		    al.add(southChungAipercent);
		    al.add(southChungNum);
		    
		    System.out.println(al + "4");
		    
		    int northGyeongAipercent = (int) Math.floor(100*northGyeongAi/(northGyeongAi+northGyeongHuman));
		    int northGyeongNum = (int) Math.floor(northGyeongAi+northGyeongHuman);
		    al.add(northGyeongAipercent);
		    al.add(northGyeongNum);
		    
		    System.out.println(al + "5");
		    
		    int southGyeongAipercent = (int) Math.floor(100*southGyeongAi/(southGyeongAi+southGyeongHuman));
		    int southGyeongNum = (int) Math.floor(southGyeongAi+southGyeongHuman);
		    al.add(southGyeongAipercent);
		    al.add(southGyeongNum);
		    
		    System.out.println(al + "6");
		    
		    int northJeonAipercent = (int) Math.floor(100*northJeonAi/(northJeonAi+northJeonHuman));
		    int northJeonNum = (int) Math.floor(northJeonAi+northJeonHuman);
		    al.add(northJeonAipercent);
		    al.add(northJeonNum);
		    
		    System.out.println(al + "7");
		    
		    int southJeonAipercent = (int) Math.floor(100*southJeonAi/(southJeonAi+southJeonHuman));
		    int southJeonNum = (int) Math.floor(southJeonAi+southJeonHuman);
		    al.add(southJeonAipercent);
		    al.add(southJeonNum);
		    
		    System.out.println(al + "8");
		
		
		
		return al;
	}
	
}