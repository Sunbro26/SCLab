/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }
    
    @Test
    public void testWrittenByYourselfShouldIgnoreCitation() {
        // It should return true because it's written by yourself, citation doesn't matter
        assertTrue(RulesOf6005.mayUseCodeInAssignment(true, false, false, false, true));
    }

    @Test
    public void testAllFalseShouldReturnFalse() {
    	// This tests whether the method mistakenly allows usage when all conditions should reject it.
        assertFalse(RulesOf6005.mayUseCodeInAssignment(false, false, true, false, true));
    }
    
    @Test
    public void testNotCitingSourceShouldReturnFalse() {
    	// Test if the method incorrectly allows external code that is not cited.
        assertFalse(RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
    }


}
