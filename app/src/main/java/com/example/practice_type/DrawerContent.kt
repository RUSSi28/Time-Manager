package com.example.practice_type

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice_type.ui.theme.PrimaryColor
import com.example.practice_type.ui.theme.SubColor
import com.example.practice_type.ui.theme.SubSubColor

import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

//ページ2
@Composable
fun DrawerContent(
//    gradientColors: List<Color> = listOf(PrimaryColor, SubColor),
    itemClick: (String) -> Unit
) {

    var text: String by remember { mutableStateOf("") }
    val itemsList = prepareNavigationDrawerItems()


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SubColor),
//            .background(brush = Brush.verticalGradient(colors = gradientColors)),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(vertical = 36.dp)
    ) {

        item {
            Text(
                modifier = Modifier
                    .padding(bottom = 12.dp),
                text = "TimeManager",
                fontSize = 26.sp,
                style = MaterialTheme.typography.h1,
                color = Color.Black
            )

            // user's image
//            Image(
//                modifier = Modifier
//                    .size(size = 120.dp),
//                painter = painterResource(id = R.drawable.miku_launcher),
//                contentDescription = "Profile Image"
//            )

            // user's email
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 30.dp),
                text = "you can easily manage your time",
                style = MaterialTheme.typography.h3,
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        //高級関数、それぞれの配列に対して同様の処理を行う
        items(itemsList) { item ->
            NavigationListItem(item = item) {
                itemClick(item.projectName)
            }
        }
    }
    //問題の箇所
    Row() {
        OutlinedTextField(
            value = text,
            onValueChange = {it -> text =it},
            label = { Text(text = "projectName")},
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Button(
            onClick = {
                if (text.isEmpty()) return@Button

            }

        ) {

        }
    }
}
