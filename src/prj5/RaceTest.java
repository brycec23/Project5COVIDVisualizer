package prj5;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bryce Cullen (brycec23)
// -- Jonathan Ko (jonathancko)
// -- TODO NAME (PID)

/**
 * Test class for Race
 * 
 * @author Bryce Cullen (brycec23)
 * @author Jonathan Ko (jonathancko)
 * @author TODO
 * @version 2020.11.21
 */
public class RaceTest extends TestCase {
    /**
     * Fields
     */
    private Race race;

    /**
     * Sets up the test class for accurate testing
     */
    public void setUp() {
        race = new Race("White");
    }


    /**
     * Makes sure the method getName works as expected
     */
    public void testGetName() {
        assertEquals("White", race.getName());
    }


    /**
     * Makes sure the method getNumCases works as expected
     */
    public void testGetNumCases() {
        assertEquals(0, race.getNumCases());
    }


    /**
     * Makes sure the method setCases works as expected
     */
    public void testSetCases() {
        race.setCases(100);
        assertEquals(100, race.getNumCases());
    }


    /**
     * Makes sure the method getNumDeaths works as expected
     */
    public void testGetNumDeaths() {
        assertEquals(0, race.getNumDeaths());
    }


    /**
     * Makes sure the method setDeaths works as expected
     */
    public void testSetDeaths() {
        race.setDeaths(50);
        assertEquals(50, race.getNumDeaths());
    }


    /**
     * Makes sure the method calcCFR works as expected
     */
    public void testCalcCFR() {
        // assertEquals(0, race.calcCFR());
    }


    /**
     * Makes sure the method compareTo works as expected
     */
    public void testCompareTo() {

    }


    /**
     * Makes sure the method toString works as expected
     */
    public void testToString() {

    }
}
