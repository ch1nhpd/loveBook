package vn.loveBook.util;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.lang3.StringUtils;

public class FileUtil {
	
	private static final String root = "E:\\hangIntern\\readbook\\readBook\\src\\main\\webapp\\template\\web\\img";

	public static String save(byte[] bytes, String  path) {
		String link = root+path;
		File file = new File(StringUtils.substringBeforeLast(link, "\\"));
		if(!file.exists()) {
			file.mkdir();
		}
		try(FileOutputStream fos = new FileOutputStream(new File(root+path))) {
			
			fos.write(bytes);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
