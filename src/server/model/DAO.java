package server.model;


import java.sql.Connection;

public abstract class DAO<T> {
	
	public Connection connect;
	
	/**
	 * Allow to get an object by his ID
	 * @param id
	 * @return
	 */
	public abstract T find(long id);
	
	/**
	 * Allow to create an entry in the database with an object
	 * @param obj
	 */
	public abstract T create(T obj);
	
	/**
	 * Allow to update the data of an entry into the database  
	 * @param obj
	 */
	public abstract T update(T obj);
	
	/**
	 * Allow to delete an entry from the database
	 * @param obj
	 */
	public abstract void delete(T obj);
	
	public void setConnection (Connection c) {
		this.connect = c;
		
	}
	
}
