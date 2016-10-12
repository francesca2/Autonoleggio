package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;
import utility.DataSource;

public class MacchinaDao {
	
	public int registraMacchina(String modello, String targa){
		int primaryKey = 0;
		PreparedStatement st = null;
		try {
			Connection con = DataSource.getInstance().getConnection();
			String sql = "insert into macchina(modello,targa) VALUES (?,?)";
			st = con.prepareStatement(sql, new String[]{"id_macchina"});
			st.setString(1, modello);
			st.setString(2, targa);
			st.executeUpdate();
			ResultSet generatedKeys = st.getGeneratedKeys();
			if (null != generatedKeys && generatedKeys.next()) {
				primaryKey = generatedKeys.getInt(1);
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} 
		return primaryKey;
	}
	
	public Macchina trovaMacchina(String targa){
		PreparedStatement st = null;
		ResultSet rst=null;
		Macchina m=null;
		try {
			Connection con = DataSource.getInstance().getConnection();
			String sql = "select * from macchina where targa=?";
			st = con.prepareStatement(sql);
			st.setString(1, targa);
			rst=st.executeQuery();

			if (rst.next()) {
				long id=rst.getInt(1);
				String modello= rst.getString(2);
				m=new Macchina(id,modello,targa);
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(rst != null)
				try {
					rst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} 
		return m;
	}
	
	public boolean aggiornaMacchina(String modello, String targa)
	{		
		PreparedStatement st = null;
		boolean b=false;
		try {
			Connection con = DataSource.getInstance().getConnection();
			String sql = "update macchina set modello=? where targa=?";
			st = con.prepareStatement(sql);
			st.setString(1, modello);
			st.setString(2, targa);
			int n=st.executeUpdate();

			if (n>0) {
				b=true;
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

		} 
		return b;		
	}
	
	public boolean eliminaMacchina(String targa)
	{
		boolean b=false;
		PreparedStatement st = null;
		try {
			Connection con = DataSource.getInstance().getConnection();
			String sql = "delete from macchina where targa=?";
			st = con.prepareStatement(sql);
			st.setString(1, targa);
			int n= st.executeUpdate();
			if(n>0)
			{
				b=true;
			}

		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}  
		return b;
	}
	
}
