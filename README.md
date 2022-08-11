![build](https://github.com/wisnukurniawan/Compose-Wallee/actions/workflows/build.yml/badge.svg)

## Compose playground: Expense Tracker

<a href='https://play.google.com/store/apps/details?id=com.wisnu.kurniawan.wallee'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' width=240/></a>

Compose playground for learning purpose

* UI completely in [Jetpack Compose](https://developer.android.com/jetpack/compose)
* Uses [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines/coroutines-guide.html)
* Uses [Kotlin Flow](https://kotlinlang.org/docs/flow.html)
* Uses many of the [Architecture Components](https://developer.android.com/topic/libraries/architecture/), including: Room, DataStore, Navigation, ViewModel
* Uses [Hilt](https://dagger.dev/hilt/) for dependency injection
* Uses [Java 8+ API desugaring support](https://developer.android.com/studio/write/java8-support#library-desugaring) for date and time usage

## Demo

<img src="art/demo.gif" width="500">

<img src="art/demo2.gif" width="500">

## Prerequisites

* Android Studio Chipmunk | 2021.2.1
* Min SDK 21
* Target SDK 33
* AGP 7.2.2
* Java 11
* Kotlin 1.7.10

## Setup

1. Clone this repository, `git clone https://github.com/wisnukurniawan/Compose-Wallee.git`
2. Open via [Android studio](https://developer.android.com/studio)
3. Sync the project, **File -> Sync Project with Gradle files**

## How to build

* Generate debug apk `./gradlew assembleDebug`
* Run unit test `./gradlew testDebug`
* Install on connected device `./gradlew installDebug`

## Others

* [Mercury architecture](https://github.com/wisnukurniawan/Compose-ToDo/blob/main/doc/architecture.md)
* [Project structure](https://github.com/wisnukurniawan/Compose-ToDo/blob/main/doc/project-structure.md)
* [Modularization](https://github.com/wisnukurniawan/Compose-ToDo/blob/main/doc/module.md)
