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
            double cfr = 0.0;
            cfr = ((double)numDeaths / (double)numCases) * 100;
            DecimalFormat df = new DecimalFormat("#.#");
            return Double.parseDouble(df.format(cfr));
        }
    }


    /**
     * Returns a string representation of CFR, formatted to project guidelines.
     * 
     * @return CFR as string.
     */
    public String cfrToString()
    {
        String formattedCFR = String.valueOf(calcCFR());
        if (formattedCFR.substring(formattedCFR.length() - 2).equals(".0"))
        {
            formattedCFR = formattedCFR.replace(".0", "");
        }
        return formattedCFR;
    }


    /**
     * Returns a string representation of Race object.
     * 
     * @return String representation of race.
     */
    public String toString()
    {
        return (name + ": " + numCases + " cases, " + cfrToString() + "% CFR");
    }

}
