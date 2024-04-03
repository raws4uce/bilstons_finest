package weka_test;

import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

public class csvtoarff {

	public static void main(String[] args) throws IOException {
		CSVLoader csv = new CSVLoader();
		csv.setSource(new File("C:\\Users\\saura\\Documents\\alevel\\coursework.ComputerScience();\\sql2.csv"));
		Instances data = csv.getDataSet();
		
		ArffSaver arff = new ArffSaver();
		arff.setInstances(data);
		arff.setFile(new File("C:\\Users\\saura\\Documents\\alevel\\coursework.ComputerScience();\\newTrainingSet.arff"));
		arff.writeBatch();
		System.out.print("fdnfbd");
	}
}
