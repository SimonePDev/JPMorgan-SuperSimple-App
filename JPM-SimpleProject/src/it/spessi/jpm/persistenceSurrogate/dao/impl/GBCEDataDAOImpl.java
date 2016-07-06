package it.spessi.jpm.persistenceSurrogate.dao.impl;

import it.spessi.jpm.persistenceSurrogate.dao.ifaces.IGBCEDataDAO;
import it.spessi.jpm.persistenceSurrogate.domain.ifaces.IGBCEStock;
import it.spessi.jpm.persistenceSurrogate.domain.impl.GBCEStockCommon;
import it.spessi.jpm.persistenceSurrogate.domain.impl.GBCEStockPreferred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GBCEDataDAOImpl implements IGBCEDataDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public HashMap<String, IGBCEStock> retrieveAllAsHAshMap() {
		HashMap<String, IGBCEStock> gbceHashMap = new HashMap<String, IGBCEStock>();
		gbceHashMap.put("TEA", new GBCEStockCommon("TEA", 0, 100, (Math.random()*10)/100));
		gbceHashMap.put("POP", new GBCEStockCommon("POP", 8, 100, (Math.random()*10)/100));
		gbceHashMap.put("ALE", new GBCEStockCommon("ALE", 23, 60, (Math.random()*10)/100));
		gbceHashMap.put("GIN", new GBCEStockPreferred("GIN", 8, 100, (Math.random()*10)/100, 2));
		gbceHashMap.put("JOE", new GBCEStockCommon("JOE", 13, 250, (Math.random()*10)/100));
		return gbceHashMap;
	}

	@Override
	public List<IGBCEStock> retrieveAllAsList() {
		List<IGBCEStock> igbceDataList = new ArrayList<IGBCEStock>();
		HashMap<String, IGBCEStock> createHashMap = createHashMap();
		igbceDataList.add(createHashMap.get("TEA"));
		igbceDataList.add(createHashMap.get("POP"));
		igbceDataList.add(createHashMap.get("ALE"));
		igbceDataList.add(createHashMap.get("GIN"));
		igbceDataList.add(createHashMap.get("JOE"));
		return igbceDataList;
	}

	private HashMap<String, IGBCEStock> createHashMap(){
		HashMap<String, IGBCEStock> gbceHashMap = new HashMap<String, IGBCEStock>();
		gbceHashMap.put("TEA", new GBCEStockCommon("TEA", 0, 100, (Math.random()*10)/100));
		gbceHashMap.put("POP", new GBCEStockCommon("POP", 8, 100, (Math.random()*10)/100));
		gbceHashMap.put("ALE", new GBCEStockCommon("ALE", 23, 60, (Math.random()*10)/100));
		gbceHashMap.put("GIN", new GBCEStockPreferred("GIN", 8, 100, (Math.random()*10)/100, 2));
		gbceHashMap.put("JOE", new GBCEStockCommon("JOE", 13, 250, (Math.random()*10)/100));
		return gbceHashMap;
	}
	
}
