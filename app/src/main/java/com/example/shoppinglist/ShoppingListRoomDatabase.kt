package com.example.shoppinglist

import android.content.Context
import androidx.room.*
import com.example.shoppinglist.dao.ProductDao
import com.example.shoppinglist.models.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ShoppingListRoomDatabase: RoomDatabase() {

  abstract fun productDao(): ProductDao

  companion object {
    private const val DATABASE_NAME = "SHOPPING_LIST_DATABASE"

    @Volatile
    private var shoppingListRoomDatabaseInstance: ShoppingListRoomDatabase? = null

    fun getDatabase(context: Context): ShoppingListRoomDatabase? {
      if (shoppingListRoomDatabaseInstance == null) {
        synchronized(ShoppingListRoomDatabase::class.java) {
          if (shoppingListRoomDatabaseInstance == null) {
            shoppingListRoomDatabaseInstance =
              Room.databaseBuilder(
                context.applicationContext,
                ShoppingListRoomDatabase::class.java,
                DATABASE_NAME
              ).build()
          }
        }
      }
      return shoppingListRoomDatabaseInstance
    }
  }
}
