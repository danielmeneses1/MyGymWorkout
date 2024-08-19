# Use a imagem base do Maven para a fase de build
FROM maven:3.9.6-amazoncorretto-17 AS build

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo pom.xml para o diretório de trabalho
COPY pom.xml .

# Copie o diretório src para o diretório de trabalho
COPY src ./src

# Verifique o conteúdo do diretório (para depuração)
RUN ls -la /app

# Execute o comando Maven para construir o projeto sem rodar os testes
RUN mvn clean package -X -DskipTests

# Use a imagem base do OpenJDK para a fase de runtime
FROM openjdk:17-jdk-alpine

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR gerado da fase de build para a fase de runtime
COPY --from=build /app/target/*.jar teste.jar

# Defina o ponto de entrada para a aplicação
ENTRYPOINT ["java", "-jar", "teste.jar"]