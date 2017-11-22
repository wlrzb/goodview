package goodview.data.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import goodview.data.Graph;

public abstract class AbstractGraphReader implements GraphReader{

	@Override
	public Graph readGraph(File f) throws DataIOException {
		try {
			return readGraph(new FileInputStream(f));
		} catch (FileNotFoundException e) {
			throw new DataIOException(e);
		}
	}
	
	public abstract Graph readGraph(InputStream is) throws DataIOException;

}
