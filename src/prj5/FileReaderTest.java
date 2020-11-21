package prj5;

import java.io.FileNotFoundException;
import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bryce Cullen (brycec23)
// -- Jonathan Ko (jonathancko)
// -- TODO NAME (PID)

/**
 * Test class for FileReader
 * 
 * @author Bryce Cullen (brycec23)
 * @author Jonathan Ko (jonathancko)
 * @author TODO
 * @version 2020.11.21
 */
public class FileReaderTest extends TestCase {

    public void setUp() throws Exception {

    }


    public void test() throws FileNotFoundException {
        FileReader f = new FileReader(
            "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
    }

}
