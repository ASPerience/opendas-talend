%~d0
 cd %~dp0
java -Xms256M -Xmx1024M -cp classpath.jar; opendas.set_0_1.SET --context=Default %* 