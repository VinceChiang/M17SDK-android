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
implementation "com.m17ent:core:1.0.11"
implementation "com.m17ent:messaging:1.0.3"
implementation "com.m17ent:player:1.0.2"
implementation 'com.android.support:preference-v14'
    
//Kotlin
implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version"

//Android X
implementation 'androidx.appcompat:appcompat:1.1.0'
implementation 'androidx.core:core-ktx:1.1.0'

//Gson
implementation "com.google.code.gson:gson:$gson_version"

//Koin
implementation "org.koin:koin-android:$koin"
implementation "org.koin:koin-androidx-scope:$koin"
implementation "org.koin:koin-androidx-viewmodel:$koin"

//Retrofit
implementation "com.squareup.okhttp3:okhttp:$okhttp"
implementation "com.squareup.okhttp3:logging-interceptor:$loggingInterceptor"
implementation "com.squareup.retrofit2:retrofit:$retrofit"
implementation "com.squareup.retrofit2:adapter-rxjava2:$retrofit"
implementation "com.squareup.retrofit2:converter-gson:$retrofit"
implementation "ren.yale.android:retrofitcachelibrx2:$retrofitcachelibrx2"

//RxJava
implementation "io.reactivex.rxjava2:rxjava:$rxJava"
implementation "io.reactivex.rxjava2:rxkotlin:$rxKotlin"
implementation "io.reactivex.rxjava2:rxandroid:$rxAndroid"
implementation "com.jakewharton.rxbinding2:rxbinding:$rxBinding"
implementation "org.jetbrains.kotlin:kotlin-reflect:$kotlin_version"

//Timber
implementation "com.jakewharton.timber:timber:$timber"

//Paging
implementation "androidx.paging:paging-runtime-ktx:$paging_version"
implementation "androidx.paging:paging-rxjava2:$paging_version"
```

## Application
### SDK Init
```
override fun onCreate() {
   super.onCreate()
   M17Sdk.getInstance().initSdk(M17SdkConfig({"Input Your License"}))
}
```

### Set Your UserId
 - M17Sdk.getInstance().setUser({"Input Your UserId"})

### Class Reference
 - (Class) M17LiveListConfig - To create the configuration for live list fragment.
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

# Retrofit https://github.com/yale8848/RetrofitCache
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

# Gson specific classes
-dontwarn sun.misc.**
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

```

## Run your project


