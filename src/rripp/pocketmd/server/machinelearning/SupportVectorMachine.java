package rripp.pocketmd.server.machinelearning;

import java.util.List;
import java.util.Map;

import libsvm.LibSVM;
import libsvm.svm_parameter;

import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.evaluation.CrossValidation;
import net.sf.javaml.classification.evaluation.PerformanceMeasure;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.core.SparseInstance;

public class SupportVectorMachine implements MachineLearningAnalysis {

	private Classifier svm;
	private Dataset trainingData;
	
	@Override
	public void setTrainingData(List<Map<Integer, Double>> values, List<Double> classes, int trainingDataSize) {
		// TODO Auto-generated method stub
        /* get a data set */
		trainingData = new DefaultDataset();
		//generate the data from instances
		for (int instanceIndex = 0; instanceIndex < trainingDataSize; instanceIndex++) {
			Instance instance = new SparseInstance(values.get(instanceIndex).size());
			instance.putAll(values.get(instanceIndex));
			instance.setClassValue(classes.get(instanceIndex));
			trainingData.add(instance);
		}
		//System.out.println("The training data: "+trainingData);
	}
		
	@Override
	public Object train() {
		// Training phase
        //svm = new SelfOptimizingLinearLibSVM();
		//((SelfOptimizingLinearLibSVM) svm).setFolds(5);
				
		svm = new LibSVM();
		svm_parameter param = ((LibSVM) svm).getParameters();
		param.probability = 1;
		//param.kernel_type = svm_parameter.LINEAR;
		((LibSVM) svm).setParameters(param);
        svm.buildClassifier(trainingData);
        return svm;
	}

	@Override
	public void validate() {
		//The performance measurement
		CrossValidation cv = new CrossValidation(svm);
		Map<Object, PerformanceMeasure> measure = cv.crossValidation(trainingData,5);
		double p = 0;
		for (PerformanceMeasure m : measure.values()){
			p +=m.getPrecision();
		}
		p /= measure.size();
		System.out.println("Presicion: "+p);
	}

	@Override
	public Object estimate(Map<Integer, Double> testData) {
        /* Classify instance and check with the correct class values */
        	//System.out.println(inst);
		Instance instance = new SparseInstance();
		instance.putAll(testData);
        Object predictedClassValue = svm.classify(instance);
        Double predictedProbabilityValue = ((LibSVM) svm).estimate(instance);
        //System.out.println("Probability : "+predictedProbabilityValue);
        //System.out.println("Class : "+predictedClassValue+" true: ");
        return predictedClassValue;
	}

}
