package prj5;

import java.util.Comparator;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bryce Cullen (brycec23)
/**
 * A comparator to sort Races by CFR
 * 
 * @author Bryce Cullen (brycec23)
 * @version 2020.11.21
 * 
 */
public class SortCFR implements Comparator<Race>
{

    /**
     * Sorts races by CFR
     * 
     * @param r1
     *            First race to compare.
     * @param r2
     *            Second race to compare.
     * @return 1 if r1 is greater than r2, -1 if less than r2, 0 if equal.
     */
    @Override
    public int compare(Race r1, Race r2)
    {
        Double a = r1.calcCFR();
        Double b = r2.calcCFR();

        if (a > b)
        {
            return -1;
        }
        else if (a.equals(b))
        {
            return r1.getName().compareTo(r2.getName());
        }
        return 1;
    }

}
