package aplikasi.mobile.uas_rental_mobil.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "rentalmobil.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("PRAGMA foreign_keys=ON");
        db.execSQL("create table penyewa (" +
                "nama text," +
                "alamat text," +
                "no_hp text," +
                "primary key(nama)" +
                ");" +
                "");
        db.execSQL("create table mobil(" +
                "merk text," +
                "harga int," +
                "primary key(merk)" +
                ");" +
                "");
        db.execSQL("create table sewa(" +
                "merk text," +
                "nama text," +
                "promo int," +
                "lama int," +
                "total double," +
                "foreign key(merk) references mobil (merk), " +
                "foreign key(nama) references penyewa (nama) " +
                ");" +
                "");

        db.execSQL("insert into mobil values (" +
                "'All New Avanza'," +
                "350000" +
                ");" +
                "");
        db.execSQL("insert into mobil values (" +
                "'Honda Jazz'," +
                "250000" +
                ");" +
                "");
        db.execSQL("insert into mobil values (" +
                "'Honda Mobilio'," +
                "300000" +
                ");" +
                "");
        db.execSQL("insert into mobil values (" +
                "'Xenia'," +
                "350000" +
                ");" +
                "");
        db.execSQL("insert into mobil values (" +
                "'Ertiga'," +
                "350000" +
                ");" +
                "");
        db.execSQL("insert into mobil values (" +
                "'APV'," +
                "300000" +
                ");" +
                "");
        db.execSQL("insert into mobil values (" +
                "'Innova Reborn'," +
                "500000" +
                ");" +
                "");
        db.execSQL("insert into mobil values (" +
                "'Xpander'," +
                "400000" +
                ");" +
                "");
        db.execSQL("insert into mobil values (" +
                "'Elf'," +
                "700000" +
                ");" +
                "");
        db.execSQL("insert into mobil values (" +
                "'Pajero'," +
                "550000" +
                ");" +
                "");
        db.execSQL("insert into mobil values (" +
                "'Fortuner'," +
                "550000" +
                ");" +
                "");
        db.execSQL("insert into mobil values (" +
                "'Rush'," +
                "400000" +
                ");" +
                "");
        db.execSQL("insert into mobil values (" +
                "'Alphard'," +
                "1200000" +
                ");" +
                "");
        db.execSQL("insert into mobil values (" +
                "'Hiace'," +
                "1000000" +
                ");" +
                "");
    }

    public List<String> getAllCategories() {
        List<String> categories = new ArrayList<String>();
        String selectQuery = "select * from mobil";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                categories.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return categories;
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }

}