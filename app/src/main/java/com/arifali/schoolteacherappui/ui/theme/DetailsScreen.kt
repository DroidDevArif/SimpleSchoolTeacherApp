package com.arifali.schoolteacherappui.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.arifali.schoolteacherappui.R

@Composable
fun DetailsScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF945DCF))
    ) {
        Column {
            TeacherHeader()
            TeacherInfo()
        }
    }
}

@Composable
fun  TeacherHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.teacher5),
            contentDescription = "Teacher Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                contentDescription = "Back",
                modifier = Modifier
                    .size(60.dp)
                    .padding(8.dp)
                    .clickable {

                    }
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_share_24),
                contentDescription = "Back",
                modifier = Modifier
                    .size(60.dp)
                    .padding(8.dp)
                    .clickable {

                    }
            )
        }
    }
}

@Composable
fun   TeacherInfo() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Color.White)
            .padding(20.dp)
    ) {
        item {
            Text("Mr.Sarvjeet Singh Sir", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Mathematics", color = Color.Gray)
            Text("New Delhi", color = Color.Gray)

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                StatItem(icon = Icons.Filled.Person, value = "500+", label = "Students")
                StatItem(icon = Icons.Filled.Star, value = "4 Years +", label = "Experience")
                StatItem(icon = Icons.Filled.Star, value = "4.5", label = "Rating")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Biography", fontWeight = FontWeight.Bold)
            Text(
                "A board-certified with over 5 years of experience,.",
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ActionButton(icon = painterResource(id = R.drawable.baseline_sms_24), label = "Message")
                ActionButton(icon = painterResource(id = R.drawable.baseline_call_24), label = "Call")
                ActionButton(icon = painterResource(id = R.drawable.baseline_directions_24), label = "Direction")
                ActionButton(icon = painterResource(id = R.drawable.baseline_share_24), label = "Share")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Handle appointment */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF945DCF))
            ) {
                Text("Make Appointment", color = Color.White)
            }
        }
    }
}

@Composable
fun StatItem(icon: ImageVector, value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = null, tint = Color(0xFF945DCF))
        Text(value, fontWeight = FontWeight.Bold)
        Text(label, color = Color.Gray, fontSize = 12.sp)
    }
}

@Composable
fun ActionButton(icon: Painter, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = icon,
            contentDescription = "",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color(0xFFF0EFF4))
                .padding(8.dp)
        )
        Text(label, fontSize = 12.sp)
    }
}