import java.awt.Color;
import javax.swing.*;

/*
 *  A GUI component
 *
 *  A simple extension of JPanel which records its
 *  coordinates in xcoord and ycoord, NOT in 'x' and 'y'.
 *  Why not? Because 'x' and 'y' are already attributes of
 *  the panel (super) class which say where to draw it in the window.
 *
 *  The game grid and allows the background colour to be set with ease.
 *
 *  @author mhatcher
 */
public class GridSquare extends JButton
{
    private int xcoord, ycoord;  // location in the grid
	
	// constructor takes the x and y coordinates of this square
	public GridSquare(int xcoord, int ycoord)
	{
		super();
		this.setSize(50,50);

        if (xcoord < 0){
            xcoord = 0;
        }
        if (xcoord > 3){
            xcoord = 3;
        }
        if (ycoord < 0){
            ycoord = 0;
        }
        if (ycoord > 3){
            ycoord = 3;
        }
		this.xcoord = xcoord;
		this.ycoord = ycoord;

	}
	
	// if the decider is even, it chooses black, otherwise white (for 'column+row' will allow a chequerboard effect)
    public void setColor(int decider)
    {
        decider = decider % 2;
        Color colour = (decider == 0) ? Color.red: Color.blue;
        this.setBackground(colour);

    }
    
    // if the square is black it becomes white, and vice-versa
    public void setInitColor()
    {

        this.setBackground(Color.white);
    }
    
    // simple setters and getters
    public void setXcoord(int value)    { xcoord = value; }
    public void setYcoord(int value)    { ycoord = value; }
    public int getXcoord()              { return xcoord; }
    public int getYcoord()              { return ycoord; }
    public Color getColor()             {return getBackground();}
}
