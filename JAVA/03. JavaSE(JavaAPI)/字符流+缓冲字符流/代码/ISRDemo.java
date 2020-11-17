package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ×Ö·ûÁ÷¶ÁÈ¡×Ö·û²Ù×÷
 * @author ta
 *
 */
public class ISRDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("osw.txt");
		
		InputStreamReader isr
			= new InputStreamReader(fis,"UTF-8");
		
		BufferedReader br
			= new BufferedReader(isr);
		
		
		int d = -1;
		while((d = isr.read())!= -1) {
			System.out.print((char)d);
		}
		
		
		isr.close();
	}
}





