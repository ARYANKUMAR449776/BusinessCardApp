package com.example.businescardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businescardapp.ui.theme.BusinesCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinesCardAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun BusinessCard(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileSection(name = "Full name", title = "Title")
    }
}


@Composable
fun ProfileSection(name: String,title:String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()

    )
    {
        Image(
            painter = painterResource(R.drawable.profile),

            contentDescription = "Profile Image" ,
            modifier = Modifier.size(150.dp)
                               .fillMaxWidth()
                                .align(Alignment.CenterHorizontally)

        )
        Text(
            text = name,
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = modifier.fillMaxWidth(),

        )
        Text(
            text = title,
            fontSize = 23.sp,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth()


        )
        ContactSection()


    }


}


@Composable
fun ContactSection(){
    Column (
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        ContactInfo(imageRes = R.drawable.phone, contactDescription = "+00 (00)-000-000")
        ContactInfo(imageRes = R.drawable.email, contactDescription = "@socialMediaHandle")
        ContactInfo(imageRes = R.drawable.social, contactDescription = "email@doeail.com")    }

}

@Composable
fun ContactInfo(imageRes:Int,contactDescription:String){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 90.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "phoneImage",

        )
        Text(
            text = contactDescription

        )
    }

}


@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinesCardAppTheme {
    BusinessCard(modifier = Modifier.fillMaxSize())
    }
}



