package m17.sdk.demo

import androidx.multidex.MultiDexApplication
import com.machipopo.media17.sdk.module.sdk.M17Sdk

class DemoApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        M17Sdk.getInstance().initSdk(this)
    }
}

