package m17.sdk.demo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import m17.sdk.demo.view.TestLiveCellLayout
import com.m17ent.core.module.sdk.M17Sdk
import com.m17ent.core.module.sdk.configs.M17LiveListConfig
import com.m17ent.core.module.sdk.interfaces.M17LiveCellBaseView
import com.m17ent.core.module.sdk.interfaces.M17LiveCellRender
import m17.sdk.demo.R
import m17.sdk.demo.databinding.TestActivityLiveListBinding

class TestLiveCellsActivity : AppCompatActivity() {

    private lateinit var dataBinding : TestActivityLiveListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_activity_live_list)

        dataBinding = DataBindingUtil.setContentView<TestActivityLiveListBinding>(
            this, R.layout.test_activity_live_list
        ).apply {
            this.setLifecycleOwner(this@TestLiveCellsActivity)
        }

        M17Sdk.getInstance().setUser("Set Company Name", "Set UserId")

        var config = M17LiveListConfig()

        //Customer -- START
//        var config = M17LiveListConfig(object : M17LiveCellRender {
//            override fun renderCell(): M17LiveCellBaseView {
//                return TestLiveCellLayout(this@TestLiveCellsActivity)
//            }
//        })
        //Customer -- END

        val fragment = M17Sdk.getInstance().createLiveListFragment(config)

        fragment?.let {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame, it, "TestLiveListFragment")
                .addToBackStack(null)
                .commit()
        }
    }

}