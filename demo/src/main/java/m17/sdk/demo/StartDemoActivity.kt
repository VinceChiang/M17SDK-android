package m17.sdk.demo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import m17.sdk.demo.activity.TestLiveCellsActivity

class StartDemoActivity : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_activity_start)
        startActivity(Intent(this, TestLiveCellsActivity::class.java))
    }

}