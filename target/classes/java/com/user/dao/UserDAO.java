package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.model.User;

public class UserDAO {
	
	private String jdbcURL="jdbc:mysql://localhost:30006/userappdb";
	private String jdbcUserName="root";
	private String jdbcPassward="My_sql@327";
	
	
	private static final String INSERT_USER_SQL="INSERT INTO Book"+"( ISBN, title, Author, pub_year) VALUES "+"(?,?,?,?);";	
	private static final String SELECT_USER_BY_ID="SELECT * FROM Book where id=?;";
	private static final String SELECT_ALL_USERS="SELECT * FROM Book;";
	private static final String DELETE_USERS_SQL="DELETE FROM Book WHERE id=?;";
	private static final String UPDATE_USERS_SQL="UPDATE Book SET ISBN=?, TITLE=?, AUTHOR=?, PUB_YEAR=? WHERE ID=?;";
	
	public UserDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection() {
		
		Connection connection=null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(jdbcURL, DELETE_USERS_SQL, jdbcPassward);
		}
		
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
		
	}
	
	
	public void insertUser(User user)
	{
		UserDAO dao=new UserDAO();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USER_SQL);
			preparedStatement.setInt(1,user.getISBN());
			preparedStatement.setString(2,user.getTitle());
			preparedStatement.setString(1,user.getAuthor());
			preparedStatement.setInt(1,user.getPub_year());
			
			preparedStatement.executeUpdate();
			
			
		}
		catch ( Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public User selectUser(int id ) {
		User user =new User();
		UserDAO dao=new UserDAO();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				user.setId(id);
				user.setISBN(resultSet.getInt("ISBN"));
				user.setTitle(resultSet.getString("title"));
				user.setAuthor(resultSet.getString("Author"));
				user.setPub_year(resultSet.getInt("pub_year"));
				
			}
			
			
			
		}
		catch ( Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}
	
	public List<User> selectAllUsers()
	{
		List<User> users= new ArrayList<User>();
		UserDAO dao=new UserDAO();

		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_USERS);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int id=resultSet.getInt("id");
				String ISBN=resultSet.getString("ISBN");
				String title=resultSet.getString("title");
				String Author=resultSet.getString("Auhtor");
				int Pub_year=resultSet.getInt("pub_year");
				
				users.add(new User(id,ISBN,title,Author,Pub_year));
				
			 }
		}
		catch ( Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public boolean deleteUser(int id )
	{
		boolean status = false;
		UserDAO dao=new UserDAO();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USERS_SQL);
			preparedStatement.setInt(id, id);
			
			status=preparedStatement.execute();
		}
		catch ( Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
}
