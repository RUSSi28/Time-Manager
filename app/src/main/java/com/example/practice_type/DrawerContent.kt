package com.example.practice_type

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice_type.ui.theme.PrimaryColor
import com.example.practice_type.ui.theme.SubColor
import com.example.practice_type.ui.theme.SubSubColor

//ページ2
//状態ホイスティング
@Composable
fun DrawerContent(
//    gradientColors: List<Color> = listOf(PrimaryColor, SubColor),
    projectList: SnapshotStateList<NavigationDrawerItem>,

    text: MutableState<String>,
    itemClick: (String) -> Unit,
    onClickButton: () -> Unit = {},
) {


    Column() {
        BoxWithConstraints() {
            val screenWidth = with(LocalDensity.current) { constraints.maxWidth.toDp() }
            val screenHeight = with(LocalDensity.current) { constraints.maxHeight.toDp() }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screenHeight - 60.dp)
                    .background(color = SubColor),
//            .background(brush = Brush.verticalGradient(colors = gradientColors)),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(vertical = 36.dp),
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
                    Text(
                        modifier = Modifier.padding(top = 8.dp, bottom = 30.dp),
                        text = "you can easily manage your time",
                        style = MaterialTheme.typography.h3,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Divider(color = PrimaryColor, thickness = 2.dp)
                }
                //itemを使用すればRowやColumnを使えるらしい
                items(projectList) { item ->
                    NavigationListItem(item = item) {
                        itemClick(
                            item.projectName+" " +
                                    "\n "+item.time+" h"
                        )
                    }
                }
            }
        }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = text.value,
                    onValueChange = { it -> text.value = it },
                    label = { Text(text = "projectName") },
                    modifier = Modifier
                        .width(230.dp)
                        .padding(10.dp, 0.dp, 0.dp, 0.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = PrimaryColor,
                        cursorColor = PrimaryColor,
                        focusedLabelColor = PrimaryColor
                    )
                )

                //ボタン押されたらデータベース追加したい、今はただのTextFieldにしかなってない
                Button(
                    onClick = {
                        onClickButton()//onClickButtonで処理を渡している⇨渡せていないかもしれない
                        if (text.value.isEmpty()) return@Button
                        text.value = ""
                    },
                    modifier = Modifier
                        .size(65.dp, 58.dp)
                        .padding(0.dp, 8.dp, 0.dp, 0.dp),
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = PrimaryColor,
                        contentColor = Color.Black
                    )
                    ) {
                    Text(text = "Add")
                }
            }
    }
}

