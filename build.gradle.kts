plugins {
	id("java")
}

group = "kr.ayukawa"

configure<JavaPluginConvention> {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

var versions = mapOf(
	"hibernate" to "4.3.10.Final",
	"h2db" to "1.4.187"
)

tasks.withType<JavaCompile> {
	options.encoding = "UTF-8"
}

repositories {
	mavenCentral()
}

dependencies {
	compile("org.hibernate:hibernate-entitymanager:${versions["hibernate"]}")
	compile("com.h2database:h2:${versions["h2db"]}")
}
