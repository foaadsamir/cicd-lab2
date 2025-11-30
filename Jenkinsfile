pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                echo "Pulling source code from GitHub..."
                checkout scm
            }
        }

        stage('Clean') {
            steps {
                echo " Running mvn clean"
                sh 'mvn clean'
            }
        }

        stage('Run Tests') {
            steps {
                echo " Running mvn test"
                sh 'mvn test'
            }
        }

        stage('Package App') {
            steps {
                echo " Packaging application using mvn package"
                sh 'mvn package'
            }
        }

        stage('Deploy Artifact') {
            steps {
                echo " Deploying artifact with mvn deploy"
                sh 'mvn deploy'
            }
        }

        stage('Archive Jar') {
            steps {
                echo " Archiving built JAR file"
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}
