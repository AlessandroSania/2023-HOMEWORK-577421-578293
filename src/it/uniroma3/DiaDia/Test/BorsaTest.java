package it.uniroma3.DiaDia.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.DiaDia.Attrezzi.Attrezzo;
import it.uniroma3.DiaDia.Giocatore.Borsa;

public class BorsaTest{
	Borsa borsa = new Borsa();
	Attrezzo martello;
	Attrezzo ascia;
	
	@Before
	public void setUp() {
		martello = new Attrezzo("martello", 9);
		ascia = new Attrezzo("ascia", 18);
	}
	
	@Test
	public void testGetPeso() {
		borsa.addAttrezzo(martello);
		assertEquals(martello, borsa.getAttrezzo("martello"));

	}
	
	@Test
	public void testAddAttrezzoPesoMinDieci() {
		assertTrue(borsa.addAttrezzo(martello));

	}
	
	@Test
	public void testAddAttrezzoPesoMaggDieci() {
		assertFalse(borsa.addAttrezzo(ascia));

	}
}