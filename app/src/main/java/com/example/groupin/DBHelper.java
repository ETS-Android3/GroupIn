package com.example.groupin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";
    public static final String TABLE1 = "projects";
    public static final String TABLE2 = "tasks";

    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use for locating paths to the the database
     *  name    of the database file, or null for an in-memory database
     * factory to use for creating cursor objects, or null for the default
     *                {@link #onUpgrade} will be used to upgrade the database; if the database is
     *                newer, {@link #onDowngrade} will be used to downgrade the database
     */
    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param myDB The database.
     */
    @Override
    public void onCreate(SQLiteDatabase myDB) {
        String table1 = "create Table "+TABLE1+"(projectid INTEGER primary key autoincrement, projectname TEXT,pstart TEXT,pend TEXT, status BOOLEAN)";
        String table2 = "create Table "+TABLE2+"(taskid INTEGER primary key autoincrement, projectid INTEGER, task TEXT,duedate TEXT, member TEXT, tstatus TEXT)";
        myDB.execSQL("create Table users(username TEXT primary key, password TEXT, projectid INTEGER, foreign key (projectid) references "+TABLE1+"(projectid))");
        myDB.execSQL(table1);
        myDB.execSQL(table2);
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     *
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param myDB         The database.
     * @param i The old database version.
     * @param j The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int j) {
        myDB.execSQL("drop Table if exists users");
        myDB.execSQL("drop table if exists "+TABLE1);
        myDB.execSQL("drop table if exists "+TABLE2);
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = myDB.insert("users", null, contentValues);
        return result != -1;
    }
    public Boolean checkusername(String username){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from users where username = ?", new String[] {username});
        return cursor.getCount() > 0;
    }

    public  Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        return cursor.getCount() > 0;
    }

    public String addProject(String projectname,String pstart,String pdue) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();

        contentValues1.put("projectname", projectname);
        contentValues1.put("pstart", pstart);
        contentValues1.put("pend", pdue);
        contentValues1.put("status", false);

        long result=myDB.insert(TABLE1, null, contentValues1);
        if(result==-1)
            return "Project Creation Failed";
        else
            return  "Project Successfully Created";
    }

    public String addTask(String taskname, String tdue, String tmem, String tstatus, String pid){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues2 = new ContentValues();

        contentValues2.put("projectid",Integer.parseInt(pid));
        contentValues2.put("task",taskname);
        contentValues2.put("duedate",tdue);
        contentValues2.put("member",tmem);
        contentValues2.put("tstatus",tstatus);

        long result=myDB.insert(TABLE2, null, contentValues2);

        if(result==-1)
            return "Additon Failed";
        else
            return  "Added Successfully";

    }

    public Cursor readalldata(){
        SQLiteDatabase myDB = this.getWritableDatabase();
        String qry = "select projectid,projectname,pend,status from "+TABLE1+" order by projectid desc";
        Cursor cursor = myDB.rawQuery(qry, null);
        return cursor;
    }

    public Cursor readallTasks(String pid){
        SQLiteDatabase myDB = this.getWritableDatabase();
        String qry = "select taskid,task,duedate,member,tstatus from "+TABLE2+" where projectid="+Integer.parseInt(pid);
        Cursor cursor = myDB.rawQuery(qry, null);
        return cursor;
    }

}
