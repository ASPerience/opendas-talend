#!/bin/bash
ERREUR="FIN AVEC ERREUR"
# CHEMINS ABSOLUS
DAS_SERVER="/home/opendas/workspace/opendas/server"
DAS="/home/opendas/workspace/opendas/client"

# CHEMINS RELATIFS
TALEND="/home/opendas/install/TOS_DI-r118616-V5.5.1"
WORKSPACE="/home/opendas/install/TOS_DI-r118616-V5.5.1/workspace"
VERSION="5.5.1.r118616"

COMPOSANTS="composants"
LIB="OpenDAS_xmlrpc/build/lib"

OK=true

echo "******************************************"
echo "------ TESTS PARAMETRES"
echo "******************************************"
for rep in $DAS $DAS_SERVER $TALEND $WORKSPACE $COMPOSANTS $LIB
do
	if [ ! -e $rep ]; then
		echo "ERREUR  : $rep n'existe pas"
		OK=false
		break
	elif [ -f $rep ]; then
		echo "ERREUR  : $rep est un fichier"
		OK=false
		break
	elif [ -d $rep ]; then
		echo "OK      : $rep"
	fi
done
if [ $OK == false ]; then
	echo $ERREUR
	exit
fi

echo "******************************************"
echo "------ LINK LIBRAIRIES XMLRPC DANS TALEND"
echo "******************************************"
declare -a tab
tab=("$LIB/OpenDAS_xmlrpc1.jar" "$LIB/xmlrpc-1.1.1.jar")
for ((i=0;i<${#tab[*]};i++)); do
 	if [ ! -e ${tab[${i}]} ]; then
		echo "ERREUR     : ${tab[${i}]} n'existe pas"
		OK=false
	elif [ -f ${tab[${i}]} ]; then
		echo "OK      : " ${tab[${i}]} "---->" $TALEND/lib/java/
		ln -sf `pwd`/${tab[${i}]} $TALEND/lib/java/
		#for composant in `ls $COMPOSANTS`
		#do
		#	echo $composant
		#	if [ ! `expr match $composant 'tXMLRPC'` == 0 ]; then
		#		echo "OK      : ln ${tab[${i}]} dans $COMPOSANTS/$composant/"
		#		ln -sf `pwd`/${tab[${i}]} $COMPOSANTS/$composant/
		#	fi
		#done
	elif [ -d ${tab[${i}]} ]; then
		echo "ERREUR  : ${tab[${i}]} est un répertoire"
		OK=false
	fi
done
if [ $OK == false ]; then
	echo $ERREUR
	exit
fi

echo "******************************************"
echo "------ LINK COMPOSANTS DANS TALEND"
echo "******************************************"
for i in `ls $COMPOSANTS`
do
	tmp=`pwd`/$COMPOSANTS/$i
	if [ -d $tmp ]; then
		echo "OK      : "$COMPOSANTS/$i "--->" $TALEND/plugins/org.talend.designer.components.localprovider_$VERSION/components/
		ln -sf $tmp $TALEND/plugins/org.talend.designer.components.localprovider_$VERSION/components/
	fi
done

if [ $OK == false ]; then
	echo $ERREUR
	exit
fi


echo "******************************************"
echo "------ LINK DAS_SERVER DANS TALEND ET DAS"
echo "******************************************"

if [ -e $DAS_SERVER/bin/opendas-server.jar ]; then
	echo "OK      : $DAS_SERVER/bin/opendas-server.jar"
	echo "OK      : $DAS_SERVER/bin/opendas-server.jar ----> $DAS/lib/"
	ln -sf $DAS_SERVER/bin/opendas-server.jar $DAS/lib/
	echo "OK      : $DAS_SERVER/bin/opendas-server.jar ----> $TALEND/lib/java/"
	ln -sf $DAS_SERVER/bin/opendas-server.jar $TALEND/lib/java/
	echo "OK      : $DAS_SERVER/bin/lib/toplink-essentials.jar ----> $TALEND/lib/java/"
	ln -sf $DAS_SERVER/bin/lib/toplink-essentials.jar $TALEND/lib/java/
	ln -sf $DAS_SERVER/bin/lib/activemq-all-5.5.0.jar $TALEND/lib/java/
	echo "OK      : $DAS_SERVER/bin/lib/log4j-1.2.13.jar ----> $TALEND/lib/java/"
	ln -sf $DAS_SERVER/bin/lib/log4j-1.2.13.jar $TALEND/lib/java/
	echo "OK      : $DAS_SERVER/bin/lib/slf4j-simple-1.5.4.jar ----> $TALEND/lib/java/"
	ln -sf $DAS_SERVER/bin/lib/slf4j-simple-1.5.4.jar $TALEND/lib/java/
	
else
	echo "ERREUR  : $DAS_SERVER/bin/opendas-server.jar n'existe pas"
	OK=false
fi

if [ $OK == false ]; then
	echo $ERREUR
	exit
fi





