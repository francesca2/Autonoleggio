package test;

import static org.junit.Assert.*;
import model.Gestione;
import model.Macchina;
import model.Utente;

import org.junit.Test;

public class Gestione2Test {

	@Test
	public void testRegistraUtente() {
		Gestione g=new Gestione();
		Utente u=g.addUtente("test", "test", "test");
		
		assertNotNull(u);

	}

}
