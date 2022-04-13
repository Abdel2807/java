package individu;
import produit.produit;
import individu.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.File;
import java.io.*;
import java.nio.file.Files;


public class client extends individu {
	public static  List<client> nosclients = new ArrayList<client>();
	public client(int id, String nom, String prenom, String age, String numero, String email, String motDePasse) {
		super(id, nom, prenom, age, numero, email, motDePasse); 
		nosclients.add(this);
		}
	public String adresse;
	public int notification = 0;
	public static int getId(client c) {
		return c.id ;
	}
	
	public String consulter_produit(produit p) {
		System.out.println (p.getNom());
		System.out.println (p.getPrix());
		System.out.println (p.getPrixLiv());
		System.out.println (p.getRefP());
		return "Voici le porduit";
	}

	
	public int modifierAdresse(client c, String newadress) {
		int n= getId(c);
		String line = "";
		String pathfile="src/identificationClient.txt";
		try {
			FileWriter fw=new FileWriter(pathfile);
			BufferedReader br= new BufferedReader(new FileReader(pathfile));
		String[] columns = null ;
		for(int i=0;i<n ;i++) {
			line=br.readLine();			
		}
		columns = line.split(";");
		fw.write(columns[0]+columns[1]+columns[2]+newadress);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not Found");
			}catch(IOException e) {
			e.printStackTrace();
			}
		
		return 0;
	}
	
	public static void supprimernvadd(client c) throws IOException {
		
		creerFichier();
		String inputFileName = "src/adresse"; 
		String outputFileName = "src/adresse";
		String lineToRemove = c.id + ";" + c.adresse;
		
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
            String lineToAppend = c.id+ newadresse;
            byte[] byteArr = lineToAppend.getBytes();
            Files.write(Paths.get(file), byteArr, StandardOpenOption.APPEND);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
	
	
	public void modifieraddresse(client c, String newadresse) throws IOException {
		supprimernvadd(c);
		ajouternvadd(c,newadresse);
				
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
	
	
	public static void selectionnerProduit(produit p){
		try {
				FileWriter fw=new FileWriter(new File("src/Panier.txt"));
				fw.write(p.getNom());
				fw.flush();
				fw.close();
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

