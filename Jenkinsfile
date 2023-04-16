pipeline {
    agent any

    tools{
        git 'Default'
    }

    triggers {
        cron('15 0 * * *')
    }

    stages {
        stage('checkout'){
            steps {
                git 'https://github.com/kdrzazga/java8-11-excercises'
            }
            post {
                always {
                    echo 'Checkout finished.'
                }
                success {
                    echo "Project checked out from GH"
                }
            }
        }
        stage('build') {
            steps {
                sh "mvn -DskipTests clean compile"
            }
            post {
                failure {
                    echo "Build failed"
                }
            }
        }
        stage('unit test'){
            steps {
                sh "mvn test -DgroupsToRun=unit"
            }
            post {
                success {
                    echo "Tests passed"
                }
            }//end post
        }//end stage
        stage('module math test'){
            steps {
                sh "mvn test -DgroupsToRun=math"
            }
            post {
                success {
                    echo "Tests passed"
                }
            }//end post
        }//end stage
        stage('module array test'){
            steps {
                sh "mvn test -DgroupsToRun=array"
            }
            post {
                success {
                    echo "Tests passed"
                }
            }//end post
        }//end stage
        stage('remaining tests'){
            steps {
                sh 'mvn test -DgroupsToRun=""'
            }
            post {
                success {
                    echo "Tests passed"
                }
            }//end post
        }//end stage
    }
}
