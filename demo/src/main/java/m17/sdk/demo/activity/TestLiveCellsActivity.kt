package m17.sdk.demo.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.m17.sdk.demo.view.TestLiveCellLayout
import com.machipopo.media17.sdk.module.common.activity.M17BaseActivity
import com.machipopo.media17.sdk.module.livelist.interfaces.M17LiveCellBaseView
import com.machipopo.media17.sdk.module.livelist.interfaces.M17LiveCellRender
import com.machipopo.media17.sdk.module.sdk.M17LiveListConfig
import com.machipopo.media17.sdk.module.sdk.M17Sdk
import m17.sdk.demo.R
import m17.sdk.demo.databinding.TestActivityLiveListBinding

class TestLiveCellsActivity : M17BaseActivity() {

    private lateinit var dataBinding : TestActivityLiveListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_activity_live_list)

        dataBinding = DataBindingUtil.setContentView<TestActivityLiveListBinding>(
            this, R.layout.test_activity_live_list
        ).apply {
            this.setLifecycleOwner(this@TestLiveCellsActivity)
        }

        var config = M17LiveListConfig(object : M17LiveCellRender {
            override fun renderCell(): M17LiveCellBaseView {
                return TestLiveCellLayout(this@TestLiveCellsActivity)
            }
        })
        val fragment = M17Sdk.getInstance().createLiveListFragment(config)

        fragment?.let {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame, fragment, "TestLiveListFragment")
                .addToBackStack(null)
                .commit()
        }
    }

}