pipeline {
    agent any
    tools{
    gradle "Gradle"
    }
    stages {
        stage('Sonar Execution') {
            steps {
                echo "hola"
                sh "gradle clean"
            }
        }
    }
}