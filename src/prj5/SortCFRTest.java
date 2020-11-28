package prj5;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bryce Cullen (brycec23)
/**
 * Test class for sortCFR().
 * 
 * @author Bryce Cullen (brycec23)
 * @version 2020.11.21
 * 
 */
public class SortCFRTest extends TestCase
{

    private SortCFR s;
    private Race race1;
    private Race race2;

    /**
     * Sets up intial test conditions.
     */
    public void setUp()
    {
        s = new SortCFR();
        race1 = new Race("a");
        race1.setCases(10);
        race1.setDeaths(2);
        race2 = new Race("b");
        race2.setCases(20);
        race2.setDeaths(10);
    }


    /**
     * Tests comapre method to make sure races are sorted by CFR.
     */
    public void testCompare()
    {
        assertEquals(1, s.compare(race1, race2));
        assertEquals(-1, s.compare(race2, race1));
    }

}
