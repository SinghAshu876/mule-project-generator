%dw 2.0
output application/java
/*
 * Eg: Suppose you need to create a file named util.xml 
 * in the generated project under /src/main/mule,
 * STEPS TO FOLLOW:
 * =========================================================  
 * 1] place util.xml file under /src/main/resources/template.
 * 2] put key = "util.xml"
 * 3] put value = "/src/main/mule/util.xml"
 */

---
{
	"pom.xml":"/pom.xml",
	"proj-project":"/.project",
	"proj-classpath":"/.classpath",
	"mule-artifact.json":"/mule-artifact.json",
	"log4j2.xml":"/src/main/resources/log4j2.xml",
	"log4j2-test.xml":"/src/test/resources/log4j2-test.xml",
	"configurations.xml":"/src/main/mule/configurations.xml",
	"local.yaml":"/src/main/resources/local.yaml",
	"dev.yaml":"/src/main/resources/dev.yaml",
	"test.yaml":"/src/main/resources/test.yaml",
	"prod.yaml":"/src/main/resources/prod.yaml"
}