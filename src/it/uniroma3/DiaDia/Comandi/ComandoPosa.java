package it.uniroma3.DiaDia.Comandi;

import it.uniroma3.DiaDia.IO;
import it.uniroma3.DiaDia.Partita;
import it.uniroma3.DiaDia.Attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "posa";


	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);

		if(partita.getStanzaCorrente().getNumeroAttrezziPossibili()>0) {
			partita.getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		}
		else {
			io.mostraMessaggio("Non c'e' spazio nella stanza per poter inserire questo attrezzo!");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo  = parametro;

	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	public void setIo(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return NOME;
	}

}