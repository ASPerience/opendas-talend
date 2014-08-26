cd `dirname $0`
 ROOT_PATH=`pwd`
java -Xms256M -Xmx1024M -cp classpath.jar: opendas.get_0_1.GET --context=Default $* 