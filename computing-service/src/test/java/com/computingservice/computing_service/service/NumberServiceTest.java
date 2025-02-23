package com.computingservice.computing_service.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberServiceTest {

    private final NumberService numberService = new NumberService();

    @Test
    void testShiftDigits() {
        // Test: posunout číslice <= 3 doprava
        assertEquals("41325", numberService.shiftDigits("13245"));
        assertEquals("4132", numberService.shiftDigits("1324"));
        assertEquals("413265", numberService.shiftDigits("132465"));
    }

    @Test
    void testMultiplyDigits() {
        // Test: násobení 8 a 9 dvakrát
        assertEquals("716", numberService.multiplyDigits("78"));
        assertEquals("1618", numberService.multiplyDigits("89"));
        assertEquals("123456", numberService.multiplyDigits("123456"));
    }

    @Test
    void testRemoveSevens() {
        // Test: odstranění všech 7
        assertEquals("1234", numberService.removeSevens("12347"));
        assertEquals("2", numberService.removeSevens("727"));
        assertEquals("89", numberService.removeSevens("879"));
    }

    @Test
    void testDivideByEvenCount() {
        // Test: dělení počtem sudých číslic
        assertEquals(82, numberService.divideByEvenCount("246"));
        assertEquals(555, numberService.divideByEvenCount("555"));
        assertEquals(1112, numberService.divideByEvenCount("1112"));
        assertEquals(2160, numberService.divideByEvenCount("4321"));  // pouze 2 sudé číslice
    }

    @Test
    void testProcessNumber() {
        // Test: testování celé logiky zpracování čísla
        assertEquals(11331545, numberService.processNumber(43256791));
        assertEquals(809, numberService.processNumber(789));
        assertEquals(32363242, numberService.processNumber(7892184));
    }
}
