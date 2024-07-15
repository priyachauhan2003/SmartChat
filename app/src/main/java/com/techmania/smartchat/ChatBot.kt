package com.techmania.smartchat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import com.techmania.smartchat.components.ChatFooter
import com.techmania.smartchat.components.ChatHeader
import androidx.lifecycle.viewmodel.compose.viewModel
import com.techmania.smartchat.components.ChatList

@Composable
fun Chatbot(
    viewModel: ChatBotVM=viewModel(),
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()

    ) {
        ChatHeader()

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.BottomCenter
        ){
            if(viewModel.list.isEmpty()){
                Text(text = "No chat available yet")
            }else
            ChatList(list = viewModel.list)
        }

        ChatFooter {
            if(it.isNotEmpty()){
                viewModel.sendMessage(it)
            }
        }
    }
}