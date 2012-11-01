generic-process
===============

Maven archetype for java command line process

Usage
===============
1.-Generate mvn archetype from project:
	mvn archetype:create-from-project
2.-Install archetype into local repository:
	target/generated-sources/archetype
	mvn install
3.-Use the archetype to generate projects:
	mvn archetype:generate -DarchetypeCatalog=local
	(You must specify package when asked from interactive maven)
