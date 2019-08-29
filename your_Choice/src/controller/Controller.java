package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.NotExistException;
import model.dao.YourChoiceService;
import model.dto.UserInfoDTO;
import model.dto.VoteDTO;

@WebServlet("/Con")
public class Controller extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=utf-8");
    	request.setCharacterEncoding("UTF-8");
    	
    	String command = request.getParameter("command");
    	
    	try{
			if(command.equals("insertUserInfo")){
				insertUserInfo(request, response);
			}else if(command.equals("updateVote")){
				updateVote(request, response);
			}else if(command.equals("admin")) {
				admin(request, response);
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
    }
	
	protected void insertUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException, SQLException, NotExistException {
		HttpSession session = request.getSession();
		
		String url = "showError.jsp";
		
		if(YourChoiceService.userNickName(request.getParameter("nickName")) == null){
			session.setAttribute("nickName", request.getParameter("nickName"));
			session.setAttribute("sex", request.getParameter("sex"));
			session.setAttribute("age", request.getParameter("age"));
			session.setAttribute("location", request.getParameter("location"));
		      
			String nickName = (String) session.getAttribute("nickName");
			String sex = (String) session.getAttribute("sex");
			int age = Integer.parseInt((String) session.getAttribute("age"));
			String location = (String) session.getAttribute("location");
		      
			if(nickName != null && nickName.length() != 0 && 
					sex != null && sex.length() != 0&&
					location != null && location.length() != 0) {
		         
				UserInfoDTO voter = new UserInfoDTO(nickName, sex, age, location);
		         
				try{
					boolean result = YourChoiceService.addUserInfo(voter);
					if(result){
						url = "vote.jsp";
					}else{
						session.setAttribute("errorMsg", "다시 시도하세요");
					}
				}catch(Exception s){
					session.setAttribute("errorMsg", s.getMessage());
				}
				response.sendRedirect(url);
			}
		}else {
			session.setAttribute("errorMsg", "이미 존재하는 닉네임 입니다.");
			response.sendRedirect(url);
		}
		
//		session.setAttribute("nickName", request.getParameter("nickName"));
//		session.setAttribute("sex", request.getParameter("sex"));
//		session.setAttribute("age", request.getParameter("age"));
//		session.setAttribute("location", request.getParameter("location"));
//	       
//		String url = "showError.jsp";
//	      
//		String nickName = (String) session.getAttribute("nickName");
//		String sex = (String) session.getAttribute("sex");
//		int age = Integer.parseInt((String) session.getAttribute("age"));
//		String location = (String) session.getAttribute("location");
//	      
//		if(nickName != null && nickName.length() != 0 && 
//				sex != null && sex.length() != 0&&
//				location != null && location.length() != 0) {
//	         
//			UserInfoDTO voter = new UserInfoDTO(nickName, sex, age, location);
//	         
//			try{
//				boolean result = YourChoiceService.addUserInfo(voter);
//				if(result){
//					url = "vote.jsp";
//				}else{
//					session.setAttribute("errorMsg", "다시 시도하세요");
//				}
//			}catch(Exception s){
//				session.setAttribute("errorMsg", s.getMessage());
//			}
//			response.sendRedirect(url);
//		}
	}
	
	
	public void updateVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("question", request.getParameter("question"));
		
		System.out.println("Controller - updateVote");
		System.out.println(session.getAttribute("nickName"));
		System.out.println(session.getAttribute("question"));
		String url = "showError.jsp";
		try {
			session.setAttribute("voteResult", YourChoiceService.updateVote((String)session.getAttribute("nickName"), (String)session.getAttribute("question")));
				String a = request.getParameter("pageNumber");
				
				if(a.equals("8")) {
					VoteDTO vote = YourChoiceService.getVote((String)session.getAttribute("nickName"));
					session.setAttribute("vHuman", vote.getVHuman());
					session.setAttribute("vAi", vote.getVAi());
					url = "result.jsp";
				}else {
					url = "vote"+ a +".jsp";
				}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		response.sendRedirect(url);
	}
	
//	public void updateVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	      HttpSession session = request.getSession();
//	      session.setAttribute("question", request.getParameter("question"));
//	      
//	      System.out.println("Controller - updateVote");
//	      System.out.println(session.getAttribute("nickName"));
//	      System.out.println(session.getAttribute("question"));
//	      String url = "showError.jsp";
//	      try {
//	         session.setAttribute("voteResult", YourChoiceService.updateVote((String)session.getAttribute("nickName"), (String)session.getAttribute("question")));
//	         a++;
//	         if(a<8) {
//	            url = "vote"+ a +".jsp";
//	         }else {
//	            VoteDTO vote = YourChoiceService.getVote((String)session.getAttribute("nickName"));
//	            session.setAttribute("vResult", vote);
//	            session.setAttribute("vHuman", vote.getVHuman());
//	            session.setAttribute("vAi", vote.getVAi());
//	            url = "result.jsp";
//	         }
//	      }catch(Exception s){
//	         request.setAttribute("errorMsg", s.getMessage());
//	      }
//	      response.sendRedirect(url);
//	   }
	
	public void admin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	      
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String url = "showError.jsp";
		try {
			if(id.equals("admin") && pw.equals("admin")) {
				session.setAttribute("getAllChart", YourChoiceService.getTableChart());
				session.setAttribute("getPieChart", YourChoiceService.getPieChart());
				session.setAttribute("getAgeInfo", YourChoiceService.getAgeInfo());
				session.setAttribute("getSexInfo", YourChoiceService.getSexInfo());
				session.setAttribute("getLocationInfo", YourChoiceService.getLocationInfo());
				url = "admin.jsp";
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		response.sendRedirect(url);
	}

}