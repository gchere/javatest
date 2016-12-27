package student;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 * Servlet implementation class CurdServlet
 */
@WebServlet("/servlet/UpDateServlet")
public class UpDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpDate() {
        super();
        // TODO Auto-generated constructor stub
    }
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("stuName");
		 String clss = request.getParameter("stuClass");
		 String course = request.getParameter("stuCourse");
		 String score = request.getParameter("stuScore");
		 HttpSession hs = request.getSession();
		 int x = (int)hs.getAttribute("index");
		 List<StudentScore> list = (List<StudentScore>)getServletContext().getAttribute("list");
		 list.get(x).setName(name);
		 list.get(x).setClss(clss);
		 list.get(x).setCourse(course);
		 list.get(x).setScore(score);
		
		
		 
		 getServletContext().setAttribute("list", list);
		 response.setHeader("refresh", "0,../ShowStudentScore.jsp");
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
