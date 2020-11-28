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
 * Parses a CSV file and creates a LinkedList of Regions with Races containing
 * the data.
 * 
 * @author Bryce Cullen (brycec23)
 * @version 2020.11.20
 */
public class FileReader
{

    private DLList<Region> data;

    /**
     * Creates a new FileReader.
     * 
     * @param fileName
     *            File to parse.
     * @throws FileNotFoundException
     *             if file is not found.
     */
    public FileReader(String fileName) throws FileNotFoundException
    {
        data = readFile(fileName);
        printToConsole();
        // @SuppressWarnings("unused")
        // GUIWindow w = new GUIWindow(data);
    }


    /**
     * Reads a file and creates regions with races from that data.
     * 
     * @param file
     *            File to read.
     * @return a doubly linked list of regions of races representing the data in
     *         the file.
     * @throws FileNotFoundException
     *             if file is unacceptable.
     */
    private DLList<Region> readFile(String file) throws FileNotFoundException
    {
        DLList<Region> data = new DLList<Region>();
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter(",|\\n|\\r");
        String[] races = new String[5];
        races[0] = "white";
        races[1] = "black";
        races[2] = "latinx";
        races[3] = "asian";
        races[4] = "other";
        int count = 0;
        while (scanner.hasNextLine() && count < 6)
        {
            scanner.nextLine();
            Region r = new Region(scanner.next());
            int horizCount = 0;
            while (scanner.hasNext() && horizCount < races.length)
            {
                Race tempRace = new Race(races[horizCount]);
                String curr = scanner.next();
                if (curr.equals("NA"))
                {
                    tempRace.setCases(-1);
                }
                else
                {
                    tempRace.setCases(Integer.parseInt(curr));
                }
                r.addRaceData(tempRace);
                horizCount++;
            }
            horizCount = 0;
            while (scanner.hasNext() && horizCount < races.length)
            {
                String curr = scanner.next();
                if (curr.equals("NA"))
                {
                    r.getRaces().get(horizCount).setDeaths(-1);
                }
                else
                {
                    r.getRaces().get(horizCount).setDeaths(Integer.parseInt(
                        curr));
                }
                horizCount++;
            }
            data.add(r);
            count++;
        }
        scanner.close();
        return data;
    }


    /**
     * Prints the data to console.
     */
    private void printToConsole()
    {
        Region region = null;
        DLList<Race> races = null;
        Race race = null;
        for (int i = 0; i < 6; i++)
        {
            region = data.get(i);
            races = region.toDLList();
            races.insertionSort(new SortAlpha());
            System.out.println(region.getName());
            for (int j = 0; j < 5; j++)
            {
                race = races.get(j);
                System.out.println(race.toString());
            }
            System.out.println("====");
            races.insertionSort(new SortCFR());
            for (int j = 0; j < 5; j++)
            {
                race = races.get(j);
                System.out.println(race.toString());
            }
            System.out.println("====");
        }

    }
}
