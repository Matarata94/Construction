package ir.matarata.construction;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {
	
	private final Context mycontext;
	public final String path = "data/data/ir.matarata.construction/databases/";
	public final String dbname = "constructiondb.db3";
	public SQLiteDatabase mydb;
	
	public database(Context context) {
		super(context, "constructiondb.db3", null, 1);
		mycontext = context;
	}
	public void onCreate(SQLiteDatabase db) {
		
	}
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	public boolean checkdb(){
		SQLiteDatabase db = null;
		try{
		db = SQLiteDatabase.openDatabase(path + dbname, null, SQLiteDatabase.OPEN_READONLY);
		}catch(SQLException e)
		{
			
		}
		return db != null ? true:false;
	}
	public void databasecreate(){
		boolean checkdb = checkdb();
		if(checkdb){
			
		}else{
			this.getReadableDatabase();
			try{
			copydatabase();
			}catch(IOException e){
				
			}
		}
	}
	public void copydatabase() throws IOException{
		OutputStream myOutput = new FileOutputStream(path + dbname);
		byte[] buffer = new byte[1024];
		int length;
		InputStream myInput = mycontext.getAssets().open(dbname);
		while((length = myInput.read(buffer)) > 0){
			myOutput.write(buffer, 0, length);
		}
		myInput.close();
		myOutput.flush();
		myOutput.close();
	}
	public void open(){
		mydb = SQLiteDatabase.openDatabase(path + dbname, null, SQLiteDatabase.OPEN_READWRITE);
	}
	public void close(){
		mydb.close();
	}

	public String QuerySetting(int fild, int id){
		Cursor cu = mydb.rawQuery("SELECT * FROM setting WHERE id=" + id, null);
		cu.moveToFirst();
		String name = cu.getString(fild);
		cu.close();
		return name;
	}
	public String QueryInformation(int fild, int id){
		Cursor cu = mydb.rawQuery("SELECT * FROM information WHERE id=" + id, null);
		cu.moveToFirst();
		String name = cu.getString(fild);
		cu.close();
		return name;
	}
	public void UpdateSetting(String value, int id, String row){
		ContentValues cv = new ContentValues();
		cv.put(row, value);
		mydb.update("setting", cv, "id=" + id, null);
	}
	public void UpdateInformation(String value, int id,String row){
		ContentValues cv = new ContentValues();
		cv.put(row, value);
		mydb.update("information", cv, "id=" + id, null);
	}
}