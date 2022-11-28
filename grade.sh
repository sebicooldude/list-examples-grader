# Create your grading script here

set -e

rm -rf student-submission
git clone $1 student-submission
cat TestListExamples.java >> student-submission/TestListExamples.java
cp -r lib student-submission
cd student-submission
FILE=ListExamples.java
if [ -f "$FILE" ]; then
    if javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java; 
    then 
        if java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples
        then 
        echo "Score: 2/2"
        else
        java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples | tee -a output.txt
        echo "Number of tests passed out of 2"
        temp=$(grep -i "Tests run" output.txt)
        failedTests=$(echo $temp | cut -d ' ' -f 5)
        echo Score: $((2 - failedTests))/2

        fi
    else
        echo "Code did not compile. Score: 0"
    fi
else 
    echo "$FILE does not exist."
    echo Score 0/2
fi

