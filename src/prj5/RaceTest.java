package prj5;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bryce Cullen (brycec23)
// -- Jonathan Ko (jonathancko)
/**
 * Test class for Race
 * 
 * @author Bryce Cullen (brycec23)
 * @author Jonathan Ko (jonathancko)
 * @version 2020.11.21
 */
public class RaceTest extends TestCase
{
    private Race race;

    /**
     * Sets up the test class for accurate testing
     */
    public void setUp()
    {
        race = new Race("White");
    }


    /**
     * Makes sure the method getName works as expected
     */
    public void testGetName()
    {
        assertEquals("White", race.getName());
    }


    /**
     * Makes sure the method getNumCases works as expected
     */
    public void testGetNumCases()
    {
        assertEquals(-1, race.getNumCases());
    }


    /**
     * Makes sure the method setCases works as expected
     */
    public void testSetCases()
    {
        race.setCases(100);
        assertEquals(100, race.getNumCases());
    }


    /**
     * Makes sure the method getNumDeaths works as expected
     */
    public void testGetNumDeaths()
    {
        assertEquals(-1, race.getNumDeaths());
    }


    /**
     * Makes sure the method setDeaths works as expected
     */
    public void testSetDeaths()
    {
        race.setDeaths(50);
        assertEquals(50, race.getNumDeaths());
    }


    /**
     * Makes sure the method calcCFR works as expected
     */
    public void testCalcCFR()
    {
        race.setCases(-1);
        race.setDeaths(-1);
        assertEquals(-1.0, race.calcCFR(), 0.01);

        race.setCases(100);
        race.setDeaths(50);
        assertEquals(50.0, race.calcCFR(), 0.01);
    }


    /**
     * Makes sure the method toString works as expected
     */
    public void testToString()
    {
        race.setCases(100);
        race.setDeaths(50);
        assertEquals("White: 100 cases, 50% CFR", race.toString());
        race.setCases(-1);
        race.setDeaths(-1);
        assertEquals("White: -1 cases, -1% CFR", race.toString());
    }


    /**
     * Test cfrToString
     */
    public void testCfrToString()
    {
        Race race1 = new Race("Black");
        race1.setCases(3);
        race1.setDeaths(1);
        assertEquals("33.3", race1.cfrToString());
    }
}
