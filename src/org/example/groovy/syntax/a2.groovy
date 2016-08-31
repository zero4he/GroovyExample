#!/usr/bin/env groovy

package org.example.groovy.syntax

import groovy.json.JsonOutput

def name = 'zero'
println(/hi,${name}/)

def person = [name: 'Guillaume', age: 36,'date':new Date()]

println(person)

println(JsonOutput.toJson(person))
