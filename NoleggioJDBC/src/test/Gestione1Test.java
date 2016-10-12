package test;

import static org.junit.Assert.*;
import model.Gestione;
import model.Macchina;

import org.junit.Test;

public class Gestione1Test {

	@Test
	public void testRegistraMacchina() {
		Gestione g=new Gestione();
		Macchina m=g.addMacchina("test", "test");
		
		assertNotNull(m);
	}

}
