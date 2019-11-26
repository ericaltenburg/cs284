package classses;

public class Pair<E,F>{

	private E fst;
	private F snd;
	
	
	public Pair(E fst, F snd) {
		super();
		this.fst = fst;
		this.snd = snd;
	}
	
	public E getFst() {
		return fst;
	}
	public void setFst(E fst) {
		this.fst = fst;
	}
	public F getSnd() {
		return snd;
	}
	public void setSnd(F snd) {
		this.snd = snd;
	}
	
	
}
