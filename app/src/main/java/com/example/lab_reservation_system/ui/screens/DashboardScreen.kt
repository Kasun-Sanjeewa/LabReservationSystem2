package com.example.lab_reservation_system.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DashboardScreen(navController: NavController) {
    var selectedDepartment by remember { mutableStateOf("Information Communication Tech...") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
    ) {
        Scaffold(
            backgroundColor = Color(0xFF1A1A1A),
            topBar = {
                TopAppBar(
                    backgroundColor = Color(0xFF1A1A1A),
                    elevation = 0.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Dashboard",
                            fontSize = 28.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        IconButton(onClick = { /* Handle notification */ }) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = "Notifications",
                                tint = Color.White
                            )
                        }
                    }
                }
            },
            bottomBar = {
                BottomNavigation(
                    backgroundColor = Color(0xFF2A2A2A),
                    elevation = 16.dp
                ) {
                    BottomNavigationItem(
                        icon = { Icon(Icons.Default.Home, "Home") },
                        selected = true,
                        onClick = { },
                        selectedContentColor = Color(0xFF41B6A6),
                        unselectedContentColor = Color.Gray
                    )
                    BottomNavigationItem(
                        icon = { Icon(Icons.Default.Add, "History") },
                        selected = false,
                        onClick = { },
                        selectedContentColor = Color(0xFF41B6A6),
                        unselectedContentColor = Color.Gray
                    )
                    BottomNavigationItem(
                        icon = { Icon(Icons.Default.Check, "Calendar") },
                        selected = false,
                        onClick = { },
                        selectedContentColor = Color(0xFF41B6A6),
                        unselectedContentColor = Color.Gray
                    )
                    BottomNavigationItem(
                        icon = { Icon(Icons.Default.Settings, "Settings") },
                        selected = false,
                        onClick = { },
                        selectedContentColor = Color(0xFF41B6A6),
                        unselectedContentColor = Color.Gray
                    )
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                // Department Dropdown
                Button(
                    onClick = { /* Handle dropdown */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF2A2A2A)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = selectedDepartment,
                            color = Color.White,
                            fontSize = 14.sp
                        )
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "Dropdown",
                            tint = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "TODAY'S SCHEDULE",
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(4) {
                        ScheduleCard()  // Replaced "Schedule" with "ScheduleCard"
                    }
                }
            }
        }
    }
}

@Composable
fun ScheduleCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color(0xFF2A2A2A),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Date Column
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "JUNE",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "10",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "2024",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }

                // Details Column
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Operating System",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = "8:00 AM - 10:00 AM",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = "SF 01",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = "1st Year",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Button(
                onClick = { /* Handle check */ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF41B6A6)
                ),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = "Check",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }
    }
}
