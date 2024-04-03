package weka_test;


import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.attribute.Discretize;
import weka.filters.Filter;
import weka.core.converters.ArffSaver;
import java.io.File;

public class discritise {
	public static void main(String[] args) throws Exception {
		DataSource source = new DataSource("C:/Users/saura/Documents/alevel/sparse.arff");
		Instances dataset = source.getDataSet();
		
		String[] options = new String[5];
		
		options[0] = "-B"; options[1] = "2";
		options[2] = "-R"; options[3] = "1-5";//index starts at 1 
		options[4] = "-V";
		Discretize discretize = new Discretize();
		discretize.setOptions(options);
		discretize.setInputFormat(dataset);
		Instances newData = Filter.useFilter(dataset, discretize);
		
		
		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File("C:/Users/saura/Documents/alevel/discretisation.arff"));
		saver.writeBatch();
	}

}
