%dw 2.0
output application/java
---
{
	"classpath://template/pom.xml":"/pom.xml",
	"classpath://template/proj-project":"/.project",
	"classpath://template/proj-classpath":"/.classpath",
	"classpath://template/mule-artifact.json":"/mule-artifact.json",
	"classpath://template/log4j2.xml":"/src/main/resources/log4j2.xml",
	"classpath://template/log4j2-test.xml":"/src/test/resources/log4j2-test.xml",
	"classpath://template/configurations.xml":"/src/main/mule/configurations.xml",
	"classpath://template/local.yaml":"/src/main/resources/local.yaml",
	"classpath://template/dev.yaml":"/src/main/resources/dev.yaml",
	"classpath://template/test.yaml":"/src/main/resources/test.yaml",
	"classpath://template/prod.yaml":"/src/main/resources/prod.yaml"
}