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
public class I extends Tetrimino {
    
    public I(int x, int y, int dir, int[][] grid)
    {
        super(x, y, dir, grid);
        
        //add Iv
        ArrayList<Integer> ivX = new ArrayList<Integer>();
        ArrayList<Integer> ivY = new ArrayList<Integer>();
        ivX.add(0);
        ivY.add(-1);
        ivX.add(0);
        ivY.add(-1);
        ivX.add(0);
        ivY.add(0);
        ivX.add(0);
        ivY.add(1);
        getXShape().add(ivX);
        getYShape().add(ivY);

        //add Ih
        ArrayList<Integer> ihX = new ArrayList<Integer>();
        ArrayList<Integer> ihY = new ArrayList<Integer>();
        ihX.add(-2);
        ihY.add(0);
        ihX.add(-1);
        ihY.add(0);
        ihX.add(0);
        ihY.add(0);
        ihX.add(1);
        ihY.add(0);
        getXShape().add(ihX);
        getYShape().add(ihY);
        
        updatePos();
    }
    
    public int returnType()
    {
        return 7;
    }
}