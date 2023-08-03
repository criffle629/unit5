package com.unit5test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.unit5.BalancedBrackets;

public class BalancedBracketsTest {

    BalancedBrackets isBalanced = new BalancedBrackets();

    @Test
    public void testisBalanced_balancedParens() {
        assertTrue(isBalanced.isBalanced("(1)"));
    }

    @Test
    public void testisBalanced_tooManyOpenParens() {
        assertFalse(isBalanced.isBalanced("({1)"));
    }

    @Test
    public void testisBalanced_tooManyClosedParens() {
        assertFalse(isBalanced.isBalanced("({1})>"));
    }

    @Test
    public void testisBalanced_startWithClosedParens() {
        assertFalse(isBalanced.isBalanced(")("));
    }

    @Test
    public void testisBalanced_emptyString() {
        assertTrue(isBalanced.isBalanced(""));
    }

    @Test
    public void testisBalanced_balancedComboBrackets() {
        assertTrue(isBalanced.isBalanced("<({})>"));
    }

    @Test
    public void testisBalanced_mismatchedBrackets() {
        assertFalse(isBalanced.isBalanced("<({)}>"));
    }
}
