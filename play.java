import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class play{
    private static boolean solveBoard(gameBoard gb, moves[] possibleMoves, List<moves> goodMoves){
        int k=gb.getNumofMoves(15);//get number of moves

        if(gb.pegsRemaining()==1){//if a solution has been found the solveBoard is done
            return true;
        }
        else if(k<2||goodMoves.size()>12) {//if there are no more moves but more then one peg than solution has failed
            return false;
        }
        else{
            //try move from current location
            Queue<moves> possible = new LinkedList<>();
            for (int i=0;i<18;i++) {
                if (moves.validMove(gb, possibleMoves[i])) { //if moved works add to queue
                    possible.add(possibleMoves[i]);
                }
                if (moves.validMove(gb, possibleMoves[i].getReverse())) {//if the reverse of the move works add to the queue
                    possible.add(possibleMoves[i].getReverse());
                }
            }
            while(possible.size()!=0){//while there are still possible moves to be made
                moves currentMove=possible.remove();//get next possible move from queue

                gameBoard testBoard=new gameBoard(gb);
                testBoard.makeMove(currentMove);//try move

                if(solveBoard(testBoard, possibleMoves, goodMoves)){
                    goodMoves.add(currentMove);//if move worked add to list
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        gameBoard gb=new gameBoard();
        moves[] possibleMoves=moves.generateMoves(); //get the array of possible moves
        //------------------------
        for(int i=0;i<4;i++) { //change 'i<4' to what you would like to test
        // ------------------------
            gb.makeBoard(i); //generate the board
            List<moves> goodMoves;
            goodMoves=new LinkedList<>(); //make a list of the moves travers
            solveBoard(gb, possibleMoves, goodMoves);//function to solve the boards

            System.out.println("=== "+i+" ===");
            gb.printBoard();
            System.out.println();
            for(int j=0;j<goodMoves.size();j++){//traverses the moves in reverse order
                moves thisMove=goodMoves.get(goodMoves.size()-j-1);
                gb.makeMove(thisMove);//move the pegs 
                gb.printBoard();
                System.out.println();
            }
        }
    }
}
