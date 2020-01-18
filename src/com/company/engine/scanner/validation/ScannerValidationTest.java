package com.company.engine.scanner.validation;

import com.company.engine.ship.ShipFactory;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class ScannerValidationTest {

    private ScannerValidation scannerValidation;

    @Test
    void validateSizeBoard() {
        Integer sizeBoard = ScannerValidation.validateSizeBoard(6);
        assertEquals(6, sizeBoard);
    }

    @Test
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
    void validateShot() {
        Integer value = ScannerValidation.validateShot(2, 4);
        assertEquals(2, value);
    }

    @Test
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