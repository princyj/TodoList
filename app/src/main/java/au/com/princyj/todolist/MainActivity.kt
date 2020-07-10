package au.com.princyj.todolist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val LOG_TAG = MainActivity.javaClass.simpleName
        val EXTRA_MESSAGE = "au.com.princyj.todolist.extra.MESSAGE"
    }

    val TEXT_REQUEST = 1
    private val taskList = mutableListOf<String>()
//    private val adapter by lazy { makeAdapter(taskList) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun launchAddTaskActivity(view: View) {
        Log.d(LOG_TAG, "Button Clicked")
        val intent = Intent(this, AddTask::class.java)
        val message = edit_text.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                val reply = data?.getStringExtra(AddTask.EXTRA_REPLY)
                text_header_reply.visibility = VISIBLE
                text_message_reply.text = reply
                text_message_reply.visibility = VISIBLE
            }
        }

    }


}
