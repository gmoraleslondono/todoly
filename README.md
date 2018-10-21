# ToDoly
[![GitHub license](https://img.shields.io/github/license/gmoraleslondono/todoly.svg)](https://github.com/gmoraleslondono/todoly/blob/master/LICENSE) [![Travis (.com)](https://img.shields.io/travis/com/gmoraleslondono/todoly.svg)](https://travis-ci.com/gmoraleslondono/todoly) [![GitHub issues](https://img.shields.io/github/issues/gmoraleslondono/todoly.svg)](https://github.com/gmoraleslondono/todoly/issues) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/46e443da1be04b04813dc23fb710be70)](https://www.codacy.com/app/gmoraleslondono/todoly) [![Known Vulnerabilities](https://snyk.io/test/github/gmoraleslondono/todoly/badge.svg)](https://snyk.io/test/github/gmoraleslondono/todoly)

This is a command-line to-do list application with a text based user interface that allows the user to create, edit and remove tasks. The user can assign the task a title, a due date, a project, and mark it as done.

## Usage

### Prerequisites

The following programs are required before starting

- [Java JRE](https://www.java.com/en/download/) version 8 or higher. To check, run `java -version`. You should see something like this:

    ```
    ❯ java -version
    java version "9.0.4"
    Java(TM) SE Runtime Environment (build 9.0.4+11)
    Java HotSpot(TM) 64-Bit Server VM (build 9.0.4+11, mixed mode)
    ```

- Download the latest version of [ToDoly](https://github.com/gmoraleslondono/todoly/releases/latest)

### Running

To run the app type the following command in the terminal

```
java -jar todoly.jar
```

## Deveploment

### Prerequisites

The following programs are required before starting

- [Gradle](https://gradle.org/install/) version 4.10 or higher. To verify the installation run gradle -v to run gradle and display the version. You should see something like this:

    ```
    ❯ gradle -v
    ------------------------------------------------------------
    Gradle 4.10.1
    ------------------------------------------------------------

    Build time:   2018-09-12 11:33:27 UTC
    Revision:     76c9179ea9bddc32810f9125ad97c3315c544919

    Kotlin DSL:   1.0-rc-6
    Kotlin:       1.2.61
    Groovy:       2.4.15
    Ant:          Apache Ant(TM) version 1.9.11 compiled on March 23 2018
    JVM:          9.0.4 (Oracle Corporation 9.0.4+11)
    OS:           Mac OS X 10.13.6 x86_64
    ```

- Clone the project with the following command

    ```
    git clone https://github.com/gmoraleslondono/todoly.git
    ```

    And navigate to the project folder

    ```
    cd todoly
    ```

### Running

To run the app use the following command

```
./gradlew run
```

### Testing

To run the tests use the following command

```
./gradlew test
```

### Building

To create a JAR including all dependencies use the following command

```
./gradlew build
```

The JAR file will be located in the `/build/libs` folder

## Credits

Made with ❤ by Gloria Morales
