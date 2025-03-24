package com.example.restarttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    var tooltipText by remember { mutableStateOf<String?>(null) }
    var tooltipOffset by remember { mutableStateOf(0.dp) }

    val currentRoute by navController.currentBackStackEntryAsState()

    // Show overlay when navigating to home
    LaunchedEffect(currentRoute?.destination?.route) {
        currentRoute?.destination?.route?.let { route ->
            when (route) {
                "home" -> {
                    tooltipText = Constants.HOME_OVERLAY
                }
                "connect" -> {
                    tooltipText = Constants.CONNECT_OVERLAY
                }
                "questions" -> {
                    tooltipText = Constants.QUESTIONS_OVERLAY
                }
                "tools" -> {
                    tooltipText = Constants.TOOLS_OVERLAY
                }
                "profile" -> {
                    tooltipText = Constants.PROFILE_OVERLAY
                }
                else -> tooltipText = null
            }
        }
    }

    Box {
        Scaffold(
            bottomBar = {
                val current = navController.currentBackStackEntryAsState().value?.destination?.route
                if (current != "login") {
                    BottomNavigationBar(navController) { text, offset ->
                        tooltipText = text
                        tooltipOffset = offset
                    }
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

        // Overlay inside Box to ensure it displays properly
        TooltipOverlay(tooltipText, tooltipOffset, onDismiss = { tooltipText = null })
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Composable
fun TooltipOverlay(
    tooltipText: String?,
    yOffset:Dp,
    onDismiss: () -> Unit
) {
    if (tooltipText != null) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.4f))
                .clickable { onDismiss()}
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(x = (-40).dp,y = (-150).dp) // Move it above bottom bar
                    .padding(start = yOffset)
                    .background(Color(0xFF2C2C2C), shape = RoundedCornerShape(8.dp))
                    .padding(10.dp)
            ) {
                Text(tooltipText, color = Color.White, fontSize = 14.sp)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewBottomNavigationApp() {
    BottomNavigationApp()
}