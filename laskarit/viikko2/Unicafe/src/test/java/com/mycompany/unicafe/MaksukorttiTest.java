package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {
    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals(1000, kortti.saldo());
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(500);
        assertEquals(1500, kortti.saldo());
    }
    
    @Test
    public void rahanOttaminenToimii() {
        kortti.otaRahaa(500);
        assertEquals(500, kortti.saldo());
    }
    
    @Test
    public void saldoVaheneeOikeinJosRahaaTarpeeksi() {
        kortti.otaRahaa(1000);
        assertEquals(0, kortti.saldo());
    }
    
    @Test
    public void saldoEiMuutuJosRahaaEiTarpeeksi() {
        kortti.otaRahaa(5000);
        assertEquals(1000, kortti.saldo());
    }
    
    @Test
    public void metodiPalauttaaTrueJosRahatRiittivat() {
       assertTrue(kortti.otaRahaa(500));
    }
   
    @Test
    public void metodiPalauttaaFalseJosRahatEivatRiita() {
       assertFalse(kortti.otaRahaa(5000));
    }
    
    @Test
    public void toStringToimiiOikein() {
        assertEquals("saldo: 10.0", kortti.toString());
    }
}
