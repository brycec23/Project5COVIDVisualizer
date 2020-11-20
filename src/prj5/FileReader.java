package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bryce Cullen (brycec23)
/**
 * Parses a CSV file and creates a LinkedList of Regions with Races.
 * 
 * @author Bryce Cullen (brycec23)
 * @version 2020.11.19
 */
public class FileReader
{

    private LinkedList<Region> data;

    /**
     * Creates a new FileReader.
     * 
     * @param fileName
     *            File to parse.
     * @throws FileNotFoundException
     */
    public FileReader(String fileName) throws FileNotFoundException
    {
        data = readFile(fileName);
        GUIWindow w = new GUIWindow(data);
    }


    private LinkedList<Region> readFile(String file)
        throws FileNotFoundException
    {//TODO need to account for NA being read (line 58 and line 65)
        LinkedList<Region> data = new LinkedList<Region>();
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter(",");
        String[] races = new String[5];
        races[0] = "WHITE";
        races[1] = "BLACK";
        races[2] = "LATINX";
        races[3] = "ASAIN";
        races[4] = "OTHER";
        while (scanner.hasNextLine())
        {
            scanner.nextLine();
            Region r = new Region(scanner.next());
            int horizCount = 0;
            while (scanner.hasNext() && horizCount < races.length)
            {
                Race tempRace = new Race(races[horizCount]);
                tempRace.setCases(scanner.nextInt());
                r.addRaceData(tempRace);
                horizCount++;
            }
            horizCount = 0;
            while (scanner.hasNext())
            {
                r.getRaces().get(horizCount).setDeaths(scanner.nextInt());
                horizCount++;
            }
            data.add(r);
        }
        return data;
    }

}
