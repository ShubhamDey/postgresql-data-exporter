pipeline {
    agent any

    stages {
        stage('Pull') {
            steps {
                echo 'Generating build...'
                script {
                    cleanWs()
                    checkout scm
                }
            }
        }
        stage('Build') {
            steps {
                echo 'Generating build...'
                script {
                    
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying build...'
            }
        }
    }
}
