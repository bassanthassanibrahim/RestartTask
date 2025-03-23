package com.example.restarttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.runtime.*
import androidx.navigation.compose.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.restarttask.presentation.ui.components.BottomNavigationBar
import com.example.restarttask.presentation.ui.screens.ConnectScreen
import com.example.restarttask.presentation.ui.screens.HomeScreen
import com.example.restarttask.presentation.ui.screens.LoginScreen
import com.example.restarttask.presentation.ui.screens.ProfileScreen
import com.example.restarttask.presentation.ui.screens.QuestionsScreen
import com.example.restarttask.presentation.ui.screens.ToolsScreen
import com.example.restarttask.ui.theme.RestartTaskTheme
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RestartTaskTheme {
                BottomNavigationApp()
            }
        }
    }
}

@Composable
fun BottomNavigationApp() {
    val navController = rememberNavController()
    val userName = FirebaseAuth.getInstance().currentUser?.displayName ?: "User"

    Scaffold(
        bottomBar = {
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
            if (currentRoute != "login") {
                BottomNavigationBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "login",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("login") { LoginScreen(navController) }
            composable("home") { HomeScreen(userName) }
            composable("connect") { ConnectScreen() }
            composable("questions") { QuestionsScreen() }
            composable("tools") { ToolsScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}


@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomNavigationApp() {
    BottomNavigationApp()
}