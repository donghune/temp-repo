package com.dragonsnest.presenter.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.lifecycle.lifecycleScope
import com.amplifyframework.auth.AuthProvider.facebook
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.kotlin.core.Amplify
import com.dragonsnest.presenter.R
import com.dragonsnest.presenter.databinding.ViewOauthFacebookBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val users = viewModel.userList.collectAsState()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(ScrollState(0))
            ) {
                AndroidViewBinding(
                    modifier = Modifier.fillMaxWidth(),
                    factory = ViewOauthFacebookBinding::inflate
                )

                Button(
                    onClick = {
                        viewModel.fetchUser()
                    }
                ) {
                    Text("Search User")
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    users.value.forEach { UserCard(it) }
                }
            }
        }
    }

    private fun openAuthLoginPage() {
        lifecycleScope.launch {
            flowOf(Amplify.Auth.signInWithSocialWebUI(facebook(), this@MainActivity))
                .catch { Log.e("AuthQuickstart", "Sign in failed", it) }
                .collect { Log.i("AuthQuickstart", "Sign in OK: $it") }
        }
    }

    private fun checkAuthSession() {
        lifecycleScope.launch {
            flowOf(Amplify.Auth.fetchAuthSession())
                .catch { Log.e(TAG, "onCreate: failed to fetch auth session", it) }
                .collect { Log.i(TAG, "onCreate: auth session = $it") }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == AWSCognitoAuthPlugin.WEB_UI_SIGN_IN_ACTIVITY_CODE) {
            data?.let { Amplify.Auth.handleWebUISignInResponse(it) }
            checkAuthSession()
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
