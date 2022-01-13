import java.awt.*;
import javax.swing.*;
import java.awt.event.*;





public class GUI extends JFrame implements ActionListener {

    // declaring the variables used in creating the GUI
    private JPanel topPanel, bottomPanel;
    private JLabel instructionLabel;
    private JButton topButton;
    private JButton whiteButton;
    private JButton redButton;
    private JButton blueButton;
    private GridLayout gridSquares;
    private int rows, columns;

    // create, organize and display the GUI
    public GUI() {

        rows = 4;
        columns = 4;

        // creating the panels as required
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        bottomPanel = new JPanel();


        instructionLabel = new JLabel("Player's turn");


        topButton = new JButton("New Game");

        topPanel.add(instructionLabel);
        topPanel.add(topButton);

        GridLayout grid = new GridLayout(rows, columns);
        bottomPanel.setLayout(grid);


        whiteButton = new JButton();
        blueButton = new JButton();
        redButton = new JButton();

        whiteButton.setBackground(Color.WHITE);
        whiteButton.setOpaque(true);



        /*for(int i = 0; i <= rows; i++){
            for(int x = 0; x <= columns; x++){
                bottomPanel.add(whiteButton);
            }
        }*/

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






