package it.uniroma3.DiaDia.Giocatore;

public class Giocatore{
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	
	public Giocatore(){
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	/**
	 * Set e Get CFU
	 * @return cfu
	 */
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	/**
	 * Set e Get borsa
	 * @return borsa
	 */
	
	public Borsa getBorsa() {
		return this.borsa;
	}

	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;		
	}	
	
}