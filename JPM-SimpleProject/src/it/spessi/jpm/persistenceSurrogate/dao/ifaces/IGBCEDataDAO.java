package it.spessi.jpm.persistenceSurrogate.dao.ifaces;

import it.spessi.jpm.persistenceSurrogate.domain.ifaces.IGBCEStock;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public interface IGBCEDataDAO extends Serializable{
	
	public HashMap<String, IGBCEStock> retrieveAllAsHAshMap();
	public List<IGBCEStock> retrieveAllAsList();

}
