package com.company.engine.scanner.validation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScannerValidationTest {

    ScannerValidationTest(ScannerValidation scannerValidation) {
    }

    @Test
    // sprawdzenie wczytanego rozmiary planszy
    void validateSizeBoard() {
        Integer sizeBoard = ScannerValidation.validateSizeBoard(6);
        assertEquals(6, sizeBoard);
    }

    @Test
    // Sprawdzenie czy podanie nieporawnego rozmiaru planszy zwraca poprawne exception
    void validateSizeBoardException() { // jesli przekroczy size to ex,
        Boolean isException = false;
        try {
            ScannerValidation.validateSizeBoard(2);
        } catch (IllegalArgumentException ex) {
            isException = true;
        }
        assert (isException);
    }

    @Test
    // sprawdzam czy podane koordynatory sa poprawne ( wieksze od 0 i mniejsze niz rozmiar planszy)
    void validateShot() {
        Integer value = ScannerValidation.validateShot(2, 4);
        assertEquals(2, value);
    }

    @Test
    // Sprawdza czy podanie niepopraweych koordynatow strzalu wyrzuci spodziewane excetpion
    void validateShotException() { // jesli wieksza niz pole to exce,
        Boolean isException = false;
        try {
            ScannerValidation.validateShot(4, 2);
        } catch (IllegalArgumentException ex) {
            isException = true;
        }
        assert (isException);
    }

}