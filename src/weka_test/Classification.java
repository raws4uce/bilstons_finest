package weka_test;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Classification {

	public static void main(String[] args) throws Exception {
		DataSource source = new DataSource("C:\\Program Files\\Weka-3-8-6\\data\\iris.arff");
		Instances dataset = source.getDataSet();
		
		dataset.setClassIndex(dataset.numAttributes()-1);
		
		NaiveBayes nb = new NaiveBayes();
		System.out.println(nb.getCapabilities().toString());

		J48 tree = new J48();
		tree.buildClassifier(dataset);
		String[] options = new String[1];
		options[0] = "-U";
		tree.setOptions(options);
		System.out.println(tree.graph());
		
		
	}

}
