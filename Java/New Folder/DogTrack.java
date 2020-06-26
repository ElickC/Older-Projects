public class DogTrack{

   private int trackSize;
   private int fido, spot, rover;
   private int move;

   public DogTrack(int size){
      trackSize = size;
   }
   public void initializeGame(){
      rover = 0;
      spot = 0;
      fido = 0;
      move = 0;
   }
   public void playGame(){
      initializeGame();
      while(!isOver()){
         showTrack();
         moveDogs();
      }
      showTrack();
      showWinners();
   }
   public int spin(){
      return (int)(Math.random()*5)+1;
   }
   public void moveDogs(){
      fido += dogRoll(fido);
      spot += dogRoll(spot);
      rover += dogRoll(rover);
      setMax();
      setMin();
   }
   public boolean isOver(){
      if(rover >= (trackSize-1) || spot >= (trackSize-1) || fido >= (trackSize-1))
         return true;
      else
         return false;
   }
   public void showTrack(){
      for(int i=0; i<4;i++){
         System.out.println();
         for(int j=0; j < trackSize; j++){
            if (i==0 && j == fido) 
              System.out.print("F");
            else if (i==1 && j == spot)
              System.out.print("S");
            else if (i==2 && j == rover)
              System.out.print("R");
            else if (i==3)
              System.out.print("-");
            else
              System.out.print("o");
          }
      }
   }
   public void showWinners(){
      System.out.println();
      if (fido >= (trackSize-1))
         System.out.println("Fido Wins!");
      if (spot >= (trackSize-1))
         System.out.println("Spot Wins!");
      if (rover >= (trackSize-1))
         System.out.println("Rover Wins!");
   }
   public int dogRoll(int dog){
      move = spin();
      if (dog + move == (trackSize/3) || dog + move == (2*trackSize/3))
         move = -1;
      return move;
   }
   public void setMax(){
      if (fido >= trackSize)
         fido = trackSize-1;
      if (spot >= trackSize)
         spot = trackSize-1;
      if (rover >= trackSize)
         rover = trackSize-1;
   }
   public void setMin(){
      if (fido < 0)
         fido = 0;
      if (spot < 0)
         spot = 0;
      if (rover < 0)
         rover = 0;
   }
}