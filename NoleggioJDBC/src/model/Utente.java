package model;

public class Utente {
	//nome, cognome, codice fiscale
	private long idUtente;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	
	public Utente() {
	}
	
	public Utente(long idUtente, String nome, String cognome,
			String codiceFiscale) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
	}

	public long getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	

}
