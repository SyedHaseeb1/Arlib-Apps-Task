package com.hsb.task.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hsb.task.presentation.vm.SharedViewModel
import com.hsb.task.domain.utils.Extensions.name
import com.hsb.task.presentation.home.HomeScreen
import com.hsb.extensions_hsb.utils.globalextensions.Extensions.toast
import com.hsb.task.R
import com.hsb.task.presentation.components.UiHelpers

object LoginScreen {
    @Composable
    fun LoginScreenUI(
        navController: NavHostController?,
        viewModel: SharedViewModel = hiltViewModel()
    ) {
        val context = LocalContext.current
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // App Icon
            AppIcon(Modifier.size(200.dp))

            // App Name
            AppName(context.getString(R.string.app_name))

            UiHelpers.SimpleText(text = "A Simple Task App By Syed Haseeb For Arlib Apps")

            Spacer(modifier = Modifier.height(32.dp))
            UiHelpers.HeadingLargeText(text = "LogIn Here")

            // Username Input
            LoginInputField(
                value = username,
                onValueChange = { username = it },
                label = "Username"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password Input
            LoginInputField(
                value = password,
                onValueChange = { password = it },
                label = "Password"
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Login Button
            LoginButton(onClick = {
                if (username.isBlank()) {
                    context.toast("Please enter a username") // Show a toast message if the username is empty
                } else {
                    // Fetch data only if the list is empty
                    if (viewModel.drugsList.isEmpty()) {
                        viewModel.fetchDrugsFromApi()
                    }
                    context.toast("Login Successful")
                    // Perform login logic here
                    viewModel.setUsername(username)
                    navController?.navigate(HomeScreen.name()) // Navigate to HomeScreen after login
                }
            })

        }
    }


    @Composable
    fun AppIcon(modifier: Modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.ic_app_icon_square),
            contentDescription = "App Icon",
            modifier = modifier
        )
    }

    // AppName.kt
    @Composable
    fun AppName(appName: String, modifier: Modifier = Modifier) {
        Text(
            text = appName,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )
    }

    // LoginInputField.kt
    @Composable
    fun LoginInputField(
        value: String,
        onValueChange: (String) -> Unit,
        label: String,
        modifier: Modifier = Modifier
    ) {
        OutlinedTextField(
            value = value,
            maxLines = 1,
            singleLine = true,
            onValueChange = onValueChange,
            label = { Text(label) },
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
    }

    // LoginButton.kt
    @Composable
    fun LoginButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
        Button(
            onClick = onClick,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Login")
        }
    }
}