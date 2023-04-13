import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessFrame implements ActionListener {

    JFrame frame;
    JPanel panelgame, panelnorth, panelwest;
    JLabel lblround;
    Piece[][] matrix;
    char c;
    public static boolean bool = false;
    int row, col;
    int lastrow, lastcol;
    public static boolean round = true;


    public ChessFrame() {
        frame = new JFrame("Шахи");
        panelgame = new JPanel();
        panelnorth = new JPanel();
        panelwest = new JPanel();
        lblround = new JLabel("Черга білих", SwingConstants.CENTER);

        panelgame.setLayout(new GridLayout(8, 8));
        panelnorth.setLayout(new GridLayout(1, 8));
        panelwest.setLayout(new GridLayout(8, 1));

        c = 'a';
        for (int k = 1; k < 9; k++) {
            panelnorth.add(new JLabel(String.valueOf(c), SwingConstants.CENTER));
            panelwest.add(new JLabel(" " + String.valueOf(k) + " ", SwingConstants.CENTER));
            c++;
        }

        frame.setLayout(new BorderLayout());
        frame.add(panelgame, BorderLayout.CENTER);
        frame.add(panelnorth, BorderLayout.NORTH);
        frame.add(panelwest, BorderLayout.WEST);
        frame.add(lblround, BorderLayout.SOUTH);
        matrix = new Piece[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((j + i) % 2 == 0) {
                    matrix[i][j] = new Piece(new JButton(), 's');
                    matrix[i][j].getButton().setBackground(Color.WHITE);
                    matrix[i][j].getButton().addActionListener(this);
                } else {
                    matrix[i][j] = new Piece(new JButton(), 's');
                    matrix[i][j].getButton().setBackground(Color.BLACK);
                    matrix[i][j].getButton().addActionListener(this);
                }
                panelgame.add(matrix[i][j].getButton());
            }
        }


        for (int j = 0; j < 8; j++) {
            matrix[1][j].setPiece('p', false);
            matrix[6][j].setPiece('p', true);
        }


        matrix[0][0].setPiece('r', false);
        matrix[0][1].setPiece('h', false);
        matrix[0][2].setPiece('b', false);
        matrix[0][3].setPiece('q', false);
        matrix[0][4].setPiece('k', false);
        matrix[0][5].setPiece('b', false);
        matrix[0][6].setPiece('h', false);
        matrix[0][7].setPiece('r', false);


        matrix[7][0].setPiece('r', true);
        matrix[7][1].setPiece('h', true);
        matrix[7][2].setPiece('b', true);
        matrix[7][3].setPiece('q', true);
        matrix[7][4].setPiece('k', true);
        matrix[7][5].setPiece('b', true);
        matrix[7][6].setPiece('h', true);
        matrix[7][7].setPiece('r', true);


        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (e.getSource() == matrix[i][j].getButton()) {
                    if (bool) {
                        if (matrix[i][j].getButton().getBackground() == Color.ORANGE) {
                            if (matrix[i][j].getType() == 'k') {

                                matrix[i][j].setPiece(matrix[row][col].getType(), matrix[row][col].isWhite());
                                matrix[row][col].setPiece('s');

                                for (int k = 0; k < 8; k++) {
                                    for (int l = 0; l < 8; l++) {
                                        if ((l + k) % 2 == 0) {
                                            matrix[k][l].getButton().setBackground(Color.WHITE);
                                        } else {
                                            matrix[k][l].getButton().setBackground(Color.BLACK);
                                        }
                                    }
                                }

                                int close = 0;
                                try {
                                    Image img = ImageIO.read(getClass().getResource("Images/VictoryCup.png"));
                                    Image image = img.getScaledInstance(125, 125, Image.SCALE_DEFAULT);
                                    if (round) {
                                        close = JOptionPane.showConfirmDialog(frame, "Білі перемогли!", "Перемога", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, new ImageIcon(image));
                                    } else {
                                        close = JOptionPane.showConfirmDialog(frame, "Чорні перемогли!", "Перемога", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, new ImageIcon(image));
                                    }
                                } catch (Exception ex) {
                                    System.out.println(ex);
                                }
                                if (close == JOptionPane.OK_OPTION || close == JOptionPane.CLOSED_OPTION)
                                    frame.dispose();
                            }

                            matrix[i][j].setPiece(matrix[row][col].getType(), matrix[row][col].isWhite());
                            matrix[row][col].setPiece('s');

                            round = !round;
                            if (round) {
                                lblround.setText("Черга білих");
                            } else {
                                lblround.setText("Черга чорних");
                            }
                            lastrow = i;
                            lastcol = j;

                            bool = false;
                            for (int k = 0; k < 8; k++) {
                                for (int l = 0; l < 8; l++) {
                                    if ((l + k) % 2 == 0) {
                                        matrix[k][l].getButton().setBackground(Color.WHITE);
                                    } else {
                                        matrix[k][l].getButton().setBackground(Color.BLACK);
                                    }
                                }
                            }

                            if (matrix[i][j].isWhite()) {
                                if (matrix[i][j].getType() == 'p' && i == 0) {
                                    ChangePawnFrame frameCP = new ChangePawnFrame(matrix, matrix[i][j].isWhite(), i, j);
                                }
                            } else {
                                if (matrix[i][j].getType() == 'p' && i == 7) {
                                    ChangePawnFrame frameCP = new ChangePawnFrame(matrix, matrix[i][j].isWhite(), i, j);
                                }
                            }

                        } else {
                            if (i == row && j == col) {
                                bool = false;
                                for (int k = 0; k < 8; k++) {
                                    for (int l = 0; l < 8; l++) {
                                        if ((l + k) % 2 == 0) {
                                            matrix[k][l].getButton().setBackground(Color.WHITE);
                                        } else {
                                            matrix[k][l].getButton().setBackground(Color.BLACK);
                                        }
                                    }
                                }
                            }
                            if (matrix[row][col].isWhite() == matrix[lastrow][lastcol].isWhite()) {
                                bool = false;
                            }
                        }
                    }
                    else {
                        switch (matrix[i][j].getType()) {
                            case 's':
                                break;
                            case 'p':
                                matrix[i][j].movementP(matrix, i, j, round);

                                row = i;
                                col = j;
                                bool = true;
                                break;
                            case 'r':
                                matrix[i][j].movementR(matrix, i, j, round);

                                row = i;
                                col = j;
                                bool = true;
                                break;
                            case 'h':
                                matrix[i][j].movementH(matrix, i, j, round);

                                row = i;
                                col = j;
                                bool = true;
                                break;
                            case 'b':
                                matrix[i][j].movementB(matrix, i, j, round);

                                row = i;
                                col = j;
                                bool = true;
                                break;
                            case 'q':
                                matrix[i][j].movementQ(matrix, i, j, round);

                                row = i;
                                col = j;
                                bool = true;
                                break;
                            case 'k':
                                matrix[i][j].movementK(matrix, i, j, round);

                                row = i;
                                col = j;
                                bool = true;
                                break;
                        }
                    }
                }
            }
        }
    }
}