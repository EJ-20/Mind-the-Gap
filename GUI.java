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
        topPanel.setLayout(new BorderLayout());

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);


    }





}
