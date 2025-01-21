pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'reqres-test-image' // Replace with your Docker image name
        DOCKER_TAG = 'latest' // Tag for the Docker image
    }

    stages {
        stage('Build Docker Image') {
            steps {
                script {
                    echo 'Building Docker image...'
                    docker.build("${DOCKER_IMAGE}:${DOCKER_TAG}")
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    echo 'Running tests inside the Docker container...'
                    retry(3) { // Retry up to 3 times on failure
                        docker.image("${DOCKER_IMAGE}:${DOCKER_TAG}").inside('-p 8080:8080') {
                            sh 'mvn test'
                        }
                    }
                }
            }
        }

        stage('Clean Up') {
            steps {
                script {
                    echo 'Cleaning up dangling Docker containers and images...'
                    sh '''
                        docker ps -a --filter "status=exited" --quiet | xargs -r docker rm
                        docker images --filter "dangling=true" --quiet | xargs -r docker rmi
                    '''
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline failed. Please check the logs for details.'
        }
        always {
            cleanWs() // Clean workspace to avoid clutter
        }
    }
}
