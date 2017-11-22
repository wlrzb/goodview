package goodview.data.io;

import java.io.File;

import goodview.data.Graph;

public interface GraphReader {
	public Graph readGraph(File f) throws DataIOException;
}
