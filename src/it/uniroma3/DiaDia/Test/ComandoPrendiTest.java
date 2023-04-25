package it.uniroma3.DiaDia.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.DiaDia.IOConsole;
import it.uniroma3.DiaDia.IO;
import it.uniroma3.DiaDia.Partita;
import it.uniroma3.DiaDia.Attrezzi.Attrezzo;
import it.uniroma3.DiaDia.Comandi.Comando;
import it.uniroma3.DiaDia.Comandi.ComandoPrendi;

public class ComandoPrendiTest {

	private Partita partita;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoPesante;
	private Comando comando;
	private IO io;
	
	@Before
	public void setUp() throws Exception {
		partita = new Partita();
		attrezzo = new Attrezzo("ascia", 3);
		attrezzoPesante = new Attrezzo("cassamalta", 12);
		comando = new ComandoPrendi();
		io = new IOConsole();
		comando.setIo(io);
	}


	@After
	public void tearDown() throws Exception {
	}
	
	public boolean attrezzoPresente(String s) {
		Attrezzo[] array = partita.getStanzaCorrente().getAttrezzi();
		for(Attrezzo a : array) {
			if(a != null && s.equals(a.getNome()))
					return true;
		}
		return false;
	}
	
	@Test
	public void testAttrezzoPreso() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("ascia");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("ascia"));
	}
	@Test
	public void testAttrezzoNonPresente() {
		comando.setParametro("ascia");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("ascia"));
	}
	
	@Test
	public void testAttrezzoPesante() {
		partita.getStanzaCorrente().addAttrezzo(attrezzoPesante);
		comando.setParametro("cassamalta");
		comando.esegui(partita);
		assertTrue(attrezzoPresente("cassamalta"));
	}
	
}
