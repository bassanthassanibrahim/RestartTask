package com.example.restarttask.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.Image
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.restarttask.R
import com.example.restarttask.domain.model.Tool

@Composable
fun ToolsScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Tools", color = Color(0xFF146D6D), style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 8.dp))

        val tools = listOf(
            Tool("Progress 100%", 100, R.drawable.tool),
            Tool("Progress 50%", 50, R.drawable.tool),
            Tool("Progress 50%", 50, R.drawable.tool),
            Tool("Progress 50%", 50, R.drawable.tool),
            Tool("Progress 50%", 50, R.drawable.tool),
            Tool("Progress 50%", 50, R.drawable.tool),
            Tool("Progress 50%", 50, R.drawable.tool),
            Tool("Progress 50%", 50, R.drawable.tool)
        )

        var selectedTool by remember { mutableStateOf(tools.first()) }

        LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
            items(tools) { tool ->
                ToolCard(tool, tool == selectedTool) { selectedTool = it }
            }
        }
    }
}

@Composable
fun ToolCard(tool: Tool, isSelected: Boolean, onClick: (Tool) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick(tool) },
        colors = CardDefaults.cardColors(containerColor = if (isSelected) Color.White else Color.LightGray),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.badge), contentDescription = "tools")
            Image(painter = painterResource(id = R.drawable.tool), contentDescription = "voyage", modifier = Modifier.padding(top = 8.dp))
            Text(tool.name, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 8.dp))
            LinearProgressIndicator(
                progress = { tool.progress / 100f },
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            )
        }
    }
}