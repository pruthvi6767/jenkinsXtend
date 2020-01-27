package io.jenkins.pipeline.sample

@Library('shared-library')
import io.jenkins.pipeline.sample.Utils

sh acme.name
acme.name = 'something'
sh acme.name

acme.caution('world')

sayHello 'World'
sayHello()

parallel(
        action1: {
            node() {
                def utils = new Utils()
                sh "${utils.gitTools()}"
                sh 'sleep 3'
                String json = libraryResource 'io/jenkins/pipeline/sample/request.json'
                println json
            }
        },
        action2: {
            node() {
                sh 'sleep 4'
                error 'message'
            }
        }
)