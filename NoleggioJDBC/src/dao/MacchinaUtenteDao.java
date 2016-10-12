package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Macchina;
import utility.DataSource;

public class MacchinaUtenteDao {
	
	public boolean registraMacchinaUtente(long idUtente, long idMacchina){
		PreparedStatement st = null;
		boolean b=false;
		try {
			Connection con = DataSource.getInstance().getConnection();
			String sql = "insert into u_to_m(id_utente,id_macchina) VALUES (?,?)";
			st = con.prepareStatement(sql);
			st.setLong(1, idUtente);
			st.setLong(2, idMacchina);
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

	public List<Macchina> getTutteMacchineDiUtente(long idUtente){
		List<Macchina> lista = new ArrayList<Macchina>();
		PreparedStatement st = null;
		ResultSet rst=null;

		try {
			Connection con = DataSource.getInstance().getConnection();
			String sql = "select macchina.id_macchina, macchina.modello, macchina.targa "
					+ "from macchina, u_to_m where u_to_m.id_utente=? "
					+ "and u_to_m.id_macchina=macchina.id_macchina";
			
			st = con.prepareStatement(sql);
					
			st.setLong(1, idUtente);
			
			rst=st.executeQuery();
			
			while(rst.next())
			{
				long id=rst.getLong(1);
				String modello=rst.getString(2);
				String targa=rst.getString(3);
				
				Macchina m= new Macchina(id,modello,targa);
				lista.add(m);
									
			}

		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		return lista;
	}
	
}
