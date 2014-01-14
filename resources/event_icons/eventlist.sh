#!/bin/bash
for i in $(ls -1 */*.jpg)
do
	EVENT=${i%.*}
	echo "<!--${EVENT}-->" >> eventlist.txt
done
