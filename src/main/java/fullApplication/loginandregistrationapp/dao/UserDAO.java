package fullApplication.loginandregistrationapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fullApplication.loginandregistrationapp.model.User;

public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + " (name, password) VALUES " + " (?, ?);";
	
	private static final String SELECT_USER_BY_ID = "select id,name,password from users where id = ?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set name = ?, password= ? where id = ?;";
	
	protected Connection getConnection(){
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
		e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	// Creation
	public void insertUser(User user) throws SQLException{
		try(Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
				preparedStatement.setString(1, user.getName());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.executeUpdate();
				}catch (Exception e){
					e.printStackTrace();
				}
		}
	
	// Updating
	public boolean updateUser(User user) throws SQLException{
		boolean rowUpdated;
		try(Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);){
				statement.setString(1, user.getName());
				statement.setString(2, user.getPassword());
				statement.setInt(3, user.getId());
				
				rowUpdated = statement.executeUpdate() > 0;
			}
			return rowUpdated;
	}
	
	// Selection by ID
	public User selectUser(int id){
		User user = null;
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);){
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				String name = rs.getString("name");
				String password = rs.getString("password");
				user = new User(id, name, password);
				}
				} catch (SQLException e){
					e.printStackTrace();
				}
				return user;
	}
	
	// Select all the users
	public List<User> selectAllUsers(){
		List<User> users = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);){
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				users.add(new User(id, name, password));
				}
				} catch (SQLException e){
					e.printStackTrace();
				}
				return users;
			}
	
	// Deletion
	public boolean deleteUser(int id) throws SQLException{
		boolean rowDeleted;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);){
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;	
	}
}