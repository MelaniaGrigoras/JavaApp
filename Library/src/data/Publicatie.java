package data;

import java.time.LocalDate;

public abstract class Publicatie extends Item implements Imprumutabil {
	protected String autor;
	protected String titlu;
	protected String categorie;
	protected LocalDate dataImprumut;
	
	public Publicatie(String autor, String titlu, String categorie) {
		this.autor = autor;
		this.titlu = titlu;
		this.categorie = categorie; //dataImprumut?
	}	
	
	public boolean isDisponibil() {
		if(dataImprumut == null)
			return true;
		return false;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public String getCategorie() {
		return this.categorie;
	}
	
	@Override
	public void imprumuta(LocalDate dataImprumut) throws Exception {
		if(this.isDisponibil()) //cu try catch?
			 {
				this.dataImprumut = dataImprumut;
				this.disponibil = false;
			 }
		else {
			throw new Exception("Publicatia " +  this.getId() + " este indisponibila!");
		}
	}

	@Override
	public void returneaza(LocalDate dataRetur) throws Exception {
		if(!this.isDisponibil())
		{
			LocalDate termenPredare = dataImprumut.plusWeeks( getTermenImprumut() );
			if(dataRetur.isAfter(termenPredare)) {
				throw new ArithmeticException("Termen depasit pentru publicatia " + this.getId() + "!");
			}

			this.dataImprumut = null;
			this.disponibil = true;
		}
		else {
				throw new Exception("Publicatia " + this.getId() + " nu poate fi returnata (nu a fost imprumutata)!");
		}
	}
	
	@Override
	public double calculPenalizare(LocalDate dataRetur) {
		LocalDate termenPredare = dataImprumut.plusWeeks( getTermenImprumut() );
		if( dataRetur.isAfter(termenPredare) ) {
			if(dataRetur.getYear() == termenPredare.getYear()) {
				return (dataRetur.getDayOfYear() - termenPredare.getDayOfYear()) * getPenalizare();
			}
			else {
				LocalDate date = LocalDate.of(termenPredare.getYear(), 12, 31);
				int dif = date.getDayOfYear() - termenPredare.getDayOfYear() + dataRetur.getDayOfYear();
				return dif * getPenalizare();
			}
		}
		return 0;
	}
	
	public abstract int getTermenImprumut();
	
	public abstract double getPenalizare();

	@Override
	public String toString() {
		if(dataImprumut != null) {
			return super.toString() + "Author : " + autor + ", title : " + titlu
					+ ", category : " + categorie + ", borrowing date : " + dataImprumut; 
		}
		
		return super.toString() + "Author : " + autor + ", title : " + titlu
				+ ", category : " + categorie; 
	}
	
}
