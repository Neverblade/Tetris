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
public class L extends Tetrimino {
    
    public L(int x, int y, int dir, int[][] grid)
    {
        super(x, y, dir, grid);
        
        ArrayList<Integer> lrX = new ArrayList<Integer>();
        ArrayList<Integer> lrY = new ArrayList<Integer>();
        lrX.add(0);
        lrY.add(-1);
        lrX.add(0);
        lrY.add(0);
        lrX.add(0);
        lrY.add(1);
        lrX.add(1);
        lrY.add(1);
        getXShape().add(lrX);
        getYShape().add(lrY);
        
        ArrayList<Integer> ldX = new ArrayList<Integer>();
        ArrayList<Integer> ldY = new ArrayList<Integer>();
        ldX.add(-1);
        ldY.add(0);
        ldX.add(0);
        ldY.add(0);
        ldX.add(1);
        ldY.add(0);
        ldX.add(-1);
        ldY.add(1);
        getXShape().add(ldX);
        getYShape().add(ldY);
        
        ArrayList<Integer> llX = new ArrayList<Integer>();
        ArrayList<Integer> llY = new ArrayList<Integer>();
        llX.add(-1);
        llY.add(-1);
        llX.add(0);
        llY.add(-1);
        llX.add(0);
        llY.add(0);
        llX.add(0);
        llY.add(1);
        getXShape().add(llX);
        getYShape().add(llY);
        
        ArrayList<Integer> luX = new ArrayList<Integer>();
        ArrayList<Integer> luY = new ArrayList<Integer>();
        luX.add(1);
        luY.add(-1);
        luX.add(-1);
        luY.add(0);
        luX.add(0);
        luY.add(0);
        luX.add(1);
        luY.add(0);
        getXShape().add(luX);
        getYShape().add(luY);
        
        updatePos();
    }
    
    public int returnType()
    {
        return 6;
    }    
}