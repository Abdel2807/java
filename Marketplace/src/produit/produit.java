package produit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;


public class produit {
	
	protected String id;
	private String nom;
	private String RefP;
	private String prix;
	private String prixLiv; 
	
	public produit (String nom, String RefP,  String prix, String prixLiv) {
        this.nom = nom;
        this.RefP = RefP;
        this.prix = prix;
        this.prixLiv = prixLiv;
    }
	
	public String getId() {
        return id;
    }
	public String getNom() {
        return nom;
    }
    public String getRefP() {
        return RefP;
    }
    
    public String getPrix() {
        return prix;
    }
    
    public String getPrixLiv() {
        return prixLiv;
    }
 
    public String setId(String id) {
        return this.id = id;
    }
    public String setnom(String nom) {
        return this.nom = nom;
    }
    public String setRefP(String RefP) {
        return this.RefP = RefP;
    }
    
    public String setPrix(String prix) {
        return this.prix = prix;
    }
    
    public String setPrixLiv(String prixLiv) {
        return this.prixLiv = prixLiv;
    }
    
 


	public int estvendu(produit p) {
		String pathfile="h:/Documents/Produit.txt";
		String line;
		try {
			BufferedReader br= new BufferedReader(new FileReader(pathfile));
			String[] columns = null ;
			while ((line=br.readLine())!=null){
                columns = line.split(";");
                if (line.contains(p.RefP)) {
                	return 0;	
                }
            }
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not Found");
		}catch(IOException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	
}

