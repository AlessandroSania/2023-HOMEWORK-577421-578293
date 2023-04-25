package it.uniroma3.DiaDia.Comandi;

import it.uniroma3.DiaDia.IO;
import it.uniroma3.DiaDia.Partita;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO & 577421 & 578293
 * @version base
 */

public interface Comando {
    
    /**
    * esecuzione del comando
    */
    public void esegui(Partita partita);

    /**
    * set parametro del comando
    */
    public void setParametro(String parametro);
    
    String getParametro();
    
    public void setIo(IO io);
    
    public String getNome();
}