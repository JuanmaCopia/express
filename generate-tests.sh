#!/bin/bash

SIMPLE_CLASS_NAME=$1


RANDOOP_JAR=test-generators/randoop-all-4.3.3.jar

SUBJECT_CLASS_PATH=build/resources/main/examples/${SIMPLE_CLASS_NAME,,}/src

# Compile Subject
echo compiling: $SUBJECT_CLASS_PATH/\*.java
javac $SUBJECT_CLASS_PATH/*.java -d $SUBJECT_CLASS_PATH


CLASS_PATH=${SUBJECT_CLASS_PATH}:${RANDOOP_JAR}

SUBJECT_FULL_CLASS_NAME=examples\.${SIMPLE_CLASS_NAME,,}\.${SIMPLE_CLASS_NAME}
echo "Subject: ${SUBJECT_FULL_CLASS_NAME}"

TEST_OUTPUT_DIR=src/examples/java/casestudies/${SIMPLE_CLASS_NAME,,}/test


OUTPUT_TEST_CLASSNAME=${SIMPLE_CLASS_NAME}Test
TIME_LIMIT=60
MAX_NUMBER_TEST=400

java -Xmx3000m -cp $CLASS_PATH randoop.main.Main gentests --testclass=$SUBJECT_FULL_CLASS_NAME --time-limit=$TIME_LIMIT --output-limit=$MAX_NUMBER_TEST --regression-test-basename=$OUTPUT_TEST_CLASSNAME --junit-output-dir=$TEST_OUTPUT_DIR


#java -Xmx3000m -cp build/resources/main/examples/schedule:randoop-all-4.3.3.jar randoop.main.Main gentests --testclass=casestudies.schedule.Schedule --time-limit=60