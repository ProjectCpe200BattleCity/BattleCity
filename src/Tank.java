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
    public iTank hp() {
        return null;
    }

    @Override
    public iTank addHp() {
        return null;
    }

    @Override
    public iTank attack() {
        return null;
    }

    @Override
    public iPosition getHead() {
        return null;
    }

    @Override
    public char getDirection() {
        return tankDirection;
    }

    @Override
    public void setDirection(char dir) {
        tankDirection = dir;
    }

    /*
    public iTank append(int row, int col);
    public int hp();
    public int addHp();                             //add hp when pick up health
    public int attack();                            //attack point
    */

}