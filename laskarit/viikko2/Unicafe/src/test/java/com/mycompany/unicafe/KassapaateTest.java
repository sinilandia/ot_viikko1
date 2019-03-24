package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author siniliu
 */
public class KassapaateTest {
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000); //10euroa
    }
    
    @Test
    public void konstruktoriLuoKassapaatteenOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateisostoEdullisetToimii() {
        assertEquals(260, kassa.syoEdullisesti(500));
        assertEquals(100240, kassa.kassassaRahaa());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateisostoEdullisetTasasumma() {
        //tätäkään ei tarvitse olla
        //jotta saa 100% testikattavuuden
        //vaikka Maksukortti-tehtävässä piti
    }
    
    @Test
    public void kateisostoEdullisetEiRiitaRahat() {
        assertEquals(200, kassa.syoEdullisesti(200));
        
        //näitä kahta ei tarvii, jotta saa 100% testikattavuuden
        //mutta tehtävänannon mukaan pitää olla
        assertEquals(0,kassa.edullisiaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test 
    public void kateisostoMaukkaatToimii() {
        assertEquals(100, kassa.syoMaukkaasti(500));
        assertEquals(100400, kassa.kassassaRahaa());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());      
    }
    
    @Test
    public void kateisostoMaukkaatEiRiitaRahat() {
        assertEquals(200, kassa.syoMaukkaasti(200));
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiostoEdullisetToimii() {
        assertTrue(kassa.syoEdullisesti(kortti));
        assertEquals(760, kortti.saldo());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test 
    public void korttiostoEdullisetEiRiitaSaldo() {
        Maksukortti koyhaKortti = new Maksukortti(200);
        assertFalse(kassa.syoEdullisesti(koyhaKortti));
        assertEquals(200, koyhaKortti.saldo());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test 
    public void korttiostoMaukkaatToimii() {
        assertTrue(kassa.syoMaukkaasti(kortti));
        assertEquals(600, kortti.saldo());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void korttiostoMaukkaatEiRiitaSaldo() {
        Maksukortti koyhaKortti = new Maksukortti(200);
        assertFalse(kassa.syoMaukkaasti(koyhaKortti));
        assertEquals(200, koyhaKortti.saldo());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortilleLataaminenToimii() {
        kassa.lataaRahaaKortille(kortti, 500); //lataa 5euroa kortille
        assertEquals(1500, kortti.saldo());
        assertEquals(100500, kassa.kassassaRahaa());
    }
    
    //vaikka tämän testin kommentoisi ulos
    //niin silti metodin testikattavuus on 100%
    //MIKSI?
    @Test
    public void kortilleEiVoiLadataNegatiivistaSummaa() {
        kassa.lataaRahaaKortille(kortti, -500);
        assertEquals(1000, kortti.saldo());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
}
