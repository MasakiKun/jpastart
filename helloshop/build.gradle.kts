plugins {
	id("java")
}

group = "kr.ayukawa"

configure<JavaPluginConvention> {
	sourceCompatibility = JavaVersion.VERSION_11
	targetCompatibility = JavaVersion.VERSION_11
}

var versions = mapOf(
	"hibernate" to "5.4.1.Final",
	"h2db" to "1.4.198"
)

tasks.withType<JavaCompile> {
	options.encoding = "UTF-8"
}

repositories {
	mavenCentral()
}

dependencies {
	compile("org.hibernate:hibernate-core:${versions["hibernate"]}")
	compile("com.h2database:h2:${versions["h2db"]}")
}
