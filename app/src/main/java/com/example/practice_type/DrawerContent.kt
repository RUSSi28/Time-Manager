package com.example.practice_type

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
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

//ページ2
//状態ホイスティング
@Composable
fun DrawerContent(
//    gradientColors: List<Color> = listOf(PrimaryColor, SubColor),
    projectList: SnapshotStateList<NavigationDrawerItem>,

    text: MutableState<String>,
    itemClick: (String) -> Unit,
    onClickButton: () -> Unit = {}
) {

//    var text: String by remember { mutableStateOf("") }
//    val itemsList = prepareNavigationDrawerItems()
//    val itemsList = remember { mutableStateOf(prepareNavigationDrawerItems()) }

    Column() {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
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

            items(projectList) { item ->
                NavigationListItem(item = item) {
                    itemClick(
                        item.projectName
                    )
                }
            }
        }

        //問題の箇所
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            OutlinedTextField(
                value = text.value,
                onValueChange = { it -> text.value = it },
                label = { Text(text = "projectName") },
                modifier = Modifier.width(230.dp)
            )

            //ボタン押されたらデータベース追加したい、今はただのTextFieldにしかなってない
            Button(
                onClick = {
                    onClickButton()//onClickButtonで処理を渡している⇨渡せていないかもしれない
                    if (text.value.isEmpty()) return@Button
                    text.value = ""
                },


                ) {
                Text(text = "Add")
            }
        }
    }

}

