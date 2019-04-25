package myAPI;

import org.junit.Test;

import static org.junit.Assert.*;

public class PredicateTemplatesTest {

    @Test
    public void isMinus1Even() {
        assertFalse(new PredicateTemplate().isEven(-1));
    }

    @Test
    public void is0Even() {
        assertTrue(new PredicateTemplate().isEven(0));
    }

    @Test
    public void is1Even() {
        assertFalse(new PredicateTemplate().isEven(1));
    }

    @Test
    public void is2Even() {
        assertTrue(new PredicateTemplate().isEven(2));
    }

    @Test
    public void is3Even() {
        assertFalse(new PredicateTemplate().isEven(3));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void isMinus1Prime() { assertFalse(new PredicateTemplate().isPrime(-1));}

    @Test
    public void is0Prime() {
        assertFalse(new PredicateTemplate().isPrime(0));
    }

    @Test
    public void is1Prime() {
        assertFalse(new PredicateTemplate().isPrime(1));
    }

    @Test
    public void is2Prime() {
        assertTrue(new PredicateTemplate().isPrime(2));
    }

    @Test
    public void is3Prime() {
        assertTrue(new PredicateTemplate().isPrime(3));
    }

    @Test
    public void is4Prime() {
        assertFalse(new PredicateTemplate().isPrime(4));
    }
}