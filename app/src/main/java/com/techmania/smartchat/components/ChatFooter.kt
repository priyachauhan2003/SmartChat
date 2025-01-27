package com.techmania.smartchat.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@Composable
fun ChatFooter(
    onClick: (text: String)->Unit
) {
    var inputText by remember{
            mutableStateOf("")
    }
    val controller = LocalSoftwareKeyboardController.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .offset(0.dp, -50.dp)
            .background(Color.LightGray)
            .padding(10.dp)
    ){
        OutlinedTextField(value = inputText, onValueChange = {inputText=it},
            placeholder = { Text(text = "Enter your query") },
            singleLine = true,
            modifier = Modifier
                .weight(1f)
                .background(Color.Gray)
        )

        IconButton(onClick ={
            onClick(inputText)
            inputText=""
            controller?.hide()
        }){
            Icon(Icons.Rounded.Send, contentDescription =null,
                modifier = Modifier.size(40.dp).clip(CircleShape).background(Color.Black).padding(8.dp),
                tint = Color.White
            )
        }
    }
}


