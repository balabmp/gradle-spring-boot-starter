Install the Development Platform
--------------------------------
* Install Java


Install the Build Tool
----------------------
Gradle is...

Install it following the instructions here: https://gradle.org/install/

Create a directory for your project:

    mkdir gradle-spring-boot-starter
    cd gradle-spring-boot-starter


Initialize a new Gradle project
-------------------------------
    gradle init

  * this creates a few starter files & directories in your project

  ├── build.gradle
  ├── gradle
  │   └── wrapper
  │       ├── gradle-wrapper.jar
  │       └── gradle-wrapper.properties
  ├── gradlew
  ├── gradlew.bat
  └── settings.gradle

  `build.gradle` is the place that will describe how to compile your project, run tests and generate any required artifacts.

  The `gradle` directory contains the [Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html). The Gradle Wrapper is the preferred way of running Gradle, because it ensures that anyone using your project is using the exact same version of Gradle.

  `gradlew` & `gradlew.bat` are the Gradle Wrapper runners for Unix & Windows respectively.

  From now on, instead of typing `gradle <taskname>`, you'll run `./gradlew <taskname>`

  `settings.gradle` is a place to put various configuration settings used by the main `build.gradle` file. You'll notice that currently all it has in it is the name of the project

Learn about Gradle Tasks
------------------------

Run this command to see what tasks are currently available with your project

    ./gradlew tasks

Notice that there are no tasks to actually build the project.

We can fix this by telling Gradle that this is going to be a java project. Add the following to your `build.gradle`:

      apply plugin: 'java'

Now run `./gradlew tasks` again and notice the new tasks -- most notable `clean` and `build`


Build a Java artifact
---------------------
The deployable artifact we're going to be using is a [Jar file](https://docs.oracle.com/javase/tutorial/deployment/jar/basicsindex.html).

You can create this jar file by executing the following Gradle command:

    ./gradlew build

You'll now have a new directory called `build`, under which there is a `libs` directory containing your new jar file. Since you have no code yet, the jar file doesn't actually contain anything useful.

We can get rid of this directory by executing the following Gradle command:

    ./gradlew clean

From now on, we'll combine these two tasks to ensure we start with an empty build directory before building.

    ./gradlew clean build


Turn it into a Spring Boot project
----------------------------------
In order to quickly make a web service, we'll use [Spring Boot](https://projects.spring.io/spring-boot/).

Tell Gradle that we're going to be using Spring Boot by adding the following to the _top_ of your `build.gradle` file.

    plugins {
        id 'org.springframework.boot' version '2.0.0.RELEASE'
    }

If you run `./gradlew tasks` again, you'll notice that there is a new `bootRun` task. We'll use this to start the Spring Boot application in a few steps.

the `plugins` entry also tells Gradle to use the specified spring-boot version for any other dependencies that we add to the project.

Next, the following to your `build.gradle` file:

    repositories {
        mavenCentral()
    }

    dependencies {
        compile 'org.springframework.boot:spring-boot-starter-web'
    }

The `repositories` section tells Gradle where to look in order to download any dependencies needed by the build process and/or your application. [Maven Central](https://search.maven.org/) is a well known location that hosts many open source projects.

The `dependencies` section tells Gradle that we are going to add the specified dependency to the Java compilation classpath. The Maven infrastructure (which is leveraged by Gradle and many other build tools) is able to identify all artifacts by three items:
  * group id     - `org.springframework.boot`
  * artifact id  - `spring-boot-starter-web`
  * version      - Gradle resolves this automatically because of the `plugins` section from above.

