package date181219.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx {
	
	public static void main(String[] args){
	
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is); 
		// InputStreamReader has a InputStream // has-a
		BufferedReader br = new BufferedReader(isr); // is-a 
		
		try {
			br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
