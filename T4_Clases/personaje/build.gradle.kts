plugins {
    id("java")
    id("io.freefair.aspectj.post-compile-weaving") version "8.11"
    id("io.freefair.lombok") version "8.11"
}

group = "jmb.juanma"
version = "1.0-SNAPSHOT"

repositories { // Donde voy a buscar 'lo que necesito'
    flatDir {dirs("/home/juanma/jar")}
    mavenCentral()
}

dependencies { // Lo que necesito
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.aspectj:aspectjrt:1.9.22")
    implementation("fsg.retamar:validacion:1.0")
    aspect("fsg.retamar:validacion:1.0")
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-parameters")
}

tasks.test {
    useJUnitPlatform()
}

/*
plugins {
    //id("java") //SOLO APLICACIONES
    `java-library`  //SOLO LIBRERIAS
    `maven-publish` //SOLO LIBRERIAS A PUBLICAR EN MAVEN LOCAL
    id("io.freefair.aspectj") version "8.11" //SIN LOMBOK
    //CON LOMBOK Y ASPECTJ
    // 1. Cambiamos el plugin de aspectj por el de post-compile-weaving
    //id("io.freefair.aspectj.post-compile-weaving") version "8.11"
    // 2. Usamos el plugin de lombok de freefair que gestiona mejor los conflictos
    //id("io.freefair.lombok") version "8.11"
}

group = "fsg.fernando"
version = "1.0"

//SOLO LIBRERIAS A PUBLICAR EN MAVEN LOCAL
//Ruta donde se guarda
//Windows: C:\Users\TuUsuario\.m2\repository
//Linux: /home/tuusuario/.m2/repository
//macOS: /Users/tuusuario/.m2/repository
//Dentro de repository, las librerías se organizan siguiendo la estructura de carpetas de tu group id.
// Por ejemplo, si tu grupo es com.mi.libreria, la ruta será
// .../repository/com/mi/libreria/.
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}

repositories {
    //SOLO LIBRERIAS (.jar) ALMACENADAS EN UN DIRECTORIO LOCAL
    /*
    flatDir {
        dirs("C:/jar")
    }
    */
    //mavenLocal() //SOLO LIBRERIAS PUBLICADAS EN MAVEN LOCAL
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Definir que validar contiene aspectos que deben inyectarse
    //aspect("fsg.fernando:validacion:1.0")
    //implementation("fsg.fernando:validacion:1.0")

    // AspectJ Runtime
    implementation("org.aspectj:aspectjrt:1.9.22")
}

tasks.test {
    useJUnitPlatform()
}

//AÑADIDO
tasks.jar {
    //SOLO PARA RENOMBRAR EL .jar GENERADO POR GRADLE
    //[archiveBaseName]-[archiveAppendix]-[archiveVersion]-[archiveClassifier].[archiveExtension]
    //MODIFICAR EL NOMBRE COMPLETO
    //archiveFileName.set("servidor-final.jar") //cambiar el nombre completo
    //MODIFICACIONES PARCIALES DEL .jar
    //archiveBaseName.set("mi-app")  //cambiar el nombre base del jar (por defecto el definido en setting.gradle.kts)
    //archiveAppendix.set("")      // quitar/cambiar el sufijo
    //archiveVersion.set("")      // quitar/cambiar la version
    //archiveClassifier.set("")   // quitar/cambiar el clasificador
    //archiveExtension.set("pkg") // cambiar la extension

    //SOLO APLICACIONES PARA GENERAR (FAT JAR)
    /*
    manifest {
        attributes["Main-Class"] = "fsg.aplicacion.Main"
    }

    // Configuración para incluir todas las dependencias y la librería en el JAR final
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    */

    //SOLO LIBRERIAS PUBLICADAS EN MAVEN LOCAL
    finalizedBy("publishToMavenLocal")
}

//SOLO PARA PUBLICAR EL .jar (LIBRERIA O APLICACION) EN UN DIRECTORIO LOCAL
/*
tasks.register<Copy>("copiarJar") {
    from(tasks.jar.get().archiveFile)
    into(layout.projectDirectory.dir("C:/jar"))
}

tasks.named("jar") {
    finalizedBy("copiarJar")
}
*/

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-parameters")
}
*/