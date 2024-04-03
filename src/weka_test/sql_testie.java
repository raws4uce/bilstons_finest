package weka_test;
import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.DatabaseLoader;
public class sql_testie {

	public static void main(String[] args) throws Exception {

		
		// Load data from the database
		DatabaseLoader loader = new DatabaseLoader();
		String[] url = new String[3];
		String query = "SELECT * FROM results";
		url[0] = "jdbc:mysql://localhost:3306/csmathapp";
		url[1] = "root";
		url[2] = "1M@Y0URb17144473";
		loader.setUrl(url[0]);
		loader.setPassword(url[2]);
		loader.setUser(url[1]);
		loader.setQuery(query);
		Instances data = loader.getDataSet();
		if (data != null) {
			System.out.println("this is data" + data);
			data.setClassIndex(9); // Set the class attribute index

			ArffSaver saver = new ArffSaver();
			saver.setInstances(data);
			saver.setFile(new File("C:/Users/saura/Documents/alevel/resultsCHsibfspin.arff"));
			saver.writeBatch();
		}

	}

}
