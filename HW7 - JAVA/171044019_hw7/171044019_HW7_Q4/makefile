JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  Admin.java \
		  SearchTree.java\
		  BinaryTree.java\
		  BinarySearchTree.java \
		  Software.java\
		  SoftwareStore.java\
		  Test.java\
		  \
		  

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	
run:
	java MainTest
	