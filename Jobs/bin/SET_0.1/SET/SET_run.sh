cd `dirname $0`
 ROOT_PATH=`pwd`
java -Xms256M -Xmx1024M -cp classpath.jar: opendas.set_0_1.SET --context=Default $* 