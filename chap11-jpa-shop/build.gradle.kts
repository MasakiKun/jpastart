plugins {
	id("java")
	id("war")
}

group = "kr.ayukawa"

configure<JavaPluginConvention> {
	sourceCompatibility = JavaVersion.VERSION_11
	targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<JavaCompile> {
	options.encoding = "UTF-8"
}

tasks.withType<Test> {
	useJUnitPlatform()
}

repositories {
	mavenCentral()
}

dependencies {
	compile("org.springframework:spring-webmvc:5.1.6.RELEASE")
	compile("org.springframework:spring-orm:5.1.6.RELEASE")
	compile("org.hibernate:hibernate-core:5.4.2.Final")
	compile("com.h2database:h2:1.4.199")
	compile("org.apache.tomcat:tomcat-jdbc:8.5.39")
//	compile("javax.servlet.jsp.jstl:jstl:1.2")
	compile("javax.servlet:jstl:1.2")
	compileOnly("javax.servlet:javax.servlet-api:4.0.1")
	compileOnly("javax.servlet.jsp:javax.servlet.jsp-api:2.3.3")
	compile("org.slf4j:slf4j-api:1.7.26")
	compile("ch.qos.logback:logback-classic:1.2.3")
	testCompile("org.springframework:spring-test:5.1.6.RELEASE")
	testCompile("org.junit.jupiter:junit-jupiter-api:5.4.1")
	testCompile("org.junit.jupiter:junit-jupiter-engine:5.4.1")
//	testCompile("junit:junit:4.12")
	compileOnly("org.projectlombok:lombok:1.18.6")
}