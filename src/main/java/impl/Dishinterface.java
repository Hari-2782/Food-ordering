package impl;

import model.Dishe;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Dishinterface {

	public void adddish(Dishe dish );
	
	public Dishe getdish(int id) throws SQLException;
	public ArrayList<Dishe> getdishes() throws SQLException;
	public Dishe updatedish(int id,Dishe d);
	public void removedishe(int id);
}
