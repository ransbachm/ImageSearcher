package imageSearcher;

import java.util.Comparator;

public class FilePairComperator implements Comparator<FilePair> {
	
	
	
	@Override public int compare(FilePair o1, FilePair o2) {
		return o1.compareTo(o2);
	}

}
