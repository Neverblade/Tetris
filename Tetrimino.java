/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author James
 */
public class Tetrimino {
    private int x;
    private int y;
    private int dir;
    private int[][] grid;
    private ArrayList<ArrayList<Integer>> xShape;
    private ArrayList<ArrayList<Integer>> yShape;
    
    public Tetrimino(int x, int y, int dir, int[][] grid)
    {
        this.x = x;
        this.y = y;
        this.dir = dir;
	this.grid = grid;
        xShape = new ArrayList<ArrayList<Integer>>();
        yShape = new ArrayList<ArrayList<Integer>>();
    }
	
	/* Logic Methods */
	
	public void updatePos()
	{
            for (int i = 0; i < grid.length; i++)
            {
                for (int j = 0; j < grid[0].length; j++)
                {
                    if (grid[i][j] == -1) grid[i][j] = 0;
                }
            }
            for (int i = 0; i < xShape.get(dir).size(); i++)
            {
                grid[y+yShape.get(dir).get(i)][x+xShape.get(dir).get(i)] = -1;
            }
	}
	
	public void clearCurrentPos()
	{
            for (int i = 0; i < xShape.get(dir).size(); i++)
            {
                grid[y+yShape.get(dir).get(i)][x+xShape.get(dir).get(i)] = 0;
            }		
	}
	
	public boolean moveDirectional(int s)
	{
            clearCurrentPos();
            int[] dX = {1, 0, -1, 0};
            int[] dY = {0, -1, 0, 1};
            boolean c = true;
            for (int i = 0; i < xShape.get(dir).size(); i++)
            {
                int medX = x + xShape.get(dir).get(i) + dX[s];
                int medY = y + yShape.get(dir).get(i) + dY[s];
                if (medX < 0 || medX >= grid[0].length || medY < 0 || medY >= grid.length || grid[medY][medX] != 0)
                {
                    c = false;
                    break;
                }
            }
            if (c)
            {
                this.x += dX[s];
                this.y += dY[s];
            }
            updatePos();
            if (c) return true;
            else return false;
	}
        
        public void moveRotational(int s)
        {
            clearCurrentPos();
            int z = (dir + s) % getXShape().size();
            if (z < 0) z += getXShape().size();
            boolean c = true;
            for (int i = 0; i < xShape.get(z).size(); i++)
            {
                int medX = x + xShape.get(z).get(i);
                int medY = y + yShape.get(z).get(i);
                if (medX < 0 || medX >= grid[0].length || medY < 0 || medY >= grid.length || grid[medY][medX] != 0)
                {
                    c = false;
                    break;
                }
            }
            
            if (c)
            {
                dir = z;
            }
            updatePos();
        }
        
        //turns the live tetrimino to dead blocks to be cleared
        public void convertToBlocks(int z)
        {
            for (int i = 0; i < xShape.get(dir).size(); i++)
            {
                grid[y+yShape.get(dir).get(i)][x+xShape.get(dir).get(i)] = z;
            }	
        }
        
        //hard drop: drop it like it's hot
        public void drop()
        {
            clearCurrentPos();
            lol:
            while (true)
            {
                for (int i = 0; i < xShape.get(dir).size(); i++)
                {
                    int tempY = y + yShape.get(dir).get(i) + 1;
                    int tempX = x + xShape.get(dir).get(i);
                    if (tempY >= grid.length || tempY < 0 || grid[tempY][tempX] != 0)
                    {
                        break lol;
                    }
                }
                y++;
            }
            updatePos();
        }
    
	/* Accessors */
	
    public int getX()
    {
        return this.x;
    }
    
    public int getY()
    {
        return this.y;
    }
    
    public int[][] getGrid()
    {
            return grid;
    }
	
    public ArrayList<ArrayList<Integer>> getXShape()
    {
            return xShape;
    }

    public ArrayList<ArrayList<Integer>> getYShape()
    {
            return yShape;
    }
    
    public int getType()
    {
        if (this instanceof T) return 1;
        else if (this instanceof J) return 2;
        else if (this instanceof Z) return 3;
        else if (this instanceof O) return 4;
        else if (this instanceof S) return 5;
        else if (this instanceof L) return 6;
        else if (this instanceof I) return 7;
        else 
        {
            System.out.println("Something went wrong.");
            return -2;
        }
    }
    
    public int returnType()
    {
        return -2;
    }
}
