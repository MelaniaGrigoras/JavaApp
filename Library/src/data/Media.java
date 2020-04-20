package data;

public abstract class Media extends Item implements Consultabil {
	protected String suport; // CD, DVD etc..
	
	public Media(String suport) {
		this.suport = suport;
	}
	
	@Override
	public void consulta() {
		if(disponibil) {
			disponibil = false;
		}
	}
	
	@Override
	public void elibereaza() {
		if( !disponibil) {
			disponibil = true;
		}		
	}

	@Override
	public String toString() {
		return super.toString() + "Suport : " + suport;
	}
}
