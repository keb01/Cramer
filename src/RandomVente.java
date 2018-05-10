import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

import client.dtoClient.ClientMagasinDAO;
import client.dtoClient.ClientPersonneDAO;
import client.dtoClient.ClientVenteDAO;
import client.dtoClient.Query;

import common.Personne;
import common.Vente;

import server.model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RandomVente {
	
	public static void main (String []args){
		
		Query qManager = new Query();
		ClientPersonneDAO clientPersonneDAO = new ClientPersonneDAO(qManager);
		ClientVenteDAO venteDAO = new ClientVenteDAO(qManager);
		ArrayList<Personne> listClient = clientPersonneDAO.getAllClients(); 
		ArrayList<Vente> listVente= venteDAO.getAllVentesClientX(0);
		
		for (int i =0 ; i< listVente.size()-1; i++) {
		
		Random rand = new Random();
		int randomNum = rand.nextInt(listVente.size()-1) + 1;
		
		listVente.get(i).setId(randomNum);
		
		clientPersonneDAO.update(listVente.get(i));

		   
		    int i = 1;
	        int id = 9;
	        int idVente;
	        int qte;
	        Date date;
	        int produit;
	        int client;
	        int employe;


        while (i <= 100) {
            idVente = id;
            qte = generateRandomInteger(1, 20);
            employe = generateRandomInteger(1,6);
            produit = generateRandomInteger(1,5);
            client = generateRandomInteger(1,5);
            Statement st =null;
    		ResultSet rs =null;
    		
            try {
    			st = this.connect.createStatement();
    			String sql = "insert into Vente (`id`,`ìdArticle`,`idEmploye`,`idClient` `quantite`,`prix`, `dateVente`,`retour`,`ticket`) values (?,?,?,?,?,?,?,?,?)";
    			st.executeUpdate(sql);
    		} catch (SQLException e) {
    			e.printStackTrace();
		
		}
	}



	/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */


	    public static int generateRandomInteger(int min, int max) {
	        if (min >= max) {
	            throw new IllegalArgumentException("min argument must be less than max");
	        }

	        Random rand = new Random();
	        int randomNum = rand.nextInt((max - min) + 1) + min;

	        return randomNum;
	    }

	    public static void generatePurchase() throws SQLException {
	        //List containing all the shops.

	       

	        while (i <= 100) {
	            idVente = id;
	            qte = generateRandomInteger(1, 2);
	            produit = generateRandomInteger(1, 5);
	            client = generateRandomInteger(1, 5);
	            Statement st =null;
	    		ResultSet rs =null;
	    		
	            try {
	    			st = this.connect.createStatement();
	    			String sql = "insert into Vente (`id`,`ìdArticle`,`idEmploye`,`idClient` `quantite`,`prix`, `dateVente`,`retour`,`ticket`) values (?,?,?,?,?,?,?,?,?)";
	    			st.executeUpdate(sql);
	    		} catch (SQLException e) {
	    			e.printStackTrace();
	    		
	            
	            Connection myConn = db.getConnection();
	            st.setInt(1, idVente);
	            st.setInt(2, qte);
	            st.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
	            st.setInt(4, produit);
	            st.setInt(5, client);
	            st.executeUpdate();
	            st.close();
	            //increment the loop
	            id++;
	            i++;
	    		}
	        }
	    }

	    public static void deletePurchase() throws SQLException {
	    	 Statement st =null;
	    	 ResultSet rs =null;
	        Connection myConn = db.getConnection();
	        st = myConn.prepareStatement("delete from Vente");
	        st.executeUpdate();
	        st.close();
	    }


	}


