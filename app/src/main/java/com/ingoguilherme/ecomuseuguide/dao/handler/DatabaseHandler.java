package com.ingoguilherme.ecomuseuguide.dao.handler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ingoguilherme.ecomuseuguide.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DatabaseHandler extends SQLiteOpenHelper {
	
	private static final int VERSION = 2;

	Context context;

	public static final String db_name = "ecomuseu_guide_db";

	public DatabaseHandler(Context context) {
		super(context, db_name, null, VERSION);
		this.context = context;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {

		try {
	        int createsCount = insertFromFile(db, R.raw.creates);
	        Log.d("SQL", "Creates: " + createsCount);
	    } catch (IOException e) {
	    	Log.d("ERRO_DB", "Creates: " + e.toString());
	        e.printStackTrace();
	    }
		
		try {
	        int insertCount = insertFromFile(db, R.raw.inserts);
	        Log.d("SQL", "Inserts General: "+insertCount);
	    } catch (IOException e) {
	    	Log.d("ERRO_DB", "Inserts General: " + e.toString());
	        e.printStackTrace();
	    }
		
	}
	
	public int insertFromFile(SQLiteDatabase db, int resourceId) throws IOException {
	    // Reseting Counter
	    int result = 0;
	    int lines = 0;

	    // Open the resource
	    InputStream insertsStream = context.getResources().openRawResource(resourceId);
	    BufferedReader insertReader = new BufferedReader(new InputStreamReader(insertsStream));

	    // Iterate through lines (assuming each insert has its own line and theres no other stuff)
	    while (insertReader.ready()) {
	    	String insertStmt = insertReader.readLine();
	    	if(lines == 0)
	    		insertStmt = insertReader.readLine();
	    	lines++;
	    	
	        if(insertStmt != null){
	        	if(!insertStmt.trim().isEmpty()){
	        		if(insertStmt.substring(0, 3).trim().equals("/*")){
	        			//É um comentário
	        			//Log.d("ERRO", "comentario");
	        		}
	        		else{
	        			//Log.d("ERRO", "sql");
		        		db.execSQL(insertStmt);
			        	result++;
			        	
	        		}
	        	}
	        	else{
	        		//É uma linha vazia
	        		//Log.d("ERRO", "vazia");
	        	}
	        	
	        }
	    }
	    insertReader.close();

	    // returning number of inserted rows
	    return result;
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int older, int newer) {
		onCreate(db);
	}

}
