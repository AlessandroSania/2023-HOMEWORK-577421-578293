package it.uniroma3.DiaDia.Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.DiaDia.IOConsole;
import it.uniroma3.DiaDia.IO;
import it.uniroma3.DiaDia.Comandi.Comando;
import it.uniroma3.DiaDia.Comandi.ComandoNonValido;
import it.uniroma3.DiaDia.Comandi.ComandoVai;
import it.uniroma3.DiaDia.Comandi.ComandoFine;
import it.uniroma3.DiaDia.Comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica f;
	private IO io;
	private Comando expected;
	
	@Before
	public void setUp() throws Exception {
		io = new IOConsole();
		f = new FabbricaDiComandiFisarmonica(io);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testComandoNonValido() {
		expected = new ComandoNonValido();
		assertEquals( expected.getNome(), f.costruisciComando("nonValgo").getNome());
	}
	
	@Test
	public void testComandoConParametro() {
		expected = new ComandoVai();
		expected.setParametro("nord");
		Comando current = f.costruisciComando("vai nord");
		assertEquals( expected.getNome(), current.getNome());
		assertEquals( expected.getParametro(), current.getParametro());
	}
	
	@Test
	public void testComandoSenzaParametro() {
		expected = new ComandoFine();
		assertEquals( expected.getNome(), f.costruisciComando("fine").getNome());
	}

}
