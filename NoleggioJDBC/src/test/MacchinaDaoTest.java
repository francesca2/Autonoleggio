package test;

import static org.junit.Assert.*;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import model.Macchina;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import utility.DataSource;
import dao.MacchinaDao;
import dao.UtenteDao;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MacchinaDaoTest {

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
	public void test_1_RegistraMacchina() {
		MacchinaDao udao= new MacchinaDao();
		int n=udao.registraMacchina("test", "test");

		assertNotNull(n);

	}

	@Test
	public void test_2_TrovaMacchina() {
		MacchinaDao udao= new MacchinaDao();
		Macchina m=udao.trovaMacchina("test");

		assertNotNull(m);

	}

	@Test
	public void test_3_AggiornaMacchina() {
		MacchinaDao udao= new MacchinaDao();

		Macchina m1=udao.trovaMacchina("test");

		boolean b=udao.aggiornaMacchina("test2","test");

		Macchina m2=udao.trovaMacchina("test");

		assertTrue(b);
		assertNotEquals(m1.getModello(),m2.getModello());

	}

	@Test
	public void test_5_EliminaMacchina() {
		MacchinaDao udao= new MacchinaDao();

		boolean b=udao.eliminaMacchina("test");

		assertTrue(b);

	}

}
