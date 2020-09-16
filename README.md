#Projeto DACS 2020

##Processo de atualização do JAVA 11 no CodeSpaces
- Instalar a OpenJDK11 no Code Spaces
- wget https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.8+10/OpenJDK11U-jdk_x64_linux_hotspot_11.0.8_10.tar.gz -O /tmp/OpenJDK11U-jdk_x64_linux_hotspot_11.0.8_10.tar.gz

- sudo tar xfvz /tmp/OpenJDK11U-jdk_x64_linux_hotspot_11.0.8_10.tar.gz --directory /usr/lib/jvm

- rm -f /tmp/openjdk-11+28_linux-x64_bin.tar.gz

- Tecla F1 e digitar Java: Configure Java Runtime
- Na próxima tela, clicar no link User Settings
- Na próxima tela, clicar em edit Settings.json
- Na propriedade "java_home" informar o valor "/usr/lib/jvm/jdk-11.0.8+10"
- Fechar e abrir o VSCode


##Build Docker image
- Incluir o pluggin do Spotify no arquivo pom.xml
- Instalar o Maven, no CodeSpaces
- sudo apt-get update
- sudo apt-get install maven
- Build da imagem: mvn install docker:build
- Instalar o Docker Compose: sudo apt-get install docker-compose
- docker-compose up -d
