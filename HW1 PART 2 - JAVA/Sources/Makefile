JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  MainTest.java \
		  Admin.java \
		  Branch.java \
		  BranchEmployee.java \
		  Cargo.java \
		  Company.java \
		  Customer.java \
		  Employee.java \
		  TransportationPersonnel.java \
		  User.java \



default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	
run:
	java MainTest