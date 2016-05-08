import java.util.*;
import java.io.*;

public class PhoneBook {

	public static void main(String[] args) throws IOException {
		
		File phone_book = new File("Phone Records");
		if(!phone_book.isFile()) {
				
			phone_book.createNewFile();
		}
		FrontEndUI newInstance = new FrontEndUI("Phone Book", phone_book);
		
		
		

	}

}
