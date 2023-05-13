package it.uniroma3.DiaDia.Test.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.DiaDia.Attrezzi.Attrezzo;
import it.uniroma3.DiaDia.ambienti.StanzaBuia;

public class StanzaBuiaTest {

	private StanzaBuia s;
	private Attrezzo lampadina;
	
	@Before
	public void setUp() throws Exception {
		s = new StanzaBuia("StanzaBuia", "lampadina");
		lampadina = new Attrezzo("lampadina", 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDescrizioneConAttrezzo() {
		s.addAttrezzo(lampadina);
		assertEquals(s.toString(), s.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		String e = "qui c'è un buio pesto";
		assertEquals(e, s.getDescrizione());
	}
}
