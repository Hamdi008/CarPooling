plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.hilt)
    kotlin("kapt")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.hamdi.carpooling"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.hamdi.carpooling"
        minSdk = 29
        targetSdk = 34
        versionName = getVersionName("version.txt")
        versionCode = getVersionCode(versionName as String)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            buildConfigField("String", "API_BASE_URL", "\"https://api.production.com/\"")
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            buildConfigField("String", "API_BASE_URL", "\"http://192.168.83.190:9000/\"")
            isMinifyEnabled = false
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
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            pickFirsts += "META-INF/gradle/incremental.annotation.processors"
        }
    }


    applicationVariants.all {
        outputs.forEach { output ->
            (output as? com.android.build.gradle.internal.api.BaseVariantOutputImpl)?.apply {
                //outputFileName = "Carpooling-${buildType.name}-$versionName.apk"
                outputFileName = if (buildType.name == "debug")
                    "${rootProject.name}-${buildType.name}-$versionName.apk"
                else
                    "${rootProject.name}-$versionName.apk"
            }
        }
    }


}

fun getVersionName(versionFile: String): String {
    var year = "XX"
    var releaseNumber = "XX"
    var patch = "XX"
    var build = "XXXX"
    File(versionFile).forEachLine {
        when {
            it.startsWith("VERSION_YEAR=") -> year = it.substringAfter("=").padStart(2, '0')
            it.startsWith("VERSION_RELEASE_NUM=") -> releaseNumber = it.substringAfter("=").padStart(2, '0')
            it.startsWith("VERSION_PATCH=") -> patch = it.substringAfter("=").padStart(2, '0')
            it.startsWith("VERSION_BUILD=") -> build = it.substringAfter("=").padStart(4, '0')
        }
    }
    return "$year.$releaseNumber.$patch-$build"
}


fun getVersionCode(version: String): Int {
    return getVersions(version)?.let { (year, releaseNumber, patch, build) ->
        val code = (year - 25) * 10000000 + (releaseNumber) * 100000 + (patch) * 1000 + (build).rem(1000)
        if (code == 0) 1 else code
    }
        ?: throw GradleException("version doesn't respect the version rule 'year.releaseNumber.patch-buildNumber': $version")
}

fun getVersions(version: String?): Array<Int>? {
    return version?.let {
        "(\\d{2})\\.(\\d{2})\\.(\\d{2})\\-(\\d{4})".toRegex().matchEntire(version)?.let { matchEnt ->

            matchEnt.let {
                val year = matchEnt.groups[1]?.value?.toInt() ?: 22
                val releaseNumber = matchEnt.groups[2]?.value?.toInt() ?: 0
                val patch = matchEnt.groups[3]?.value?.toInt() ?: 0
                val build = matchEnt.groups[4]?.value?.toInt() ?: 0

                arrayOf(year, releaseNumber, patch, build)
            }
        }
    }
}

dependencies {

    // Jetpack Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.8.9")
    implementation("androidx.compose.material:material-icons-extended:1.6.7")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")

    // Gson
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    // Dagger Hilt
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.android)
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation(libs.androidx.animation.core.lint)

    // Room dependencies
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}