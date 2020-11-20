package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bryce Cullen (brycec23)
// -- Jonathan Ko (jonathancko)
// -- TODO NAME (PID)

/**
 * Represents the COVID-19 Deaths and Cases for a single race.
 * 
 * @author Bryce Cullen (brycec23)
 * @author Jonathan Ko (jonathancko)
 * @author TODO
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
        //TODO needs to account for case of "NA"
        double CFR = 0.0;
        CFR = numDeaths / numCases;
        return CFR;
    }


    /**
     * Returns a string representation of Race object.
     * 
     * @return String representation of race.
     */
    public String toString()
    {
        return ("Race: " + name + " Cases: " + numCases + " Deaths: "
            + numDeaths);
    }

}
