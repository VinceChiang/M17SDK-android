# M17SDK-Android

## Generate your github authorization
![](website/github_generate_auth.png)

## Gradle
### Repositories
```
maven {
    url "https://raw.githubusercontent.com/17media/M17_SDK_Released/master/releases"
    credentials(HttpHeaderCredentials) {
        name = "Authorization"
        value = "Bearer {Input Your Github Authorization}"
    }
    authentication {
        header(HttpHeaderAuthentication)
    }
}
```

### DataBinding
```
dataBinding {
   enabled = true
}
```

### Dependencies
```
//M17SDK
implementation "com.m17ent:core:1.2.1"
implementation 'com.android.support:preference-v14'
    
//Kotlin
implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version"

//Android X
implementation 'androidx.appcompat:appcompat:1.1.0'
implementation 'androidx.core:core-ktx:1.1.0'

//ViewPager2
implementation 'androidx.viewpager2:viewpager2:1.0.0'

//Koin
implementation "org.koin:koin-android:$koin"

//Retrofit
implementation "com.squareup.okhttp3:okhttp:$okhttp"

//RxJava
implementation "io.reactivex.rxjava2:rxjava:$rxJava"

//Paging
implementation "androidx.paging:paging-runtime-ktx:$paging_version"
implementation "androidx.paging:paging-rxjava2:$paging_version"

//Constraint Layout
implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
```

## Application
### SDK Init
```
override fun onCreate() {
   super.onCreate()
   M17Sdk.getInstance().initSdkApplication(M17SdkConfig({"Input Your License"}))
}
```

### Get your license to Show Live List
 - M17Sdk.getInstance().getLicense(M17LicenseCallback {
               override fun onSuccess(license: M17License) {
                   ``` Handle Your License ```
                   ``` ex.license.getRegionlListFilterConfig() is M17ListFilterConfig ```
               }

               override fun onError(error: String) {
                    ``` Handle Your Error ```
               }
           })

### External User ID
 - An external user ID is used to associate with M17 account. There's some features require users binding their account to M17 account beforehand. In this case, you have to set your user id as your external user id. If the external user id haven't been set, the app will prompt an error message if the feature requires users binding 17 account.

    How to set it

    Just simply call updateExternalUserId(), a method of M17Sdk class.

    In practical, you can specify your user id to our SDK in two common cases,

       1.Update external user id after setting up M17Sdk.
       2.Update external user id once your user logged in and has a user id.

### Class Reference
 - (Interface) M17LiveCellBaseView - The view has to confirm this interface to implement in your custom live cell layout.

### How to get the custom Fragment of live list 
![](website/LiveListFragment.png)

### How to implement your custom layout of live cell
![](website/LiveCellBaseView.png)

### Set your proguard-rules.pro
```
# Core Module -- START
-keep class com.m17ent.core.dto.** { *; }
-keep class com.m17ent.core.module.**.dto.** { *; }
-keep class com.m17ent.core.module.sdk.** { *; }
-keep public class com.m17ent.core.module.common.activity.M17BaseActivity { *; }
-keep public class com.m17ent.core.module.common.fragment.M17BaseFragment { *; }
-keep interface * {
  <methods>;
}
# Core Module -- START

# Messaging Module -- START
-keep class com.m17ent.messaging.dto.** { *; }
-keep class com.m17ent.messaging.module.**.dto.** { *; }
-keep class com.m17ent.messaging.module.**.interface.** { *; }
-keep class com.m17ent.messaging.module.msgprovider.** { *; }
# Messaging Module -- END

#WANSU_CHAT -- START
-keep class com.wangsu.mts.** { *; }
#WANSU_CHAT -- END

# Pubnub -- START
-dontwarn org.slf4j.**
-dontwarn com.pubnub.**
-keep class com.pubnub.** { *; }
-dontnote retrofit2.Platform
-dontwarn retrofit2.Platform$Java8
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
-keepattributes Exceptions
# Pubnub -- END

# Ijk -- START
-keep class tv.danmaku.ijk.media.** { *; }
# Ijk -- END

#----------------------

# Koin
-keep public class * extends java.lang.Exception
-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}

# OkHttp3
-dontwarn okhttp3.internal.platform.ConscryptPlatform
-dontwarn org.codehaus.mojo.animal_sniffer.*
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

# Retrofit
-dontwarn ren.yale.android.retrofitcachelibrx2.**
-keep class ren.yale.android.retrofitcachelibrx2.** { *; }
-keepclasseswithmembernames class retrofit2.adapter.rxjava2.BodyObservable { *; }
-keepclasseswithmembernames class retrofit2.adapter.rxjava2.ResultObservable { *; }
-keepclasseswithmembernames class retrofit2.adapter.rxjava2.CallEnqueueObservable { *; }
-keepclasseswithmembernames class retrofit2.adapter.rxjava2.CallExecuteObservable { *; }
-keepclasseswithmembernames class retrofit2.Retrofit { *; }
-keepclasseswithmembernames class retrofit2.ServiceMethod { *; }
-keepclasseswithmembernames class retrofit2.OkHttpCall { *; }
-dontwarn javax.annotation.**
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

```

## Run your project


