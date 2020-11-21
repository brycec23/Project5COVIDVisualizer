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
 * Test class for Region
 * 
 * @author Bryce Cullen (brycec23)
 * @author Jonathan Ko (jonathancko)
 * @author TODO
 * @version 2020.11.21
 */
public class RegionTest extends TestCase {
    /**
     * Fields
     */
    private Region region;
    private Region region1;
    private Race race;

    /**
     * Sets up the test class for accurate testing
     */
    public void setUp() {
        region = new Region("VA");

        race = new Race("White");
        race.setCases(100);
        race.setDeaths(50);

        region1 = new Region("DC");
        region1.addRaceData(race);
    }


    /**
     * Makes sure the method getName works as expected
     */
    public void testGetName() {
        assertEquals("VA", region.getName());
    }


    /**
     * Makes sure the method addRaceData works as expected
     */
    public void testAddRaceData() {
        region.addRaceData(race);
        assertEquals("[White: 100 cases, 50.0 CFR]", region.getRaces()
            .toString());
    }


    /**
     * Makes sure the method getRaces works as expected
     */
    public void testGetRaces() {
        assertEquals("[White: 100 cases, 50.0 CFR]", region1.getRaces()
            .toString());
    }


    /**
     * Makes sure the method getDeaths works as expected
     */
    public void testGetDeaths() {
        assertEquals(50, region1.getDeaths(race));
    }


    /**
     * Makes sure the method getCases works as expected
     */
    public void testGetCases() {
        assertEquals(100, region1.getCases(race));
    }


    /**
     * Makes sure the method toString works as expected
     */
    public void testToString() {

    }


    /**
     * Makes sure the method compareTo works as expected
     */
    public void testCompareTo() {
        assertEquals(1, region.compareTo(region1));
        assertEquals(-1, region1.compareTo(region));
        assertEquals(0, region.compareTo(region));
    }
}
