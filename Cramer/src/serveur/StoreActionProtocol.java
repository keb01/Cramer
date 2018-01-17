package serveur;



public interface StoreActionProtocol {
	// envoyer les informations du magasin qui se connecte
	default void sendStoreDetail(){}
	
	// envoyer la liste des produits du magasin
	default void sendProductList(){}
	
	// envoyer les détails pour un produit
	default void sendProductDetail(int idProduct){}
	
	// ajouter un produit dans le stock
	default void addProduct(String name, int quantity, String description){}
	
	// modifier un produit
	default void modifyProduct(String name, int quantity, String description){}
	
	
	
	default void sendQuit(){}
	
}
