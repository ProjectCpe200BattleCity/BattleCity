import java.util.*;

/**
 * Write a implements of interface iTank here.
 * Created by SatrarinSaejew on 10/19/2016 AD.
 */

public class Tank implements iTank {

    private char tankDirection;

    public Tank(){
        tankDirection = 'l';
    }



    @Override
    public int hp() {
        return 0;
    }

    @Override
    public int addHp() {
        return 0;
    }

    @Override
    public int attack() {
        return 0;
    }


    /*
    public iTank append(int row, int col);
    public int hp();
    public int addHp();                             //add hp when pick up health
    public int attack();                            //attack point
    */

}