package server;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import server.datahandler.DataOperations;
import server.datahandler.DataParser;
import server.machinelearning.MachineLearningAnalysis;
import server.machinelearning.SupportVectorMachine;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is the first message of the PocketMD server");
		//TODO Test the csv reader : 
		DataParser dataparser = new DataParser();
		//System.out.println(dataparser.getVariable("TIM"));
		//TODO Test the SVM classifier :  
		//Getting the data
		List<List<Double>> values = new ArrayList<List<Double>>();
		List<Double> classes = dataparser.getVariable("ISH");
		values.add(dataparser.getVariable("TROMB1"));
		values.add(dataparser.getVariable("TIMEHOSP"));
		
		//The svm itself
		MachineLearningAnalysis mySVMDataCrunching = new SupportVectorMachine();
		mySVMDataCrunching.setTrainingData(DataOperations.listTranspose(values), classes, 500);
		mySVMDataCrunching.train();
		//mySVMDataCrunching.estimate();
	}
}
