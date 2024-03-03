package com.example.rentcare

import android.content.ContentValues.TAG
import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.rentcare.Components.CButton
import com.example.rentcare.ui.theme.Indigo
import com.example.rentcare.ui.theme.SkyBlue
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpOwner(
    navController: NavController
) {
    val toastContext = LocalContext.current
    val BASE_URL = "http://192.168.43.186:5001/"
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
    var nam = remember { mutableStateOf(TextFieldValue()) }
    var address = remember { mutableStateOf(TextFieldValue()) }
    var mobile = remember { mutableStateOf(TextFieldValue()) }
    var email = remember { mutableStateOf(TextFieldValue()) }
    var bkash = remember { mutableStateOf(TextFieldValue()) }
    var password = remember { mutableStateOf(TextFieldValue()) }
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box() {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(80.dp))
                Text(
                    text = "Sign Up",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(500),
                        color = Indigo
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                //Spacer(modifier = Modifier.height(120.dp))
            }
        }
        Box(){

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(top = 50.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(110.dp))
                OutlinedTextField(
                    value =nam.value,
                    onValueChange ={nam.value=it},
                    singleLine = true,
                    label = { Text(text = "Name") },
                    //colors = TextFieldDefaults.colors(),
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                    shape = RoundedCornerShape(15.dp),
                    )

                OutlinedTextField(
                    value =address.value,
                    onValueChange ={ address.value = it},
                    singleLine = true,
                    label = { Text(text = "Address") },
                    //colors = TextFieldDefaults.colors(),
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                    shape = RoundedCornerShape(15.dp),

                    )
                OutlinedTextField(
                    value =mobile.value ,
                    onValueChange ={ mobile.value=it},
                    singleLine = true,
                    label = { Text(text = "Mobile") },
                    //colors = TextFieldDefaults.colors(),
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                    shape = RoundedCornerShape(15.dp),
                    )
                OutlinedTextField(
                    value =email.value ,
                    onValueChange ={ email.value=it},
                    singleLine = true,
                    label = { Text(text = "Email") },
                    //colors = TextFieldDefaults.colors(),
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                    shape = RoundedCornerShape(15.dp),
                    )
                OutlinedTextField(
                    value =bkash.value ,
                    onValueChange ={ bkash.value=it},
                    singleLine = true,
                    label = { Text(text = "BKASH number") },
                    //colors = TextFieldDefaults.colors(),
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                    shape = RoundedCornerShape(15.dp),

                    )
                OutlinedTextField(
                    value =password.value ,
                    onValueChange ={ password.value=it},
                    singleLine = true,
                    label = { Text(text = "Password") },
                    //colors = TextFieldDefaults.colors(),
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
                    shape = RoundedCornerShape(15.dp),

                    )

                Spacer(modifier = Modifier.height(10.dp))
                CButton(text = "Sign Up", onClick = {
                    // Create a RenterInfo object with the entered data
                    val ownerInfo = OwnerInfo(
                        name = nam.value.text,
                        address = address.value.text,
                        email = email.value.text,
                        mobile = mobile.value.text,
                        bkash = bkash.value.text,
                        password = password.value.text,
                    )
                    // Make the PUT request
                    apiService.InputOwnerInfo(ownerInfo).enqueue(object : Callback<Void> {
                        override fun onResponse(call: Call<Void>, response: Response<Void>) {
                            if (response.isSuccessful) {
                                navController.navigate(Screen.FindAUnit.route){
                                    popUpTo(Screen.FindAUnit.route){
                                        inclusive = true
                                    }
                                }
                            } else {
                                // Handle error
                                val errorMessage = "Error: ${response.code()}"
                                // Show error message to the user
                                showToast(toastContext,errorMessage)
                            }
                        }

                        override fun onFailure(call: Call<Void>, t: Throwable) {
                            val errorMessage = "Failed to update: ${t.localizedMessage}"
                            // Show error message to the user
                            showToast(toastContext,errorMessage)
                        }
                    })
//                    navController.navigate(Screen.FindAUnit.route){
//                        popUpTo(Screen.FindAUnit.route){
//                            inclusive = true
//                        }
//                    }

                })

                Row(modifier = Modifier.padding(top = 12.dp,bottom = 40.dp)) {
                    Text("Already have an account?",
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                    )
                    Text("Sign in",
                        style= TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight(800),
                            color = Color.Black
                        ),
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.Login.route){
                                popUpTo(Screen.Login.route){
                                    inclusive = true
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

private fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}



