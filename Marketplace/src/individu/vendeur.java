package individu;


import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import produit.Contrat;
import produit.produit;

public class vendeur extends individu{

	public vendeur(int id, String nom, String prenom, String age, String numero, String email, String motDePasse) {
		super(id, nom, prenom, age, numero, email, motDePasse);

	}

	public void signerContrat(Contrat contrat) {
		if(contrat.getType() == false) {
			contrat.setType(true);
		}
	}

	public static void ajouteritems(produit produit) {
        try
        {
            String file = "h:/Documents/Produit.txt";
            String newLine = System.getProperty("line.separator");
            String lineToAppend = produit.getId() + ";"+ produit.getNom() + ";" + produit.getRefP() + ";" + produit.getPrix() + ";" + produit.getPrixLiv() + newLine;
            byte[] byteArr = lineToAppend.getBytes();
            Files.write(Paths.get(file), byteArr, StandardOpenOption.APPEND);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
	
	public static void creerFichier() {
	        try 
	        {
	  
	            File f = new File("h:/Documents/newProduit.txt");
	  
	            if (f.createNewFile())
	                System.out.println("File created");
	            else
	                System.out.println("File already exists");
	        }
	        catch (Exception e) {
	            System.err.println(e);
	        }
	    }
	

	public static void supprimeritems(produit produit) throws IOException {
		
		creerFichier();
		String inputFileName = "h:/Documents/Produit.txt"; 
		String outputFileName = "h:/Documents/newProduit.txt";
		String lineToRemove = produit.getId() + ";"+ produit.getNom() + ";" + produit.getRefP() + ";" + produit.getPrix() + ";" + produit.getPrixLiv();
		
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
		    }
		    	    

		      if(inputFile.delete()){
		       System.out.println(inputFile.getName() + " est supprimé.");
		      }else{
		       System.out.println("Opération de suppression echouée");
		      }
		      
		      boolean renamed = outputFile.renameTo(inputFile);
		       
		      System.out.println("Renamed: "+ renamed);
		      
		}
			catch (IOException ex) {
	   
				ex.printStackTrace();
			}
	}
	
	
	
	public void modifierItems(produit produit, produit newProduit) throws IOException {
		supprimeritems(produit);
		ajouteritems(newProduit);
				
	}
}















