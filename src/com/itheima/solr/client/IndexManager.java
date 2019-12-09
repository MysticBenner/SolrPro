package com.itheima.solr.client;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;


public class IndexManager {
    @Test
    public void insertAndUpdateIndex() throws Exception{
        //创建HttpSolrServer
        HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr");
        //创建Document对象
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id","c001");
        doc.addField("name","solr cb success");
        //将Document对象添加到索引库
        server.add(doc);
        //提交
        server.commit();
    }
    @Test
    public void deleteIndex() throws Exception{
        //创建HttpSolrServer
        HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr");
        //根据指定的ID进行删除
        //server.deleteById("c001");
        //根据指定条件删除索引
        server.deleteByQuery("id:c001");
        //删除所有的索引，使用前需要谨慎
        //server.deleteById("*:*");
        //提交
        server.commit();
    }
}
