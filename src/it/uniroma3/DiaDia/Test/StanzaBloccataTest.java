package it.uniroma3.DiaDia.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.DiaDia.Attrezzi.Attrezzo;
import it.uniroma3.DiaDia.ambienti.Stanza;
import it.uniroma3.DiaDia.ambienti.StanzaBloccata;

public class StanzaBloccataTest {

	private StanzaBloccata sb;
	private Stanza stanza;
	private Attrezzo a;
	
	@Before
	public void setUp() throws Exception {
		sb = new StanzaBloccata("StanzaBloccata", "est", "PiedeDiPorco");
		stanza = new Stanza("Stanzino");
		a = new Attrezzo("PiedeDiPorco", 1);
		sb.impostaStanzaAdiacente("est", stanza);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(sb, sb.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(stanza, sb.getStanzaAdiacente("est"));
		
	}

	@Test
	public void testGetDescrizioneDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(sb.toString(), sb.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneDirezioneBloccata() {
		String e = "Stanza bloccata nella direzione: est"+"\nPrendi il PiedeDiPorco e posalo nella stanza";
		assertEquals(e, sb.getDescrizione());
		
	}

}
