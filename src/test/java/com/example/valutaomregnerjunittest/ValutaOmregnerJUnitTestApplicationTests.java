package com.example.valutaomregnerjunittest;

import com.example.valutaomregnerjunittest.repository.ValutaOmregnerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValutaOmregnerJUnitTestApplicationTests {

    ValutaOmregnerRepository valutaOmregner;

    @BeforeEach
    void setUp(){
        valutaOmregner = new ValutaOmregnerRepository();
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void convertDKKtoUSD() {

        //act
        double result = valutaOmregner.exchange("DKK","USD",100);

        //assert
        assertEquals(14,result, 0.5 ,"Convert DKK to USD - 100");
    }

    @Test
    void convertUSDtoDKK() {

        //act
        double result = valutaOmregner.exchange("USD","DKK",100);

        //assert
        assertEquals(718,result, 0.5 ,"Convert USD to DKK - 100");
    }

    @Test
    void convertGRBtoUSD() {

        //act
        double result = valutaOmregner.exchange("GRB","USD",100);

        //assert
        assertEquals(119,result, 0.5 ,"Convert GRB to USD - 100");
    }

    @Test
    void convertUSDtoUnknown() {

        //act &
        //assert
        assertThrows(IllegalArgumentException.class, () -> valutaOmregner.exchange("USD","CommunistSickles",100),
                "Exception on unknown valuta");
    }

}
