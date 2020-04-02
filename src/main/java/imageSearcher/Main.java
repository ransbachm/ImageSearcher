package imageSearcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		
		File root  = new File("F:\\");
		final List<String> endings = List.of(".png", ".jpg", ".jpeg", ".bmp", ".gif");
		
		System.out.println("Searching...");
		List<File> files = FileUtil.getFilesOfType(root, endings);
		System.out.println("Search complete!");
		StringBuilder sb = new StringBuilder();
		
		List<FilePair> fileList = new ArrayList<FilePair>();
		
		for(File file : files) {
			FilePair p = ImageUtil.getFilePair(file);
			if(p == null) continue;
			if(!checkViable(p)) continue;
			fileList.add(p);
			
		}
		System.out.println(fileList);
		fileList.sort(new FilePairComperator());
		System.out.println(fileList);
		System.out.println("done");
		
		
	}
	
	private static boolean checkViable(FilePair pair) {
		int x = pair.getDimWidth();
		int y = pair.getDimHeight();
		
		if(x>512 && y>512 && x%y==0)
			return true;
		return false;
	}
	
}
