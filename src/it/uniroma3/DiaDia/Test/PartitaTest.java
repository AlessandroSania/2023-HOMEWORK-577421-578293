package it.uniroma3.DiaDia.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.DiaDia.Partita;
import it.uniroma3.DiaDia.ambienti.Labirinto;
import it.uniroma3.DiaDia.ambienti.LabirintoBuilder;
import it.uniroma3.DiaDia.ambienti.Stanza;

public class PartitaTest {

	
	Labirinto labirinto;	
	Partita match;
	Stanza corrente;
	
	@BeforeEach
	public void setUp() {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		 match = new Partita(labirinto);
		 corrente = new Stanza("Stanza");
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
