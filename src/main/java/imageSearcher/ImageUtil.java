package imageSearcher;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageUtil {
	static ImageReader getReader(File file) throws IOException {
		ImageInputStream in = ImageIO.createImageInputStream(file);
		Iterator<ImageReader> readers = ImageIO.getImageReaders(in);
		if(readers.hasNext()) {
			ImageReader reader = readers.next();
			reader.setInput(in);
			return reader;
		}
		throw new IOException();
	}
	
	@Deprecated static Dimension getDimenstions(ImageReader reader) throws IOException {
		return new Dimension(reader.getWidth(0), reader.getHeight(0));
		
	}
	
	static FilePair getFilePair(File file) {
		int x = 0;
		int y = 0;
		try {
			ImageReader reader = getReader(file);
			x = reader.getWidth(0);
			y = reader.getHeight(0);
			reader.dispose();
		} catch (IOException e) {
			System.out.println("Error reading file" + file);
			return null;
		}
		Dimension d = new Dimension(x, y);
		return new FilePair(file, d);
		
		
	}
	

}
