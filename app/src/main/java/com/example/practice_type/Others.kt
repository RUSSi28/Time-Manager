package com.example.practice_type

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice_type.data.NavigationDrawerItem

@Composable
fun NavigationListItem(
    item: NavigationDrawerItem,
    unreadBubbleColor: Color = Color(0xFF0FFF93),
    itemClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                itemClick()
            }
            .padding(horizontal = 24.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // label
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = item.projectName,
            //ここでstyle要素指定しないと後でaddした要素のstyleは特殊な書き方をしない限りデフォルトのままになってしまう
            style = MaterialTheme.typography.h2,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
    }
}



//@Composable
fun prepareNavigationDrawerItems(): List<NavigationDrawerItem> {
    val itemsList = mutableListOf<NavigationDrawerItem>()

    itemsList.add(
        NavigationDrawerItem(
            id = 1,
//            image = painterResource(id = R.drawable.items_launcher),
            projectName = "Mathematics",
//            style = MaterialTheme.typography.h2
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            id = 2,
//            image = painterResource(id = R.drawable.items_launcher),
            projectName = "English",
            //一週間使用されていないときにtrueになる変数をそれぞれに用意
//            showUnreadBubble = true,
//            style = MaterialTheme.typography.h2
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            id = 3,
//            image = painterResource(id = R.drawable.items_launcher),
            projectName = "Moon shot",
//            showUnreadBubble = true,
//            style = MaterialTheme.typography.h2
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            id = 4,
//            image = painterResource(id = R.drawable.items_launcher),
            projectName = "Play game",
//            style = MaterialTheme.typography.h2
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            id = 5,
//            image = painterResource(id = R.drawable.items_launcher),
            projectName = "Make game",
//            style = MaterialTheme.typography.h2
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            id = 6,
//            image = painterResource(id = R.drawable.items_launcher),
            projectName = "Chemistry",
//            style = MaterialTheme.typography.h2
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            id = 7,
//            image = painterResource(id = R.drawable.items_launcher),
            projectName = "Physics",
//            style = MaterialTheme.typography.h2
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            id = 8,
//            image = painterResource(id = R.drawable.items_launcher),
            projectName = "Illustration",
//            style = MaterialTheme.typography.h2
        )
    )


//    itemsList.add(
//        NavigationDrawerItem(
//            id = 9,
////            image = painterResource(id = R.drawable.ic_launcher),
//            projectName = "＋Add",
////            style = MaterialTheme.typography.h2
//        )
//    )

    return itemsList
}