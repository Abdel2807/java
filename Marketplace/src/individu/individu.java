package individu;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class individu {

    protected int id;
    public String nom;
    private String prenom;
    private String  age;
    public String numero;
    public String email;
    private String motDePasse;


    public individu(int id, String nom, String prenom, String age, String numero, String email, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.numero = numero;
        this.email = email;
        this.motDePasse = motDePasse;
    }
    public int getId() {
    	return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAge() {
        return age;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public boolean authentification() {
    //String file = "../identificateur.txt";
        String file = "../demo.txt";
    try(BufferedReader br = new BufferedReader(new FileReader(file)))
    {
        String line;
        String[] columns;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            columns = line.split(";");
            if (columns[0].equalsIgnoreCase(String.valueOf(this.id)) && columns[1].equalsIgnoreCase(this.nom) && columns[2].equalsIgnoreCase(this.prenom) && columns[3].equalsIgnoreCase(this.age)&& columns[4].equalsIgnoreCase(this.numero) && columns[5].equals(this.email) && columns[6].equals(this.motDePasse)) {
                    return true;
                }

        }
        return false;
    }
    catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    return false;

}

    private void ajouterDansRegistre(){
        try
        {
            String file = "../demo.txt";
            String newLine = System.getProperty("line.separator");
            String lineToAppend = this.id + ";"+ this.nom + ";" + this.prenom + ";" + this.age + ";" + this.numero + ";" + this.email + ";" + this.motDePasse + newLine;
            byte[] byteArr = lineToAppend.getBytes();
            Files.write(Paths.get(file), byteArr, StandardOpenOption.APPEND);
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void creerCompte(individu individu){
        if(this.authentification()){
            System.out.println("Vous êtes déjà dans le registre ! ");
        }else{
            this.ajouterDansRegistre();
            System.out.println("vous venez d'être inscrit ! Félicitations ! ");
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


public void supprimerIndividu(individu newIndividu) throws IOException {
	
	creerFichier();
	String inputFileName = "h:/Documents/Personne.txt"; 
	String outputFileName = "h:/Documents/newPersonne.txt";
	String lineToRemove =  this.id + ";"+ this.nom + ";" + this.prenom + ";" + this.age + ";" + this.numero + ";" + this.email + ";" + this.motDePasse; 
	
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


// Prends en entrée le produit qu'on veut changer et le nouveau produit
public void modifierMpd(individu individu, individu newIndividu) throws IOException {
	supprimerIndividu(individu);
	creerCompte(newIndividu);
			
}


}
