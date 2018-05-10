package client.dtoClient;

import common.Article;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.codehaus.jackson.map.ObjectMapper;

import common.Fournisseur;
import common.Magasin;
import common.Personne;

public class ClientArticleDTO extends ClientDAO<Article> {
	private Query queryManager;
    
    public ClientArticleDTO(Query q) {
		this.queryManager = q;		
	}

	@Override
	public Article find(long id) {
		return null;
	}

	@Override
	public Article create(Article obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article update(Article obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Article obj) {
		// TODO Auto-generated method stub
		
	}
    
	public ArrayList<Article> getAllArticles(long fournisseurid) {
		
		queryManager.setQueryType("LIST");
		queryManager.setTable("ARTICLEFOURNISSEUR");
		queryManager.setParam("{\"idFournisseur\":"+fournisseurid+"}");
		String answer = queryManager.executeQuery();
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Article> listArticles = new ArrayList<>();
		
		try {
			Article[] tab = objectMapper.readValue(answer, Article[].class);
			listArticles = new ArrayList<>(Arrays.asList(tab));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return listArticles;
		
	}
	
	public ArrayList<Article> getAllArticlesOfMagasin(long idMagasin) {
		
		queryManager.setQueryType("LIST");
		queryManager.setTable("ARTICLEMAGASIN");
		queryManager.setParam("{\"idMagasin\":"+idMagasin+"}");
		String answer = queryManager.executeQuery();
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Article> listArticles = new ArrayList<>();
		
		try {
			Article[] tab = objectMapper.readValue(answer, Article[].class);
			listArticles = new ArrayList<>(Arrays.asList(tab));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return listArticles;
		
	}
}