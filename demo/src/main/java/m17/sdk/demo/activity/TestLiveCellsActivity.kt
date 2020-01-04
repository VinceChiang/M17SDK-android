package m17.sdk.demo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.m17ent.core.module.sdk.M17Sdk
import com.m17ent.core.module.sdk.configs.M17LiveListConfig
import com.m17ent.core.module.sdk.dto.M17License
import com.m17ent.core.module.sdk.interfaces.M17LicenseCallback
import kotlinx.android.synthetic.main.test_activity_live_list.*
import m17.sdk.demo.BuildConfig
import m17.sdk.demo.R

class TestLiveCellsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_activity_live_list)

        infoTxtView.text = BuildConfig.VERSION_INFO

        M17Sdk.getInstance().getLicense("Input Your Company Name", "Input Your UserId", object: M17LicenseCallback {
            override fun onSuccess(license: M17License) {
                license?.apply {
                    showLiveListFragment(this)
                }
            }
        })
    }

    fun showLiveListFragment(license: M17License){
        //Customer -- START
//        var config =
//            M17LiveListConfig(object : M17LiveCellRender {
//                override fun renderCell(): M17LiveCellBaseView {
//                    return TestLiveCellLayout(this@TestLiveCellsActivity)
//                }
//            })
        //Customer -- END

        var config = M17LiveListConfig(filterConfig = license?.getRegionListFilterConfig())
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