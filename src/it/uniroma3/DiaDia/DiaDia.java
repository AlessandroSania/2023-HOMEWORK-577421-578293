package it.uniroma3.DiaDia;
import java.util.Scanner;

import it.uniroma3.DiaDia.Attrezzi.Attrezzo;
import it.uniroma3.DiaDia.ambienti.Stanza;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO & 577421 & 578293
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *     
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "prendi", "posa", "fine"};
	
	/* crea partita */
	private Partita partita;
	public DiaDia() {
		this.partita = new Partita();
	}

	/* inizio partita */
	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if(comandoDaEseguire.getNome()==null) {
			System.out.println("Devi eseguire un comando..");
			return false;
		}
		else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} 
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else
			System.out.println("Comando sconosciuto");
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu()-1;
			this.partita.getGiocatore().setCfu(cfu);
			
		}
		System.out.println(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		System.out.println(partita.getGiocatore().getBorsa().toString());
		System.out.println(partita.getGiocatore().getCfu());
	}
	
	/**
	 * prende oggetto 
	 * dalla stanza e lo mette in borsa
	 */
	private void prendi(String nomeAttrezzo) {
		Attrezzo attrezzo = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzo);
		System.out.println(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		System.out.println(partita.getGiocatore().getBorsa().toString());
	}
	
	/**
	 * lascia  oggetto
	 * rimuovendolo dalla borsa e mettendolo in stanza
	 */
	private void posa(String nomeAttrezzo) {
		Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		System.out.println(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		System.out.println(partita.getGiocatore().getBorsa().toString());
	}
	
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}