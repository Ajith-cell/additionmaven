# Maven Addition with Jenkins and Docker

This sample Maven project adds two integers, runs unit tests, and packages the app as an executable JAR.

## Run locally

Requires JDK 17. The Maven Wrapper downloads the project's pinned Maven version on first use:

```sh
./mvnw clean verify
java -jar target/maven-addition-1.0.0.jar 3 4
```

On Windows, use `mvnw.cmd clean verify`.

The application prints `7`.

## Run with Docker

Requires Docker:

```sh
docker build -t maven-addition:latest .
docker run --rm maven-addition:latest 3 4
```

## Jenkins pipeline

Create a Jenkins Pipeline job pointing at this repository and use the included `Jenkinsfile`. The Jenkins agent must have JDK 17, network access to download Maven on first run, Docker CLI, and access to a Docker daemon. No system-wide Maven installation is needed. The pipeline uses the Maven Wrapper to run tests, publishes JUnit test results, then builds the Docker image.
