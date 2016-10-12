package model;

import java.util.Map;

import dao.*;

public class Gestione {
// macchina aggiungi macchina;utente aggiungi utente; boolean assegna utente a macchina
	
	public Macchina addMacchina(String modello,String targa)
	{
		Macchina m=null;
		MacchinaDao mdao=new MacchinaDao();
		int n=mdao.registraMacchina(modello, targa);
			
		if(n!=0)
		{
		m=new Macchina(n,modello,targa);
		}
		
		return m;
	}
	
	public Utente addUtente(String nome, String cognome, String codiceFiscale)
	{
		Utente u=null;
		UtenteDao udao=new UtenteDao();
		int n=udao.registraUtente(nome, cognome, codiceFiscale);
		
		if(n!=0)
		{
			u=new Utente(n,nome,cognome,codiceFiscale);
		}
		return u;
	}
	
	public boolean assegnaUtenteAMacchina(Utente u,Macchina m)
	{
		boolean b=false;
		MacchinaUtenteDao umdao= new MacchinaUtenteDao();

		b=umdao.registraMacchinaUtente(u.getIdUtente(), m.getIdMacchina());
		return b;
		
	}
}
