#!/bin/bash
for i in $(ls -1 *.jpg)
do
	EVENT=${i%.*}
	echo "<item>${EVENT}</item>" >> eventlist.txt
done
