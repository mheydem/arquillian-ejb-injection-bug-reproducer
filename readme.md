The Injection of an EJB bean into an arquillian test is not working with glassfish 7.0.4 and higher. It is working at least for glassfish 7.0.3.
If the injected EJB bean contains a method with a signature of 
`long callLong()`
the following Exection is thrown during test execution:
``` 
Caused by: java.lang.VerifyError: Operand stack overflow
Exception Details:
  Location:
    org/example/__EJB31_Generated__TestEjbBean__Intf____Bean__.callLong()J @4: invokeinterface
  Reason:
    Exceeded max stack size.
  Current Frame:
    bci: @4
    flags: { }
    locals: { 'org/example/__EJB31_Generated__TestEjbBean__Intf____Bean__' }
    stack: { long }
  Bytecode:
    0000000: 2ab4 0014 b900 2101 00ad               

	at java.base/java.lang.Class.getDeclaredConstructors0(Native Method)
	at java.base/java.lang.Class.privateGetDeclaredConstructors(Class.java:3373)
	at java.base/java.lang.Class.getConstructor0(Class.java:3578)
	at java.base/java.lang.Class.getConstructor(Class.java:2271)
	at com.sun.ejb.containers.BaseContainer.instantiateOptionalEJBLocalBusinessObjectImpl(BaseContainer.java:3347)
	at com.sun.ejb.containers.StatelessSessionContainer.initializeHome(StatelessSessionContainer.java:191)
	at com.sun.ejb.containers.StatelessContainerFactory.createContainer(StatelessContainerFactory.java:39)
	at org.glassfish.ejb.startup.EjbApplication.loadContainers(EjbApplication.java:192)
	... 67 more
```
This project is a minimal reproducer.
The environment variable GLASSFISH_HOME has to be set to the glassfish installation you want to test against.