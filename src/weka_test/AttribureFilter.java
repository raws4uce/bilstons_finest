package weka_test;
import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
public class AttribureFilter {
	public static void main(String[] args) throws Exception {
		DataSource source = new DataSource("C:/Users/saura/Documents/alevel/test.arff");
		Instances dataset = source.getDataSet();
		
		String[] opts = new String[] { "-R", "3"};
		
		Remove remove = new Remove();
		remove.setOptions(opts);
		remove.setInputFormat(dataset);
		
		Instances newData = Filter.useFilter(dataset, remove);
		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File("C:/Users/saura/Documents/alevel/testFilteredWithRemove.arff"));
		saver.writeBatch();
		
	}

}