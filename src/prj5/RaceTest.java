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
    private Race race2;
    private Race race3;
    private Race race4;

    /**
     * Sets up the test class for accurate testing
     */
    public void setUp() {
        race = new Race("White");
        race2 = new Race("Black");
        race3 = new Race("Asian");
        race4 = new Race("LatinX");
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
        Exception exception = null;
        try {
            race.calcCFR();
            fail("calcCFR() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("calcCFR() is throwing the wrong type of exceptions",
            exception instanceof ArithmeticException);

        race.setCases(-1);
        race.setDeaths(-1);
        assertEquals(-1.0, race.calcCFR(), 0.01);

        race.setCases(100);
        race.setDeaths(50);
        assertEquals(0.5, race.calcCFR(), 0.01);
    }


    /**
     * Makes sure the method compareTo works as expected
     */
    public void testCompareTo() {
        race.setCases(100);
        race.setDeaths(50);
        race2.setCases(100);
        race2.setDeaths(25);
        race3.setCases(100);
        race3.setDeaths(75);
        race4.setCases(100);
        race4.setDeaths(50);
        assertEquals(1, race.compareTo(race2));
        assertEquals(-1, race.compareTo(race3));
        assertEquals(0, race.compareTo(race4));
    }


    /**
     * Makes sure the method toString works as expected
     */
    public void testToString() {
        race.setCases(100);
        race.setDeaths(50);
        assertEquals("White: 100 cases, 0.5 CFR", race.toString());
        race.setCases(-1);
        race.setDeaths(-1);
        assertEquals("White: -1 cases, -1.0 CFR", race.toString());
    }
}
