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
// -- Jonathan Ko (jonathancko)
/**
 * Parses a CSV file and creates a LinkedList of Regions with Races containing
 * the data.
 * 
 * @author Bryce Cullen (brycec23)
 * @author Jonathan Ko (jonathancko)
 * @version 2020.11.20
 */
public class FileReader {

    private LinkedList<Region> data;

    /**
     * Creates a new FileReader.
     * 
     * @param fileName
     *            File to parse.
     * @throws FileNotFoundException
     *             if file is not found.
     */
    public FileReader(String fileName) throws FileNotFoundException {
        data = readFile(fileName);
        @SuppressWarnings("unused")
        GUIWindow w = new GUIWindow(data);
    }


    private LinkedList<Region> readFile(String file)
        throws FileNotFoundException {
        LinkedList<Region> data = new LinkedList<Region>();
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter(",|\\n|\\r");
        String[] races = new String[5];
        races[0] = "WHITE";
        races[1] = "BLACK";
        races[2] = "LATINX";
        races[3] = "ASAIN";
        races[4] = "OTHER";
        int count = 0;
        while (scanner.hasNextLine() && count < 6) {
            scanner.nextLine();
            Region r = new Region(scanner.next());
            int horizCount = 0;
            while (scanner.hasNext() && horizCount < races.length) {
                Race tempRace = new Race(races[horizCount]);
                String curr = scanner.next();
                if (curr.equals("NA")) {
                    tempRace.setCases(-1);
                }
                else {
                    tempRace.setCases(Integer.parseInt(curr));
                }
                r.addRaceData(tempRace);
                horizCount++;
            }
            horizCount = 0;
            while (scanner.hasNext() && horizCount < races.length) {
                String curr = scanner.next();
                if (curr.equals("NA")) {
                    r.getRaces().get(horizCount).setDeaths(-1);
                }
                else {
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
}
