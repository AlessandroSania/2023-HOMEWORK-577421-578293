package it.uniroma3.DiaDia.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.DiaDia.Partita;
import it.uniroma3.DiaDia.ambienti.Stanza;

public class PartitaTest {

	Partita match;
	Stanza corrente;
	
	@BeforeEach
	public void setUp() {
		match = new Partita();
		corrente = new Stanza("Corrente");
	}

	@Test
	public void testIsFinita() {
		assertFalse(match.isFinita());
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", match.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		match.getLabirinto().setStanzaCorrente(corrente);
		assertEquals(corrente, match.getLabirinto().getStanzaCorrente());
	}
	
}
