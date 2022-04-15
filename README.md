# Android-MVVM-with-Retrofit

plugins {
.
.
.

    id  'kotlin-kapt'
}

dependencies {
.
.
.

    //retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'


    // ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.1.0"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.1.0"


    //roomdb
    def room_version = "2.3.0"
    implementation "androidx.room:room-runtime:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
    implementation "androidx.room:room-ktx:$room_version"

    //coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1'
.
.
.
}
