package com.example.rentcare


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rentcare.Components.CButton
import com.example.rentcare.ui.theme.Indigo
import com.example.rentcare.ui.theme.SkyBlue
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun YourUnit(navController: NavController) {
    val notification = rememberSaveable{ mutableStateOf("") }
    if(notification.value.isNotEmpty()){
        Toast.makeText(LocalContext.current,notification.value,Toast.LENGTH_LONG).show()
        notification.value = ""
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(8.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            //here add the back arrow
            Icon(
                imageVector = Icons.Default.ArrowBack, // Use the back arrow icon
                contentDescription = null, // Content description can be null for decorative icons
                modifier = Modifier
                    .size(24.dp) // Set the size of the icon
                    .clickable {
                        // Handle back arrow click action (e.g., navigate back)
                        navController.navigate(Screen.FindUnit.route) {
                            popUpTo(Screen.FindUnit.route) {
                                inclusive = true
                            }
                        }
                    }
            )

            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "   ${MainActivity.unitDetails?.flatname} Unit Details",
                    modifier = Modifier
                        .fillMaxWidth(.9f)
                        .border(2.dp, Color.Blue, shape = RoundedCornerShape(8.dp)),
                    //.background(color = Indigo, shape = RoundedCornerShape(8.dp)),
                    style = TextStyle(
                        fontSize = 25.sp, // Set the font size
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue // Set the text color
                    )
                )
            }

        }

        Row(
        )
        {
            Text(
                text = "Owner Info",
                color = Color.Blue,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 8.dp
                )
            )
        }
        Text(
            text = "Name : ${MainActivity.unitDetails?.name}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp)
//                .background(color = SkyBlue,
//                    shape = RoundedCornerShape(8.dp)) // Set the background color of the box
                .border(
                    2.dp,
                    Color.White,
                    shape = RoundedCornerShape(8.dp)
                ) // Set the border of the box
                .padding(8.dp), // Add padding inside the box
            style = TextStyle(
                fontSize = 20.sp, // Set the font size
                fontWeight = FontWeight.Bold,
                color = Color.Black // Set the text color
            )
        )
        Text(
            text = "Email : ${MainActivity.unitDetails?.email}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp)
//                .background(color = SkyBlue,
//                    shape = RoundedCornerShape(8.dp)) // Set the background color of the box
                .border(
                    2.dp,
                    Color.White,
                    shape = RoundedCornerShape(8.dp)
                ) // Set the border of the box
                .padding(8.dp), // Add padding inside the box
            style = TextStyle(
                fontSize = 20.sp, // Set the font size
                fontWeight = FontWeight.Bold,
                color = Color.Black // Set the text color
            )
        )
        Text(
            text = "bkash number : ${MainActivity.unitDetails?.bkash}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp)
//                .background(
//                    color = SkyBlue,
//                    shape = RoundedCornerShape(8.dp) // Set the rounded corners
//                ) // Set the background color of the box
                .border(
                    2.dp,
                    Color.White,
                    shape = RoundedCornerShape(8.dp)
                ) // Set the border of the box
                .padding(8.dp), // Add padding inside the box
            style = TextStyle(
                fontSize = 20.sp, // Set the font size
                fontWeight = FontWeight.Bold,
                color = Color.Black // Set the text color
            )
        )
        Row(
        )
        {
            Text(
                text = "Payment Status",
                color = Indigo,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 8.dp
                )
            )
        }
        Text(
            text = "Rent Bill : ${MainActivity.unitDetails?.rent}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 20.dp)
//                .background(color= SkyBlue,
//                    shape = RoundedCornerShape(8.dp)) // Set the background color of the box
                .border(
                    2.dp,
                    Color.White,
                    shape = RoundedCornerShape(8.dp)
                ) // Set the border of the box
                .padding(8.dp), // Add padding inside the box
            style = TextStyle(
                fontSize = 20.sp, // Set the font size
                fontWeight = FontWeight.Bold,
                color = Color.Black // Set the text color
            )
        )
        Text(
            text = "Gas and others : ${MainActivity.unitDetails?.gas}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp)
//                .background(color= SkyBlue,
//                    shape = RoundedCornerShape(8.dp)) // Set the background color of the box
                .border(
                    2.dp,
                    Color.White,
                    shape = RoundedCornerShape(8.dp)
                )// Set the border of the box
                .padding(8.dp), // Add padding inside the box
            style = TextStyle(
                fontSize = 20.sp, // Set the font size
                fontWeight = FontWeight.Bold,
                color = Color.Black // Set the text color
            )
        )

        BillStatusBox(isPaid = false, modifier = Modifier.align(Alignment.CenterHorizontally))
        CButton(text = "Pay Now", onClick = {

        },
            containerColor = SkyBlue
        )
        Row(
        )
        {
            Text(
                text = "Due Clear?",
                color = Indigo,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 8.dp
                )
            )
            CButton(text = "Notify Owner", onClick = {

            },
                containerColor = Color.DarkGray
            )
        }
        // Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun BillStatusBox(isPaid: Boolean, modifier: Modifier = Modifier) {
    val backgroundColor = if (isPaid) {
        Color.Green // Change to your desired color for paid bills
    } else {
        Color.Red // Change to your desired color for due bills
    }

    Box(
        modifier = modifier
            .size(100.dp, 50.dp)
            .background(backgroundColor)
    ) {
        // Display the "Paid" or "Due" text inside the box
        Text(
            text = if (isPaid) "Paid" else "Due",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun YourUnitPre() {
    val navController = rememberNavController()
    YourUnit(navController)
}