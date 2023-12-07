package com.example.education

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.education.ui.theme.EducationTheme
import com.example.education.ui.theme.MineTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val mainViewModel: MainViewModel = viewModel()
            EducationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 测试greendao功能
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = { mainViewModel.querySchool() },
                            modifier = Modifier
                                .padding(5.dp)
                                .background(
                                    color = MineTheme.colors.background,
                                    shape = RoundedCornerShape(5.dp)
                                )
                        ) {
                            Text(text = "查询学校数据")
                        }

                        Button(
                            onClick = { mainViewModel.insertSchool() },
                            modifier = Modifier
                                .padding(5.dp)
                                .background(
                                    color = MineTheme.colors.background,
                                    shape = RoundedCornerShape(5.dp)
                                )
                        ) {
                            Text(text = "增加学校数据")
                        }

                        Button(
                            onClick = { mainViewModel.deleteSchool() },
                            modifier = Modifier
                                .padding(5.dp)
                                .background(
                                    color = MineTheme.colors.background,
                                    shape = RoundedCornerShape(5.dp)
                                )
                        ) {
                            Text(text = "清除所有学校数据")
                        }
                    }
                }
            }
        }
    }
}