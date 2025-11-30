def call() {
    stage('Clean') {
        sh 'mvn clean'
    }

    stage('Test') {
        sh 'mvn test'
    }

    stage('Package') {
        sh 'mvn package'
    }

    stage('Install') {
        sh 'mvn install'
    }
}
