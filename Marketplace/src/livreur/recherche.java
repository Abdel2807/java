package livreur;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

public class recherche {
		public  int  rechercher (String a , int i) {
			String pathfile="src/identificationClient.txt";
			String line=" ";
			int yest=0 ;
			try {
				BufferedReader br= new BufferedReader(new FileReader(pathfile));
				String[] columns = null ;
				while(br.ready()) {
				line=br.readLine();
				columns = line.split(";");
				if(a.equals(columns[i])) {
					yest = 1;
					
				}
				System.out.println(yest);
				br.close();
				}
				
				return yest ;
				
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("File not Found");
			}catch(IOException e) {
				e.printStackTrace();
			}
			return yest ;
		}
}
