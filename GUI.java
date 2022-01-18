import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.Color;

public class GUI extends JFrame implements ActionListener {

    // declaring the variables used in creating the GUI
    private JPanel topPanel, bottomPanel;
    private JLabel instructionLabel;
    private JLabel p1Label;
    private JLabel p2Label;
    private JButton topButton;
    private GridSquare [][] gridSquares;
    private int x, y;
    private int count;
    private int index;
    private boolean started = false;
    private int xCoord, yCoord;
    private Random rand;

    // create, organize and display the GUI
    public GUI() {

        // x and y are the number of rows and columns
        x = 4;
        y = 4;

        // creating the panels as required
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(x,y, 10, 10));
        bottomPanel.setSize(500,500);

        // create the labels and buttons as required and add it to the appropriate panel
        instructionLabel = new JLabel("Don't select neighbour squares! Click 'New Game' to begin.    ");
        topButton = new JButton("New Game");
        topButton.addActionListener(this);
        p1Label = new JLabel("Player 1's turn");
        p2Label = new JLabel("Player 2's turn");

        topPanel.add(instructionLabel);
        topPanel.add(topButton);


        // create the grid of buttons and add to the appropriate panel
        grid();

        // add the panels to the content pane and organize them
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(bottomPanel, BorderLayout.CENTER);
        pack();

        setSize(600, 600);

        // adding a few functionality to the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);

    }

    // starts the game
    public void game() {

        String[] players = {"Player 1's turn", "Player 2's turn"};
        index = count % 2;
        instructionLabel.setText(players[index]);

    }

    public void grid(){

        gridSquares = new GridSquare [x][y];
        for(int column = 0; column < y; column++){
            for(int row = 0; row < x; row++){

                gridSquares [column][row] = new GridSquare(column,row);
                gridSquares [column][row].setSize( new Dimension(200, 200));
                gridSquares [column][row].setInitColor();
                gridSquares [column][row].setOpaque( true);
                gridSquares [column][row].setBorder(BorderFactory.createLineBorder(Color.black));
                gridSquares[column][row].addActionListener(this);
                bottomPanel.add( gridSquares [column][row]);

            }
        }

    }

/*
    public void colors(int y, int x){
        Color col1 = gridSquares[xCoord-1][yCoord-1].getColor();
        Color col2 = gridSquares[xCoord+1][yCoord+1].getColor();
        Color col3 = gridSquares[xCoord][yCoord-1].getColor();
        Color col4 = gridSquares[xCoord][yCoord+1].getColor();
        Color col5 = gridSquares[xCoord-1][yCoord].getColor();
        Color col6 = gridSquares[xCoord+1][yCoord].getColor();
        Color col7 = gridSquares[xCoord+1][yCoord-1].getColor();
        Color col8 = gridSquares[xCoord-1][yCoord+1].getColor();

        Color[] colour = new Color[]{col1, col2, col3, col4, col5, col6, col7, col8};
        System.out.println(colour[2].toString());
    }



 */



    // method for tracking user actions
    public void actionPerformed (ActionEvent act){

        Object selected = act.getSource();

        if (selected.equals(topButton)){

            rand = new Random();
            count = rand.nextInt(2);
            started = true;
            game();


        }

        if (started) {

            if (selected instanceof GridSquare) {

                GridSquare square = (GridSquare) selected;
                if (square.getColor() == Color.white) {
                    square.setColor(count);
                    count++;
                }

                int xCoord = square.getXcoord();
                int yCoord = square.getYcoord();


                game();

                //colors(yCoord, xCoord);
                // end of game instructions
                if (square.getColor().equals(getNorth(square).getColor()) |
                        square.getColor().equals(getSouth(square).getColor())|
                        square.getColor().equals(getEast(square).getColor())|
                        square.getColor().equals(getWest(square).getColor())|
                        square.getColor().equals(getNorthEast(square).getColor())|
                        square.getColor().equals(getNorthWest(square).getColor())|
                        square.getColor().equals(getSouthEast(square).getColor())|
                        square.getColor().equals(getSouthWest(square).getColor())){
                    started = false;

                }

            // start a new game if 'New Game' button is clicked
            if (selected.equals(topButton)){
                for(int column = 0; column < y; column++) {
                    for (int row = 0; row < x; row++) {

                        gridSquares[column][row].setInitColor();

                    }
                }
            }






            }
        }
    }

    // getter methods
    public GridSquare getNorth(GridSquare current)          {return gridSquares[current.getXcoord()][current.getYcoord()+1];}
    public GridSquare getSouth(GridSquare current)          {return gridSquares[current.getXcoord()][current.getYcoord()-1];}
    public GridSquare getEast(GridSquare current)           {return gridSquares[current.getXcoord()+1][current.getYcoord()];}
    public GridSquare getWest(GridSquare current)           {return gridSquares[current.getXcoord()-1][current.getYcoord()];}
    public GridSquare getSouthEast(GridSquare current)      {return gridSquares[current.getXcoord()+1][current.getYcoord()-1];}
    public GridSquare getNorthWest(GridSquare current)      {return gridSquares[current.getXcoord()-1][current.getYcoord()+1];}
    public GridSquare getSouthWest(GridSquare current)      {return gridSquares[current.getXcoord()-1][current.getYcoord()-1];}
    public GridSquare getNorthEast(GridSquare current)      {return gridSquares[current.getXcoord()+1][current.getYcoord()+1];}
}






