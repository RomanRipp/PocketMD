package rripp.pocketmd.server.datahandler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import rripp.pocketmd.server.resources.DataHandlerResourses;

public class Serialization {
	/**
	 * Serialization of data
	 * @param object
	 * @return
	 */
	public static boolean serialize(Object object, String modelName){
		String fileName = object.getClass().getName();
		fileName += "."+modelName;
		DataHandlerResourses dataHandlerResourses = new DataHandlerResourses();
		String filePath = dataHandlerResourses.getString("serializedPath");
		filePath += fileName+".model"; 
		try
		{
			FileOutputStream fileOut =
					new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(object);
			out.close();
			fileOut.close();
			//System.out.println("Serialized data is saved in "+filePath);
			return true;
		}catch(IOException i)
		{
			i.printStackTrace();
			return false;
		}
	}
    /*public static Object deserialize(){
    	Object svn = null;
    	 try
         {
            FileInputStream fileIn = new FileInputStream("data/serializedTypes/libsvm.LibSVM.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            svn = in.readObject();
            in.close();
            fileIn.close();
            System.out.println("All good");
            return svn;
         }catch(IOException i)
         {
            i.printStackTrace();
            return null;
         }catch(ClassNotFoundException c)
         {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return null;
         }
    }*/
}
