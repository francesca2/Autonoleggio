package model;

public class Macchina {
	//modello, targa
	private long idMacchina;
	private String modello;
	private String targa;
	
	public Macchina() {
	}
	
	public Macchina(long idMacchina, String modello, String targa) {
		this.idMacchina = idMacchina;
		this.modello = modello;
		this.targa = targa;
	}

	public long getIdMacchina() {
		return idMacchina;
	}

	public void setIdMacchina(long idMacchina) {
		this.idMacchina = idMacchina;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

}
