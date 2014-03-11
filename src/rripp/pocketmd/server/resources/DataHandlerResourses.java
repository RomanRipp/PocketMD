package rripp.pocketmd.server.resources;

import java.util.ListResourceBundle;

public class DataHandlerResourses extends ListResourceBundle {
	protected Object[][] getContents(){
		return new Object[][] {
				{"dataFilePath","data"},
				{"dataFileName","data.csv"},
				{"separator",","},
				{"serializedPath","data/serializedTypes/"}
		};
	}
}
