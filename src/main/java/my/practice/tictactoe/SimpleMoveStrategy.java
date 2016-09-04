package my.practice.tictactoe;

/**
 * Created by kmishra on 8/31/2016.
 */
public class SimpleMoveStrategy implements MoveStrategy
{
    private TicTacToe game;

    public SimpleMoveStrategy(TicTacToe t) {
        game = t ;
    }

    public int move() {
        for(int i = 0; i < TicTacToe.N; i++) {
            for(int j = 0; j < TicTacToe.N; j++) {
                if(game.board[i][j] == 0)
                    return (i * 3 + j + 1);
            }
        }
        return 0;
    }
}
