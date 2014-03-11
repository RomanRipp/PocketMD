package rripp.pocketmd.server.machinelearning;

import java.util.List;
import java.util.Map;


public interface MachineLearningAnalysis {
	/**
	 * The training data is presented as an 2d array of values followed by known classed 
	 * @param values
	 * @param classes
	 * @param trainingDataSize
	 */
	public void setTrainingData(List<Map<Integer, Double>> values, List<Double> classes, int trainingDataSize);
	
	/**
	 * Supervised training  
	 * @return
	 */
	public Object train();
	/**
	 * the training evaluation step, here we estimate model quality
	 */
	public void validate();
	/**
	 * the evaluation step classifies the new instance using the model built by training stage
	 * @param testData
	 * @return
	 */
	public Object estimate(Map<Integer, Double> testData);
}
