/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.SwingWorker;

/**
 *
 * @author James
 */
public class Tetris {
	private static int[][] grid = new int[24][10];
	private static Tetrimino piece;
        private static Board board;
        private static GameFrame frame;
        private static boolean allowInput;
        private static long targetTime;
        private static int level;
        private static int linesCleared;
        private static int targetLines;
        private static int score;
        private static boolean paused = false;
        private static boolean isRunning = false;
	
        private static int[] scoreGuide = {0, 40, 100, 300, 1200, 9001};
        private static int[] timeDelayGuide = {799, 715, 632, 549, 466, 383, 300, 216, 133, 100, 83, 83, 83, 67, 67, 67, 50, 50, 50, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 17};
        
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        board = new Board(grid, piece);
        frame = new GameFrame(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(300, 440));
        frame.validate();
        frame.setVisible(true);
        
        //set variables
        level = 0;
        linesCleared = 0;
        targetLines = (level+1) * 10;
        score = 0;
        updateLabels();
        
        board.setFocusable(true);
        board.requestFocusInWindow();
        board.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                if (allowInput)
                {
                    int input = e.getKeyCode();
                    if (input == KeyEvent.VK_RIGHT)
                    {
                        piece.moveDirectional(0);
                    }
                    else if (input == KeyEvent.VK_LEFT)
                    {
                        piece.moveDirectional(2);
                    }
                    else if (input == KeyEvent.VK_DOWN)
                    {
                        boolean c = piece.moveDirectional(3);
                        if (c)
                        {
                            int timeDelay;
                            if (level > 29) timeDelay = timeDelayGuide[29];
                            else timeDelay = timeDelayGuide[level];
                            targetTime = System.currentTimeMillis() + timeDelay;
                        }
                    }
                    else if (input == KeyEvent.VK_X || input == KeyEvent.VK_UP)
                    {
                        piece.moveRotational(1);
                    }
                    else if (input == KeyEvent.VK_Z)
                    {
                        piece.moveRotational(-1);
                    }
                    else if (input == KeyEvent.VK_SPACE)
                    {
                        piece.drop();
                        targetTime = 0;
                    }
                    else if (input == KeyEvent.VK_P && isRunning)
                    {
                        if (paused)
                        {
                            paused = false;
                            frame.getProgressLabel().setText("Have fun!");
                        } else
                        {
                            paused = true;
                            frame.getProgressLabel().setText("Paused.");
                        }
                    }
                    
                    board.setPiece(piece);
                    board.update();
                    frame.repaint();
                }
            }
        });
        
        GameLoopWorker gameLoop = new GameLoopWorker();
        gameLoop.execute();
    }
    
    public static class GameLoopWorker extends SwingWorker<Void, Void>
    {
        protected Void doInBackground() throws Exception
        {
            isRunning = true;
            lol:
            while (true)
            {
                if (!paused)
                {
                    //check the grid for loss status
                    for (int i = 0; i < 4; i++)
                    {
                        for (int j = 0; j < grid[0].length; j++)
                        {
                            if (grid[i][j] > 0)
                            {
                                return null;
                            }
                        }
                    }

                    //if we need a piece, spawn a random one
                    if (piece == null)
                    {
                        piece = createTetrimino();
                    }

                    //sleep for a bit
                    allowInput = true;
                    int timeDelay;
                    if (level > 29) timeDelay = timeDelayGuide[29];
                    else timeDelay = timeDelayGuide[level];
                    targetTime = System.currentTimeMillis() + timeDelay;
                    while (System.currentTimeMillis() < targetTime)
                    {
                        Thread.sleep(10);
                    }
                    if (paused) continue;
                    allowInput = false;
                    
                    //attempt to move down
                    boolean c = piece.moveDirectional(3);
                    if (!c)
                    {
                        //give the user a bit of extra time
                        /*allowInput = true;
                        targetTime = System.currentTimeMillis() + 250;
                        while (System.currentTimeMillis() < targetTime)
                        {
                            Thread.sleep(10);
                        }
                        allowInput = false;*/

                        //turn it into blocks
                        piece.convertToBlocks(piece.getType());
                        piece = null;

                        //check for filled lines, remove them and shift everything down
                        int combo = board.clearLine();

                        //update variables
                        linesCleared += combo;
                        if (linesCleared >= targetLines)
                        {
                            level++;
                            targetLines = (level+1)*10;
                        }
                        score += (level+1)*scoreGuide[combo];
                        updateLabels();
                    }

                    //update the board
                    board.setPiece(piece);
                    board.update();
                    frame.repaint();
            }
            }
        }
        
        protected void done()
        {
            isRunning = false;
            board.clear();
            frame.getProgressLabel().setText("You lose.");
            frame.repaint();
        }
    }
    
    public static void updateLabels()
    {
    frame.getLevelLabel().setText("Level: " + level);
    String med = "" + score;
    while (med.length() < 6)
    {
        med = "0" + med;
    }
    frame.getScoreLabel().setText("Score: " + med);        
    }
    
    public static Tetrimino createTetrimino()
    {
        Random r = new Random();
        int med = r.nextInt(7) + 1;
        if (med == 1) return new T(4, 2, 2, grid);
        else if (med == 2) return new J(4, 3, 0, grid);
        else if (med == 3) return new Z(4, 2, 0, grid);
        else if (med == 4) return new O(4, 2, 0, grid);
        else if (med == 5) return new S(4, 2, 0, grid);
        else if (med == 6) return new L(4, 2, 1, grid);
        else return new I(5, 2, 1, grid);
    }
  
    public static void print()
    {
        for (int i = 4; i < grid.length; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if (grid[i][j] == 0) System.out.print("-");
                else if (grid[i][j] == -1) System.out.print("#");
                else System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
