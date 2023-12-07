plugins {
    id("com.android.application")

    // greenDao 配置 ，必须在kotlin之前，否则出错
    id("org.greenrobot.greendao")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.education"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.education"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildToolsVersion = "33.0.1"
}

greendao {
    schemaVersion = 1 //数据库版本号
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")

    // poi 使用旧版本，新版本出现方法重复，暂未解决
//    implementation("org.apache.poi:poi:4.1.2")
    implementation("org.apache.poi:poi-ooxml:3.17")
    implementation("stax:stax-api:1.0.1")
    implementation("org.apache.xmlbeans:xmlbeans:3.1.0")
    implementation("com.fasterxml:aalto-xml:1.2.2")


    implementation("org.greenrobot:greendao:3.2.2") // 业务配置 greendao


    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}