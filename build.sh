#!/bin/bash

# Instalar Maven
apt-get update && apt-get install -y maven

# Construir el proyecto con Maven
mvn clean package