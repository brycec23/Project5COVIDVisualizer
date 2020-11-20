package prj5;

import java.util.ArrayList;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bryce Cullen (brycec23)
// -- Jonathan Ko (jonathancko)
// -- TODO NAME (PID)

/**
 * Represents the COVID-19 Deaths and Cases for a single region.
 * 
 * @author Bryce Cullen (brycec23)
 * @author Jonathan Ko (jonathancko)
 * @author TODO
 * @version 2020.11.17
 */

public class Region
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


    public int getDeaths(Race race)
    {

    }


    public int getCases(Race race)
    {

    }


    public String toString()
    {

    }

}
