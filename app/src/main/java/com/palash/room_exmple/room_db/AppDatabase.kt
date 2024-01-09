package com.palash.room_exmple.room_db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.palash.room_exmple.api_service.MyDao
import com.palash.room_exmple.models.MyDataClass

val MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Implement your migration logic here. For example:
        database.execSQL("ALTER TABLE emp ADD COLUMN isActive INTEGER NOT NULL DEFAULT(0)")
    }
}

@Database(entities = [MyDataClass::class], version = 2)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun myDaoFromAppDatabase() : MyDao

    /*val MIGRATION_1_2 = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Implement your migration logic here
            // For example:
            database.execSQL("ALTER TABLE emp ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
        }
    }*/
}