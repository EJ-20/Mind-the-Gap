import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class GUI extends JFrame implements ActionListener {

    // declaring the variables used in creating the GUI
    private JPanel topPanel, bottomPanel;
    private JLabel instructionLabel;
    private JLabel p1Label;
    private JLabel p2Label;
    private JButton topButton;
    private GridSquare [][] gridSquares;
    private int x, y;
    //private String[] players;
    private int count = 0;
    private int index;
    private boolean started = false;
    private int xCoord, yCoord;

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

    // method for tracking user actions
    public void actionPerformed (ActionEvent act){

        Object selected = act.getSource();

        if (selected.equals(topButton)){
            started = true;
            game();

        }
        if (started) {
            if (selected instanceof GridSquare){

                GridSquare square = (GridSquare) selected;
                if (square.getColor() == Color.white){
                    square.setColor(count);
                    count++;
                }

                int xCoord = square.getXcoord();
                int yCoord = square.getYcoord();


                game();
            }
        }


    }


}






