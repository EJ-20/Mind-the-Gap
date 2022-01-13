import java.awt.*;
import javax.swing.*;
import java.awt.event.*;





public class GUI extends JFrame implements ActionListener {

    // declaring the variables used in creating the GUI
    private JPanel topPanel, bottomPanel;
    private JLabel instructionLabel;
    private JButton topButton;
    private GridSquare [][] gridSquares;
    private int x, y;

    // create, organize and display the GUI
    public GUI() {

        // creating the panels as required
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        x = 4;
        y = 4;


        instructionLabel = new JLabel("Player's turn");


        topButton = new JButton("New Game");

        topPanel.add(instructionLabel);
        topPanel.add(topButton);



        gridSquares = new GridSquare [x][y];
        for(int column = 0; column < x; column++){
            for(int row = 0; row < y; row++){
                gridSquares [column][row] = new GridSquare( x,y);
                gridSquares [column][row].setSize( 20, 20);
                gridSquares [column][row].setColor( column + row);
                gridSquares [column][row].setOpaque( true);				// without this line and the next the OS' default
                //gridSquares [column][row].setBorderPainted( false);		// look & feel will dominate / interfere
                // (try commenting each out & see what happens)

                bottomPanel.add( gridSquares [column][row]);

            }
        }

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        pack();

        setSize(600, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);

    }

        public void actionPerformed (ActionEvent act){

        }


    }






