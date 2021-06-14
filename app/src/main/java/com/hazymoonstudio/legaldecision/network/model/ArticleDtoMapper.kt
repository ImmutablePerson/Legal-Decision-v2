package com.hazymoonstudio.legaldecision.network.model

import com.hazymoonstudio.legaldecision.domain.model.Article
import com.hazymoonstudio.legaldecision.domain.util.DomainMapper
import javax.inject.Inject

class ArticleDtoMapper @Inject constructor(private val componentMapper: ComponentDtoMapper): DomainMapper<ArticleDto, Article> {
    override fun mapToDomainModel(model: ArticleDto): Article {
        return Article (
            articleId = model.articleId,
            title = model.title,
            text = model.text,
            imgUrl = model.imgUrl,
            components = componentMapper.toDomainList(model.components)
        )
    }

    override fun mapFromDomainModel(domainModel: Article): ArticleDto {
        return ArticleDto (
            articleId = domainModel.articleId,
            title = domainModel.title,
            text = domainModel.text,
            imgUrl = domainModel.imgUrl,
            components = componentMapper.fromDomainList(domainModel.components)
        )
    }

    fun toDomainList(initial: List<ArticleDto>): List<Article>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Article>): List<ArticleDto>{
        return initial.map { mapFromDomainModel(it) }
    }
}