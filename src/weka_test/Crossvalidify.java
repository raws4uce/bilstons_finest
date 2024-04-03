package weka_test;

import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;

public class Crossvalidify {

	public static void main(String[] args) throws Exception {
		
//		J48 tree = new J48();
		DataSource src = new DataSource("C:\\Users\\saura\\Documents\\alevel\\coursework.ComputerScience();\\newTrainingSet.arff");
		Instances train = src.getDataSet();
		train.setClassIndex(train.numAttributes()-1);
		
		J48 tree = (J48) SerializationHelper.read("J48.model");
		Evaluation eval = new Evaluation(train);
		Random rand = new Random(1);
		int folds = 10;
		
		DataSource src1 = new DataSource("C:\\Users\\saura\\Documents\\alevel\\coursework.ComputerScience();\\newTestingSet.arff");
		Instances test = src1.getDataSet();
		test.setClassIndex(test.numAttributes()-1);
		
//		eval.evaluateModel(tree, test);
		eval.crossValidateModel(tree, test, folds, rand);
		System.out.println(eval.toSummaryString("Eval results:\n", false));
	}

}
