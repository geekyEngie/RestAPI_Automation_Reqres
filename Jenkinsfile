pipeline {
    agent {
        docker {
            image 'my-reqrestest-container'
            args '-p 8080:8080'
        }
    }
    environment {
        DOCKER_IMAGE = 'my-reqrestest-container'
    }
    stages {
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    retry(3) {
                        sh 'mvn test'
                    }
                }
            }
        }
        stage('Docker Build and Push') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE}")
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    docker.image("${DOCKER_IMAGE}").run("-p 8080:8080")
                }
            }
        }
    }
    post {
        success {
            echo 'Pipeline executed successfully.'
        }
        failure {
            echo 'Pipeline failed. Check the build logs.'
        }
    }
}
