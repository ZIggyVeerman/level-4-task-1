package com.example.shoppinglist.repositories

import android.content.Context
import com.example.shoppinglist.ShoppingListRoomDatabase
import com.example.shoppinglist.dao.ProductDao
import com.example.shoppinglist.models.Product

class ProductRepository(context: Context) {

  private val productDao: ProductDao

  init {
    val database = ShoppingListRoomDatabase.getDatabase(context)
    productDao = database!!.productDao()
  }

  suspend fun getAllProducts(): List<Product> = productDao.getAllProducts()

  suspend fun insertProduct(product: Product) = productDao.insertProduct(product)

  suspend fun deleteProduct(product: Product) = productDao.deleteProduct(product)

  suspend fun deleteAllProducts() = productDao.deleteAllProducts()

}
