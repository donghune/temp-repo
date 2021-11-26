package com.dragonsnest.presenter.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dragonsnest.domain.entity.UserEntity

@Composable
fun UserCard(user: UserEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text("ID : ${user.id}")
            Text("NICK_NAME : ${user.nickName}")
            Text("PHOTO : ${user.photo}")
            Text("EMAIL : ${user.email}")
            Text("PHONE_NUMBER : ${user.phoneNumber}")
            Text("INTRODUCTION : ${user.introduction}")
        }
    }
}
