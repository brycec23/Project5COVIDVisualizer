package prj5;

import java.text.DecimalFormat;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bryce Cullen (brycec23)
// -- Jonathan Ko (jonathancko)
/**
 * Represents the COVID-19 Deaths and Cases for a single race.
 * 
 * @author Bryce Cullen (brycec23)
 * @author Jonathan Ko (jonathancko)
 * @version 2020.11.17
 */
public class Race
{
    private String name;
    private int numCases;
    private int numDeaths;

    /**
     * Creates a new Race.
     * 
     * @param name
     *            The name of race/ethnicity.
     * @param numCases
     *            Number of COVID cases in that race.
     * @param numDeaths
     *            Number of COVID deaths in that race.
     */
    public Race(String name)
    {
        this.name = name;
        numCases = -1;
        numDeaths = -1;
    }


    /**
     * Getter method for name.
     * 
     * @return Name of race.
     */
    public String getName()
    {
        return name;
    }


    /**
     * Getter method for number of cases.
     * 
     * @return Number of cases.
     */
    public int getNumCases()
    {
        return numCases;
    }


    /**
     * Sets the cases for a race.
     * 
     * @param cases
     *            number to set cases to.
     */
    public void setCases(int cases)
    {
        numCases = cases;
    }


    /**
     * Getter method for number of deaths.
     * 
     * @return Number of deaths.
     */
    public int getNumDeaths()
    {
        return numDeaths;
    }


    /**
     * Sets the deaths for a race.
     * 
     * @param deaths
     *            number to set deaths to.
     */
    public void setDeaths(int deaths)
    {
        numDeaths = deaths;
    }


    /**
     * Calculates the CFR (Case Fatality Ratio)
     * 
     * @return CFR as a double.
     */
    public double calcCFR()
    {
        if (numCases == -1 || numDeaths == -1 || numDeaths == 0)
        {
            return -1.0;
        }
        else
        {
            double CFR = 0.0;
            CFR = ((double)numDeaths / (double)numCases) * 100;
            DecimalFormat df = new DecimalFormat("#.#");
            return Double.parseDouble(df.format(CFR));
        }
    }


    /**
     * Returns a string representation of Race object.
     * 
     * @return String representation of race.
     */
    public String toString()
    {
        String formattedCFR = String.valueOf(calcCFR());
        if (formattedCFR.substring(formattedCFR.length() - 2).equals(".0"))
        {
            formattedCFR = formattedCFR.replace(".0", "");
        }
        return (name + ": " + numCases + " cases, " + formattedCFR + "% CFR");
    }


    /**
     * Checks if two races are equal.
     * 
     * @param other
     *            Race to compare to.
     * @return True if races are equal.
     */
    public boolean equals(Race other)
    {

        if (other == this)
        {
            return true;
        }
        if (other == null)
        {
            return false;
        }
        if (this.getClass() == other.getClass() && this.getName() == other
            .getName() && this.getNumCases() == other.getNumCases() && this
                .getNumDeaths() == other.getNumDeaths())
        {
            return true;
        }

        return false;
    }
}
