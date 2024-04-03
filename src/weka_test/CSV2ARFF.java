package weka_test;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import java.io.File;
public class CSV2ARFF {
    public static void main(String[] args) throws Exception {
    	
    	//load csv
    	CSVLoader loader = new CSVLoader();
    	loader.setSource(new File("C:/Users/saura/Documents/alevel/test.csv"));
    	Instances data = loader.getDataSet();
    	
    	ArffSaver saver = new ArffSaver();
    	saver.setInstances(data);
    	
    	saver.setFile(new File("C:/Users/saura/Documents/alevel/test.arff"));
    	saver.writeBatch(); 
    }
}
