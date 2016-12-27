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
@WebServlet("/servlet/CurdServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext app = null;
	private List<StudentScore>list=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		list = new LinkedList<StudentScore>();
		app = config.getServletContext();
		app.setAttribute("list", list);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("stuName");
		 String clss = request.getParameter("stuClass");
		 String course = request.getParameter("stuCourse");
		 String score = request.getParameter("stuScore");
		 StudentScore sc = new StudentScore();
		 sc.setName(name);
		 sc.setClss(clss);
		 sc.setCourse(course);
		 sc.setScore(score);
		
		 List<StudentScore>list=  (List<StudentScore>)app.getAttribute("list");
		 list.add(sc);
		 app.setAttribute("list", list);
		 response.setHeader("refresh", "0,../ShowStudentScore.jsp");
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
