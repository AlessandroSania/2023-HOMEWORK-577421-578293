package it.uniroma3.DiaDia.Test;

import it.uniroma3.DiaDia.DiaDia;
import it.uniroma3.DiaDia.IOSimulator;
import it.uniroma3.DiaDia.ambienti.Stanza;
import it.uniroma3.DiaDia.Attrezzi.Attrezzo;

public class Fixture {
	public static IOSimulator creaSimulazionePartitaEGioca(String... comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		new DiaDia(io).gioca();
		return io;
	}
	
	public static Attrezzo creaAttrezzoEAggiugniAStanza(Stanza stanzaDaRiempire, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		stanzaDaRiempire.addAttrezzo(attrezzo);
		return attrezzo;
	}
	
}
