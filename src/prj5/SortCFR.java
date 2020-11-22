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

    @Override
    public int compare(Race o1, Race o2)
    {
        Double a = o1.calcCFR();
        Double b = o2.calcCFR();

        if (a > b)
        {
            return -1;
        }
        else if (a.equals(b))
        {
            return o1.getName().compareTo(o2.getName());
        }
        return 1;
    }

}
