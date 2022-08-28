package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	public static void saveImage(String root, String frame, byte[] data) throws IOException {
		
		root += "/images";
		File f = new File(root);
		if(!f.exists()) f.mkdir();
		
		FileOutputStream out = new FileOutputStream(f);
		out.write(data);
		out.close();
		
	}
}
