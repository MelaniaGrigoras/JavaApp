package data;

import java.time.LocalDate;

public class Articol extends Publicatie {
	public static int TERMEN_IMPRUMUT = 2;
	public static double PENALIZARE = 0.1;
	protected String publicatie;
	protected LocalDate dataPublicatie;
	
	public Articol(String autor, String titlu, String categorie, String publicatie, LocalDate dataPublicatie) {
		super(autor, titlu, categorie);
		this.publicatie = publicatie;
		this.dataPublicatie = dataPublicatie;
	}
	
	@Override
	public int getTermenImprumut() {
		return TERMEN_IMPRUMUT;
	}
	
	@Override
	public double getPenalizare() {
		return PENALIZARE;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", publication : " + publicatie + ", publication date : " + dataPublicatie;
	}
}
