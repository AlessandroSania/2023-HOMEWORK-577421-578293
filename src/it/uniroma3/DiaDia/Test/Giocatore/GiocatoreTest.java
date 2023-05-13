package it.uniroma3.DiaDia.Test.Giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.DiaDia.Giocatore.Giocatore;

public class GiocatoreTest {
	
	Giocatore giocatore;
	
	@BeforeEach
	public void setUp() {
		giocatore = new Giocatore();
	}
	
	@Test
	public void testGetCfuPredefinito() {
		assertEquals(20, giocatore.getCfu());
	}
	
	@Test
	public void testGetBorsaPredefenito() {
		assertNotNull(giocatore.getBorsa());
	}
	
	@Test
	public void testSetCfu() {
		giocatore.setCfu(10);
		assertEquals(10, giocatore.getCfu());
	}
}
