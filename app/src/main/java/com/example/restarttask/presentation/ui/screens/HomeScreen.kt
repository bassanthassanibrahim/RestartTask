package com.example.restarttask.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.restarttask.R

@Composable
fun HomeScreen(userName: String) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Text(stringResource(R.string.home), color = Color(0xff146d6d), style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 8.dp))
            Text("Hi $userName",style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 8.dp))
            Text(stringResource(R.string.study), color = Color(0xff146d6d), style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 16.dp))

            val imageList = listOf(
                R.drawable.unite1,
                R.drawable.unite2,
                R.drawable.unite3,
                R.drawable.unite4,
                R.drawable.unite5
            )

            LazyColumn {
                items(imageList) { imageRes ->
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = "Sample Image",
                        modifier = Modifier.fillMaxWidth().height(150.dp).padding(8.dp)
                    )
                }
            }
        }
    }
}