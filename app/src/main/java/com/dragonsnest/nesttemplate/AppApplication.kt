package com.dragonsnest.nesttemplate

import android.app.Application
import android.util.Log
import com.amplifyframework.AmplifyException
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.kotlin.core.Amplify
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppApplication : Application() {

    companion object {
        private const val TAG = "AppApplication"
    }

    override fun onCreate() {
        super.onCreate()

        try {
            Log.i(TAG, "onCreate: Initialized Amplify")
        } catch (exception: AmplifyException) {
            Log.e(TAG, "onCreate: Could not initialize Amplify", exception)
        }
    }
}
