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
 * Test class for Region
 * 
 * @author Bryce Cullen (brycec23)
 * @author Jonathan Ko (jonathancko)
 * @version 2020.11.21
 */
public class RegionTest extends TestCase
{
    private Region region;
    private Region region1;
    private Region region2;
    private Race race;
    private Race race1;

    /**
     * Sets up the test class for accurate testing
     */
    public void setUp()
    {
        region = new Region("VA");

        race = new Race("White");
        race.setCases(100);
        race.setDeaths(50);

        race1 = new Race("Black");
        race1.setCases(100);
        race1.setDeaths(25);

        region1 = new Region("DC");
        region1.addRaceData(race);

        region2 = new Region("CT");
        region2.addRaceData(race);
        region2.addRaceData(race1);
    }


    /**
     * Makes sure the method getName works as expected
     */
    public void testGetName()
    {
        assertEquals("VA", region.getName());
    }


    /**
     * Makes sure the method addRaceData works as expected
     */
    public void testAddRaceData()
    {
        region.addRaceData(race);
        assertEquals("[White: 100 cases, 50% CFR]", region.getRaces()
            .toString());
    }


    /**
     * Makes sure the method getRaces works as expected
     */
    public void testGetRaces()
    {
        assertEquals("[White: 100 cases, 50% CFR]", region1.getRaces()
            .toString());
    }


    /**
     * Makes sure the method getDeaths works as expected
     */
    public void testGetDeaths()
    {
        assertEquals(50, region1.getDeaths(race));
    }


    /**
     * Makes sure the method getCases works as expected
     */
    public void testGetCases()
    {
        assertEquals(100, region1.getCases(race));
    }


    /**
     * Makes sure the method toString works as expected
     */
    public void testToString()
    {
        assertEquals("DC's COVID-19 Stats by race: [White: 100 cases, 50% CFR]",
            region1.toString());
    }


    /**
     * Makes sure toDLList returns the correct DDList representation of a
     * region.
     */
    public void testToDLList()
    {
        DLList<Race> region1List = new DLList<Race>();
        region1List = region1.toDLList();
        DLList<Race> reference = new DLList<Race>();
        reference.add(race);
        assertEquals(reference.toString(), region1List.toString());
    }


    /**
     * Makes sure the method compareTo works as expected
     */
    public void testCompareTo()
    {
        assertEquals(1, region.compareTo(region1));
        assertEquals(-1, region1.compareTo(region));
        assertEquals(0, region.compareTo(region));
    }
}
