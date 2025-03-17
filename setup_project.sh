#!/bin/bash

# 최상위 프로젝트 디렉토리
PROJECT_ROOT="cinema"

# 생성할 apps 및 modules 리스트
APPS=("reservation-service" "schedule-service" "seat-service" "movie-service" "screen-service")
MODULES=("reservation" "schedule" "seat" "movie" "screen")

# apps 디렉터리 생성
for app in "${APPS[@]}"; do
  mkdir -p "$PROJECT_ROOT/apps/$app/src/main/java/com/hanghae99/skillup/$app"
  mkdir -p "$PROJECT_ROOT/apps/$app/src/main/resources"
  touch "$PROJECT_ROOT/apps/$app/build.gradle"
done

# modules 디렉터리 생성
for module in "${MODULES[@]}"; do
  mkdir -p "$PROJECT_ROOT/modules/$module/src/main/java/com/hanghae99/skillup/$module"
  mkdir -p "$PROJECT_ROOT/modules/$module/src/main/resources"
  touch "$PROJECT_ROOT/modules/$module/build.gradle"
done

# 최상위 build.gradle 생성
cat <<EOF > "$PROJECT_ROOT/build.gradle"
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.4.3' apply false
    id 'io.spring.dependency-management' version '1.1.7'
}

group = 'com.hanghae99.skillup'
version = '0.0.1-SNAPSHOT'

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply plugin: 'java'
    apply plugin: 'io.spring.dependency-management'

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }

    dependencies {
        implementation 'org.springframework.boot:spring-boot-starter'
        implementation 'org.springframework.boot:spring-boot-starter-web'
        implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
        implementation 'mysql:mysql-connector-java:8.0.33'
        implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0'

        testImplementation 'org.springframework.boot:spring-boot-starter-test'
    }

    tasks.withType(JavaCompile).configureEach {
        options.encoding = 'UTF-8'
    }

    tasks.withType(Test).configureEach {
        useJUnitPlatform()
    }
}
EOF

# settings.gradle 생성
cat <<EOF > "$PROJECT_ROOT/settings.gradle"
rootProject.name = 'cinema'

include("apps:reservation-service")
include("apps:schedule-service")
include("apps:seat-service")
include("apps:movie-service")
include("apps:screen-service")

include("modules:reservation")
include("modules:schedule")
include("modules:seat")
include("modules:movie")
include("modules:screen")
EOF

# 각 하위 모듈의 build.gradle 생성
for app in "${APPS[@]}"; do
  cat <<EOF > "$PROJECT_ROOT/apps/$app/build.gradle"
plugins {
    id 'java'
    id 'org.springframework.boot'
    id 'io.spring.dependency-management'
}

dependencies {
    implementation project(':modules:common')
    implementation 'org.springframework.boot:spring-boot-starter'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'mysql:mysql-connector-java'

    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.withType(JavaCompile).configureEach {
    options.encoding = 'UTF-8'
}

tasks.withType(Test).configureEach {
    useJUnitPlatform()
}
EOF
done

for module in "${MODULES[@]}"; do
  cat <<EOF > "$PROJECT_ROOT/modules/$module/build.gradle"
plugins {
    id 'java'
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter'
}
EOF
done

echo "✅ 프로젝트 구조 생성 완료!"
