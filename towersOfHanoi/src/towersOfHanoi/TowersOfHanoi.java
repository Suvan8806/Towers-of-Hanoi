package towersOfHanoi;

import java.util.*;
@SuppressWarnings("unchecked")
public class TowersOfHanoi{
  private Stack<Integer>[] towers = new Stack[3];
	private int numDisks;
    public TowersOfHanoi(){
      
    }
    public TowersOfHanoi(int numDisks) {
      //Initialize important stuff
       towers[0] = new Stack<Integer>();
       towers[1] = new Stack<Integer>();
       towers[2] = new Stack<Integer>();
       this.numDisks = numDisks;
       
      //add disks to the first stack
    	for (int i = numDisks; i >= 1;i--) {
    		towers[0].push(i);
    	}


      //check if numDisks is even or odd & call the move method in the right order
    	int i = 0;
    	int count = 0;
    	display();
    	while (i < (Math.pow(2,numDisks)-1)) {
    		//display();
    		i++;
    		
    		
			int a,b,c;
			a = !towers[0].isEmpty() ? towers[0].peek(): 99999;
			b = !towers[1].isEmpty() ? towers[1].peek(): 99999;
			c = !towers[2].isEmpty() ? towers[2].peek(): 99999;
			
			
			if (numDisks%2 == 0) {
	    		// even
				if (count == 0) {
					move(0,1);
				} else if (count == 1) {
					move(0,2);
				} else if (count == 2) {
					move(1,2);
					count = -1;
				}
				count++;

				

	    	} else {
	    		// odd
	    		if (count == 0) {
					move(0,2);
				} else if (count == 1) {
					move(0,1);
				} else if (count == 2) {
					move(1,2);
					count = -1;
				}
	    		count++;
	    		

		
    	}
    	
      // loop here to run the needed amount of times (2^n -1)
    	} 
    }
    
    public void move(int f, int t) {
      int a,b;
      if(towers[f].isEmpty()) {
    	  a = -1;
      } else {
    	  a = towers[f].peek();
      }
      
      if(towers[t].isEmpty()) {
    	  b = -1;
      } else {
    	  b = towers[t].peek();
      }
      
      if(a == -1) {
    	  towers[f].push(towers[t].pop());
      } else if(b == -1) {
    	  towers[t].push(towers[f].pop());
      } else if(a < b) {
    	  towers[t].push(towers[f].pop());
      } else if(a > b) {
    	  towers[f].push(towers[t].pop());
      }
    	
      
      display();
    }
    
    public void display() {
      System.out.println("  A  |  B  |  C  ");
      System.out.println("-----------------");
      for(int i = numDisks; i >= 0; i--) {
        String t1 = " ", t2 = " ", t3 = " ";
        
        try {
          t1 = String.valueOf(towers[0].get(i));
        } catch (Exception e) {}
        try {
          t2 = String.valueOf(towers[1].get(i));
        } catch (Exception e) {}
        try {
          t3 = String.valueOf(towers[2].get(i));
        } catch (Exception e) {}
           
        System.out.println("  " + t1 + "  |  " + t2 + "  |  " + t3);
      } 
      System.out.println();
    }
}
