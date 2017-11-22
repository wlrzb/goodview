package goodview.data.io;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

import goodview.data.Graph;
import goodview.data.Schema;

public class GraphMLReader extends AbstractGraphReader {

	@Override
	public Graph readGraph(InputStream is) throws DataIOException {
        try {       
            SAXParserFactory factory   = SAXParserFactory.newInstance();
            SAXParser        saxParser = factory.newSAXParser();
            
            GraphMLHandler   handler   = new GraphMLHandler();
            saxParser.parse(is, handler);
            return handler.getGraph();
        } catch ( Exception e ) {
            if ( e instanceof DataIOException ) {
                throw (DataIOException)e;
            } else {
                throw new DataIOException(e);
            }
        }
	}
	
	public interface Tokens {
		
	}
	
	public static class GraphMLHandler extends DefaultHandler implements Tokens {
		
		/**
		 * Default data field used to denote the source node in an edge table 
		 * 用于表示“edge表”中“source node”默认数据字段名
		 * 默认字段名为 “data.graph.sourceKey”
		 */
		protected static final String SRC = Graph.DEFAULT_SOURCE_KEY;
		protected static final String TRG = Graph.DEFAULT_TARGET_KEY;
		
		protected Schema m_nsch = new Schema();
		protected Schema m_esch = new Schema();
		
		public void startDocument() {
			m_esch.addColumn(SRC, int.class);
		}
	}

}
