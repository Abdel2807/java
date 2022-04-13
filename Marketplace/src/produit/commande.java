package produit;
public class commande {
	
	protected int id;
	private int idclient;
	private String adresse;
	private String dateLivraison;
	private double montantLivraison;
	private int nombreProduit;
	private int etat; 
	
	public void commande(int id, int idclient, String adresse, String dateLivraison, double montantLivraison, int nombreProduit, int etat) {
        this.id = id;
        this.idclient = idclient;
        this.adresse = adresse;
        this.dateLivraison = dateLivraison;
        this.montantLivraison = montantLivraison;
        this.nombreProduit = nombreProduit;
        this.etat = etat;
    }
    public int getId() {
    	return id;
    }
    public int getIdclient() {
    	return idclient;
    }

    public String getAdresse() {
        return adresse;
    }
    
    public String getDateLivraison() {
        return dateLivraison;
    }

    public double getMontantLivraison() {
        return montantLivraison;
    }
    
    public int getNombreProduit() {
    	return nombreProduit;
    }
    public int getetat() {
        return etat;
    }
    
    public int setId(int id) {
        return this.id = id;
    }
    public int setIdClient(int idclient) {
        return this.idclient = idclient;
    }
    public String setAdresse(String adresse) {
        return this.adresse = adresse;
    }
    
    public String setDateLivraison(String dateLivraison) {
        return this.dateLivraison = dateLivraison;
    }
    
    public double setMontantLivraison(double montantLivraison) {
        return this.montantLivraison = montantLivraison;
    }
    
    public int setNombreProduit(int nombreProduit) {
        return this.nombreProduit = nombreProduit;
    }
    public int setEtat(int etat) {
        return this.etat = etat;
    }
   

}