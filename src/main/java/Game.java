import javax.swing.*;
import java.awt.*;

public class Game {
    private static Board board;
    private static Player player;

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        board = new Board();
        player = new Player(Player.PlayerType.X);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton tile = board.tiles[i][j];
                tile.addActionListener(e -> clickTile(tile));
            }
        }

        board.resetButton.addActionListener(e -> restartGame());
    }

    private static void restartGame() {
        board.label.setText("Tic Tac Toe");
        board.resetBoard();
        player.currentPlayer = Player.PlayerType.X;
    }

    private static void clickTile(JButton tile) {
        if (tile.getText().isEmpty()) {
            if (player.currentPlayer == Player.PlayerType.X) {
                tile.setForeground(Color.pink);
            } else {
                tile.setForeground(Color.yellow);
            }

            tile.setText(player.currentPlayer.toString());
            checkClickTile();
        }
    }

    private static void checkClickTile() {
        if (checkWin()) {
            board.label.setText("Player " + player.currentPlayer + " wins!");
            board.disableAllTiles();
        } else if (checkDraw()) {
            board.label.setText("It's a draw!");
        } else {
            player.switchPlayer();
            board.label.setText("Player " + player.currentPlayer + "'s turn");
        }
    }

    private static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            // Check rows and columns
            if (checkLine(board.tiles[i][0], board.tiles[i][1], board.tiles[i][2]) ||
                    checkLine(board.tiles[0][i], board.tiles[1][i], board.tiles[2][i])) {
                return true;
            }
        }
        // Check diagonals
        return checkLine(board.tiles[0][0], board.tiles[1][1], board.tiles[2][2]) ||
                checkLine(board.tiles[0][2], board.tiles[1][1], board.tiles[2][0]);
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.tiles[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;

    }

    private static boolean checkLine(JButton tile1, JButton tile2, JButton tile3) {
        if (tile1.getText().isEmpty() || tile2.getText().isEmpty() || tile3.getText().isEmpty()) {
            return false;
        }
        return tile1.getText().equals(tile2.getText()) && tile1.getText().equals(tile3.getText());
    }
}
