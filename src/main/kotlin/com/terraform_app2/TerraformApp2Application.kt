package com.terraform_app2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class TerraformApp2Application

fun main(args: Array<String>) {
    runApplication<TerraformApp2Application>(*args)
}
