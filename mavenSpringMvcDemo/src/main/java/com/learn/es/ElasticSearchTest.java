package com.learn.es;
/*
package com.yuanjin.es;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
//import org.junit.Before;
//import org.junit.Test;

public class ElasticSearchTest {
    TransportClient client;
    @Before
    @SuppressWarnings({ "unchecked" })
    public void before() throws UnknownHostException, InterruptedException, ExecutionException {
        Settings esSettings = Settings.builder()
                .put("cluster.name", "touda-uat") //����ESʵ��������
                .put("client.transport.sniff", true) //�Զ���̽������Ⱥ��״̬���Ѽ�Ⱥ������ES�ڵ��ip��ӵ����صĿͻ����б���
                .build();
        client = new PreBuiltTransportClient(esSettings);//��ʼ��client���ϰ汾�����˱仯���˷����м������ط�������ʼ������ȡ�
        //�˲������IP������һ������ʵһ���͹��ˣ���Ϊ������Զ���̽����
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9200));
    }
    
    @Test
    public void index() throws Exception {
        Map<String,Object> infoMap = new HashMap<String, Object>();
        infoMap.put("name", "�����Ϣ11");
        infoMap.put("title", "�ҵĹ��22");
        infoMap.put("createTime", new Date());
        infoMap.put("count", 1022);
        IndexResponse indexResponse = client.prepareIndex("test", "info","100").setSource(infoMap).execute().actionGet();
        System.out.println("id:"+indexResponse.getId());
    }
    
    @Test
    public void get() throws Exception {
        GetResponse response = client.prepareGet("sxq", "user", "2")  
                .execute().actionGet();  
        System.out.println("response.getId():"+response.getId());  
        System.out.println("response.getSourceAsString():"+response.getSourceAsString());  
    }
    
    @Test
    public void query() throws Exception {
        //term��ѯ
//        QueryBuilder queryBuilder = QueryBuilders.termQuery("age", 50) ;
        //range��ѯ
        QueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age").gt(50);
        SearchResponse searchResponse = client.prepareSearch("sxq")
                .setTypes("user")
                .setQuery(rangeQueryBuilder)
                .addSort("age", SortOrder.DESC)
                .setSize(20)
                .execute()
                .actionGet();
        SearchHits hits = searchResponse.getHits(); 
        System.out.println("�鵽��¼����"+hits.getTotalHits());
        SearchHit[] searchHists = hits.getHits();
        if(searchHists.length>0){
            for(SearchHit hit:searchHists){
                String name =  (String) hit.getSource().get("name");
                Integer age = (Integer)hit.getSource().get("age");
                System.out.format("name:%s ,age :%d \n",name ,age);
            }
        }
    }
    
}

*/