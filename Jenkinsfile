pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                echo " Pulling source code from GitHub..."
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

        stage('Install Artifact') {
            steps {
                echo " Installing artifact to local Maven repository"
                sh 'mvn install'
            }
        }

        stage('Archive Jar') {
            steps {
                echo " Archiving built JAR file"
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {

        always {
            echo "♻ Cleaning workspace..."
            cleanWs()
        }

        success {
            echo " Build finished successfully!"
            echo " Artifact is ready in Jenkins artifacts."
        }

        failure {
            echo " Build failed!"
            echo " Please check the logs for more details."
        }

        unstable {
            echo " Build is unstable!"
            echo "Maybe tests failed or warnings appeared."
        }
    }
}
