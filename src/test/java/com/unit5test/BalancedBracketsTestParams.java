package com.unit5test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.unit5.BalancedBrackets;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BalancedBracketsTestParams {
    private String input;
    private boolean expectedOutput;
    BalancedBrackets balancedBrackets = new BalancedBrackets();

    public BalancedBracketsTestParams(String input, boolean expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> testConditions() {
        String balancedParens = "(1)";
        String balancedAngleBrackets = "<<>>";
        String balancedComboBrackets = "<({})>";
        String emptyString = "";
        String tooManyOpenParens = "((1";
        String tooManyOpenParens1 = "(1)(";
        String tooManyClosedParens = "(1))";
        String startClosedParens = ")(";
        String mismatchedBrackets = "<({)}>";

        Object[][] expectedOutputs = {
                { balancedParens, true },
                { balancedAngleBrackets, true },
                { balancedComboBrackets, true },
                { emptyString, true },
                { tooManyOpenParens, false },
                { tooManyOpenParens1, false },
                { tooManyClosedParens, false },
                { startClosedParens, false },
                { mismatchedBrackets, false }
        };

        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testBalancedBrackets(){
        assertEquals(expectedOutput, balancedBrackets.isBalanced(input));
    }
}
