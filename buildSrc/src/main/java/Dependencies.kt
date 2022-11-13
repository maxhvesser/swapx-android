package uk.swapx.build

object Versions {
    const val accompanist = "0.26.5-rc"
    const val activity = "1.7.0-alpha02"
    const val compose = "1.3.0-rc01"
    const val composeCompiler = "1.3.2"
    const val coreKtx = "1.9.0"
    const val datastore = "1.1.0-dev01"
    const val espresso = "3.5.0-beta01"
    const val flipper = "0.171.1"
    const val gradlePlugin = "7.3.1"
    const val hilt = "2.44"
    const val hiltNavigation = "1.0.0"
    const val junit = "4.13.2"
    const val junitExt = "1.1.4-beta01"
    const val kotlin = "1.7.20"
    const val lifecycle = "2.6.0-alpha02"
    const val material3 = "1.0.0-rc01"
    const val navigation = "2.6.0-alpha02"
    const val protoBuf = "4.0.0-rc-2"
    const val protoBufPlugin = "0.8.16"
    const val retrofit = "2.9.0"
    const val room = "2.5.0-beta01"
    const val soLoader = "0.10.4"
}

object Deps {
    object Accompanist {
        const val insetsUi = "com.google.accompanist:accompanist-insets-ui:${Versions.accompanist}"
        const val navigationMaterial = "com.google.accompanist:accompanist-navigation-material:${Versions.accompanist}"
    }

    object Compose {
        const val activity = "androidx.activity:activity-compose:${Versions.activity}"
        const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"

        object Ui {
            const val ui = "androidx.compose.ui:ui:${Versions.compose}"
            const val testing = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
            const val testManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
            const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        }
    }

    object Datastore {
        const val datastore = "androidx.datastore:datastore-preferences:${Versions.datastore}"
        const val protoBuf = "com.google.protobuf:protobuf-javalite:${Versions.protoBuf}"
    }

    object Flipper {
        const val flipper = "com.facebook.flipper:flipper:${Versions.flipper}"
        const val soLoader = "com.facebook.soloader:soloader:${Versions.soLoader}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
        const val navigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}"
    }

    object Junit {
        const val junit = "junit:junit:${Versions.junit}"
        const val ext = "androidx.test.ext:junit:${Versions.junitExt}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }

    object Kotlin {
        const val ktx = "androidx.core:core-ktx:${Versions.coreKtx}"
    }

    object Lifecycle {
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
    }

    object Material {
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val material3 = "androidx.compose.material3:material3:${Versions.material3}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}"
    }
}

object Plugins {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val protoBufGradlePlugin = "com.google.protobuf:protobuf-gradle-plugin:${Versions.protoBufPlugin}"
}