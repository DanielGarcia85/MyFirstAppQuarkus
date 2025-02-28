
# MyFirstAppQuarkuss

This project uses **Quarkus**, the Supersonic Subatomic Java Framework, designed for high-performance Java applications with minimal resource usage during the ***63-51 Emerging Technologies*** course at **Haute École de Gestion (HEG)**

If you want to learn more about Quarkus, visit its official website: <https://quarkus.io/>.

## Features
- Built with **Quarkus** for fast startup times and low memory usage.
- Supports **JVM mode** and **native mode** with GraalVM.
- Provides RESTful endpoints using **RESTEasy**.
- Can be containerized and run in **Docker**.
- Supports **live coding** with Quarkus Dev mode.

## Project Structure
The project is organized into several folders:
- **src/main/java/** : Contains the Java source code of the application implementing REST services.
- **src/main/resources/** : Contains configuration files for Quarkus.
- **target/** : Directory where compiled files and packaged applications are generated.
- **.mvn/** : Directory containing Maven Wrapper-specific files.
- **mvnw** and **mvnw.cmd** : Scripts for running Maven Wrapper on Unix/Linux and Windows.
- **pom.xml** : Maven configuration file defining dependencies and plugins.

## Prerequisites
Before starting, make sure you have:
- **JDK 17 or 21 or later**: [Download here](https://openjdk.org)
- **Maven 3.9.6 or later**: [Download here](https://maven.apache.org/download.cgi)
- **Docker 20 or later** (for containerized builds and deployments) [Download here](https://www.docker.com)
- **An IDE** (IntelliJ IDEA, VS Code, Eclipse, etc.) for easier development.

## Usage
### Running the application in dev mode
You can run your application in development mode, enabling live coding, using:
```shell
mvn clean compile quarkus:dev
```
> **_NOTE:_** Quarkus includes a Dev UI, available in dev mode at http://localhost:8080/q/dev/.

### Packaging and running the application
To package the application:
```shell
mvn clean package  -DskipTest
```
This produces the quarkus-run.jar file in the target/quarkus-app/ directory. To run it:
```shell
java -jar target/quarkus-app/quarkus-run.jar
```

### Creating a native executable
You can create a native executable using:
```shell
mvn clean package -DskipTest -Pnative
```
If you don't have GraalVM installed, build it in a container with:
```shell
mvn clean install -Dnative -DskipTest -Dquarkus.native.container-build=true
```
Run the native executable with:
```shell
./target/myfirstappquarkus-1.0-SNAPSHOT-runner
```
For more details on native executables, visit https://quarkus.io/guides/maven-tooling.

### Running in a Docker Container
Build and run the application inside a Docker container:
```shell
mvn clean package
```
For JVM mode:
```shell
docker build -f src/main/docker/Dockerfile.jvm -t myfirstapp-jvm -t myfirstappoquarkus-jvm:myfirstappoquarkus-1.0.0-SNAPSHOT .
docker run -i --rm -p 8080:8080 myfirstappoquarkus-jvm:myfirstappoquarkus-1.0.0-SNAPSHOT
```
> **_NOTE:_** Testing : http://localhost:8080/hello

For native mode:
```shell
docker build -f src/main/docker/Dockerfile.native -t myfirstappoquarkus-jvm:myfirstappoquarkus-1.0.0-SNAPSHOT .
docker run -i --rm -p 8080:8080 myfirstappoquarkus-jvm:myfirstappoquarkus-1.0.0-SNAPSHOT
```
> **_NOTE:_** Testing url : http://localhost:8080/hello

## Endpoints
| Method | Endpoint         | Description            |
|--------|------------------|------------------------|
| GET    | `/hello`         | Returns a greeting message in english |
| GET    | `/bonjour`       | Returns a greeting message in french |

## Useful Resources
- Quarkus Documentation: https://quarkus.io/guides/
- Getting Started with Quarkus: https://quarkus.io/guides/getting-started
- RESTEasy Guide: https://quarkus.io/guides/resteasy
- GraalVM Native Compilation: https://www.graalvm.org/

## Troubleshooting
- **Issue:** `mvnw: command not found`
  - **Solution:** Make sure the `mvnw` script has execution permissions:  
    ```shell
    chmod +x mvnw
    ```
- **Issue:** `Port 8080 already in use`
  - **Solution:** Stop any process using port 8080 or run the app on a different port:
    ```shell
    mvn quarkus:dev -Dquarkus.http.port=8081
    ```

## License
This project is licensed under the *Creative Commons Attribution-ShareAlike* (CC BY-SA) license.

## Author
Project created by **Daniel Garcia** as part of the course ***63-51 Emerging Technologies*** at **Haute École de Gestion (HEG)** during the Spring semester of 2025*


