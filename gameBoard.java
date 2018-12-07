class gameBoard{
    private int[] pegs = new int [16]; //array that will hold the positions of th board
    gameBoard(){ //default constructor
    }
    gameBoard(gameBoard oldBoard){
        for(int i=0;i<16;i++){
            pegs[i]=oldBoard.getNumofMoves(i);
        }
    }
    void makeBoard(int i){ //makes the game board
        for(int j=0;j<15;j++) {
            if (j==i) { //mark where the peg will be missing
                pegs[j]=0;
            } else //mark all other pegs
                pegs[j]=1;
        }
        pegs[15]=14; //extra array space to keep track of the number of available moves
    }
    int getNumofMoves(int i){
        return pegs[i]; //number of moves a peg has
    }
    void makeMove(moves move){ //moves peg and takes peg that was jumped
        pegs[move.getStart()]=0; //old position set to empty
        pegs[move.getJump()]=0; //position of peg that was jumped is set to empty
        pegs[move.getLand()]=1; //new location is set to full
    }
    int pegsRemaining(){ //counts the number of pegs on the board
        int counter=0;
        for(int i=0;i<15;i++){
            if(pegs[i]==1){ //if the position has a peg increment the counter
                counter++;
            }
        }
        return counter; //return the number of pegs
    }
    private int t, a, b; //objects that will help set up the board

    private void setLevels(int t, int a, int b){
        this.t=t;
        this.a=a;
        this.b=b;
    }
    void printBoard(){
        gameBoard[] levels=new gameBoard[5];

        //allocating memory for the array
        for(int i=0;i<5;i++){
            levels[i]=new gameBoard();
        }
        //sets up print
        levels[0].setLevels(4,0,0);
        levels[1].setLevels(3,1,2);
        levels[2].setLevels(2,3,5);
        levels[3].setLevels(1,6,9);
        levels[4].setLevels(0,10,14);

        for(int i=0;i<5;i++){
            StringBuilder tab=new StringBuilder();
            for(int j=0; j<levels[i].t;j++) {
                tab.append(" ");
            }
            System.out.print(tab);
            for(int j=levels[i].a; j<levels[i].b+1;j++){
                if(pegs[j]==0){
                    System.out.print(". ");
                }
                else{
                    System.out.print("x ");
                }
            }
            System.out.println();
        }
    }
}
