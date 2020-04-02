package imageSearcher;

import java.awt.Dimension;
import java.io.File;

public class FilePair implements Comparable<FilePair> {
	private File file;
	private Dimension dim;
	
	public FilePair(File file, Dimension dimension) {
		this.file = file;
		this.dim = dimension;
	}
	
	public File getFile() {
		return file;
	}
	public Dimension getDimension() {
		return dim;
	}
	
	public int getDimWidth() {
		return (int) Math.round(dim.getWidth());
	}
	
	public int getDimHeight() {
		return (int) Math.round(dim.getHeight());
	}
	
	@Override public String toString() {
		return String.format("[FilePair : %s : [%s|%s]]%n", file, dim.width, dim.height);
	}
	
	@Override public int compareTo(FilePair p) {
		long otherSquare = p.getDimWidth() * p.getDimWidth();
		long ownSquare = this.getDimWidth() * this.getDimHeight();
		
		if(otherSquare > ownSquare)
			return -1;
		else if (otherSquare == ownSquare)
			return 0;
		else
			return 1;
		
		
		
	}
}
