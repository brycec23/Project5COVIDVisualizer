package prj5;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bryce Cullen (brycec23)
/**
 * Test class for sortAlpha().
 * 
 * @author Bryce Cullen (brycec23)
 * @version 2020.11.21
 * 
 */
public class SortAlphaTest extends TestCase
{

    private SortAlpha s;
    private Race race1;
    private Race race2;

    /**
     * Sets up intial test conditions.
     */
    public void setUp()
    {
        s = new SortAlpha();
        race1 = new Race("a");
        race2 = new Race("b");
    }


    /**
     * Tests comapre method to make sure races are sorted alphabetically.
     */
    public void testCompare()
    {
        assertEquals(-1, s.compare(race1, race2));
        assertEquals(1, s.compare(race2, race1));
    }

}
