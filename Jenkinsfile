pipeline {
    agent any
    tools{
    gradle "Gradle"
    }
    stages {
        stage('Sonar Execution') {
            steps {
                bat "gradle clean sonarqube"
            }
        }
        stage('Test') {
            steps {
                bat "gradle clean test"
            }
        }
    }
}