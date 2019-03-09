
package yazlab2_sudoku;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;

public class sudokuthread implements Runnable {

	 int sudoku[][];
	 int dizi[][];
    int id;
	int basi,basj;
	 final CountDownLatch latch;
	static int thid=0;
	
	
	public sudokuthread(int sudoku[][],int id,int basi,int basj,CountDownLatch latch) {
		
		this.basi=basi;
		this.basj=basj;
		this.sudoku=new int[9][9];
		this.id=id;
		this.latch=latch;
		this.dizi=new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.dizi[i][j]=sudoku[i][j];
				this.sudoku[i][j]=sudoku[i][j];
			}
	  }
		
	
	}
	

	
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		long startTime = System.nanoTime(); 
	    
		int var=0,onceki=0;
		
		int temp1=9,temp2=9,temp3=basj,temp4=basi,daha_once=0,j=temp3;
		
		
		for(int i=basi;i<temp1;i++)
		{	
			if(i==basi && daha_once==1)
			{
				temp2=basj;
			}
			if(daha_once==1&&i!=basi){
				temp2=9;
			}
			if(daha_once==0&&i==basi){
				temp3=basj;
			}
			
			for( j=temp3;j<temp2;j++)
			{		
				temp3=0;
				
				if(sudoku[i][j]==0 || onceki==1){
					
					int k;
					
		           for(k=1;k<=9;k++)
		           {
		        	   
		        	   
		        	   if(sudoku[i][j]==9)
		        	   {  
		        		   k=10;
		        		   break;
		        	   }
		        	   if(sudoku[i][j]!=0 && k==1)
		        	   {
		        		 
		        		   k=sudoku[i][j]+1;
		        		   
		        	   }
		        	
		        	
		        	   onceki=0;
						
		        	   
		        	   var=0;
		        	   
		        	   for(int m=0;m<9;m++)
		        	   {		        	

		        		   if(sudoku[i][m]==k || sudoku[m][j]==k)
		        		   {
		        		
		        			var=1;
		        			break;
		        		}
		        	   }
		        	   
		        		int bas1=i-i%3,bas2=j-j%3;
			        	
		        		for(int l=bas1;l<bas1+3;l++)
		        		{
		        			for(int n=bas2;n<bas2+3;n++)
		        			{
		        				if(sudoku[l][n]!=0 && n!=j && l!=i)
		        				{
		        			       if(sudoku[l][n]==k)
		        			       {
		        			    	   var=1;
		        			    	   break;
		        			       }
		        				}
		        				
		        			}
		        			
		        			if(var==1)
		        				break;
		        		}
		        		
		        	if(var==0){
		        	
		            	if(thid!=this.id&&thid!=0)
		            		{
		            		return ;
		            		}
		        		sudoku[i][j]=k;
		        		try {
							sudokudeneme.bWriter.write(this.id+ "-" +i + "-"+j+ "-"+k+"-"+thid+"\r\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        		
		        	break;	
		        	}
		        	   
		           }   
		           if(k==10)
		           {
		            
		            do{
		           
		            if(dizi[i][j]==0)
		             {
		            	
		            	if(thid!=this.id&&thid!=0)
		            		{

		            		return ;

		            		}
		            	sudoku[i][j]=0;

		            	try {
							
		            		sudokudeneme.bWriter.write(this.id+ "-" +i + "-"+j+ "-"+0+"-"+thid+"\r\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		         	
		             }
		         if(i==basi && j==basj);
		         else if(i==0&&j==0){
		        	 i=8;
				     j=8;
				    temp1=9; 	
				    daha_once=0;

		         }
		           else if(j==0)
		        	   {
		        		   j=8;
		        		  i--;
		        	   }
		        	   else {
		        		   j=j-1;
		        	   }
		        
		        if(dizi[i][j]==0)
		        {
		        	onceki=1;
		        	  if(i==basi && j==basj){
			        	   i=basi;j=basj-1;
			        	   
			           }
		        	  else if(i==0&&j==0)
		        	  {	 j--;
				     }
			           else if(j==0)
			        	   {
			        		   j=8;
			        		   i--;
			        		  
			        		  
			        	   }
			        	   else {
			        		   j=j-1;
			        	   }
		        	  break;
		        	
		        }
		        
		            } while(dizi[i][j]!=0);
		      
		           }
		           
				}
			}
			
			if(i==8&&j==9)
			{
				i=-1;
				temp1=basi+1;
				daha_once=1;
			}
			
		 
			
			
		}
		thid=this.id;   
	
	    	
		
	
	System.out.println(this.id+". THREAD SUDOKUYU EN ERKEN ÇÖZMÜÞTÜR.");
	
		 
         long endTime = System.nanoTime();
		 long estimatedTime = endTime - startTime;
		 double seconds = (double)estimatedTime/1000000000;
		 System.out.println("SUDOKUYU ÇÖZME SÜRESÝ :"+seconds+" sn");
		 
		
             latch.countDown();
         
		 
		 
	}

	
}

