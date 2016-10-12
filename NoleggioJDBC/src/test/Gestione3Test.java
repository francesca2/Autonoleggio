package test;

import static org.junit.Assert.*;

import java.util.List;

import model.Gestione;
import model.Macchina;
import model.Utente;

import org.junit.Test;

import dao.MacchinaDao;
import dao.MacchinaUtenteDao;
import dao.UtenteDao;

public class Gestione3Test {

	@Test
	public void testTutteMacchineDiUtente() {
		Gestione g=new Gestione();
		MacchinaDao mdao= new MacchinaDao();
		UtenteDao udao=new UtenteDao();
		MacchinaUtenteDao mudao=new MacchinaUtenteDao();
		
		Utente u=udao.trovaUtente("test", "test", "test");
		Macchina m1= g.addMacchina("bbbb", "3b");
		Macchina m2=mdao.trovaMacchina("test");
		
		g.assegnaUtenteAMacchina(u, m1);
		g.assegnaUtenteAMacchina(u,m2);
		
		List<Macchina> lista=mudao.getTutteMacchineDiUtente(u.getIdUtente());
		
		assertEquals(lista.size(),2);

	}

}
