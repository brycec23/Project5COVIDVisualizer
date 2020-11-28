package prj5;

import java.io.FileNotFoundException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bryce Cullen (brycec23)
/**
 * Contains the main method of the project.
 * 
 * @author Bryce Cullen (brycec23)
 * @version 2020.11.19
 */
public class Input
{

    /**
     * Creates a new Input (Never used).
     */
    public Input()
    {
        // Intentionally Empty
    }


    /**
     * Main method for program.
     * 
     * @param args
     *            File to be used.
     * @throws FileNotFoundException
     *             If file is not found;
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        @SuppressWarnings("unused")
        FileReader f = new FileReader(args[0]);

    }

}
