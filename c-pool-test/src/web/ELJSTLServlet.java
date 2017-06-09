package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ELJSTLServlet")
public class ELJSTLServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.getClass());
		
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("최기람","M", 24));
		userList.add(new User("김상훈","M", 27));
		userList.add(new User("한재희","F", 32));
		request.setAttribute("userList", userList);
		
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("최기람");
		strList.add("김상훈");
		strList.add("한재희");
		request.setAttribute("strList", strList);
		RequestDispatcher rd = request.getRequestDispatcher("./view.jsp");
		rd.forward(request, response);
	}
}
