package dao;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.NamingException;

import util.ConnectionPool;

public class UserDAO {
	
	public boolean insert(String uid, String upass,String uname) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
		String sql = "INSERT INTO userinfo(id,password,name) VALUES(?,?,?)";
		conn = ConnectionPool.get();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, uid);
		stmt.setString(2, upass);
		stmt.setString(3, uname);
		
		int count = stmt.executeUpdate();
		return (count>0)? true : false;
		
		}catch(NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(stmt!=null)
					stmt.close();
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		return false;
		
	}
	
	public boolean select(String uid) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
		String sql = "SELECT id FROM user WHERE id = ?";
		conn = ConnectionPool.get();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, uid);
		rs=stmt.executeQuery();
		
		return rs.next();
		
		}catch(NamingException | SQLException e) {e.printStackTrace();}
		finally {
			
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
				stmt.close();
				if(conn!=null)
					conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

		return false;
		
	}
	
	public boolean delete(String uid) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
		String sql = "DELETE FROM user WHERE id = ?";
		conn = ConnectionPool.get();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, uid);
		
		int count = stmt.executeUpdate();
		return (count>0)? true : false;
		
		}catch(NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(stmt!=null)
					stmt.close();
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		return false;
	
	}
	
	public int login(String uid, String upass) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
		String sql = "SELECT id,password FROM userinfo WHERE id = ?";
		conn = ConnectionPool.get();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, uid);
		rs=stmt.executeQuery();
		
		if(!rs.next()) return 1;
		
		
		if(!upass.equals(rs.getString("password"))) return 2;
		
		
		
		}catch(NamingException | SQLException e) {e.printStackTrace();}
		finally {
			
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
				stmt.close();
				if(conn!=null)
					conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		
		
		
		
		return 0;
		
	}
	public ArrayList<UserDto> getList(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM user ORDER BY regDt DESC";
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			
			ArrayList<UserDto> list = new ArrayList<>();
			while(rs.next()) {
				list.add(new UserDto(rs.getString("id"),rs.getString("name"),rs.getString("regDt")));
				
			}
			return list;
		}catch(NamingException | SQLException e) {
			e.printStackTrace();
		}	finally {
			
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
				stmt.close();
				if(conn!=null)
					conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		return null;
		
		
	
		
	}
	
	
}
