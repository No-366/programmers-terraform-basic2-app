package com.terraform_app2.domain.post.post.repository

import com.terraform_app2.domain.post.post.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long>