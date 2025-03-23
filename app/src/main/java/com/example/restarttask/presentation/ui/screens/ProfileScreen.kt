package com.example.restarttask.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import coil.compose.AsyncImage
import androidx.compose.material3.*
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.example.restarttask.R

@Composable
fun ProfileScreen() {
    val user = FirebaseAuth.getInstance().currentUser

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = user?.photoUrl ?: R.drawable.avatar,
            contentDescription = "User Avatar",
            error = painterResource(id = R.drawable.avatar),
            placeholder = painterResource(id = R.drawable.avatar),
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )


        Spacer(modifier = Modifier.height(16.dp))

        // Name
        Text(
            text = user?.displayName ?: "Unknown User",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Email
        Text(
            text = "Email: ${user?.email ?: "Not Available"}",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Phone Number (if available)
        Text(
            text = "Phone: ${user?.phoneNumber ?: "Not Available"}",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
