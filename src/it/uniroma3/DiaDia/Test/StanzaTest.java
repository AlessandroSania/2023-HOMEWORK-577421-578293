package it.uniroma3.DiaDia.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.DiaDia.ambienti.Stanza;
import it.uniroma3.DiaDia.Attrezzi.Attrezzo;

public class StanzaTest {	
	
	 Stanza nonVuota;
	 Stanza stanzaUno;
	 Stanza stanzaDue;
	 Attrezzo piccone;
	 Attrezzo spada;
	
	@BeforeEach
	public void setUp() {
		 this.nonVuota = new Stanza("non-vuota");
		 this.stanzaUno = new Stanza("s1");
		 this.stanzaDue = new Stanza("s2");
		 this.piccone = new Attrezzo("piccone", 23);
		 this.spada = new Attrezzo("spada", 5);
		 this.nonVuota = new Stanza("non-vuota");
		 
		 this.nonVuota.addAttrezzo(spada);
	}
	
	@Test
	public void testAddAttrezzo() {	
		assertTrue(stanzaUno.addAttrezzo(piccone));
	}
	
	@Test
	public void testSetStanzaAdiacente() {
		stanzaUno.impostaStanzaAdiacente("sud", stanzaDue);
		assertEquals(stanzaDue, stanzaUno.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacente() {
		assertNull(stanzaUno.getStanzaAdiacente("sud"));
	}
	
	
	@Test
	final void testGetAttrezzo() {
		assertSame(this.spada, this.nonVuota.getAttrezzo("spada"));
	}
}
