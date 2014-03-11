package rripp.pocketmd.server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import DataTransfer.FileServer;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		System.out.println("Server is UP, Hi");
		//The menu:		
		mainMenu();
	}
	
	private static void mainMenu(){

		System.out.println("Choose the operation: ");
		System.out.println("1. Train");
//		System.out.println("2. CrossValidate");
//		System.out.println("3. Estimate");
		System.out.println("2. Networking");
		System.out.println("3. Exit");
		
		switch (readMenuInput()){
		case 1:
			trainSubMenu();
			break;
		case 2:
			fileServerSubMenu();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("Sorry I didn't get that...");
			mainMenu();
			break;
		}
	}
	
	private static void trainSubMenu(){
		
		System.out.println("Train models, choose option: ");
		System.out.println("1. Train all models");
		//System.out.println("1. Train specific models");
		System.out.println("2. Back");
		
		switch (readMenuInput()){
		case 1:
			trainModels();
			break;
		case 2:
			mainMenu();
			break;
		default:
			System.out.println("Sorry I didn't get that...");
			mainMenu();
			break;
		}
	}
	
	private static void fileServerSubMenu(){
		System.out.println("1. Start file server");
		System.out.println("2. Stop file server");
		System.out.println("3. Back");
		
		switch (readMenuInput()){
		case 1:
			FileServer.start();
			break;
		case 2:
			FileServer.stop();
			break;
		case 3:
			mainMenu();
			break;
		default:
			System.out.println("Sorry I didn't get that...");
			mainMenu();
		break;
		}
		//Go to main menu anyway
		mainMenu();
	}
	
	private static void trainModels(){
		ModelBuilder.build("OSL1", new String[]{ "TIMEPOST", "PULSE1", "IndSh1", "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
		ModelBuilder.build("OSL3", new String[]{ "TIMEPOST", "PULSE1", "IndSh1", "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
		ModelBuilder.build("OSL5", new String[]{ "TIMEPOST", "PULSE1", "IndSh1", "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
		ModelBuilder.build("OSL7", new String[]{ "TIMEPOST", "PULSE1", "IndSh1", "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
		ModelBuilder.build("OSL9", new String[]{ "TIMEPOST", "PULSE1", "IndSh1", "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
		ModelBuilder.build("OSL10", new String[]{ "TIMEPOST", "PULSE1", "IndSh1", "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
		ModelBuilder.build("ISH", new String[]{ "TIMEPOST", "PULSE1", "IndSh1",  "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
	}
/*		
	private static void crossValidSubMenu(){
		System.out.println("Performing cross validation...");
		
	}

	private static void estmateSubMenu(){
		System.out.println("Estimateing....");
		System.out.println("Enter model name: ");
		readString();
	}
*/
	private static int readMenuInput(){
		String s = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (s != null && !s.isEmpty()){
			return Integer.parseInt(s);
		}else{
			return 0;
		}
	}
	
	private static String readString(){
		String s = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

	
}
