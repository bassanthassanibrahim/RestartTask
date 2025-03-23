package com.example.restarttask.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.restarttask.R
import com.example.restarttask.domain.model.StudyPartner


@Composable
fun ConnectScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Connect",color = Color(0xFF146D6D), style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 8.dp))
        Text("Suggested Study Partners : ",color = Color(0xFF146D6D), style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 8.dp))

        val partners = listOf(
            StudyPartner("Reem Sayed", "Yesterday", listOf("English", "Arabic", "French"),"Egypt","Female",26,"21/6/2025"),
            StudyPartner("Reem Sayed", "Yesterday", listOf("English", "Arabic", "French"),"Egypt","Female",26,"21/6/2025"),
            StudyPartner("Reem Sayed", "Yesterday", listOf("English", "Arabic", "French"),"Egypt","Female",26,"21/6/2025"),
            StudyPartner("Reem Sayed", "Yesterday", listOf("English", "Arabic", "French"),"Egypt","Female",26,"21/6/2025"),
            StudyPartner("Reem Sayed", "Yesterday", listOf("English", "Arabic", "French"),"Egypt","Female",26,"21/6/2025"),
        )

        LazyColumn {
            items(partners) { partner -> StudyPartnerCard(partner) }
        }
    }
}

@Composable
fun StudyPartnerCard(partner: StudyPartner) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp).background(Color.White), elevation = CardDefaults.cardElevation(4.dp)) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.partner),
                contentDescription = "Profile Picture",
                modifier = Modifier.size(50.dp)
            )
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(text = partner.name, color = Color(0xFF146D6D), style = MaterialTheme.typography.headlineMedium)
                Text("Last seen Online: ${partner.lastSeen}", style = MaterialTheme.typography.bodyMedium)
                Row {
                    partner.languages.forEach { lang ->
                        Text(lang, modifier = Modifier.padding(end = 4.dp).background(Color(0xffddfbfb)))
                    }
                }

            }
        }
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Default.LocationOn, contentDescription = "Location")
            Text(partner.location, modifier = Modifier.padding(start = 4.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Default.Person, contentDescription = "Gender")
            Text(partner.gender, modifier = Modifier.padding(start = 4.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Icon(painterResource(R.drawable.age), contentDescription = "Age")
            Text(partner.age.toString(), modifier = Modifier.padding(start = 4.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Default.DateRange, contentDescription = "Date")
            Text(partner.joinDate, modifier = Modifier.padding(start = 4.dp))
        }
    }
}
