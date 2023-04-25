package it.uniroma3.DiaDia.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.DiaDia.IOConsole;
import it.uniroma3.DiaDia.IO;
import it.uniroma3.DiaDia.Partita;
import it.uniroma3.DiaDia.Comandi.Comando;
import it.uniroma3.DiaDia.Comandi.ComandoPosa;
import it.uniroma3.DiaDia.Attrezzi.Attrezzo;

public class ComandoPosaTest {

	private Partita partita;
	private Attrezzo attrezzo;
	private IO io;
	private Comando comando;

	@Before
	public void setUp() throws Exception {
		partita = new Partita();
		attrezzo = new Attrezzo("ascia", 3);
		comando = new ComandoPosa();
		io = new IOConsole();
		comando.setIo(io);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAttrezzoPosato() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("ascia");
		comando.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("ascia"));
	}

	@Test
	public void testAttrezzoPosatoNull() {
		comando.setParametro("ascia");
		comando.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("ascia"));
	}
	
	@Test
	public void testTroppiAttrezzi() {
		this.creatoreAttrezzi();
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("ascia");
		comando.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("ascia"));
	}
	
	public void creatoreAttrezzi() {
		for(int i= 0; i<10;i++) {
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("arnese"+i, 1));
		}
	}
}
