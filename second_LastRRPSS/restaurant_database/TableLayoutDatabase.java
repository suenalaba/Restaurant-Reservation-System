package restaurant_database;

// import relevant java libraries to be updated as we go..
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

//import Table class
import restaurant_entity.Table;
import restaurant_manager.TableLayoutManager;


public class TableLayoutDatabase {
	public static final String DELIMITER = ";";
	
	public static ArrayList<Table> fread(String textfilename) throws IOException {

		ArrayList<String> fileasstring = FileRead.fread(textfilename);
		
		//array to store table
		ArrayList<Table> mainLayout = new ArrayList<>();

		for (int i = 0; i < fileasstring.size(); i++) {
			String data = (String) fileasstring.get(i);
			// get individual 'fields' of the string separated by the delimiter ','
			StringTokenizer str_tokenizer = new StringTokenizer(data, DELIMITER); // pass in the string to the string tokenizer
		
			int tableID = Integer.parseInt(str_tokenizer.nextToken().trim());
			int tableCapacity = Integer.parseInt(str_tokenizer.nextToken().trim());
			Table table = new Table(tableID, tableCapacity);
			mainLayout.add(table);

		}
		return mainLayout;

	}
	
	public static void fwrite(String textfilename) throws IOException {

		ArrayList<String> tablelist = new ArrayList<String>();// array list to store table data
		ArrayList<Table> mainLayout=TableLayoutManager.getInstance().getTableLayout();
		for (int i = 0; i < mainLayout.size(); i++) {
			Table table = (Table) mainLayout.get(i);
			StringBuilder tablestring = new StringBuilder();
			tablestring.append(Integer.toString(table.getTableID()));
			tablestring.append(DELIMITER);
			tablestring.append(Integer.toString(table.getTableCapacity()));
			tablestring.append(DELIMITER);
			tablelist.add(tablestring.toString());
		}
		FileRead.fwrite(tablelist,textfilename);
	}
}

