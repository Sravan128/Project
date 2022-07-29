package com;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
class AddFile{
	
	public void createfile(String str) {
		File ff=new File(str+".txt");
		try {
			if(ff.createNewFile()) {       //create a new files and returns the boolean value
				System.out.println("File added successfully");
			}
			else{
				System.out.println("Already file Exists");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
class DeleteFile{
	public void deletefile(String str) {
		File ff=new File(str+".txt");
		try {
			if(ff.delete()) {   //ff.delete perform the deletion of the specified file and returns the boolean value
				System.out.println("File deleted successfully");
			}
			else{
				System.out.println(" File does not Exists");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
class SearchFile{
	public void searchfile(String str) {
		File ff=new File(str+".txt");
		
		try {
			if(ff.exists()) {
				System.out.println(str+" file exists");
			}
			else {
				System.out.println(str+" file does not exists ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
public class BusinessRequirements {
	
	public void operations(String path) {
		Scanner sn=new Scanner(System.in);
		System.out.println("----- Business level Operations -------------");
		while(true) {
			//Business operations menu
			System.out.println("1. Add a file \n2. Delete a file  \n3.Search a file \n4.Return to main menu");
			System.out.println("\nEnter your choice : ");
			int choice=sn.nextInt();
			switch(choice) {
			    case 1:System.out.println("Enter file name to add : ");
			       String str=sn.next();
			       AddFile af=new AddFile();
			       af.createfile(path+str);
			    	break;
			    case 2:System.out.println("Enter file name to Delete : ");
			       String str1=sn.next();
			       DeleteFile df=new DeleteFile();
			       df.deletefile(path+str1);
			    	break;
			    case 3:System.out.println("Enter file name to search : ");
			       String str2=sn.next();
			       SearchFile sf=new SearchFile();
			       sf.searchfile(path+str2);
			    	break;
			    case 4:
			    	System.out.println("Navigating to main menu.");
			    	return;
			    default:System.out.println("Wrong option Entered! please enter correct option.");
			    break;
			}
		}
	}

}
