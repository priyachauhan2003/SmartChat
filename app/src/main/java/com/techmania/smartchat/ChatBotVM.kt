package com.techmania.smartchat

import android.util.Log
import android.view.View
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatBotVM:ViewModel() {
    val list by lazy{
        mutableStateListOf<ChatData>()
    }
    private val genAI by lazy {
        GenerativeModel(
            modelName = "gemini-1.5-flash",
            apiKey = "AIzaSyCz6Y6y4XW4APipPMGiHdkgeb9PAKpgx70"
        )
    }

    fun sendMessage(text: String) = viewModelScope.launch {
        //var response =genAI.startChat().sendMessage(prompt = text).text
        val chat = genAI.startChat()
        list.add(ChatData(text,ChatRoleEnum.USER.role))

        chat.sendMessage(
            content(ChatRoleEnum.USER.role ){ text(text) }
        ).text?.let{
            list.add(ChatData(it,ChatRoleEnum.MODEL.role))
        }
        //Log.d("AI_ANS",response.toString())
    }
}