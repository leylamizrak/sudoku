package yazlab2_sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import java.util.LinkedList;
import java.util.Random;


class MyJPanel1 extends JPanel{

    public MyJPanel1(int boyut){
setPreferredSize(new Dimension(0, boyut));
        
		this.setBackground(new Color(245,245,220));
    }

    int sudoku [][];
    @Override 
    public void paintComponent(Graphics g) { 
        super.paintComponent(g); 
        int x1=70,x2 = 70,y1,y2=10;  
        
       sudoku=new int[9][9];
        
        for(int a=0;a<9;a++)
        {
        	for(int b=0;b<9;b++)
        	{
        		sudoku[a][b]=sudokudeneme.sudoku[a][b];
        	}
        }
     
        
       
        int k,nerede=0;
       for(k=0;k<sudokudeneme.th_1.size();k++){
       
        	sudoku[sudokudeneme.th_1.get(k).satir][sudokudeneme.th_1.get(k).sutun]=sudokudeneme.th_1.get(k).deger;
      
       
		 if(nerede==0) {
		  x1=70;
	      x2=70;
		 }
	      
	      y1=y2;
	  for(int i=1;i<=10;i++)
       {
		  if((i%3)==1)
		  g.setColor(Color.BLUE);
		  else g.setColor(Color.RED);
         g.drawLine(5+x2, y1+10,185+x2,y1+10);
         int temp=x2-10;
         for(int sayac=0;sayac<9;sayac++)
         {
            if(i!=10&&sudoku[i-1][sayac]!=0){
            	if(sudokudeneme.baslangic[0][0]==(i-1)&&sudokudeneme.baslangic[0][1]==sayac) g.setColor(new Color(0,0,255));
            	else if(sudokudeneme.sudoku[i-1][sayac]==0) g.setColor(Color.RED);
            	else if(sudokudeneme.sudoku[i-1][sayac]!=0) g.setColor(Color.BLACK);

            	g.drawString(Integer.toString(sudoku[i-1][sayac]), temp+22 , y1+25);}
         temp+=20;
         }
         if((i%3)==1)
   		  g.setColor(Color.BLUE);
   		  else g.setColor(Color.RED);
         g.drawLine(x1+5,10+y2, x1+5,190+y2);
         
         
       
         x1+=20;
         y1+=20;
         
        
       } 
	   
		  x2=x1;
	   
	   nerede++;
	nerede=nerede%4;
	
	  if(nerede==0){ y2+=195;

	}

	 
	 }
        
    }
        


}

class MyJPanel2 extends JPanel{

    public MyJPanel2(int boyut){
setPreferredSize(new Dimension(0, boyut));
        
		this.setBackground(new Color(245,245,220));
    }
    int sudoku [][];

    @Override 
    public void paintComponent(Graphics g) { 
        super.paintComponent(g); 
        int x1=70,x2 = 70,y1,y2=10;  
        
        sudoku=new int[9][9];
         
         for(int a=0;a<9;a++)
         {
         	for(int b=0;b<9;b++)
         	{
         		sudoku[a][b]=sudokudeneme.sudoku[a][b];
         	}
         }
         
         
         int k,nerede=0;
        for(k=0;k<sudokudeneme.th_2.size();k++){
        
         	sudoku[sudokudeneme.th_2.get(k).satir][sudokudeneme.th_2.get(k).sutun]=sudokudeneme.th_2.get(k).deger;
       
          
        
 		 if(nerede==0) {
 		  x1=70;
 	      x2=70;
 		 }
 	      
 	      y1=y2;
 	  for(int i=1;i<=10;i++)
        {
 		  if((i%3)==1)
 		  g.setColor(Color.BLUE);
 		  else g.setColor(Color.RED);
          g.drawLine(5+x2, y1+10,185+x2,y1+10);
          int temp=x2-10;
          for(int sayac=0;sayac<9;sayac++)
          {

          if(i!=10&&sudoku[i-1][sayac]!=0){
          	if(sudokudeneme.baslangic[1][0]==(i-1)&&sudokudeneme.baslangic[1][1]==sayac) g.setColor(new Color(0,0,255));
          	else  if(sudokudeneme.sudoku[i-1][sayac]==0) {g.setColor(Color.RED);}
        	     else if(sudokudeneme.sudoku[i-1][sayac]!=0) g.setColor(Color.BLACK);
        	  g.drawString(Integer.toString(sudoku[i-1][sayac]), temp+22 , y1+25);}
          temp+=20;
          }
          if((i%3)==1)
       		  g.setColor(Color.BLUE);
       		  else g.setColor(Color.RED);
          g.drawLine(x1+5,10+y2, x1+5,190+y2);
          
          
        
          x1+=20;
          y1+=20;
          
         
        }
 	   
 		  x2=x1;
 	   
 	   nerede++;
 	nerede=nerede%4;
 	
 	  if(nerede==0){ y2+=195;

 	}
 	  
 	 
 	 }
 	  
 	 
         
     }


}

class MyJPanel3 extends JPanel{

    public MyJPanel3(int boyut){
setPreferredSize(new Dimension(0,  boyut));
        
		this.setBackground(new Color(245,245,220));
    	
    }

    int sudoku [][];    
    static int sinir;
    @Override 
    public void paintComponent(Graphics g) { 
        super.paintComponent(g); 
        int x1=70,x2 = 70,y1,y2=10;  
        
        sudoku=new int[9][9];
         
         for(int a=0;a<9;a++)
         {
         	for(int b=0;b<9;b++)
         	{
         		sudoku[a][b]=sudokudeneme.sudoku[a][b];
         	}
         }
         
         int k,nerede=0;
        for(k=0;k<sudokudeneme.th_3.size();k++){
        
         	sudoku[sudokudeneme.th_3.get(k).satir][sudokudeneme.th_3.get(k).sutun]=sudokudeneme.th_3.get(k).deger;
       
          
        
 		 if(nerede==0) {
 		  x1=70;
 	      x2=70;
 		 }
 	      
 	      y1=y2;
 	  for(int i=1;i<=10;i++)
        {
 		  if((i%3)==1)
 		  g.setColor(Color.BLUE);
 		  else g.setColor(Color.RED);
          g.drawLine(5+x2, y1+10,185+x2,y1+10);
          int temp=x2-10;
          for(int sayac=0;sayac<9;sayac++)
          {

          if(i!=10&&sudoku[i-1][sayac]!=0){
            	if(sudokudeneme.baslangic[2][0]==(i-1)&&sudokudeneme.baslangic[2][1]==sayac) g.setColor(new Color(0,0,255));

            	else if(sudokudeneme.sudoku[i-1][sayac]==0) {g.setColor(Color.RED);}
        	     else if(sudokudeneme.sudoku[i-1][sayac]!=0) g.setColor(Color.BLACK);
        	  g.drawString(Integer.toString(sudoku[i-1][sayac]), temp+22 , y1+25);}
          temp+=20;
          }
          if((i%3)==1)
       		  g.setColor(Color.BLUE);
       		  else g.setColor(Color.RED);
          g.drawLine(x1+5,10+y2, x1+5,190+y2);
          
          
        
          x1+=20;
          y1+=20;
          
         
        }
 	  
 	   
 		  x2=x1;
 	   
 	   nerede++;
 	nerede=nerede%4;
 	
 	  if(nerede==0){ y2+=195;

 	}

 	 
 	 }
 	  
    sinir=y2-195;
 	 
 	
         
     }


}

class MyJPanel4 extends JPanel{

	
    public MyJPanel4(int boyut){
    setPreferredSize(new Dimension(0,  boyut));
        
		this.setBackground(new Color(245,245,220));
    }

    
    
    int sudoku [][];

    @Override 
    public void paintComponent(Graphics g) { 
        super.paintComponent(g); 
        int x1=70,x2 = 70,y1,y2=10;  
        
        sudoku=new int[9][9];
         
         for(int a=0;a<9;a++)
         {
         	for(int b=0;b<9;b++)
         	{
         		sudoku[a][b]=sudokudeneme.sudoku[a][b];
         	}
         }
         
         
         int k,nerede=0;
        for(k=0;k<sudokudeneme.th_4.size();k++){
        
         	sudoku[sudokudeneme.th_4.get(k).satir][sudokudeneme.th_4.get(k).sutun]=sudokudeneme.th_4.get(k).deger;
       
          
        
 		 if(nerede==0) {
 		  x1=70;
 	      x2=70;
 		 }
 	      
 	      y1=y2;
 	  for(int i=1;i<=10;i++)
        {
 		  if((i%3)==1)
 		  g.setColor(Color.BLUE);
 		  else g.setColor(Color.RED);
          g.drawLine(5+x2, y1+10,185+x2,y1+10);
          int temp=x2-10;
          for(int sayac=0;sayac<9;sayac++)
          {

          if(i!=10&&sudoku[i-1][sayac]!=0){
            	if(sudokudeneme.baslangic[3][0]==(i-1)&&sudokudeneme.baslangic[3][1]==sayac) g.setColor(new Color(0,0,255));

            	else if(sudokudeneme.sudoku[i-1][sayac]==0) {g.setColor(Color.RED);}
     	     else if(sudokudeneme.sudoku[i-1][sayac]!=0) g.setColor(Color.BLACK);
        	  g.drawString(Integer.toString(sudoku[i-1][sayac]), temp+22 , y1+25);}
          temp+=20;
          }
          if((i%3)==1)
       		  g.setColor(Color.BLUE);
       		  else g.setColor(Color.RED);
          g.drawLine(x1+5,10+y2, x1+5,190+y2);
          
          
        
          x1+=20;
          y1+=20;
          
         
        } 
 	   
 		  x2=x1;
 	   
 	   nerede++;
 	nerede=nerede%4;
 	
 	  if(nerede==0){ y2+=195;

 	}
 	  
 	 
 	 }
 	  
    }
   
    

}




public class sudokudeneme {
	static Thread[] threads;
	static BufferedWriter bWriter; 
	
      
		 static LinkedList<adimlar> th_1;
		 static LinkedList<adimlar> th_2;
		 static LinkedList<adimlar> th_3;
		 static LinkedList<adimlar> th_4;
		       
	 
	 public static void arayuz() throws NumberFormatException, IOException
	 { 
		    
		    
		 
		 
	      
	        th_1=new LinkedList<>();
	        th_2=new LinkedList<>();
	        th_3=new LinkedList<>();
	        th_4=new LinkedList<>();

	        
	        
		        FileReader dosya_oku = null;
				try {
					dosya_oku = new FileReader("adým.txt");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
	 			BufferedReader br = new BufferedReader(dosya_oku);
	 			String s;
	 			while((s = br.readLine()) != null) {
					{String[] parcala = s.split("-");
					if(parcala[4].equals("0")){
		              if(Integer.parseInt(parcala[0])==1)
		              {
		            	  adimlar e=new adimlar(Integer.parseInt(parcala[1]),Integer.parseInt(parcala[2]),Integer.parseInt(parcala[3]));
		            	  th_1.addLast(e);
		              }
		              if(Integer.parseInt(parcala[0])==2)
		              {
		            	  adimlar e=new adimlar(Integer.parseInt(parcala[1]),Integer.parseInt(parcala[2]),Integer.parseInt(parcala[3]));
		            	  th_2.addLast(e);
		              }
		              if(Integer.parseInt(parcala[0])==3)
		              {
		            	  adimlar e=new adimlar(Integer.parseInt(parcala[1]),Integer.parseInt(parcala[2]),Integer.parseInt(parcala[3]));
		            	  th_3.addLast(e);
		              }
		              if(Integer.parseInt(parcala[0])==4)
		              {
		            	  adimlar e=new adimlar(Integer.parseInt(parcala[1]),Integer.parseInt(parcala[2]),Integer.parseInt(parcala[3]));
		            	  th_4.addLast(e);
		              }
		              
					}
					}
	 			}
	        
	 			
	 			    MyJPanel1 panel1=new MyJPanel1((th_1.size()/4+1)*195+20);
	 		        MyJPanel2 panel2=new MyJPanel2((th_2.size()/4+1)*195+20);
	 		        MyJPanel3 panel3=new MyJPanel3((th_3.size()/4+1)*195+20);
	 		        MyJPanel4 panel4=new MyJPanel4((th_4.size()/4+1)*195+20);
	 	            
	 
	       
	        JFrame pencere1=new JFrame();
	        pencere1.setResizable(false); 
	       JScrollPane scroll1 = new JScrollPane(panel1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	       pencere1.add(scroll1);
	       pencere1.setTitle("THREAD-"+(1));
	        pencere1.setBounds(0,0,960,515);
	        pencere1.setVisible(true);
           scroll1.getVerticalScrollBar().setUnitIncrement(195);
	        
	       JFrame pencere2=new JFrame();
	        pencere2.setResizable(false); 
	       JScrollPane scroll2 = new JScrollPane(panel2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	       pencere2.add(scroll2);
	       pencere2.setTitle("THREAD-"+(2));
	       pencere2.setBounds(961,0,960,515);
	       pencere2.setVisible(true);
           scroll2.getVerticalScrollBar().setUnitIncrement(195);

	       
	       JFrame pencere3=new JFrame();
	        pencere3.setResizable(false); 
	       JScrollPane scroll3 = new JScrollPane(panel3,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	       pencere3.add(scroll3);
	     pencere3.setTitle("THREAD-"+(3));
	       pencere3.setBounds(0,521,960,515);
	       pencere3.setVisible(true);
           scroll3.getVerticalScrollBar().setUnitIncrement(195);


	       JFrame pencere4=new JFrame();
	        pencere4.setResizable(false); 
	       JScrollPane scroll4 = new JScrollPane(panel4,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	       pencere4.add(scroll4);
	       pencere4.setTitle("THREAD-"+(4));
	       pencere4.setBounds(961,521,960,515);
	       pencere4.setVisible(true);
           scroll4.getVerticalScrollBar().setUnitIncrement(195);
           
	      
	       pencere4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	 }
	      
	   static int[][]  sudoku;
	   static int[][] baslangic;
	 
	public static void main(String[] args) throws InterruptedException, IOException {
		
          sudoku= new int[9][9];
			char c;
			int [][]dizi=new int[9][9];
			
			 final sudokuthread[] children;
		     
		     final CountDownLatch latch;
		    
		 	FileWriter fileWriter;
		     File file2;
		    file2=new File("adým.txt");
			if (!file2.exists()) {
	            file2.createNewFile();
	        }
			
			fileWriter = new FileWriter(file2, false);
			bWriter = new BufferedWriter(fileWriter);
	        
		     
			try {
				File file = new File("sudoku.txt");
				FileInputStream fis = new FileInputStream(file);

				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						c = (char) fis.read();
						if (c != 13 && c != 10) {
							if (c <= 57 && c >= 49)
								sudoku[i][j] = Character.getNumericValue(c);
							else
								sudoku[i][j] = 0;
						} else
							j--;

					}

				}
				fis.close();
			} catch (FileNotFoundException fnfe) {
			} catch (IOException ioe) {
			}
			System.out.println("           SUDOKU    ");
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.printf("%3d", sudoku[i][j]);
					dizi[i][j]=sudoku[i][j];

				}
				System.out.println();

			}
			
			System.out.println();
			
		int y, z, var = 0;
		for (y = 0; y < 9; y++) {
			for (z = 0; z < 9; z++) {
				if (sudoku[y][z] != 0) {
					var=0;
					for (int m = 0; m < 9; m++) {
                        
						if ((m!=z&&sudoku[y][m] == sudoku[y][z]) || (m!=y&&sudoku[m][z] == sudoku[y][z])) {
							System.out.println("y:"+y+"z:"+z);
								var = 1;
							break;
						}
					}

					int bas1 = y - y % 3, bas2 = z - z % 3;

					for (int l = bas1; l < bas1 + 3; l++) {
						for (int n = bas2; n < bas2 + 3; n++) {
							if (sudoku[l][n] != 0 && n != z && l != y) {
								if (sudoku[l][n] == sudoku[y][z]) {
									var = 1;
									break;
								}
							}

						}

						if (var == 1)
							break;
					}

					if (var == 1) {
						JOptionPane.showMessageDialog(null,  "SUDOKU DEÐERLERÝ HATALIDIR.", "UYARI", JOptionPane.WARNING_MESSAGE);

						System.exit(0);
					}

				}
			}
		}
			
			

   			baslangic=new int[4][2];
   		
   	   
   			Random rand = new Random();

   			int  i,j,elemansayisi=0;
   			 var=0;
   			while(elemansayisi!=4){
                var=0;
   				i = rand.nextInt(9);
   				j= rand.nextInt(9);
   				
                for(int k=0;k<elemansayisi;k++)
                {
                	if((baslangic[k][0]==i&&baslangic[k][1]==j)||sudoku[i][j]!=0)
                	{
                		var=1;
                		break;
                	}
                	
                }
   				
                if(var==0){
                   baslangic[elemansayisi][0]=i;
                   baslangic[elemansayisi][1]=j;
                   elemansayisi++;
                }
                
                
   			}
   			System.out.println("BAÞLANGIÇ DEÐERLERÝ");
			
			for(i=0;i<4;i++)
			{
					System.out.print((i+1)+". THREAD: "+baslangic[i][0]+" "+baslangic[i][1]);
				
				System.out.println();
			}
               
			System.out.println();
			    children = new sudokuthread[4];
		        latch = new CountDownLatch(1);
		        children[0] = new sudokuthread(sudoku,1,baslangic[0][0],baslangic[0][1],latch);
		        children[1] = new sudokuthread(sudoku,2,baslangic[1][0],baslangic[1][1],latch);
		        children[2] = new sudokuthread(sudoku,3,baslangic[2][0],baslangic[2][1],latch);
		        children[3] = new sudokuthread(sudoku,4,baslangic[3][0],baslangic[3][1],latch);

		        
		        threads = new Thread[children.length];

		        for ( i = 0; i < threads.length; i++) {
		            sudokuthread child = children[i];
		            threads[i] = new Thread(child);
		            threads[i].start();
		        }
		        
		        try {
		            latch.await();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        
		        
		        try {
					bWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
              
		        arayuz();
		        
	}

	
}