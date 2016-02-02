#!/usr/bin/env sh

case $1 in
  "dev")
        echo "Copying from $1 the build.sh to $WORKSPACE"
        cp "/inademweb/deploy/$1/build.sh" "$WORKSPACE/build.sh"
        cp "/inademweb/deploy/$1/DataSource.groovy" "$WORKSPACE/fpyme/grails-app/conf/DataSource.groovy"
        cp "/inademweb/deploy/$1/resources.groovy" "$WORKSPACE/fpyme/grails-app/conf/spring/resources.groovy"
        ;;
  "dev_test")
        echo "Copying from $1 the build.sh to $WORKSPACE"
        cp "/inademweb/deploy/$1/build.sh" "$WORKSPACE/build.sh"
        cp "/inademweb/deploy/$1/DataSource.groovy" "$WORKSPACE/fpyme/grails-app/conf/DataSource.groovy"
        cp "/inademweb/deploy/$1/resources.groovy" "$WORKSPACE/fpyme/grails-app/conf/spring/resources.groovy"
        ;;
  "test")
        echo "Copying from $1 the build.sh to $WORKSPACE"
        cp "/inademweb/deploy/$1/build.sh" "$WORKSPACE/build.sh"
        ;;      
  "prod") 
        echo "Copying from $1 the build.sh to $WORKSPACE"
        cp "/inademweb/deploy/$1/build.sh" "$WORKSPACE/build.sh"
        ;;
  "?")
        echo "Script to prepare the compilation"
        echo ""
        echo "prebuild.sh <enviroment>"
        echo ""
        echo "dev - Development enviroment"
        echo "prod - Production enviroment"
        echo "test - Tests enviroment"
        echo ""
        echo "GOD SAVE THE QUEEN !!!"
        exit 1
        ;;
esac
