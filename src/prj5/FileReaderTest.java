package prj5;

import java.io.FileNotFoundException;
import student.TestCase;

public class FileReaderTest extends TestCase
{

    public void setUp() throws Exception
    {
        
    }


    public void test() throws FileNotFoundException
    {
        FileReader f = new FileReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
    }

}
