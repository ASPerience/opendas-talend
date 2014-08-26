%~d0
 cd %~dp0
java -Xms256M -Xmx1024M -cp classpath.jar; opendas.get_0_1.GET --context=Default %* 