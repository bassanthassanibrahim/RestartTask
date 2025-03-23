package com.example.restarttask.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.restarttask.domain.model.Question
import com.example.restarttask.R

@Composable
fun QuestionsScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Questions",color = Color(0xFF146D6D), style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 8.dp))

        val questions = listOf(
            Question("Events", "Task 2", ". How can I implement user authentication in Jetpack Compose?\n" +
                    "\n" +
                    ". What is the best way to design a responsive dashboard?", "11 answers", "13 May 2023"),
            Question("Work", "Task 4", ". How can I implement user authentication in Jetpack Compose?\n" +
                    "\n" +
                    ". What is the best way to design a responsive dashboard?", "8 answers", "20 June 2023"),
            Question("Events", "Task 2", ". How can I implement user authentication in Jetpack Compose?\n" +
                    "\n" +
                    ". What is the best way to design a responsive dashboard?", "11 answers", "13 May 2023"),
            Question("Events", "Task 2", ". How can I implement user authentication in Jetpack Compose?\n" +
                    "\n" +
                    ". What is the best way to design a responsive dashboard?", "11 answers", "13 May 2023"),
        )

        LazyColumn {
            items(questions) { question -> QuestionCard(question) }
        }
    }
}

@Composable
fun QuestionCard(question: Question) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp), elevation = CardDefaults.cardElevation(4.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(question.category, fontWeight = FontWeight.Bold)
                Text(question.task, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 8.dp))
            }
            Text(question.description, modifier = Modifier.padding(vertical = 8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Row {
                    Icon(painterResource(R.drawable.page), contentDescription = "Answers", modifier = Modifier.padding(top = 3.dp))
                    Text(question.answers, modifier = Modifier.padding(start = 4.dp))
                }
                Text(question.date)
            }
        }
    }
}