@Library('jenkins-sharedlib') _

pipeline {
    agent any

    stages {
        stage('Build with Shared Library') {
            steps {
                mavenBuild()
            }
        }
    }
}
