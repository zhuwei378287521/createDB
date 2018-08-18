package zjw.generater.name;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class NameTest {
	public static void main(String[] args) throws InterruptedException {
		NameTest nameTest = new NameTest();

		while (true) {

			System.out.println(Name.getName());
			Thread.sleep(400);
		}
	}

	
}
