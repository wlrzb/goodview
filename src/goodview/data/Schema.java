package goodview.data;

public class Schema {
	private String[] m_names;
	private Class[]  m_types;
	private Object[] m_dflts;
	private int m_size;
	
	public Schema() {
		this(10);
	}
	
	public Schema(int ncols) {
		m_names = new String[ncols];
		m_types = new Class[ncols];
		m_dflts = new Object[ncols];
		m_size = 0;
	}
	
	public void addColumn(String name, Class type) {
		
	}
}
