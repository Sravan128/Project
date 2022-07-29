package bean;

import java.io.File;

public class FilesAscendingOrder {
          public void ascendingorder(String path) {
        	
				File fr=new File(path);
				String listoffiles[]=fr.list();
				if(listoffiles.length==0) {  //When directory is empty
					System.out.println("No files present in the directory");
				}
				// Files are auto arranged in a Ascending order
				//So no need to perform any operation or sorting technique.
				//Displays list of files in ascending order
				else {
				System.out.println("List of files in Directory");
				for(String str :listoffiles) {
					System.out.println(str);
				}
				}
          }
}
