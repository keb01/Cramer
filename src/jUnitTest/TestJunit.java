package jUnitTest;

import static org.junit.Assert.*;
import org.junit.Test;
import Model.MagasinDAO;
import Model.ArticleDAO;
import Model.BorneDAO;


public class TestJunit {

	@Test
	public void test() {
		MagasinDAO mg = new MagasinDAO();
		assertNotNull((mg.getAllMagasins()).get(0));
		assertEquals(97,mg.getAllMagasins().size());
		//ArrayList<Magasin> liste = new ArrayList<Magasin>();
		assertNotNull((mg.find(1)));
		assertNotNull((mg.getCategorieMagasin()));
		assertEquals(32,mg.getCategorieMagasin().size());
		
		
		ArticleDAO pro = new ArticleDAO();
		//test: product 1 exists 
		assertNotNull((pro.find(1)));
		//test: product 1 exists in shop 1
		assertNotNull((pro.findInMagasin(1,1)));
		
		BorneDAO borne = new BorneDAO();
		assertNotNull((borne.find(1)));
		assertNotNull((borne.findInBorne(3,2)));
	}
	

}
