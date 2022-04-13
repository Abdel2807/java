import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import produit.produit;
import individu.client;

public class main {
	public static void main(String[] args) {
		produit p1 = new produit ("ALB-28","CF006","20","30");
		produit p2 = new produit ("des","CF006","20","30");
		client c = new client (2,"testnom","testprenom","22","0606060606","testemail","testmdp");
		selectionnerProduit(p1);
		selectionnerProduit(p2);
		modifierAdresse(c,"14 rue de la reussite");
		}
	
public static void supprimernvadd(client c) throws IOException {
		
		String inputFileName = "src/adresse"; 
		String outputFileName = "src/adresse";
		String lineToRemove = c.getId() + ";" + c.adresse;
		
		try {
		    File inputFile = new File(inputFileName);
		    File outputFile = new File(outputFileName);
		    
		    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
		       
		        String line = null;
		        while ((line = reader.readLine()) != null) {
		            if (!line.equals(lineToRemove)) {
		                writer.write(line);
		                writer.newLine();
		            }
		        }
		      
		      boolean renamed = outputFile.renameTo(inputFile);
		       
		      System.out.println("Renamed: "+ renamed);
		      
		}
			catch (IOException ex) {
	   
				ex.printStackTrace();
			}
		    }
		finally {}
	}
	public static void ajouternvadd(client c, String newadresse) {
        try
        {
            String file = "src/adresse";
            String newLine = System.getProperty("line.separator");
            String lineToAppend = c.getId() + newadresse;
            byte[] byteArr = lineToAppend.getBytes();
            Files.write(Paths.get(file), byteArr, StandardOpenOption.APPEND);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
	
	
	public static void modifierAdresse(client c, String newadresse) {
		try {
		supprimernvadd(c);
		ajouternvadd(c,newadresse);
				
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
		System.out.println("File not Found");
		}
	catch(IOException e) {
		e.printStackTrace();
		}
	}

	public static void selectionnerProduit(produit p){
	try {
			String pathfile="src/Panier.txt";
			FileWriter fw=new FileWriter(pathfile, true);
			BufferedWriter br= new BufferedWriter(fw);
			br.newLine();
			br.write(p.getNom());
			br.close();
		}
	catch(FileNotFoundException e) {
		e.printStackTrace();
		System.out.println("File not Found");
		}
	catch(IOException e) {
		e.printStackTrace();
		}
	}
}
	
