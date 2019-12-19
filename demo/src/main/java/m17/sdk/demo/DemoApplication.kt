package m17.sdk.demo

import androidx.multidex.MultiDexApplication
import com.m17ent.core.module.sdk.M17Sdk
import com.m17ent.core.module.sdk.configs.M17SdkConfig

class DemoApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        M17Sdk.getInstance().initSdk(this, M17SdkConfig("userId", "license"))
    }
}

