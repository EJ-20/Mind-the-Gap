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

    // selects a random player to start the game
    public void player() {

        String[] players = {"Player 1's turn", "Player 2's turn"};
        index = count % 2;
        instructionLabel.setText(players[index]);

    }


    // creates the grid
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


    // method for tracking user actions
    public void actionPerformed (ActionEvent act){

        Object selected = act.getSource();

        // instructions for the event when 'New Game' is clicked
        if (selected.equals(topButton)){

            rand = new Random();
            count = rand.nextInt(2);
            started = true;
            player();


        }

        // start a new game if 'New Game' button is clicked
        if (selected.equals(topButton)) {
            for (int column = 0; column < y; column++) {
                for (int row = 0; row < x; row++) {

                    gridSquares[column][row].setInitColor();
                    started = true;
                }
            }
        }

        // instructions when the game is going on
        if (started) {

            if (selected instanceof GridSquare) {

                GridSquare square = (GridSquare) selected;
                if (square.getColor() == Color.white) {
                    square.setColor(count);
                    count++;
                }

                int xCoord = square.getXcoord();
                int yCoord = square.getYcoord();

                player();

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

                    if (square.getColor().equals(Color.red)){
                        instructionLabel.setText("Player 2 wins");
                    } else {
                        instructionLabel.setText("Player 1 wins");
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






