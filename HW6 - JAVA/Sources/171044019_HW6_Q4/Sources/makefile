JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  BinaryTree.java \
		  BinarySearchTree.java \
		  KWHashMap.java \
		  HashTableChain.java \
		  HashTableOpen.java \
		  MyHashTableChain.java \
		  MyHashTableOpen.java \
		  Test.java \
		  \
		  

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	
run:
	java Test
	