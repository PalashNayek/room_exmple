package com.palash.room_exmple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.palash.room_exmple.models.MyDataClass
import com.palash.room_exmple.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import gr.makris.androidstories.Stories
import gr.makris.androidstories.data.StoryItem
import gr.makris.androidstories.listener.StoriesCallback
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity()/*, StoriesCallback*/ {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.insertNewRecordEmp(MyDataClass(0,"ABC", "Haur", Date(),1))
        mainViewModel.recordList().observe(this, Observer {
            Log.d("MyRecord", "$it")
            convertToCustomFormat("Tue Jan 09 19:36:10 GMT+05:30 2024")
        })

        /*val storiesList = listOf<StoryItem>(
            StoryItem(url = "https://fakeimg.pl/100x400/"),
            StoryItem(url = "https://fakeimg.pl/200x400/"),
            StoryItem(url = "https://fakeimg.pl/300x400/"),
            StoryItem(url = "https://fakeimg.pl/400x400/")
        )
        val storiesView = findViewById<Stories>(R.id.stories)
        storiesView.setStoriesList(storiesList)*/
    }

    private fun convertToCustomFormat(dateStr: String?): String {
        val utc = TimeZone.getTimeZone("UTC")
        val sourceFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy")
        val destFormat = SimpleDateFormat("dd/MM/YYYY")
        sourceFormat.timeZone = utc
        val convertedDate = sourceFormat.parse(dateStr)
        Log.d("MyRecord", "${destFormat.format(convertedDate)}")
        return destFormat.format(convertedDate)
    }

    /*override fun onStoriesEnd() {
        Log.d("Story -> ", "This is story end....")
    }*/
}