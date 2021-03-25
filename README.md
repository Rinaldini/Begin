# Begin
First steps in java programming 

## Maven
  Устанавливается просто копированием в нужную директорию — никакого инсталлера нет:
  
    - Win: C:\maven-x.y.z
    - Linux: /opt/maven-x.y.z

  Установить переменную окружения M2_HOME:
  
    - Win: «Дополнительные параметры»/«Переменные среды»/«Системные переменные», добавить «M2_HOME» = "C:\maven-x.y.z\"
    - Linux: добавить строку «export M2_HOME=/opt/maven-x.y.z» в файл /etc/profile
  
  В переменную окружения PATH добавить:
  
    - Win: добавить строку %M2_HOME%\bin (директорию maven/bin, т.е, если maven находится в d:/soft/maven, то в PATH надо добавить d:/soft/maven/bin)
    - Linux: добавить строку «export PATH=$PATH:$M2_HOME/bin» в файл /etc/profile
 
 Ещё для работы maven потребует переменную JAVA_HOME, которая указывает на JDK. Если JDK находится в C:/Program Files/Java/jdk1.8.0_05, то именно такое значение нужно поместить в JAVA_HOME. Добавлять bin в конец не нужно.
