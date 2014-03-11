package rripp.pocketmd.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.javaml.core.Instance;
import net.sf.javaml.core.SparseInstance;

import rripp.pocketmd.server.datahandler.DataOperations;
import rripp.pocketmd.server.datahandler.DataParser;
import rripp.pocketmd.server.datahandler.Serialization;
import rripp.pocketmd.server.machinelearning.MachineLearningAnalysis;
import rripp.pocketmd.server.machinelearning.SupportVectorMachine;

public class ModelBuilder {
	public static MachineLearningAnalysis build(String target, String[] parameters){
		
		//CSV Reading:
		DataParser dataparser = new DataParser();
		//Getting the data
		List<List<Double>> values = new ArrayList<List<Double>>();
		List<Double> classes = dataparser.getVariable(target);
		for (String s : parameters){
			values.add(dataparser.getVariable(s));
		}
		System.out.println("Biulding the model for "+target+" classification from "+ Arrays.toString(parameters));
		//The Support vector machine:
		MachineLearningAnalysis mySVMDataCrunching = new SupportVectorMachine();
		List<Map<Integer, Double>> data = DataOperations.listMapTranspose(values);
		mySVMDataCrunching.setTrainingData(data, classes, 510);
		Object object = mySVMDataCrunching.train();
		
		//perform cross validation to measure performance
		//mySVMDataCrunching.validate();
		//System.out.println("True value: "+dataparser.getVariable(target).get(510));
		//mySVMDataCrunching.estimate(data.get(510));
		
		//Serialization:
		Serialization.serialize(object, target);
		return mySVMDataCrunching;
	}
}
