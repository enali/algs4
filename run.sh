#!/usr/bin/env bash
main_class="com.enalix.algs4.$1"
shift
main_args="$*"
class_path="$HOME/algs4/stdlib-package.jar:$HOME/algs4/algs4-package.jar:target/algorithms-1.0.0.jar"
#mvn exec:java -Dexec.mainClass=$main_class -Dexec.args=$main_args
java -cp $class_path $main_class $main_args
