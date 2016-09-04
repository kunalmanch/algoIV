package my.practice.tictactoe;

/**
 * Created by kmishra on 8/31/2016.
 */
public class Player {
    private String name ;
    private int player_type ;
    private int player_order ;
    private MoveStrategy move_strategy ;

    public Player(String pname, int type, int order, MoveStrategy move_s) {
        name = pname ;
        player_type = type ;
        player_order = order ;
        move_strategy = move_s ;
    }

    public String getName() {
        return name ;
    }

    public int getPlayerType() {
        return player_type ;
    }

    public int getMove() {
        return move_strategy.move();
    }
}