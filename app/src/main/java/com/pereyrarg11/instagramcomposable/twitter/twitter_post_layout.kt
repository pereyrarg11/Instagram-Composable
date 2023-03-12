package com.pereyrarg11.instagramcomposable.twitter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pereyrarg11.instagramcomposable.R
import com.pereyrarg11.instagramcomposable.ui.theme.TwitterPostBackground
import com.pereyrarg11.instagramcomposable.ui.theme.TwitterPostOnBackground
import com.pereyrarg11.instagramcomposable.ui.theme.TwitterPostOnBackgroundSecondary

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TwitterPostLayout() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(TwitterPostBackground)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_user),
                contentDescription = "Profile",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(32.dp)
            )
            Spacer(modifier = Modifier.size(6.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Row {
                    Text(
                        text = "Gabriel Pereyra",
                        color = TwitterPostOnBackground,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = "@pereyrarg11 - 7h", color = TwitterPostOnBackgroundSecondary)
                }
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut posuere, lacus consequat vulputate eleifend, nisi lorem congue orci, in lacinia nulla odio eget dui. Suspendisse facilisis faucibus ante. Proin lectus augue, rhoncus quis iaculis vel, malesuada vel lectus. Integer dictum sagittis dictum. Donec dapibus ex lacus, vitae porta ipsum suscipit ut. Cras sollicitudin hendrerit tellus non laoreet. Morbi consectetur augue et felis vehicula, nec feugiat enim elementum.",
                    color = TwitterPostOnBackground
                )
                Spacer(modifier = Modifier.size(8.dp))
                // reference: https://developer.android.com/jetpack/compose/graphics/images/customize?hl=es-419
                Image(
                    painter = painterResource(id = R.drawable.img_cat),
                    contentDescription = "Multimedia",
                    modifier = Modifier.clip(RoundedCornerShape(8.dp))
                )
                Spacer(modifier = Modifier.size(8.dp))
                TwitterReactions()
            }
        }
        Divider(color = TwitterPostOnBackgroundSecondary, modifier = Modifier.height(1.dp))
    }
}