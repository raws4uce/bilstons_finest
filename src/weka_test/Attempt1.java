package weka_test;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import com.opencsv.CSVWriter;

import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.ConverterUtils.DataSource;
public class Attempt1 extends Thread {

	public static void main(String[] args) throws Exception {
		ArrayList<String> ADDallHints = new ArrayList<>(), SUBallHints = new ArrayList<>(), MULallHints = new ArrayList<>(), DIVallHints = new ArrayList<>();
		//SQL query to CSV
		CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\saura\\Documents\\alevel\\coursework.ComputerScience();\\test.csv"));
		Boolean includeHeaders = true;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csmathapp", "root", "1M@Y0URb17144473");
		Statement stmt = con.createStatement();
		ResultSet myResultSet = stmt.executeQuery("SELECT correct, difficulty, topic, hintid, rating FROM results;");
		writer.writeAll(myResultSet, includeHeaders);
		writer.close();
		//CSV to ARFF
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File("C:\\Users\\saura\\Documents\\alevel\\coursework.ComputerScience();\\test.csv"));
		Instances data = loader.getDataSet();
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File("C:/Users/saura/Documents/alevel/newTestingSet.arff"));
		saver.writeBatch(); 

		J48 tree = (J48) weka.core.SerializationHelper.read("J48.model"); //already trained model
		DataSource src1 = new DataSource("C:\\Users\\saura\\Documents\\alevel\\newTestingSet.arff");
		Instances test = src1.getDataSet();
		test.setClassIndex(test.numAttributes()-1);
		for(int i = 0; i < test.numInstances(); i++) {
			Instance newInst = test.instance(i);
			double prediction = tree.classifyInstance(newInst);
			String pred = test.classAttribute().value((int) prediction);
			System.out.println(/*real + */", "+ pred);
			String hintid = newInst.toString(newInst.attribute(3)); //hint id
			String topic = newInst.toString(newInst.attribute(2)); // topic
			System.out.println("                                       " + i);
			switch (topic) {
			case "add":
				if(pred.equals("Y")) { //Y value indicates that hint is appropriate for topic
					ADDallHints.add(hintid);//store in array
				}
				break;
			case "sub":
				if(pred.equals("Y")) {SUBallHints.add(hintid);}
				break;
			case "mul":
				if(pred.equals("Y")) {MULallHints.add(hintid);}
				break;
			case "div":
				if(pred.equals("Y")) {DIVallHints.add(hintid);}
				break;
			}
		}
		System.out.println("Add       " + ADDallHints +"sub       " + SUBallHints +"mul       " + MULallHints +"div       " + DIVallHints);
		
	}

}
