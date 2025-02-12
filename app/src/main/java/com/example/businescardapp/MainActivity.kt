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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
              BusinessCard(modifier = Modifier)
            }
        }
    }
}


@Composable
fun BusinessCard(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFD2E8D4))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileSection(name = "Jennifer Doe", title = "Android Developer Extraordinaire")
    }
}


@Composable
fun ProfileSection(name: String,title:String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
            .padding(top = 250.dp)
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
            modifier = modifier.fillMaxWidth()
                .padding(bottom = 10.dp)
                .padding(top = 10.dp)
        )
        Text(
            text = title,
            color = Color(0xFF006D3B),
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth()



        )
        ContactSection()


    }


}

@Composable
fun ContactSection(){
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 70.dp, vertical = 30.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom
    ){
        ContactInfo(imageRes = R.drawable.phone, contactDescription = "+11 (123) 444 555 666")
        ContactInfo(imageRes = R.drawable.email, contactDescription = "@AndroidDev")
        ContactInfo(imageRes = R.drawable.social, contactDescription = "jen.doe@android.com")
    }
}


@Composable
fun ContactInfo(imageRes:Int,contactDescription:String){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.wrapContentSize()
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Image",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
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



