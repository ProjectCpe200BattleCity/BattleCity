import java.util.*;
/**
 * Write a description of interface iSnake here.
 * Created by SatrarinSaejew on 10/19/2016 AD.
 */

public interface iTank {

    //public iTank append(int row, int col);
    public iTank hp();
    public iTank addHp();                             //add hp when pick up health
    public iTank attack();                            //attack point
    public iPosition getHead();
    public char getDirection();
    public void setDirection(char dir);

}
