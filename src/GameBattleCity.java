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
    //
    private iTank tank;
    private iGrid grid;
    private Image tankImg_1;
    private Image treeImg_1;
    //private Image tree;

    private boolean isStarted = false;
    private boolean isOver = false;
    private boolean isItemAvailable = false;

    private iPosition itemPosition = null;

    private int speed = 5;                              //tank speed

    private Random random;                              //random drop item



    /**
     * Setup the game: loading image, initialize Tank, update initial tree location
     */
    public void setup()
    {
        window.size(iGrid.GRID_WIDTH * iGrid.GRID_COL, iGrid.GRID_HEIGHT * iGrid.GRID_ROW);
        window.title("Tank");

        tankImg_1 = getImage("Img/Tank_1.png");
        treeImg_1 = getImage("Img/Tree_1.png");


        grid = new Grid();
        tank = new Tank();
        //Tank.append(4,7).append(4,8).append(4,9).append(4,10).append(4,11);

        random = new Random();
        //updateFood();
    }


    /**
     * Handle player's key, update Tank movement, check if hit wall or Tree.
     */
    protected int updateSnake(){

        int status = STATUS_OK;
        iPosition next = null;

        /* where is the head location ? */
        iPosition head = tank.getHead();

        /* Depend on the snake direction, check if hit the wall, set the next location of snake */
        if(tank.getDirection() == 'l') {
            if(head.getCol() == 1) status = STATUS_HIT;
            next = new Position(head.getRow(), head.getCol() - 1);
        } else if(tank.getDirection() == 'r') {
            if(head.getCol() == iGrid.GRID_COL - 2) status = STATUS_HIT;
            next = new Position(head.getRow(), head.getCol() + 1);
        } else if(tank.getDirection() == 'u') {
            if(head.getRow() == 1) status = STATUS_HIT;
            next = new Position(head.getRow() - 1, head.getCol());
        } else if(tank.getDirection() == 'd') {
            if(head.getRow() == iGrid.GRID_ROW - 2) status = STATUS_HIT;
            next = new Position(head.getRow() + 1, head.getCol());
        }

        return status;

    }

    /*
     Update new food location

    protected void updateFood()
    {
        // we should do this only when snake just eat the food
        if(!isFoodAvailable) {
            int food_row, food_col;
            isFoodAvailable = true;
            // we need to make sure that we don't random the food location on the snake body
            while(true) {
                // we also need to avoid the area close to the wall
                food_row = random.nextInt(iGrid.GRID_ROW - 1) + 1;
                food_col = random.nextInt(iGrid.GRID_COL - 1) + 1;
                if(!snake.contains(foodPosition = new Position(food_row, food_col))) {
                    break;
                }
            }
        }
    }

    */

    /*
     * Update the grid data
     */
    protected void updateGrid()
    {
        /* clear the grid */
        grid.resetGrid();

    }

    /**
     * Show the start screen at the beginning of the game
     */
    public void showStartScreen()
    {
        canvas.font("SansSerif", BOLD, 20,  0, 0, 0);
        canvas.putText("Press SPACEBAR to start", 75, 100);
    }

    /**
     * Show the game over screen
     */
    public void showGameOver()
    {
        canvas.font("SansSerif", BOLD, 20, 255, 255, 255);
        canvas.putText("GAME OVER", 150, 100);
        canvas.putText("SCORE=" + (speed - 5), 150, 200);
    }

    /**
     * Draw the screen, all of the function related to the screen has to be inside this method,
     * or called from this method.
     */
    public void draw()
    {
        int status = STATUS_OK;
        framerate(speed);
        if(!isStarted) {
            showStartScreen();
        } else if (!isOver) {
            canvas.clear();
            //status = updateSnake();
            //updateFood();
            updateGrid();
        }
        if(status == STATUS_HIT) {
            isOver = true;
        }
        if(isOver) {
            showGameOver();
        }
    }

    /**
     * Handle keyboard event , always use keyRelease instead of keyPress
     */
    public void onKeyRelease()
    {
        if(keyboard.key() == keyboard.SPACE) {
            isStarted = true;
        }
        if(keyboard.key() == keyboard.I) {
            tank.setDirection('u');
        }
        if(keyboard.key() == keyboard.J) {
            tank.setDirection('l');
        }
        if(keyboard.key() == keyboard.K) {
            tank.setDirection('d');
        }
        if(keyboard.key() == keyboard.L) {
            tank.setDirection('r');
        }
    }

}


