package com.arifali.schoolteacherappui.ui.theme

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.arifali.schoolteacherappui.Navigation.Route
import com.arifali.schoolteacherappui.R

@Composable
fun HomeScreen(navController: NavHostController) {
    val backgroundColor = Color(0xFFECEFF1)
    Scaffold(
        topBar = { AppTopBar() },
        bottomBar = { BottomNavigation(navController) }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(backgroundColor)
        ) {
            item {
                BookingCard() // Add the BookingCard as the first item
            }
            item {
                TeacherSpecialities() // Add the DoctorSpecialities section
            }
            item {
                Spacer(modifier = Modifier.height(16.dp)) // Add space between sections
            }
            item {
                TopTeachers() // Add the TopDoctors section
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {

    TopAppBar(
        title = {
            Column {
                Text("Hello,Arif Ali", fontWeight = FontWeight.Bold)
                Text("How Are You Today", fontSize = 12.sp, color = Color.Gray)
            }
        },
        actions = {
            Image(
                painter = painterResource(id = R.drawable.baseline_doorbell_24),
                contentDescription = "Back",
                modifier = Modifier
                    .size(60.dp)
                    .padding(8.dp)
                    .clickable {

                    }
            )
        },
        modifier = Modifier.padding(top = 18.dp)
    )
}

@Composable
fun BookingCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.schoolpng),
            contentDescription = "Promotional image",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun TeacherSpecialities() {
    Column {
        Text(
            "Teacher Speciality",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp),
            fontSize = 18.sp
        )
        LazyRow {
            items(5) { index ->
                SpecialityItem(
                    icon = when (index) {
                        0 -> R.drawable.sub1
                        1 -> R.drawable.sub2
                        2 -> R.drawable.sub3
                        3 -> R.drawable.sub4
                        else -> R.drawable.sub5
                    },
                    name = when (index) {
                        0 -> "Sociology"
                        1 -> "Mathematics"
                        2 -> "Biology"
                        3 -> "Chemistry"
                        else -> "Physics"
                    }
                )
            }
        }
    }
}

@Composable
fun SpecialityItem(icon: Int, name: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = name,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color(0xFFF0EFF4))
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(name, fontSize = 12.sp)
    }
}

@Composable
fun TopTeachers() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Top Teachers", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            TextButton(onClick = { /* Handle See All */ }) {
                Text("See all")
            }
        }
        LazyRow {
            items(5) { index ->
                DoctorCard(
                    name = when (index) {
                        0 -> "Mr.Govind Kumar Sir"
                        1 -> "Mr.Rajesh Singh Sir"
                        2 -> "Mr.Sarvjeet Singh Sir"
                        3 -> "Mrs.Mona Singh"
                        4 -> "Mr.Javed Khan Sir"
                        else -> ""
                    },
                    specialty = when (index) {
                        0 -> "Chemistry"
                        1 -> "Biology"
                        2 -> "Mathematics"
                        3 -> "Physics"
                        4 -> "Commerce"
                        else -> ""
                    },
                    rating = when (index) {
                        0 -> 4.3f
                        1 -> 4.7f
                        2 -> 4.5f
                        3 -> 4.8f
                        4 -> 4.6f
                        else -> 0f
                    },
                    experience = when (index) {
                        0 -> "4 Years"
                        1 -> "6 Years"
                        2 -> "5 Years"
                        3 -> "7 Years"
                        4 -> "8 Years"
                        else -> ""
                    },
                    imageRes = when (index) {
                        0 -> R.drawable.math
                        1 -> R.drawable.teacher3
                        2 -> R.drawable.teacher4
                        3 -> R.drawable.youngerteacher
                        4 -> R.drawable.teacher2
                        else -> R.drawable.teacher5 // Placeholder image in case of missing data
                    }
                )
            }
        }
    }
}

@Composable
fun DoctorCard(name: String, specialty: String, rating: Float, experience: String, imageRes: Int) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp).background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Doctor",
                modifier = Modifier
                    .size(120.dp)
                    .width(140.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(name, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(specialty, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Filled.Star, contentDescription = "Rating", tint = Color.Yellow)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text("$rating")
                }
                Spacer(modifier = Modifier.width(32.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.education),
                        contentDescription = "experience",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(experience)
                }
            }
        }
    }
}

@Composable
fun BottomNavigation(navController: NavHostController) {
    val context= LocalContext.current
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Explorer") },
            selected = true,
            onClick = { /* Handle navigation */ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = "Wishlist") },
            label = { Text("Wishlist") },
            selected = false,
            onClick = {
                navController.navigate(Route.CartScreen.name)
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
            label = { Text("Settings") },
            selected = false,
            onClick = {
                Toast.makeText(context,"Coming Soon ",Toast.LENGTH_SHORT).show()
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = "Account") },
            label = { Text("Account") },
            selected = false,
            onClick = {  Toast.makeText(context,"Coming Soon ",Toast.LENGTH_SHORT).show()
            }
        )
    }
}
