package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFCD853F) // Light brown color
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val image = painterResource(id = R.drawable.android_logo)
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .height(120.dp)
                    .width(150.dp)
            )
            Text(text = stringResource(R.string.name_surname), color = Color.White)
            Text(text = stringResource(R.string.business), color = Color(0xFF3ddc84))

            Spacer(modifier = Modifier.height(32.dp))

            ContactInfo()
        }
    }
}

@Composable
fun ContactInfo() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ContactItem(iconId = R.drawable.ic_baseline_local_phone_24, text = stringResource(R.string.phone_number))
        ContactItem(iconId = R.drawable.ic_baseline_email_24, text = stringResource(R.string.email_text))
        ContactItem(iconId = R.drawable.ic_baseline_share_24, text = stringResource(R.string.share_text))
    }
}

@Composable
fun ContactItem(iconId: Int, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val icon = painterResource(id = iconId)
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.padding(start = 16.dp),
            tint = Color(0xFF3ddc84)
        )
        Text(text = text, modifier = Modifier.padding(start = 16.dp), color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}
