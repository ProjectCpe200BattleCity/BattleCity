import ucigame.*;
import java.util.*;


/**
 * Main game class, snake is a simple game. A player controls a snake through keyboard (wasd).
 * The tank will keep moving and the player has to control the tank to avoid hitting the bullet,
 * or itself. When tank take item, it gets some support.
 *
 */
public class GameBattleCity extends Ucigame {
    /* constant */
    private static int STATUS_OK = 0;                   //start with 0, tell that your tank alright
    private static int STATUS_HIT = 1;                  //mean tank hit by bullet

    /* field */
    private iTank tank;
    private iGrid grid;
    private Image tank;
    private Image grit;
    private Image tree;

    private boolean isStarted = false;
    private boolean isOver = false;
    private boolean isItemAvailable = false;

    private iPosition itemPosition = null;

    private int speed = 5;                              //tank speed

    private Random random;                              //random drop item



}