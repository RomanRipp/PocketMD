package rripp.pocketmd.server.datahandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataOperations {
	public static <T> List<List<T>> listTranspose(List<List<T>> table) {
        List<List<T>> ret = new ArrayList<List<T>>();
        final int N = table.get(0).size();
        for (int i = 0; i < N; i++) {
            List<T> col = new ArrayList<T>();
            for (List<T> row : table) {
                col.add(row.get(i));
            }
            ret.add(col);
        }
        return ret;
    }
	public static <T> List<Map<Integer, T>> listMapTranspose(List<List<T>> table) {
        List<Map<Integer, T>> ret = new ArrayList<Map<Integer, T>>();
        final int N = table.get(0).size();
        for (int i = 0; i < N; i++) {
            Map<Integer, T> col = new HashMap<Integer, T>();
            for (int j=0; j<table.size(); j++){
            	T val = table.get(j).get(i);
				if (val!=null) {
            		col.put(j, val);
				}
            }
            ret.add(col);
        }
        return ret;
    }

}
