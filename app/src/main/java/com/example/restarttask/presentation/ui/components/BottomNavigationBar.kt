package com.example.restarttask.presentation.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.restarttask.Constants
import com.example.restarttask.R
import com.example.restarttask.currentRoute
import com.example.restarttask.domain.model.BottomNavItem

@Composable
fun BottomNavigationBar(navController: NavController, onShowTooltip: (String, Dp) -> Unit) {
    val items = listOf(
        BottomNavItem("home", "Home", Icons.Filled.Home, Constants.HOME_OVERLAY),
        BottomNavItem("connect", "Connect", Icons.Filled.Face, Constants.CONNECT_OVERLAY),
        BottomNavItem("questions", "Questions", Icons.Filled.Info, Constants.QUESTIONS_OVERLAY),
        BottomNavItem("tools", "Tools", Icons.Filled.Build, Constants.TOOLS_OVERLAY),
        BottomNavItem("profile", "Profile", Icons.Filled.AccountCircle, Constants.PROFILE_OVERLAY)
    )
    val currentRoute = currentRoute(navController)

    NavigationBar {
        items.forEachIndexed { index, item ->
            val selected = currentRoute == item.route
            NavigationBarItem(
                label = {
                    Text(
                        text = item.label,
                        color = if (selected) Color.Cyan else Color.Gray,
                        fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
                    )
                },
                selected = selected,
                onClick = {
                    onShowTooltip(item.overlay, (index * 60).dp)
                    navController.navigate(item.route) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        tint = if (selected) Color.Cyan else Color.Gray
                    )
                }
            )
        }
    }
}