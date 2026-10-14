pipeline {
    agent any

    stages {
        stage('Build and test') {
            steps {
                script {
                    if (isUnix()) {
                        sh './mvnw -B clean verify'
                    } else {
                        bat 'mvnw.cmd -B clean verify'
                    }
                }
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Run application') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'java -jar target/maven-addition-1.0.0.jar 3 4'
                    } else {
                        bat 'java -jar target/maven-addition-1.0.0.jar 3 4'
                    }
                }
            }
        }

        stage('Build Docker image') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'docker build -t maven-addition:latest .'
                    } else {
                        bat 'docker build -t maven-addition:latest .'
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Build, tests, and Docker image creation completed successfully.'
        }
        failure {
            echo 'Pipeline failed. Check the stage logs for details.'
        }
    }
}
