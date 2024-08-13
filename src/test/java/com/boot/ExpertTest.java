package com.boot;

import com.example.HelloWorldApplication;
import com.example.entity.Expert;
import com.example.service.ExpertService;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration()
@SpringBootTest(classes = {HelloWorldApplication.class})
public class ExpertTest {

    @Resource
    ExpertService expertService;

    @Test
    public void test01(){
        long count = expertService.count();
        log.info("count:{}",count);
    }

    @Test
    public void createIndex() throws Exception {
        // 采集数据
        List<Expert> list = expertService.list();

        // 将采集到的数据封装到Document对象中
        List<Document> docList = new ArrayList<>();
        Document document;
        for (Expert expert : list) {
            document = new Document();
            // store:如果是yes，则说明存储到文档域中
            // 图书ID
            // Field id = new TextField("id", book.getId().toString(), Store.YES);

            Field id = new TextField("id", Integer.toString(expert.getId()), Field.Store.YES);
            // 名称
            Field name = new TextField("name", expert.getName(), Field.Store.YES);
            // 简介
            Field profile = new TextField("profile", expert.getProfile(), Field.Store.YES);
            // 图片地址
            Field pic = new TextField("pic", expert.getHeadImage(), Field.Store.YES);
            // 描述
            Field introduction = new TextField("introduction", expert.getIntroduction(), Field.Store.YES);

            // 将field域设置到Document对象中
            document.add(id);
            document.add(name);
            document.add(profile);
            document.add(pic);
            document.add(introduction);

            docList.add(document);
        }

        //JDK 1.7以后 open只能接收Path/////////////////////////////////////////////////////

        // 创建分词器，标准分词器
        Analyzer analyzer = new StandardAnalyzer();

        // 创建IndexWriter
        // IndexWriterConfig cfg = new IndexWriterConfig(Version.LUCENE_6_5_0,analyzer);
        IndexWriterConfig cfg = new IndexWriterConfig(analyzer);

        // 指定索引库的地址
//         File indexFile = new File("D:\\L\a\Eclipse\\lecencedemo\\");
//         Directory directory = FSDirectory.open(indexFile);
        Directory directory = FSDirectory.open(FileSystems.getDefault().getPath("F:\\lucenceIndex1\\"));

        IndexWriter writer = new IndexWriter(directory, cfg);
        writer.deleteAll(); //清除以前的index
        // 通过IndexWriter对象将Document写入到索引库中
        for (Document doc : docList) {
            writer.addDocument(doc);
        }

        // 关闭writer
        writer.close();
    }

    private void doSearch(Query query) {
        // 创建IndexSearcher
        // 指定索引库的地址
        try {
//          File indexFile = new File("D:\\Lpj\\Eclipse\\lecencedemo\\");
//          Directory directory = FSDirectory.open(indexFile);
            // 1、创建Directory
            //JDK 1.7以后 open只能接收Path
            Directory directory = FSDirectory.open(FileSystems.getDefault().getPath("F:\\lucenceIndex1\\"));
            IndexReader reader = DirectoryReader.open(directory);
            IndexSearcher searcher = new IndexSearcher(reader);
            // 通过searcher来搜索索引库
            // 第二个参数：指定需要显示的顶部记录的N条
            TopDocs topDocs = searcher.search(query, 10);

            // 根据查询条件匹配出的记录总数
            int count = topDocs.totalHits;
            System.out.println("匹配出的记录总数:" + count);
            // 根据查询条件匹配出的记录
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;

            for (ScoreDoc scoreDoc : scoreDocs) {
                // 获取文档的ID
                int docId = scoreDoc.doc;

                // 通过ID获取文档
                Document doc = searcher.doc(docId);
                System.out.println("ID：" + doc.get("id"));
                System.out.println("姓名：" + doc.get("name"));
                System.out.println("简介：" + doc.get("profile"));
                System.out.println("描述：" + doc.get("introduction"));
                System.out.println("==========================");
                // System.out.println("商品描述：" + doc.get("description"));
            }
            // 关闭资源
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void indexSearch() throws Exception {
        // 创建query对象
        Analyzer analyzer = new StandardAnalyzer();
        // 使用QueryParser搜索时，需要指定分词器，搜索时的分词器要和索引时的分词器一致
        // 第一个参数：默认搜索的域的名称
        QueryParser parser = new QueryParser("introduction", analyzer);

        // 通过queryparser来创建query对象
        // 参数：输入的lucene的查询语句(关键字一定要大写)
        Query query = parser.parse("20+");

//        Query query = new FuzzyQuery(new Term("introduction", "人工智能专家"));

        doSearch(query);

    }


    /**
     * 模糊搜索匹配多个字段
     * @throws Exception
     */
    @Test
    public void indexSearch01() throws Exception {
        // 创建query对象
        Analyzer analyzer = new StandardAnalyzer();

        // 使用BooleanQuery来组合多个FuzzyQuery
        BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();

        // 对name字段进行模糊查询
//        FuzzyQuery fuzzyQuery1 = new FuzzyQuery(new Term("name", "yang"));
//        booleanQuery.add(fuzzyQuery1, BooleanClause.Occur.SHOULD);

        // 对introduction字段进行模糊查询
        FuzzyQuery fuzzyQuery2 = new FuzzyQuery(new Term("introduction", "恢复生态学领域"));
        booleanQuery.add(fuzzyQuery2, BooleanClause.Occur.SHOULD);

        // 将组合后的查询作为最终的查询
        Query query = booleanQuery.build();

        doSearch(query);
    }


    /**
     * 全匹配搜索
     * @throws Exception
     */
    @Test
    public void indexSearch02() throws Exception {
        // 创建query对象
        Analyzer analyzer = new StandardAnalyzer();

        // 使用BooleanQuery来组合多个PhraseQuery
        BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();

        // 对name字段进行全匹配查询
//        PhraseQuery phraseQuery1 = new PhraseQuery.Builder()
//                .add(new Term("name", "yang"))
//                .build();
//        booleanQuery.add(phraseQuery1, BooleanClause.Occur.MUST);

        // 对introduction字段进行全匹配查询
        PhraseQuery phraseQuery2 = new PhraseQuery.Builder()
                .add(new Term("introduction", "123131231313"))
                .build();
        booleanQuery.add(phraseQuery2, BooleanClause.Occur.MUST);

        // 将组合后的查询作为最终的查询
        Query query = booleanQuery.build();

        doSearch(query);
    }


}
