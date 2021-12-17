import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Tictactoe
{
   static ArrayList<Integer> playerPos=new ArrayList<Integer>();
	static ArrayList<Integer> cpuPos=new ArrayList<Integer>();


	void display(char [][] board)
	{
  for(char row []:board)
		{
		  for(char x:row)
			{
		  System.out.print(x);
		    }
		  System.out.println();
		}
   }
void insertPos(int pos,char board[][],String p)
	{
	char c=' ';
	if(p.equals("player"))
		{
	     c='X';
		 playerPos.add(pos);
	    }
		else if(p.equals("cpu"))
		{
		c='O';
		cpuPos.add(pos);
		}
		switch(pos)
		{
	     case 1:
			 board[0][0]=c;
		 break;
		  case 2:
			 board[0][2]=c;
		 break;
		  case 3:
			 board[0][4]=c;
		 break;
		  case 4:
			 board[2][0]=c;
		 break;
		  case 5:
			 board[2][2]=c;
		 break;
		  case 6:
			 board[2][4]=c;
		 break;
		  case 7:
			 board[4][0]=c;
		 break;
		  case 8:
			 board[4][2]=c;
		 break;
		  case 9:
			 board[4][4]=c;
		 break;
		 default:
			 System.out.println("invaild value");
	    }
	}
   void winnerCond()
	{
        List topRow=Arrays.asList(1,2,3);
	    List midRow=Arrays.asList(4,5,6);
	    List botRow=Arrays.asList(7,8,9);
		List leftCol=Arrays.asList(1,4,7);
	    List mid1Col=Arrays.asList(4,5,8);
	    List rightCol=Arrays.asList(7,6,9);
		List diag1= Arrays.asList(1,5,9);
        List diag2= Arrays.asList(3,5,7);
		ArrayList<List> winCond=new ArrayList<List>();
		winCond.add(topRow);
		winCond.add(midRow);
		winCond.add(botRow);
		winCond.add(leftCol);
        winCond.add(mid1Col);
		winCond.add(rightCol);
		winCond.add(diag1);
		winCond.add(diag2);

		for(List x:winCond)
		{
		  if(playerPos.containsAll(x))
			{
		    System.out.println("player has won!");
			System.exit(0);
		    }
			else if(cpuPos.containsAll(x))
			{
			System.out.println("cpu has won!");
			System.exit(0);
			 }
			 else if((playerPos.size()+cpuPos.size())==9)
			{
			  System.out.println("It is a Draw!");
			  System.exit(0);
			 }
		}
		

	 }
}


class Launch  
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		Tictactoe t=new Tictactoe();
		char board[][]={{' ','|',' ','|',' '},
			            {'-','+','-','+','-'},
		                {' ','|',' ','|',' '},
			            {'-','+','-','+','-'},
		                {' ','|',' ','|',' '},
		
		              };
		
		t.display(board);
       while(true)
		{
      System.out.println("Enter the position between 1-9");
	  int ppos=scan.nextInt();
        
		while(Tictactoe.playerPos.contains(ppos)||Tictactoe.cpuPos.contains(ppos))
			{
		    System.out.println("Please re-enter as the pos is occupied");
			    ppos=scan.nextInt();
		     }
	    t.insertPos(ppos,board,"player");
		t.display(board);
		t.winnerCond();
	
	   Random rand=new Random();
	   int cpos=rand.nextInt(9)+1;
	   while(Tictactoe.playerPos.contains(cpos)||Tictactoe.cpuPos.contains(cpos))
			{
		    System.out.println("Please re-enter as the pos is occupied");
			  cpos=rand.nextInt(9)+1;
		     }
	   t.insertPos(cpos,board,"cpu");
	   t.display(board);
		}
	}
}
