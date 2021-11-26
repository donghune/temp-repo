package com.dragonsnest.data.mapper

import com.dragonsnest.domain.entity.UserEntity

fun User.toUserEntity(): UserEntity {
    return UserEntity(id, nickName, photo, email, phoneNumber, introduction)
}

fun UserEntity.toUser(): User {
    return User.Builder()
        .nickName(nickName)
        .photo(photo)
        .email(nickName)
        .phoneNumber(phoneNumber)
        .introduction(introduction)
        .build()
}
