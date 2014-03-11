package rripp.pocketmd.server.datahandler;

import rripp.pocketmd.server.resources.DataHandlerResourses;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import au.com.bytecode.opencsv.CSVReader;

public class DataParser {
	private final Logger LOGGER;
	private String dataFileName;
	private final Map<String, Integer> variables;
	private List<String[]> rawData;
	DataHandlerResourses dataHandlerResources;
	
	public DataParser(){
		LOGGER = Logger.getLogger(DataParser.class.getName());
		
		dataHandlerResources = new DataHandlerResourses();
		variables = new HashMap<String, Integer>();
		dataFileName = dataHandlerResources.getString("dataFilePath");
		
		//Construct path to the data file: 
		dataFileName = dataHandlerResources.getString("dataFilePath");
		dataFileName +="/";
		dataFileName += dataHandlerResources.getString("dataFileName");

		//LOGGER.info("Retirieving raw data from the CSV file :" + " " + dataFileName);
		
		try {
			//open file for reading 
			CSVReader reader = new CSVReader(new FileReader(dataFileName));
			String[] head = reader.readNext();
			//read variable names 
			int i = 0; 
			for (String v : head){
				variables.put(v, i++);				
			}
			//read the numeric raw data
			rawData = reader.readAll();
			if (rawData.isEmpty()){
				LOGGER.severe("The file was opened but not read");
			}
		} catch (IOException e) {
			LOGGER.severe("Failed to read from data file");
			e.printStackTrace();
		} 
	}  
	
	/**
	 * return the list of variables and its ID's
	 * @return
	 */
	public Map<String, Integer> getVariables() {
		return variables;
	};
	
	/**
	 * get the list of parameter's values
	 * @param key - the parameter label
	 * @return
	 */
	public ArrayList<Double> getVariable(String key) {
		//LOGGER.info("Retrieving the variable " + key + " from a data file");
		int parameterID = 1;
		if (variables.containsKey(key)) {
			parameterID = variables.get(key);
		} else {
			LOGGER.severe("The requested variable name is not found in the data file");
		}
		List<Double> paremeter = new ArrayList<Double>();
		for (String[] r : rawData){
			String cell = r[parameterID]; 
			if (!cell.isEmpty()){
				try {
					paremeter.add(Double.parseDouble(r[parameterID]));
				} catch (NumberFormatException e) {
					LOGGER.severe("The unexpected format, check the data table!");
				} 
			} else {
				//TODO find out how to represent missing values
				paremeter.add(null);
			}
		}
		return (ArrayList<Double>) paremeter; 
	};
}
