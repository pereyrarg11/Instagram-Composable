package com.pereyrarg11.instagramcomposable.twitter

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pereyrarg11.instagramcomposable.R
import com.pereyrarg11.instagramcomposable.ui.theme.Caption

@Composable
fun TwitterReactions() {
    var isCommented by rememberSaveable { mutableStateOf(false) }
    var commentsCount by rememberSaveable { mutableStateOf(11) }
    var isRt by rememberSaveable { mutableStateOf(false) }
    var rtCount by rememberSaveable { mutableStateOf(6) }
    var isLiked by rememberSaveable { mutableStateOf(false) }
    var likesCount by rememberSaveable { mutableStateOf(28) }

    Row(modifier = Modifier.fillMaxWidth()) {
        TwitterIconButton(
            reactionsCount = commentsCount,
            contentDescription = "Comments",
            iconRes = if (isCommented) R.drawable.ic_chat_filled else R.drawable.ic_chat,
            iconColor = Caption
        ) {
            isCommented = !isCommented
            if (isCommented) commentsCount++ else commentsCount--
        }

        TwitterIconButton(
            reactionsCount = rtCount,
            contentDescription = "RT",
            iconRes = R.drawable.ic_rt,
            iconColor = if (isRt) Color.Green else Caption
        ) {
            isRt = !isRt
            if (isRt) rtCount++ else rtCount--
        }

        TwitterIconButton(
            reactionsCount = likesCount,
            contentDescription = "Likes",
            iconRes = if (isLiked) R.drawable.ic_like_filled else R.drawable.ic_like,
            iconColor = if (isLiked) Color.Red else Caption
        ) {
            isLiked = !isLiked
            if (isLiked) likesCount++ else likesCount--
        }
    }
}

@Composable
fun TwitterIconButton(
    reactionsCount: Int,
    contentDescription: String,
    @DrawableRes iconRes: Int,
    iconColor: Color,
    onClickListener: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = contentDescription,
            tint = iconColor,
            modifier = Modifier
                .height(24.dp)
                .clickable { onClickListener() }
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = reactionsCount.toString())
    }
}