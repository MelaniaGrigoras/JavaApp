package data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private List<Publicatie> publicatii;
	private List<Media> media;
	
	public Biblioteca() {
		this.publicatii = new ArrayList<>();
		this.media = new ArrayList<>();
	}

	public void adaugaPublicatie(Publicatie publicatie) {
		this.publicatii.add(publicatie);
	}

	public void adaugaMedia(Media media) {
		this.media.add(media);
	}
	
	public void catalogPublicatii() {
		System.out.println("Catalog publicatii:"); 
		for(Publicatie p : publicatii) {
			System.out.println(p);
		}
		System.out.println();
	}
	
	public void catalogMedia() {
		System.out.println("Catalog media:"); 
		for(Media m : media) {
			System.out.println(m);
		}
		System.out.println();
	}
	
	public void publicatiiDisponibile() {
		System.out.println("Publicatii disponibile:"); 
		for(Publicatie p : publicatii) {
			if(p.isDisponibil()) {
				System.out.println(p);
			}
		}
		System.out.println();
	}
	
	public void publicatiiImprumutate() {
		System.out.println("Publicatii imprumutate:"); 
		for(Publicatie p : publicatii) {
			if( !p.isDisponibil()) {
				System.out.println(p);
			}
		}
		System.out.println();
	}
	
	public void consultarePublicatieDupaCategorie(String categorie) {
		System.out.println("Publicatii din categoria " + categorie + ":");
		for(Publicatie p : publicatii) {
			if(p.getCategorie() == categorie) {
				System.out.println(p);
			}
		}
		System.out.println();
	}
	
	public void consultarePublicatieDupaAutor(String autor) {
		System.out.println("Publicatii scrise de " + autor + ":");
		for(Publicatie p : publicatii) {
			if(p.getAutor() == autor) {
				System.out.println(p);
			}
		}
	}
	
	public void imprumutaPublicatie(int id, LocalDate dataImprumut) {
		boolean match = false;
		
		for(Publicatie p : publicatii) {
			if(p.getId() == id) {
				match = true;
				try {
					p.imprumuta(dataImprumut);
					System.out.println("Publicatia " + id + " a fost imprumutata.\n");
				} catch (Exception e) {
					System.out.println(e.getMessage() + "\n");
//					e.printStackTrace();
				}
				break;
			}
		}
		
		if(!match) {
			System.out.println("Publicatia " + id + " nu a fost gasita!\n");
		}
	}
	
	public void returneazaPublicatie(int id, LocalDate dataRetur) {
		boolean match = false;
		
		for(Publicatie p : publicatii) {
			if(p.getId() == id) {
				match = true;
				try {
					p.returneaza(dataRetur);
					System.out.println("Publicatia " + id + " a fost returnată.\n");
				} catch(ArithmeticException e) {
					System.out.println(e.getMessage());
					System.out.println("Penalizare " + String.format("%.2f", p.calculPenalizare(dataRetur)) + " lei\n");
					
					// Plata a fost achitata
					p.disponibil = true;
					p.dataImprumut = null;
				} catch(Exception e) {
					System.out.println(e.getMessage() + "\n");
//					e.printStackTrace();
				}
			}
		}
		
		if(!match) {
			System.out.println("Publicatia " + id + " nu a fost gasita!\n");
		}
	}
	
	public void consultaMedia(int id) {
		boolean match = false;
		
		for(Media m : media) {
			if(m.getId() == id) {
				match = true;
				System.out.println("Media " + id + " este in consultare.\n");
				m.consulta();
				break;
			}
		}
		
		if(!match) {
			System.out.println("Media " + id + " nu a fost gasita!\n");
		}
	}
	
	public void elibereazaMedia(int id) {
		boolean match = false;
		
		for(Media m : media) {
			if(m.getId() == id) {
				match = true;
				m.elibereaza();
				System.out.println("Media " + id + " este libera.\n");
				break;
			}
		}
		
		if(!match) {
			System.out.println("Media " + id + " nu a fost gasita!\n");
		}
	}
	
}
