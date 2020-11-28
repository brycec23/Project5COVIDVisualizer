package prj5;

import java.util.ArrayList;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bryce Cullen (brycec23)
// -- Jonathan Ko (jonathancko)
/**
 * Represents the COVID-19 Deaths and Cases for a single region.
 * 
 * @author Bryce Cullen (brycec23)
 * @author Jonathan Ko (jonathancko)
 * @version 2020.11.17
 */

public class Region implements Comparable<Region>
{

    private String name;
    private ArrayList<Race> races;

    /**
     * Creates a new region.
     * 
     * @param name
     *            Name of region.
     */
    public Region(String name)
    {
        this.name = name;
        races = new ArrayList<Race>();
    }


    /**
     * Getter method for name.
     * 
     * @return name.
     */
    public String getName()
    {
        return name;
    }


    /**
     * Adds a race to region's arraylist.
     * 
     * @param race
     *            Race to add.
     */
    public void addRaceData(Race race)
    {
        races.add(race);
    }


    /**
     * Returns the arraylist of races.
     * 
     * @return races
     */
    public ArrayList<Race> getRaces()
    {
        return races;
    }


    /**
     * Returns the deaths for a given race in this region.
     * 
     * @param race
     *            Race to get deaths for.
     * @return Number of death for specified race.
     */
    public int getDeaths(Race race)
    {
        return races.get(races.indexOf(race)).getNumDeaths();
    }


    /**
     * Returns the cases for a given race in this region.
     * 
     * @param race
     *            Race to get cases for.
     * @return Number of cases for specified race.
     */
    public int getCases(Race race)
    {
        return races.get(races.indexOf(race)).getNumCases();
    }


    /**
     * Returns a string representation of a region.
     * 
     * @return String representation of region.
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append(getName() + "'s COVID-19 Stats by race: ");
        for (Race r : races)
        {
            s.append("[");
            s.append(r.toString());
            s.append("]");
        }
        return s.toString();
    }


    /**
     * Returns a DLList of the races in this region.
     * 
     * @return DLList of the races in this region.
     */
    public DLList<Race> toDLList()
    {
        DLList<Race> raceLL = new DLList<Race>();
        for (Race r : races)
        {
            raceLL.add(r);
        }
        return raceLL;
    }


    /**
     * Sorts regions alphabetically.
     * 
     * @param other
     *            The region to compare to.
     * @return 1 if this is further in the alphabet than other, -1 if this is
     *         lower in the alphabet than other. If first digit is same, move to
     *         second digit, else return 0 if same word.
     */
    public int compareTo(Region other)
    {
        int compare = 0;
        if (this.getName().equals(other.getName()))
        {
            compare = 0;
        }
        if (this.getName().compareTo(other.getName()) > 0)
        {
            compare = 1;
        }
        else if (this.getName().compareTo(other.getName()) < 0)
        {
            compare = -1;
        }
        return compare;
    }

}
