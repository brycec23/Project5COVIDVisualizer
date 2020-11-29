package prj5;

import java.util.Iterator;
import cs2.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bryce Cullen (brycec23)
/**
 * Class to visually represent the data.
 * 
 * @author Bryce Cullen (brycec23)
 * @version 2020.11.29
 */
public class GUIWindow
{

    private DLList<Region> data;
    private DLList<Race> current;
    private Window window;
    private Button sortAlphaButton;
    private Button quitButton;
    private Button sortCFRButton;
    private Button repDC;
    private Button repGA;
    private Button repMD;
    private Button repNC;
    private Button repTN;
    private Button repVA;
    private static int BAR_WIDTH = 20;

    /**
     * Creates a new blank window.
     * 
     * @param data
     *            The data to be represented.
     */
    public GUIWindow(DLList<Region> data)
    {
        // Initialize data and window.
        this.data = data;
        window = new Window("COVID-19 Statistics by State");
        window.setSize(500, 500);

        //
        sortAlphaButton = new Button("Sort by Alpha");
        sortAlphaButton.onClick(this, "clickedSortAlpha");

        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");

        sortCFRButton = new Button("Sort by CFR");
        sortCFRButton.onClick(this, "clickedSortCFR");

        repDC = new Button("Represent DC");
        repDC.onClick(this, "clickedRepDC");

        repGA = new Button("Represent GA");
        repGA.onClick(this, "clickedRepGA");

        repMD = new Button("Represent MD");
        repMD.onClick(this, "clickedRepMD");

        repNC = new Button("Represent NC");
        repNC.onClick(this, "clickedRepNC");

        repTN = new Button("Represent TN");
        repTN.onClick(this, "clickedRepTN");

        repVA = new Button("Represent VA");
        repVA.onClick(this, "clickedRepVA");

        window.addButton(sortAlphaButton, WindowSide.NORTH);
        window.addButton(quitButton, WindowSide.NORTH);
        window.addButton(sortCFRButton, WindowSide.NORTH);
        window.addButton(repDC, WindowSide.SOUTH);
        window.addButton(repGA, WindowSide.SOUTH);
        window.addButton(repMD, WindowSide.SOUTH);
        window.addButton(repNC, WindowSide.SOUTH);
        window.addButton(repTN, WindowSide.SOUTH);
        window.addButton(repVA, WindowSide.SOUTH);
    }


    /**
     * Draws bar charts.
     * 
     * @param region
     *            Region to represent data for.
     */
    public void drawBars(DLList<Race> list)
    {
        window.removeAllShapes();
        Iterator<Race> iter = list.iterator();

        int x = window.getGraphPanelWidth() / (2 * list.size());
        int space = window.getGraphPanelWidth() / list.size();
        while (iter.hasNext())
        {
            Race race = iter.next();

            // Creates race name label
            TextShape raceLabel = new TextShape(0, 350, race.getName());
            int textX = x - (raceLabel.getWidth() / 2);
            raceLabel.moveTo(textX, 350);
            window.addShape(raceLabel);

            // Creates CFR label
            if (race.calcCFR() != -1.0)
            {
                TextShape cfrLabel = new TextShape(0, 370, race.CFRToString()
                    + "%");
                int cfrX = x - (cfrLabel.getWidth() / 2);
                cfrLabel.moveTo(cfrX, 370);
                window.addShape(cfrLabel);
            }

            // Creates bar charts
            // Creates NA label if CFR is not valid.
            if (race.calcCFR() == -1.0)
            {
                TextShape nope = new TextShape(0, 0, "NA");
                int nopeX = x - (nope.getWidth() / 2);
                nope.moveTo(nopeX, 330);
                window.addShape(nope);
            }
            else
            {
                int barHeight = ((int)(race.calcCFR() * 20));
                int barX = x - (BAR_WIDTH / 2);
                Shape bar = new Shape(barX, 340 - barHeight, BAR_WIDTH,
                    barHeight);
                window.addShape(bar);
            }

            x += space;
        }
    }


    /**
     * This method sorts data alphabetically.
     * 
     * @param button
     *            sortByAlpha button
     */
    public void clickedSortAlpha(Button button)
    {
        if (current == null)
        {
            window.addShape(new TextShape(window.getGraphPanelWidth() / 2,
                window.getGraphPanelHeight() / 2, "No State Selected!"));
        }
        else
        {
            current.insertionSort(new SortAlpha());
            drawBars(current);
        }
    }


    /**
     * This method quits the program.
     * 
     * @param button
     *            Quit button.
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }


    /**
     * This method sorts data by CFR.
     * 
     * @param button
     *            sortByCFR button
     */
    public void clickedSortCFR(Button button)
    {
        if (current == null)
        {
            window.addShape(new TextShape(window.getGraphPanelWidth() / 2,
                window.getGraphPanelHeight() / 2, "No State Selected!"));
        }
        else
        {
            current.insertionSort(new SortCFR());
            drawBars(current);
        }
    }


    /**
     * Represent DC button
     * 
     * @param button
     *            Button to assign to this action.
     */
    public void clickedRepDC(Button button)
    {
        current = data.get(0).toDLList();
        drawBars(current);
    }


    /**
     * Represent GA button
     * 
     * @param button
     *            Button to assign to this action.
     */
    public void clickedRepGA(Button button)
    {
        current = data.get(1).toDLList();
        drawBars(current);
    }


    /**
     * Represent MD button
     * 
     * @param button
     *            Button to assign to this action.
     */
    public void clickedRepMD(Button button)
    {
        current = data.get(2).toDLList();
        drawBars(current);
    }


    /**
     * Represent NC button
     * 
     * @param button
     *            Button to assign to this action.
     */
    public void clickedRepNC(Button button)
    {
        current = data.get(3).toDLList();
        drawBars(current);
    }


    /**
     * Represent TN button
     * 
     * @param button
     *            Button to assign to this action.
     */
    public void clickedRepTN(Button button)
    {
        current = data.get(4).toDLList();
        drawBars(current);
    }


    /**
     * Represent VA button
     * 
     * @param button
     *            Button to assign to this action.
     */
    public void clickedRepVA(Button button)
    {
        current = data.get(5).toDLList();
        drawBars(current);
    }

}
