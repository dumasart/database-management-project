
all : exp gest Graph

exp:
	javac -d bin -sourcepath src -classpath lib src/Application/ExpertApplication.java

gest:
	javac -d bin -classpath lib -sourcepath src src/Application/GestionProgramme.java

Graph:
	javac -d bin -classpath lib -sourcepath src src/Application/GraphicApplication.java

exe:
	java -classpath bin Application/GraphicApplication

exegest:
	java -classpath bin Application/GestionProgramme

exeterm :
	java -classpath bin Application/ExpertApplication

clean:
	rm -rf bin/*
