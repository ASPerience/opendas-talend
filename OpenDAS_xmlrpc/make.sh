#!/bin/sh

ant -buildfile lib_src/xmlrpc/trunk/build.xml
ant -buildfile build.xml
cp lib_src/xmlrpc/trunk/build/lib/xmlrpc-1.1.1.jar build/lib
cp lib_src/xmlrpc/trunk/build/lib/xmlrpc-1.1.1.jar test/

