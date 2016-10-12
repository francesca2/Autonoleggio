package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.Macchina;
import model.Utente;
import utility.DataSource;

public class UtenteDao {

	public int registraUtente(String nome,String cognome,String codiceFiscale){
		int primaryKey = 0;
		PreparedStatement st = null;
		try {
			Connection con = DataSource.getInstance().getConnection();
			String sql = "insert into utente(nome,cognome,codice_fiscale) VALUES (?,?,?)";
			st = con.prepareStatement(sql, new String[]{"id_utente"});
			st.setString(1, nome);
			st.setString(2, cognome);
			st.setString(3, codiceFiscale);
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

	public Utente trovaUtente(String nome,String cognome,String codiceFiscale){
		PreparedStatement st = null;
		ResultSet rst=null;
		Utente u=null;
		try {
			Connection con = DataSource.getInstance().getConnection();
			String sql = "select * from utente where nome=? and cognome=? and codice_fiscale=?";
			st = con.prepareStatement(sql);
			st.setString(1, nome);
			st.setString(2, cognome);
			st.setString(3, codiceFiscale);
			rst=st.executeQuery();

			if (rst.next()) {
				long id=rst.getInt(1);
				u=new Utente(id, nome, cognome, codiceFiscale);
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
		return u;
	}

	public boolean eliminaUtente(String nome, String cognome, String codiceFiscale)
	{
		boolean b=false;
		PreparedStatement st = null;
		try {
			Connection con = DataSource.getInstance().getConnection();
			String sql = "delete from utente where codice_fiscale=?";
			st = con.prepareStatement(sql);
			st.setString(1, codiceFiscale);

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
	
	public Map<String,Utente> getAllUtente(){
		Map<String,Utente> mappa = new TreeMap<String,Utente>();
		PreparedStatement st = null;
		ResultSet rst=null;
		try {
			Connection con = DataSource.getInstance().getConnection();
			String sql = "select * from utente";
			st = con.prepareStatement(sql);

			rst= st.executeQuery();
			while(rst.next())
			{
				long id=rst.getLong(1);
				String nome= rst.getString(2);
				String cognome= rst.getString(3);
				String codiceFiscale=rst.getString(4);
				Utente u=new Utente(id,nome,cognome,codiceFiscale);
				mappa.put(codiceFiscale, u);
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
		return mappa;
	}
	
}
