package produit;

public class Contrat {
	protected String id;
	private String numeroContrat;
	private int dureeContrat;
	private String commission;
	private String resiliation; 
	private boolean type;
	
    public Contrat(String id, String numeroContrat, int dureeContrat, String comission, String resiliation, boolean type) {
        this.numeroContrat = numeroContrat;
        this.dureeContrat= dureeContrat;
        this.commission = commission;
        this.resiliation = resiliation;
        this.type = false;
    }
    
    public String getnumeroContrat() {
        return numeroContrat;
    }
    public int getdureeContrat() {
        return dureeContrat;
    }
    
    public String getCommission() {
        return commission;
    }
    
    public String getResiliation() {
        return resiliation;
    }
    public boolean getType() {
        return type;
    }
    public String setnumeroContrat(String numeroContrat) {
        return this.numeroContrat = numeroContrat;
    }
    public int setdureeContrat(int dureeContrat) {
        return this.dureeContrat = dureeContrat;
    }
    
    public String setCommision(String commission) {
        return this.commission = commission;
    }
    
    public String setResiliation(String resiliation) {
        return this.resiliation = resiliation;
    }
    public boolean setType(boolean type) {
        return this.type = type;
    }

}
