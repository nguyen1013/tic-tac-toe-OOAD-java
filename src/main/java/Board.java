import javax.swing.*;
import java.awt.*;

public class Board {
    public JFrame board;
    public JLabel label;
    public JPanel topPanel;
    public JPanel resetGame;
    public JButton resetButton;
    public JPanel gamePanel;
    public JButton[][] tiles;

    public Board() {
        board = new JFrame();
        label = new JLabel();
        topPanel = new JPanel();
        resetGame = new JPanel();
        resetButton = new JButton();
        gamePanel = new JPanel();
        tiles = new JButton[3][3];

        label.setForeground(Color.green);
        label.setFont(new Font("Monospaced", Font.PLAIN, 50));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Tic Tac Toe");

        resetButton.setText("Restart");
        resetButton.setPreferredSize(new Dimension(150, 50));
        resetButton.setFont(new Font("Courier", Font.BOLD, 20));
        resetButton.setFocusable(false);

        resetGame.setLayout(new FlowLayout(FlowLayout.CENTER));
        resetGame.setBackground(Color.darkGray);
        resetGame.add(resetButton);

        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.darkGray);
        topPanel.add(label, BorderLayout.NORTH);
        topPanel.add(resetGame, BorderLayout.SOUTH);

        gamePanel.setLayout(new GridLayout(3, 3));
        gamePanel.setBackground(Color.darkGray);
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                tiles[i][j] = new JButton();
                tiles[i][j].setBackground(Color.darkGray);
                tiles[i][j].setFont(new Font("Courier", Font.ITALIC, 50));
                tiles[i][j].setFocusable(false);
                gamePanel.add(tiles[i][j]);
            }
        }

        board.setSize(600, 700);
        board.setTitle("Tic Tac Toe");
        board.setBackground(Color.darkGray);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setLocationRelativeTo(null);
        board.setResizable(false);
        board.setLayout(new BorderLayout());

        board.add(topPanel, BorderLayout.NORTH);
        board.add(gamePanel, BorderLayout.CENTER);

        board.setVisible(true);
    }

    public void disableAllTiles() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (tiles[i][j].getText().isEmpty()) {
                    tiles[i][j].setEnabled(false);
                }
            }
        }
    }

    public void resetBoard() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                tiles[i][j].setText("");
                tiles[i][j].setEnabled(true);
            }
        }
    }
}
