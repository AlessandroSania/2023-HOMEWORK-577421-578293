package it.uniroma3.DiaDia.Test.Comandi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.DiaDia.DiaDia;
import it.uniroma3.DiaDia.IOSimulator;
import it.uniroma3.DiaDia.Comandi.ComandoAiuto;
import it.uniroma3.DiaDia.Comandi.ComandoFine;
import it.uniroma3.DiaDia.Test.Fixture.Fixture;

public class ComandoAiutoTest {
	
	List<String> righeDaLeggere;

	@Before
	public void setUp() throws Exception {
		righeDaLeggere = new ArrayList<>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPartitaConComandoAiuto() {
		righeDaLeggere.add("aiuto");
		righeDaLeggere.add("fine");
		IOSimulator io = Fixture.creaSimulazionePartitaEGiocaEasy(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		for(int i=0; i < ComandoAiuto.ELENCO_COMANDI.length; i++) {
			assertTrue(io.hasNextMessaggio());
			assertEquals(ComandoAiuto.ELENCO_COMANDI[i]+" ", io.nextMessaggio());
		}
		assertTrue(io.hasNextMessaggio());
		io.nextMessaggio();
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}
}
