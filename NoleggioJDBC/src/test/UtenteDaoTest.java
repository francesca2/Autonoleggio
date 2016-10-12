package test;

import static org.junit.Assert.*;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import model.Utente;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.UtenteDao;
import utility.DataSource;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UtenteDaoTest {

	Connection con;
	
	@Before
	public void test() {
		 try {
			con = DataSource.getInstance().getConnection();
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	 
	 @Test
	 public void test_1_RegistraUtente() {
UtenteDao udao= new UtenteDao();
int n=udao.registraUtente("test", "test", "test");

assertNotNull(n);

	 }
	 
	 @Test
	 public void test_2_TrovaUtente() {
UtenteDao udao= new UtenteDao();

Utente u= udao.trovaUtente("test", "test",  "test");

assertNotNull(u);

	 }
	 
	 @Test
	 public void test_3_TuttiUtenti() {
UtenteDao udao= new UtenteDao();

Map <String,Utente> tuttiUtenti= udao.getAllUtente();

assertEquals(tuttiUtenti.size(),1);

	 }
	 
	 @Test
	 public void test_4_EliminaUtente() {
UtenteDao udao= new UtenteDao();

boolean b= udao.eliminaUtente("test", "test",  "test");

assertTrue(b);

	 }
	 
}
