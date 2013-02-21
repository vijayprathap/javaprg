import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
/***
 * input file format:
 * 
 *  foo|bar
 *  foo2|bar2
 *  .
 *  .
 */
public class Indexer {
  
	public static HashMap<String,String> list = new HashMap<String,String>();
	public void parse(String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = br.readLine()) != null) {
				String value[] = line.split("\\|");
				list.put(value[1], value[0]);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	/***
	 * Returns true if the list contains the given key.
	 */
	public boolean containsEntry(String key) {
		
		return list.containsKey(key);
	}
	
	/***
	 * Returns the value from the list if key is in list.
	 */
	public String getValue(String key) {
		if (!containsEntry(key)) {
			return null;
		}
		else {
			return list.get(key);
		}
	}
	
	/*public static void main(String args[]){
		Indexer i = new Indexer();
		i.parse("/home/vijaiya/Desktop/test.txt");
		
		System.out.println(i.getValue("aldrig1"));
		
	}*/
}
