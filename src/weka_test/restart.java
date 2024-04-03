package weka_test;

import java.io.File;

import weka.classifiers.lazy.IBk;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
public class restart {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DataSource source = new DataSource("C:\\Program Files\\Weka-3-8-6\\data\\iris.arff");
		Instances dataset = source.getDataSet();
		dataset.setClassIndex(dataset.numAttributes() -1);
	
		IBk classifier = new IBk();
		//set num of neighbours
		classifier.setKNN(2);
		classifier.buildClassifier(dataset);
		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(dataset);
		saver.setFile(new File("C:/Users/saura/Documents/alevel/iris_with_ibk.arff"));
		saver.writeBatch();
		System.out.println("instances: "+ saver );
	}

}
