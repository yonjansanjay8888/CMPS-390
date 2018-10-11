package scarylist;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Enter the filename: (Eg: data)");
		Scanner sc = new Scanner(System.in);
		String filename = sc.next();
		

		System.out.println("Enter the length of data:");
		int length = sc.nextInt();
		
		
			String[] names = readFile(filename);
			LinkedList list = new LinkedList();

			for(int i = 0; i < names.length && i < length; i++){
				list.add(names[i]);
			}
			list.print();
			

			System.out.println("\nPrint beginning with letter : ");
			String begin = sc.next();
			
			LinkedList l = list.beginingWith(begin);
			l.print();
			
			

			/*
			list.insertAfter(list.head.next, "Test Person");
			list.removeNode(list.head.next);
			list.removeNode(list.findLastNode());
			list.print();
			*/
		
		

			sc.close();
		
		
	}
	public static String[] readFile(String file){
		String[] temp = null;
		try{
			Scanner sc = new Scanner(new File(file));
			int count = 0;
			while(sc.hasNextLine()){
				sc.nextLine();
				count++;
			}
			//defining size for names/hashed
			temp = new String[count];

			sc = new Scanner(new File(file));
			count = 0;
			while(sc.hasNextLine()){
				temp[count] = sc.nextLine();
				count++;
			}
		
			sc.close();

		} catch (Exception e){
			System.out.println("No file found.");
		}
		
		return temp;
	}

}
