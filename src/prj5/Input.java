package prj5;

import java.io.FileNotFoundException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bryce Cullen (brycec23)
// -- Jonathan Ko (jonathancko)
// -- TODO NAME (PID)

/**
 * Contains the main method of the project.
 * 
 * @author Bryce Cullen (brycec23)
 * @author Jonathan Ko (jonathancko)
 * @author TODO
 * @version 2020.11.19
 */
public class Input {

    /**
     * Creates a new Input (Never used).
     */
    public Input() {
        // Intentionally Empty
    }


    public static void main(String[] args) throws FileNotFoundException {
        new FileReader(args[1]);
    }

}
