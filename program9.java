package practices.oop;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class program9 {

	public static void main(String[] args) throws IOException {
		String filepath="C:\\Users\\Dell\\eclipse-workspace\\practices\\src\\practices\\oop\\data.csv";
		
			FileReader fr= new FileReader(filepath);
			Scanner sc = new Scanner(fr);
			int c,i=1;
			double cta,see,credits,best;
			double totmarks,sgp=0,cgp=0,gradepoint,cgpa,sgpa,totcredits=0;
			String grade;
			
			System.out.println("\n----------------SDMCET GRADE CARD-------------------\n\n");
			
			
			while(sc.hasNextLine()) {
				System.out.println("\nSEMESTER "+i);
				int k=1;
				for(int j=1;j<=8;j++) {
					if(i==8) {
						i=1;
					}
					
				
				String line = sc.nextLine();
				String []col=line.split(",");
				
				best = Double.parseDouble(col[5]);
				cta = Double.parseDouble(col[6]);
				see = Double.parseDouble(col[7]);
				credits = Double.parseDouble(col[8]);
				
				totmarks=best+cta+(see/2);
				
				
				totcredits=totcredits+credits;
				
				if(totmarks>=90) {
					gradepoint=10;
					grade = "S";
				}
				else if(totmarks>=80) {
					gradepoint=9;
					grade = "A";
				}
				else if(totmarks>=70) {
					gradepoint=8;
					grade = "B";
				}
				else if(totmarks>=60) {
					gradepoint=7;
					grade = "C";
				}
				else if(totmarks>=50) {
					gradepoint=6;
					grade = "D";
				}
				else if(totmarks>=40) {
					gradepoint=4;
					grade = "E";
				}
				else {
					gradepoint=0;
					grade = "F";
				}
				
				System.out.println("Subject marks" +k +" "+   totmarks+"   "+grade);
				i++;
				
				sgp=sgp+(credits*gradepoint);
				
				if(gradepoint>=4) {
				cgp=cgp+(credits*gradepoint);
				}	
			}
		
			sgpa=sgp/totcredits;
			cgpa=cgp/totcredits;
			
			System.out.println("\nTHE SGPA OF THE STUDENT IS : "+sgpa );
			System.out.println("\nTHE CGPA OF THE STUDENT IS : "+cgpa+"\n" );
			
			}
			sc.close();
		} 
	
}
