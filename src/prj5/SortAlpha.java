package prj5;

import java.util.Comparator;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bryce Cullen (brycec23)
/**
 * A comparator to sort Races alphabetically
 * 
 * @author Bryce Cullen (brycec23)
 * @version 2020.11.21
 * 
 */
public class SortAlpha implements Comparator<Race>
{

    @Override
    public int compare(Race o1, Race o2)
    {
        String a = o1.getName();
        String b = o2.getName();
        return a.compareTo(b);
    }

}
