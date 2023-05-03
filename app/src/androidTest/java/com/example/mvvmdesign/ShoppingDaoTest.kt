package com.example.mvvmdesign

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class ShoppingDaoTest {
    private lateinit var database: ShoppingItemDatabase
    private lateinit var dao: ShoppingDao

    @Before
    fun setUp(){
        database = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),
        ShoppingItemDatabase::class.java).allowMainThreadQueries()
            .build()
        dao = database.shoppingDao()
    }

    @After
    fun tearDown(){
        database.close()
    }

    @Test
    fun insertShoppingItem()= runBlockingTest {
        val shoppingItem = ShoppingItem("nmae",1,1f,"url",id=1)
        dao.insertShoppingItem(shoppingItem)
       val allShoppingITem = dao.observeAllShoppingItems().getOrAwaitValue()



    }


}