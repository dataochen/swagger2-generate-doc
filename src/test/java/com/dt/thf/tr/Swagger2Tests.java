package com.dt.thf.tr;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * @author: jinCheng
 * @description: java代码生成文档
 */
public class Swagger2Tests  extends BaseTest{

    /**
     * 获取项目在线swagger的json数据,8099,修改为自己项目设置的
     */
    private String swagger_source_url = "http://localhost:8080/v2/api-docs";

    /**
     * 生成的asciidoc文件的存放目录
     */
    private String asciidoc_dir = "src/main/resources/docs/asciidoc/generated";

    private String fileName = "all";

    /**
     * 生成AsciiDocs格式文档
     *
     * @throws MalformedURLException
     */
    @Test
    public void generateAsciiDoc() throws MalformedURLException {
        // MarkupLanguage三种格式:ASCIIDOC,MARKDOWN,CONFLUENCE_MARKUP
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .build();

        Swagger2MarkupConverter.from(new URL(swagger_source_url))
                .withConfig(config)
                .build()
                .toFolder(Paths.get(asciidoc_dir));
    }

    /**
     * 生成AsciiDocs格式文档,并汇总成一个文件
     *
     * @throws Exception
     */
    @Test
    public void generateAsciiDocsToFile() throws Exception {
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL(swagger_source_url))
                .withConfig(config)
                .build()
                .toFile(Paths.get(asciidoc_dir + "/" + fileName));
    }
    /**
     * 生成Markdown格式文档
     * @throws Exception
     */
    @Test
    public void generateMarkdownDocs() throws Exception {
        //    输出Markdown格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL(swagger_source_url))
                .withConfig(config)
                .build()
                .toFolder(Paths.get("./docs/markdown/generated"));
    }

}

