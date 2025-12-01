package com.terraform_app2.global.initData

import com.terraform_app2.domain.post.post.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationRunner
import org.springframework.cache.annotation.Cacheable
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.transaction.annotation.Transactional

@Configuration
class BaseInitData(
    private val postService: PostService
) {
    @Autowired
    @Lazy
    private lateinit var self: BaseInitData

    @Bean
    fun baseInitDataApplicationRunner(): ApplicationRunner {
        return ApplicationRunner {
            self.work1()
        }
    }

    @Transactional
    fun work1() {
        if ( postService.count() > 0 ) return

        postService.write("제목 1", "내용 1")
        postService.write("제목 2", "내용 2")

        var one = 0
        var two = 0
        var three = 0

        one = self.getPlus1()
        println("one = $one")
        two = self.getPlus1()
        println("two = $two")
        three = self.getPlus1()
        println("three = $three")

    }

    @Cacheable("get1Plus1")
    fun getPlus1(): Int{
        println("get1Plus1 run!")
        return 1+1
    }

}