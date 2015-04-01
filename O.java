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
public class O extends Tetrimino {
    
    public O(int x, int y, int dir, int[][] grid)
    {
        super(x, y, dir, grid);
        
        ArrayList<Integer> oX = new ArrayList<Integer>();
        ArrayList<Integer> oY = new ArrayList<Integer>();
        oX.add(-1);
        oY.add(0);
        oX.add(0);
        oY.add(0);
        oX.add(-1);
        oY.add(1);
        oX.add(0);
        oY.add(1);
        getXShape().add(oX);
        getYShape().add(oY);
        
        updatePos();
    }
    
    public int returnType()
    {
        return 4;
    } 
}