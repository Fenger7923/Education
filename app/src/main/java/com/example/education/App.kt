package com.example.education

import android.app.Application
import com.example.education.bean.DaoMaster
import com.example.education.bean.DaoSession


/**
 * @author fengerzhang
 * @date 2023/12/5 12:19
 */
class App: Application() {
    companion object {
        lateinit var daoSession: DaoSession
    }

    override fun onCreate() {
        super.onCreate()
        initGreenDao()
    }

    /**
     * 初始化GreenDao,直接在Application中进行初始化操作
     */
    private fun initGreenDao() {
        /**
         * 连接数据库并创建会话
         *
         * TODO 待修改数据库名字
         */
        val devOpenHelper: DaoMaster.DevOpenHelper = DaoMaster.DevOpenHelper(this, "aserbao.db")
        val db = devOpenHelper.writableDatabase
        // 2、创建数据库连接
        val daoMaster = DaoMaster(db)
        // 3、创建数据库会话
        daoSession = daoMaster.newSession()
    }
}