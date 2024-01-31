package impl;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Delivery;

public interface Deliveryinterface {

	/**
	 * get particular delivery person
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public Delivery getdetail(int id) throws SQLException;
	/**
	 * add delivery person
	 * @param d
	 * @throws SQLException 
	 */
	
	public void adddelivery(Delivery d) throws SQLException;
	/**
	 * all details 
	 * @return ArrayList<Delivery>
	 * @throws SQLException 
	 */
	  
	public ArrayList<Delivery> getdetails() throws SQLException;
	/**
	 *  update details
	 * @param d
	 * @return
	 * @throws SQLException 
	 */
	public boolean updatedetails( Delivery d ) throws SQLException;
	/**
	 * remove
	 * @param id
	 * @throws SQLException 
	 */
	
	public boolean delete(int id) throws SQLException;
}
