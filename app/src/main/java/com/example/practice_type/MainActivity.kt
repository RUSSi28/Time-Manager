package com.example.practice_type

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.futured.donut.compose.DonutProgress
import app.futured.donut.compose.data.DonutConfig
import app.futured.donut.compose.data.DonutModel
import app.futured.donut.compose.data.DonutSection
import com.example.practice_type.ui.theme.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.*
import kotlin.concurrent.timer

class MainActivity : ComponentActivity() {

    private val dao = RoomApplication.database.drawerItemDao()
    private val drawerItemList = mutableStateListOf<NavigationDrawerItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practice_typeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TimeManage(drawerItemList)
                }
            }
        }
        load()
    }
    private fun load() {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.Default) {
                dao.getAll().forEach {item_ ->
                    drawerItemList.add(item_)
                }
            }
        }
    }
    private fun post(projectName: String){
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.Default) {
                dao.post(NavigationDrawerItem(projectName = projectName, id = 0))

                drawerItemList.clear()
            }
        }
    }
    //ページ1
    @Composable
    fun TimeManage(draweItemList: SnapshotStateList<NavigationDrawerItem>) {
        val timer = remember { mutableStateOf(0f) }
        val bool = remember { mutableStateOf(false) }
        val counter = remember {mutableStateOf<Unit?>(null)}

        val scaffoldState = rememberScaffoldState()
        val coroutineScope = rememberCoroutineScope()
        val contextForToast = LocalContext.current.applicationContext

        if(bool.value) {
            LaunchedEffect(Unit) {
                val handler = Handler(Looper.getMainLooper())
                counter.value = Counter(bool, timer, handler)
            }
        }else{
            LaunchedEffect(Unit){}
        }

        Scaffold(
            topBar = {
                MyTopAppBar{
                    //ドロワーは別スレッドらしい
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            },
            scaffoldState = scaffoldState,
            drawerContent = {
                DrawerContent{ itemLabel ->
                    Toast
                        .makeText(contextForToast, itemLabel, Toast.LENGTH_SHORT)
                        .show()
                    coroutineScope.launch {
                        delay(timeMillis = 250)
                        scaffoldState.drawerState.close()
                    }

                }
            },
        ) {paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(BackColor),
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                item{
                    Spacer(modifier = Modifier.padding(10.dp))
                    Column(
                        modifier = Modifier.background(
                            color = SubColor,
                            //背景の丸角をパーセンテージで指定できる↓
                            shape = RoundedCornerShape(5)
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        StatusBarColor()

                        //ゲージの表示進行
                        DonutProgress(
                            model = DonutModel(
                                cap = 60f,
                                masterProgress = 1f,
                                gapWidthDegrees = 0f,
                                gapAngleDegrees = 270f,
                                strokeWidth = 80f,
                                backgroundLineColor = Color.LightGray,
                                sections = listOf(
//                      //timer.valueの値に応じてゲージを進行させる
                                    DonutSection(amount = timer.value, color = Color.Cyan)
                                )
                            ),
                            config = DonutConfig(
                                gapAngleAnimationSpec = spring(),
                                backgroundLineColorAnimationSpec = spring(),
                                capAnimationSpec = spring(),
                                gapWidthAnimationSpec = spring(),
                                masterProgressAnimationSpec = spring(),
                                sectionAmountAnimationSpec = spring(),
                                sectionColorAnimationSpec = spring(),
                                strokeWidthAnimationSpec = spring(),
                            ),
                            modifier = Modifier
                                .size(300.dp)
                                .padding(20.dp)
                        )
                        Button(
                            modifier = Modifier
                                .size(200.dp, 50.dp)
                                .background(color = SubColor, shape = RoundedCornerShape(5)),
                            onClick = {
                                GaugeProgress(bool)
                            },
                            colors = ButtonDefaults.buttonColors(SubSubColor),
                        ) {
                            Text(text = if(bool.value == false){"start"}else{"fight for 1h"}, style = MaterialTheme.typography.h2)
                        }
                        Spacer(modifier = Modifier.padding(20.dp))
                    }

                }
            }
        }
    }

}


fun GaugeProgress(boolean:MutableState<Boolean>) {
    //bool.valueがtrueの時だけゲージを進行させる
    if(!boolean.value) { boolean.value = true }

    //log確認用→最終的には消しておいて
    println("値は${boolean.value}になっている")
}


//timer関数による別スレッドは一つしか建てられないみたい？\
fun Counter(boolean:MutableState<Boolean>, count:MutableState<Float>, hand:Handler){
    val timer = timer(period = 10000){
        hand.post{
            count.value += 1/6f
        }
    }
    if (boolean.value == false) {
        timer.cancel()
    }
}


//ステータスバーの色変更、起動時にデフォルトになっているため付け焼刃
@Composable
fun StatusBarColor(){
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(PrimaryColor)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    Practice_typeTheme {
//        TimeManage()
//    }
//}