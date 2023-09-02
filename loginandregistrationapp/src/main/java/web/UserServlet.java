package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.IoTManager;
import business.LoggingInterceptor;
import dao.IoTDao;
import dao.UserDAO;
import facade.MeasurementFacade;
import factory.UserFactory;
import model.Iotdevice;
import model.Measurement;
import model.Sensor;
import model.User;
import service.LoggingService;

/**
 * Servlet implementation class UserServlet
 */
@Stateless
@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	@Inject
	LoggingService log;
	@Inject
	MeasurementFacade mFacade;
//	{
//		try {
//			mFacade = (MeasurementFacade) new InitialContext()
//					.lookup("java:global/Facade/MeasurementFacades");
//        } catch (NamingException e) { 
//            e.printStackTrace();
//        }
//    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        this.userDAO = new UserDAO();
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action){
		case "/new":
		showNewForm(request, response);
			break;
		case "/insert":
			try{
				insertUser(request, response);
			} catch (SQLException e){
				e.printStackTrace();
			}
			break;
		case "/delete":
			try{
				deleteUser(request, response);
			} catch (SQLException e){
				e.printStackTrace();
			}
			break;
		case "/edit":
			try {
				showEditForm(request, response);
			} catch (SQLException e){
				e.printStackTrace();
			}
			break;
		case "/update":
			try{
				updateUser(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case "/tab":
			try{
				listTabularData(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case "/showSensor":
			try{
				showSensors(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/list":
			try{
				listUser(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			try{
				listUser(request, response);
			} catch (SQLException e){
				e.printStackTrace();
			}
			break;
		}
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		//log.log("**** List users ****");
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void listTabularData(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		//log.log("**** List Tabular Data ****");
		IoTDao iotDao = new IoTDao();      
		List<Iotdevice> listData = iotDao.getDevices();
        request.setAttribute("tabularList", listData);
        //Use of injected not functioning 
//		List<Iotdevice> listData = this.mFacade.getMeasurements();
//      request.setAttribute("tabularList", listData);
        
        // Forward to the JSP page responsible for displaying the tabular data
        RequestDispatcher dispatcher = request.getRequestDispatcher("DataPage.jsp");
        dispatcher.forward(request, response);
	}

	private void showSensors(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		//log.log("**** List Sensors Only ****");
		List<Sensor> listData = this.mFacade.getSensors();
		//The below commented lines work, but the injected class does not work
//		IoTDao iotDao = new IoTDao();      
//		List<Sensor> listData = iotDao.readSensors();
      request.setAttribute("sensorList", listData);

      // Forward to the JSP page responsible for displaying the sensor data
      RequestDispatcher dispatcher = request.getRequestDispatcher("sensors.jsp");
      dispatcher.forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("list");
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		User user = new User(id, name, password);
		userDAO.updateUser(user);
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}
		

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException{
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User newUser = new User(20, name, password);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}
}
