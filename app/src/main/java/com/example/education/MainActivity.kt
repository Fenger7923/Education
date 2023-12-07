package com.example.education

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.education.bean.SchoolBean
import com.example.education.bean.StudentBean
import com.example.education.ui.theme.EducationTheme
import com.example.education.ui.theme.MineTheme
import kotlin.coroutines.coroutineContext


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 获取DAO实例
        val mSession = App.daoSession.schoolBeanDao
        mSession.insert(SchoolBean("第一中学"))

        setContent {
            val mainViewModel: MainViewModel = viewModel()
            EducationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val list = mainViewModel.readExcel(applicationContext)

                    MainApp(list)
                }
            }
        }
    }
}

@Composable
private fun MainApp(list: List<StudentBean>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
//                val intent = Intent().apply {
//                    setClass(this@MainActivity, MineClearingActivity::class.java)
//                }
//                startActivity(intent)

            },
            modifier = Modifier
                .padding(5.dp)
                .background(
                    color = MineTheme.colors.background,
                    shape = RoundedCornerShape(5.dp)
                )
        ) {
            Text(text = "查询数据")

            StudentCheck(list)
        }

        Button(
            onClick = {
                // TODO 增加游戏难度设置
//                val intent = Intent().apply {
//                    setClass(this@MainActivity, SettingActivity::class.java)
//                }
//                startActivity(intent)
            },
            modifier = Modifier
                .padding(5.dp)
                .background(
                    color = MineTheme.colors.background,
                    shape = RoundedCornerShape(5.dp)
                )
        ) {
            Text(text = "上传数据")
        }
    }
}

@Composable
fun StudentCheck(list: List<StudentBean>, modifier: Modifier = Modifier) {
    LazyColumn {
        for (entry in list) {
            item {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(text = entry.sName)
                }
            }
        }
    }
}