package de.rwth.ti.db;

/**
 * This class represents the table where each scan is stored
 * 
 */
public class Scan {

	public static final String TABLE_NAME = "scans";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_TIME = "time";

	public static final String[] ALL_COLUMNS = { COLUMN_ID, COLUMN_NAME,
			COLUMN_TIME };

	public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME
			+ "(" + COLUMN_ID + " integer primary key autoincrement, "
			+ COLUMN_NAME + " text null, " + COLUMN_TIME + " integer);";
	public static final String TABLE_DROP = "DROP TABLE IF EXISTS "
			+ TABLE_NAME;

	private long id;
	private String name;
	private long time;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}