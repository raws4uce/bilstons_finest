package weka_test;

import java.util.ArrayList;

import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;

public class FirstTest {

	public static void main(String[] args) throws Exception {
		//all hint id's will be stored here according to the topic.
		ArrayList<String> ADDallHints = new ArrayList<>(), SUBallHints = new ArrayList<>(), MULallHints = new ArrayList<>(), DIVallHints = new ArrayList<>();
		//training dataset
		DataSource src = new DataSource("C:\\Users\\saura\\Documents\\alevel\\coursework.ComputerScience();\\newTrainingSet.arff");
		Instances train = src.getDataSet();
		train.setClassIndex(train.numAttributes()-1);
		//classifier
		J48 tree = new J48();
		//		J48 tree = (J48) weka.core.SerializationHelper.read("J48.model");

		tree.buildClassifier(train);
		SerializationHelper.write("J48.model", tree);
		//		Evaluation eval = new Evaluation(train);
		//		IBk classifier = new IBk();
		//		classifier.buildClassifier(train);

		//test dataset (copy of first dataset but class values replaced with "?" (classifier will prefict it))
		
//		J48 tree = (J48) weka.core.SerializationHelper.read("J48.model");
//		DataSource src1 = new DataSource("C:\\Users\\saura\\Documents\\alevel\\newTestingSet.arff");
//		Instances test = src1.getDataSet();
//		test.setClassIndex(test.numAttributes()-1);
		//		eval.evaluateModel(tree, test);
		//		System.out.println(eval.toSummaryString("Eval results:\n", false));
		//		System.out.println("Correct % = "+eval.pctCorrect ());
		//		System.out.println("Incorrect % = "+eval.pctIncorrect ());
//		for(int i = 0; i < test.numInstances(); i++) {
			//class value of training dataser
//			double realClass = train.instance(i).classValue();
//			String real = train.classAttribute().value((int) realClass);
//			Instance newInst = test.instance(i);
			//predicted class value of testing dataset
//			double prediction = tree.classifyInstance(newInst);
//			String pred = test.classAttribute().value((int) prediction);
//			System.out.println(/*real + */", "+ pred);
//
//			String hintid = newInst.toString(newInst.attribute(3)); //hint id
//			String topic = newInst.toString(newInst.attribute(2)); // topic
//			System.out.println("                                       " + i);
//			switch (topic) {
//			case "add":
//				if(pred.equals("Y")) { //Y value indicates that hint is appropriate for topic
//					ADDallHints.add(hintid);//store in array
//				}
//				break;
//			case "sub":
//				if(pred.equals("Y")) {
//					SUBallHints.add(hintid);	
//				}
//				break;
//			case "mul":
//				if(pred.equals("Y")) {
//					MULallHints.add(hintid);	
//				}
//				break;
//			case "div":
//				if(pred.equals("Y")) {
//					DIVallHints.add(hintid);	
//				}
//				break;
//
//			}
//
//		}
//		System.out.println("Add       " + ADDallHints);
//		System.out.println("sub       " + SUBallHints);
//		System.out.println("mul       " + MULallHints);
//		System.out.println("div       " + DIVallHints);
	}

}
