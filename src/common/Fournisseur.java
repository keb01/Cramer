package common;

public class Fournisseur {
	
	public int id;
	public String siret;
	public int idCategorieArticle;
	
	public Fournisseur(int id, String siret, int idCategorieArticle) {
		this.id = id;
		this.siret = siret;
		this.idCategorieArticle = idCategorieArticle;
	}
	
	public Fournisseur(){
		
	}
	
	public String toString() {
		    return this.siret;
	}
	
	
}
