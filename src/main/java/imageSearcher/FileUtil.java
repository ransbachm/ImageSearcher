package imageSearcher;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class FileUtil {
	
	static void showFiles(File[] files) {
		for(int i=0; i<files.length; i++) {
			File file = files[i];
			if(file.isDirectory()) {
				showFiles(file.listFiles());
			} else {
				System.out.println(file);
			}
		}
	}
	
	static void showFiles(File f) {
		showFiles(f.listFiles());
	}
	
	static List<File> getFilesOfType(File[] files, List<String> fileEndings) {
		if(files == null) {
			return null;
		}
		List<File> collectList = new LinkedList<>();
		for(int i=0; i<files.length; i++) {
			File file = files[i];
			if(file == null) {
				continue;
			}
			//System.out.println(file);
			if(file.isDirectory()) {
				List<File> list = getFilesOfType(file.listFiles(), fileEndings);
				if(list == null)
					continue;
				list.forEach(collectList::add);
				
				continue;
			} else {
				// check if no dot in filename
				String fileString = file.toString();
				String realSuffix = "";
				int dotIndex = fileString.indexOf('.');
				if(dotIndex == -1)
					continue;
				else
					realSuffix = fileString.substring(dotIndex);
				// check if suffix in list
				for(String crr: fileEndings) {
					if(realSuffix.equals(crr)) {
						collectList.add(file);
					}
				}
				continue;
			}
		}
		return collectList;
	}
	
	static List<File> getFilesOfType(File f, List<String> fileEndings) {
		return getFilesOfType(f.listFiles(), fileEndings);
	}
	

}
