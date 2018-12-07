class moves{
   private int start, jump, land; //declaring moves objects

    private moves(){ //default constructor
    }
    private moves(int start,int jump,int land) {
        this.start=start;
        this.jump=jump;
        this.land=land;
    }
   private void setMoves(int start,int jump,int land){
       this.start = start;
       this.jump = jump;
       this.land = land;
   }
   static moves[] generateMoves(){
       moves[] possibleMoves=new moves[18]; //array that will act as a dictionary to store the moves
        // allocating memory for the array
       for(int i=0;i<18;i++){
           possibleMoves[i]=new moves();
       }
        //all possible moves
       possibleMoves[0].setMoves(0,1,3);
       possibleMoves[1].setMoves(0,2,5);
       possibleMoves[2].setMoves(1,3,6);
       possibleMoves[3].setMoves(1,4,8);
       possibleMoves[4].setMoves(2,4,7);
       possibleMoves[5].setMoves(2,5,9);
       possibleMoves[6].setMoves(3,6,10);
       possibleMoves[7].setMoves(3,7,12);
       possibleMoves[8].setMoves(4,7,11);
       possibleMoves[9].setMoves(4,8,13);
       possibleMoves[10].setMoves(5,8,12);
       possibleMoves[11].setMoves(5,9,14);
       possibleMoves[12].setMoves(3,4,5);
       possibleMoves[13].setMoves(6,7,8);
       possibleMoves[14].setMoves(7,8,9);
       possibleMoves[15].setMoves(10,11,12);
       possibleMoves[16].setMoves(11,12,13);
       possibleMoves[17].setMoves(12,13,14);

       return possibleMoves;
   }
    moves getReverse(){
        return new moves(this.land, this.jump, this.start);
    }
    static boolean validMove(gameBoard gb, moves m){ //check if a move is valid
        int s=m.start,j=m.jump,l=m.land;
        return(gb.getNumofMoves(s)==1 && gb.getNumofMoves(j)==1 && gb.getNumofMoves(l)== 0);
    }
    int getStart(){
        return start;
    }
    int getJump(){
        return jump;
    }
    int getLand(){
        return land;
    }
}