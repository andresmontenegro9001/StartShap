pipeline {
    agent any
    tools{
    gradle "Gradle"
    }
    stages {
        stage('Sonar Execution') {
            steps {
                echo "hola"
                bat "gradle clean"
            }
        }
    }
}