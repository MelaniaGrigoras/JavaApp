package data;

public class Carte extends Publicatie{
	public static int TERMEN_IMPRUMUT = 4;
	public static double PENALIZARE = 0.5;
	protected int anPublicatie; 
	
	public Carte(String autor, String titlu, int anPublicatie, String categorie) {
		super(autor, titlu, categorie);
		this.anPublicatie = anPublicatie;
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
		return super.toString() + ", publication year: " + this.anPublicatie;
	}
}
