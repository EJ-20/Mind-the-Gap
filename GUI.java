import java.awt.*;
import javax.swing.*;
import java.awt.event.*;





public class GUI extends JFrame {
    private JPanel topPanel, bottomPanel;
    private JLabel instructionLabel;
    private JButton topButton;
    //private GridSquare [][] gridSquares;
    private int rows, columns;


    public GUI() {
        rows = 4;
        columns = 4;

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        instructionLabel = new JLabel("Player's turn");


        topButton = new JButton("New Game");

        topPanel.add(instructionLabel);
        topPanel.add(topButton);


        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        pack();

        setSize(600,600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);


    }





}
