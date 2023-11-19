// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    //Android indicators (idk about library, maybe it can be excluded, maybe try at the end of the project
    //I think it's just for making libraries
    id("com.android.application") version "8.1.4" apply false
    id("com.android.library") version "8.1.4" apply false

    //Kotlin and KSP compiler
    /*
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false*/

    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false

    //Hilt
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
}