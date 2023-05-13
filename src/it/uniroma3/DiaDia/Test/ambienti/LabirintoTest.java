package it.uniroma3.DiaDia.Test.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.DiaDia.ambienti.Labirinto;
import it.uniroma3.DiaDia.ambienti.Stanza;

public class LabirintoTest {

	Stanza n11;
	Stanza biblioteca;
	Labirinto labirinto;

	@BeforeEach
	public void setUp() {
		labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		
		biblioteca = new Stanza("Biblioteca");
		n11 = new Stanza("n11");
	}
	
	
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", labirinto.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testSetStanzaCorrente() {
		labirinto.setStanzaCorrente(n11);
		assertEquals(n11, labirinto.getStanzaCorrente());
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}

}
