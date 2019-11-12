# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keepattributes Exceptions, InnerClasses, Signature, Deprecated, SourceFile, LineNumberTable, *Annotation*, EnclosingMethod

-keep class com.google.android.gms.ads.identifier.** { *; }
-keep class com.google.android.gms.vision.** { *; }
-keep interface com.google.android.gms.vision.** { *; }
-keep interface com.google.android.gms.common.** { *; }
-keep class com.google.android.gms.** { *; }
-keep class com.google.firebase.** { *; }
-keep class androidx.** {*;}

# Platform
-keep class com.machipopo.media17.sdk.module.**.dto.** { *; }
-keep class com.machipopo.media17.sdk.module.sdk.** { *; }
-keep interface com.machipopo.media17.sdk.module.sdk.** { *; }

# enum
-keepclassmembers enum * { *; }

# koin
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

# Ijk
-keep class tv.danmaku.ijk.media.** { *; }

# Glide
-dontwarn com.bumptech.glide.**
-keep class com.bumptech.glide.** {*;}

# PubNub
-dontwarn com.pubnub.**
-keep class com.pubnub.** { *; }
