package data;

public abstract class Item {
	private int id;
	protected boolean disponibil;	
	
	private static int counter = 1;
	
	public Item() {
		this.disponibil = true;
		this.id = counter;
		counter ++;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return id + ". ";
	}
}
